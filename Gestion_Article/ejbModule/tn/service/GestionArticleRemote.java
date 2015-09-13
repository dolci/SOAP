package tn.service;


import java.util.List;

import javax.ejb.Remote;

import tn.dto.ArticleDTO;
import tn.dto.UserDTO;
import tn.model.User;
@Remote
public interface GestionArticleRemote {

	public List<ArticleDTO> getAllArticle();
	public List<UserDTO> getAllUser();
	public boolean findUser(String login, String password, UserDTO user);
	public void deleteArticle(ArticleDTO article);
	public void updateArticle (ArticleDTO article);
	public void addArticle(ArticleDTO article);
	public void updateUser(UserDTO user);
	public void deleteUser(UserDTO user);
}
