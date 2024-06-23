package engine;

import java.util.HashMap;

import model.User;

public interface UserManagerInterface {

    public HashMap<Integer, User> displayUsers();
	void registerUserToDb(String name, String surname, String gender, String date, String workAddress, String homeAddress);
	public User findUserById(int userId);
	public void deleteUser(int userId);
}
