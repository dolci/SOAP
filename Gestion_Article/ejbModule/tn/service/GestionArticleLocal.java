package tn.service;

import java.util.List;

import javax.ejb.Local;

import tn.dto.ArticleDTO;
import tn.dto.UserDTO;
import tn.model.User;


@Local
public interface GestionArticleLocal {

	public List<ArticleDTO> getAllArticle();
    public List<UserDTO> getAllUser();	
    public boolean findUser(String login, String password, UserDTO user);
	public void deleteArticle(ArticleDTO article);
	public void updateArticle (ArticleDTO article);
	public void addArticle(ArticleDTO article);
	public User returnUser(String login, String password) ;
	public void updateUser(UserDTO user);
}
