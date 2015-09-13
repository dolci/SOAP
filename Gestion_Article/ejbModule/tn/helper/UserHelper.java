package tn.helper;

import tn.dto.UserDTO;
import tn.model.User;

public class UserHelper {

	public static UserDTO modelToDto(User user)
	{
		UserDTO u = new UserDTO();
		u.setLogin(user.getLogin());
		u.setPassword(user.getPassword());
		u.setNom(user.getNom());
		u.setPrenom(user.getPrenom());
		u.setEmail(user.getEmail());
		u.setRole(user.getRole_user());
		return u;
	}
	public static User dtoToModel(UserDTO user)
	{
		
		User u = new User();
		u.setLogin(user.getLogin());
		u.setPassword(user.getPassword());
		u.setNom(user.getNom());
		u.setPrenom(user.getPrenom());
		u.setEmail(user.getEmail());
		u.setRole_user(user.getRole());
		return u;
	}
}
