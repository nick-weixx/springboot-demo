package com.nick.demo.service;

import java.util.List;

import com.nick.demo.entity.Article;

public interface IArticleService {
	List<Article> getAllArticles();

	Article getArticleById(int articleId);

	boolean addArticle(Article article);

	void updateArticle(Article article);

	void deleteArticle(int articleId);

}
