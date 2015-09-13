package tn.dao.article;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.model.Article;

/**
 * Session Bean implementation class GestionArticleDAO
 */
@Stateless
@LocalBean
public class GestionArticleDAO implements GestionArticleDAOLocal {

    /**
     * Default constructor. 
     */
  
    @PersistenceContext
    EntityManager em;
    
	@Override
	public List<Article> getAllArticles() {
		
		return  (List<Article>)em.createNamedQuery("article.getAllArticle").getResultList();
		
	}

	@Override
	public void save(Article article) {
		em.persist(article);
		
	}

	@Override
	public void delete(Article article) {
		
		if (em.find(Article.class, article.getReference()) != null)
			em.remove(em.find(Article.class, article.getReference()));
	}

	@Override
	public void update(Article article) {
		Article a1 = em.find(Article.class, article.getReference());
		a1.setPrix(article.getPrix());
		a1.setQuantite(article.getQuantite());
		a1.setTva(article.getTva());
		a1.setLibelle(article.getLibelle());
		em.persist(a1);
		
	}

}
