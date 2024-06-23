package engine;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import connector.ConnectionManager;
import model.User;

public class UserManager {
	private Connection con = ConnectionManager.getConnection();;
	private ResultSet rs = null;
	private static UserManager userMng = new UserManager();
	private HashMap<Integer,User> users = new HashMap<>();
	
	public UserManager() {}
	
	//This constructor is used for testing purposes
    public UserManager(Connection con) {
        this.con = con;
    }
    
	public static UserManager getSingleton()
	{
		if(userMng == null)
			userMng = new UserManager();
		return userMng;
	}

    public void registerUserToDb(String name, String surname, String gender, String date, String workAdrress, String homeAddress) {
    	char sqlGender = (gender.equals("Male")) ? 'M' : 'F';
    	Date sqlBirthDate = formatDate(date);
    	String insertUserSql = "INSERT INTO users (Name, Surname, Gender, Birthdate) VALUES (?, ?, ?, ?)";
    	String getLastIdSql = "SELECT LAST_INSERT_ID()";
        String insertAddressesSql = "INSERT INTO addresses (UserId, WorkAddress, HomeAddress) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement insertUserStmt = con.prepareStatement(insertUserSql);
            PreparedStatement getLastIdStmt = con.prepareStatement(getLastIdSql);
            PreparedStatement insertAddressesStmt = con.prepareStatement(insertAddressesSql);
            
            insertUserStmt.setString(1, name);
            insertUserStmt.setString(2, surname);
            insertUserStmt.setString(3, String.valueOf(sqlGender));
            insertUserStmt.setDate(4, sqlBirthDate);
            insertUserStmt.executeUpdate();
            
            rs = getLastIdStmt.executeQuery();
            int userId = 0;
            if (rs.next()) {
            	userId = rs.getInt(1);
            }
            
            insertAddressesStmt.setInt(1, userId);
            insertAddressesStmt.setString(2, workAdrress);
            insertAddressesStmt.setString(3, homeAddress);
            insertAddressesStmt.executeUpdate();
            
            insertUserStmt.close();
            getLastIdStmt.close();
            insertAddressesStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public HashMap<Integer,User> displayUsers() {
		String fetchUsersSql = "SELECT users.UserId, users.Name, users.Surname, users.Gender, users.Birthdate, addresses.WorkAddress, addresses.HomeAddress "
							+ "FROM users "
							+ "JOIN addresses ON users.UserId = addresses.UserId";
		
    	try {
	    	PreparedStatement displayUsersStmt = con.prepareStatement(fetchUsersSql);
	    	rs = displayUsersStmt.executeQuery();
	    	while (rs.next()) {
	    		if(!users.containsKey(rs.getInt("UserId"))) {
	    			User user = new User();
		            user.setId(rs.getInt("UserId"));
		            user.setName(rs.getString("Name"));
		            user.setSurname(rs.getString("Surname"));
		            user.setGender(rs.getString("Gender"));
		            user.setBirthdate(rs.getDate("Birthdate"));
		            user.setWorkAddress(rs.getString("WorkAddress"));
		            user.setHomeAddress(rs.getString("HomeAddress"));
		            users.put(rs.getInt("UserId"), user);
	    		}
	    	}
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
    	return users;
    }
	
    public User findUserById(int userId) {
    	return users.get(userId);
    }
	
    private Date formatDate(String date) {
    	String[] dateArr = date.split("/");
    	String temp = dateArr[0];
    	dateArr[0] = dateArr[dateArr.length-1];
    	dateArr[dateArr.length-1] = temp;
    	String formatedDate = String.join("-", dateArr);
    	return Date.valueOf(formatedDate);
	}

	public void deleteUser(int userId) {
		String deleteFromAddresses = "DELETE FROM addresses WHERE UserId = ?"; //First delete from addresses becuase userId is a foreign key
    	String deleteFromUsers = "DELETE FROM users WHERE UserId = ?";
    	try {
			PreparedStatement deleteUserFromAddresses = con.prepareStatement(deleteFromAddresses);
			deleteUserFromAddresses.setInt(1, userId);
			deleteUserFromAddresses.executeUpdate();
			
			PreparedStatement deleteUserFromUsers = con.prepareStatement(deleteFromUsers);
			deleteUserFromUsers.setInt(1, userId);
			deleteUserFromUsers.executeUpdate();
			users.remove(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
