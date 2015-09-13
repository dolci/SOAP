package tn.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.jws.WebService;

import tn.dao.article.GestionArticleDAO;
import tn.dao.user.GestionUserDAO;
//import tn.dao.user.GestionUserDAO;
import tn.dto.ArticleDTO;
import tn.dto.UserDTO;
import tn.helper.ArticleHelper;
import tn.helper.UserHelper;
import tn.model.Article;
//import tn.model.User;
import tn.model.User;

/**
 * Session Bean implementation class GestionArticle
 */
@Stateless
@LocalBean
@WebService(endpointInterface = "tn.service.GestionArticleWS")
public class GestionArticle implements GestionArticleLocal , GestionArticleRemote{

	@EJB
	GestionUserDAO userDAO;
	@EJB
	GestionArticleDAO articleDAO;
	
	@Override
	public List<ArticleDTO> getAllArticle() {
		
	  ArrayList<ArticleDTO> list = new ArrayList<ArticleDTO> ();
			 ;
	  if( articleDAO.getAllArticles().size()>0)
	  {
		  for(Article a : articleDAO.getAllArticles())
			  list.add(ArticleHelper.modelToDto(a));
	  }
		return list;
	}

	
	@Override
	public void deleteArticle(ArticleDTO article) {
		
		articleDAO.delete(ArticleHelper.dtoToModel(article));
	}

	@Override
	public void updateArticle(ArticleDTO article) {
		
		articleDAO.update(ArticleHelper.dtoToModel(article));
	}

	@Override
	public void addArticle(ArticleDTO article) {
		articleDAO.save(ArticleHelper.dtoToModel(article));
		
	}

	@Override
	public List<UserDTO> getAllUser() {
		
		ArrayList<UserDTO> list = new ArrayList<UserDTO> ();	
        if( userDAO.getAllUser().size()>0)
         {
	         for(User a : userDAO.getAllUser())
		         list.add(UserHelper.modelToDto(a));
           }
	   return list;
	}


	@Override
	public  boolean findUser(String login, String password, UserDTO user) {
		
		return userDAO.findUser(login, password,user);
	}


	@Override
	public User returnUser(String login, String password) {
		return userDAO.returnUser(login, password);
	}


	@Override
	public void updateUser(UserDTO user) {
		userDAO.updateUser(UserHelper.dtoToModel(user));
		
	}


	@Override
	public void deleteUser(UserDTO user) {
		userDAO.deleteUser(UserHelper.dtoToModel(user));
	}

    

}
