package tn.dao.article;


import java.util.List;
import javax.ejb.Local;
import tn.model.Article;

@Local
public interface GestionArticleDAOLocal {

	public List<Article> getAllArticles();
	public void save(Article article);
	public void delete(Article article);
	public void update(Article article);
}
