package tn.helper;

import tn.dto.ArticleDTO;
import tn.model.Article;

public class ArticleHelper {

	public static ArticleDTO modelToDto(Article article)
	{
		ArticleDTO art = new ArticleDTO();
		art.setLibelle(article.getLibelle());
		art.setReference(article.getReference());
		art.setPrix(article.getPrix());
		art.setQuantite(article.getQuantite());
		art.setTva(article.getTva());
		return art;
	}
	public static Article dtoToModel(ArticleDTO article)
	{
		Article art = new Article();
		art.setLibelle(article.getLibelle());
		art.setReference(article.getReference());
		art.setPrix(article.getPrix());
		art.setQuantite(article.getQuantite());
		art.setTva(article.getTva());
		return art;
	}
}
