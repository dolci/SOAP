package tn.service;


import java.util.List;

import tn.dto.ArticleDTO;
import tn.dto.UserDTO;
import tn.model.User;

@javax.jws.WebService
@javax.jws.soap.SOAPBinding(style = javax.jws.soap.SOAPBinding.Style.RPC)
public interface GestionArticleWS extends java.rmi.Remote {
	
	@javax.jws.WebMethod
	public List<ArticleDTO> getAllArticle();
	public List<UserDTO> getAllUser();
	public void addArticle(ArticleDTO article);
	public void updateArticle(ArticleDTO article);
	public void deleteArticle(ArticleDTO article);
	public User returnUser(String login, String password) ;
	public void updateUser(UserDTO user);
	public boolean findUser(String login, String password, UserDTO user);
	public void deleteUser(UserDTO user);
}
