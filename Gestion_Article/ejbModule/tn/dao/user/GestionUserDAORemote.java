package tn.dao.user;

import java.util.List;

import javax.ejb.Remote;

import tn.model.User;
@Remote
public interface GestionUserDAORemote {
	public List<User> getAllUser();
	public void addUser(User user);
	public void updateUser(User user);
	public boolean findUser(String login, String password, User user);
	public void deleteUser(User user);
	public User returnUser(String login, String password);
}
