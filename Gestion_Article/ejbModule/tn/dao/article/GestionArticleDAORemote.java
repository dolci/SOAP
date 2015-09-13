package tn.dao.article;

import java.util.List;
import javax.ejb.Remote;
import tn.model.Article;

@Remote
public interface GestionArticleDAORemote {

	public List<Article> getAllArticles();
	public void save(Article article);
	public void delete(Article article);
	public void update(Article article);
}
