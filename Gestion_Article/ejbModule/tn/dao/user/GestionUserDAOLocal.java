package tn.dao.user;

import java.util.List;

import javax.ejb.Local;

import tn.dto.UserDTO;
import tn.model.User;

@Local
public interface GestionUserDAOLocal {

	public List<User> getAllUser();
	public void addUser(User user);
	public void updateUser(User user);
	public boolean findUser(String login, String password, UserDTO user);
	public void deleteUser(User user);
	public User returnUser(String login, String password);
}
