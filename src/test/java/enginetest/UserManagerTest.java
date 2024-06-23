package enginetest;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import engine.UserManager;
import model.User;

class UserManagerTest {
	
	private UserManager userMng;
	private Connection mockConnection;
	private PreparedStatement mockPreparedStatement;
	private ResultSet mockResultSet;

	@BeforeEach
    public void setUp() throws SQLException {
        mockConnection = mock(Connection.class);
        mockPreparedStatement = mock(PreparedStatement.class);
        mockResultSet = mock(ResultSet.class);
        
        userMng = new UserManager(mockConnection);
        when(mockConnection.prepareStatement(any(String.class))).thenReturn(mockPreparedStatement);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);
        when(mockPreparedStatement.executeUpdate()).thenReturn(1);
    }

    @Test
    public void testRegisterUserToDb() throws SQLException {
    	userMng.registerUserToDb("John", "Doe", "Male", "01/01/1990", "Work Address", "Home Address");

        verify(mockPreparedStatement, times(2)).executeUpdate();
        verify(mockPreparedStatement, times(1)).executeQuery();
    }
    
    @Test
    public void testDeleteUser() throws SQLException { 
    	userMng.deleteUser(1);
        verify(mockPreparedStatement, times(2)).executeUpdate();
    }
    
    @Test
    public void testDisplayUsers() throws SQLException {
    	when(mockResultSet.next()).thenReturn(true).thenReturn(false);
        when(mockResultSet.getInt("UserId")).thenReturn(1);
        when(mockResultSet.getString("Name")).thenReturn("Marios");
        when(mockResultSet.getString("Surname")).thenReturn("Zich");
        when(mockResultSet.getString("Gender")).thenReturn("M");
        when(mockResultSet.getDate("Birthdate")).thenReturn(Date.valueOf("1998-10-20"));
        when(mockResultSet.getString("WorkAddress")).thenReturn("Work Address");
        when(mockResultSet.getString("HomeAddress")).thenReturn("Home Address");
        
    	HashMap<Integer, User> users = userMng.displayUsers();
        assertEquals(1, users.size());
        assertEquals("Marios", users.get(1).getName());
        assertEquals("Zich", users.get(1).getSurname());
        assertEquals("M", users.get(1).getGender());
        assertEquals(Date.valueOf("1998-10-20"), users.get(1).getBirthdate());
        assertEquals("Work Address", users.get(1).getWorkAddress());
        assertEquals("Home Address", users.get(1).getHomeAddress());
    }

}
