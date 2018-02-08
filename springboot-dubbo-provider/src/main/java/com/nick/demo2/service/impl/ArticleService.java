package com.nick.demo2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nick.demo2.dao.IArticleDao;
import com.nick.demo2.entity.Article;
import com.nick.demo2.service.IArticleService;

@Service
public class ArticleService implements IArticleService {
	@Autowired
	private IArticleDao articleDao;

	@Override
	public Article getArticleById(int articleId) {
		Article obj = articleDao.getArticleById(articleId);
		return obj;
	}

	@Override
	public List<Article> getAllArticles() {
		return articleDao.getAllArticles();
	}

	@Override
	public synchronized boolean addArticle(Article article) {
		if (articleDao.articleExists(article.getTitle(), article.getCategory())==null) {
			return false;
		} else {
			articleDao.addArticle(article);
			return true;
		}
	}

	@Override
	public void updateArticle(Article article) {
		articleDao.updateArticle(article);
	}

	@Override
	public void deleteArticle(int articleId) {
		articleDao.deleteArticle(articleId);
	}


}
