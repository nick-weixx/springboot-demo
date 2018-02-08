package com.nick.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nick.demo.dao.IArticleDAO;
import com.nick.demo.entity.Article;

/**
 * 数据访问层实现
 * @author weixinxing0226@gmail.com
 * @since 2018年2月4日 下午12:08:57
 */
@Transactional
@Repository
public class ArticleDAOImpl implements IArticleDAO {

	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Article getArticleById(int articleId) {
		return entityManager.find(Article.class, articleId);
	}
	
	/**
	 * 获取所有
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		String hql = "FROM Article as atcl ORDER BY atcl.articleId";
		return (List<Article>) entityManager.createQuery(hql).getResultList();
	}	
	
	/**
	 * 添加
	 */
	@Override
	public void addArticle(Article article) {
		entityManager.persist(article);
	}
	
	/**
	 * 更新
	 */
	@Override
	public void updateArticle(Article article) {
		Article artcl = getArticleById(article.getArticleId());
		artcl.setTitle(article.getTitle());
		artcl.setCategory(article.getCategory());
		entityManager.flush();
	}
	
	/**
	 * 删除
	 */
	@Override
	public void deleteArticle(int articleId) {
		entityManager.remove(getArticleById(articleId));
	}
	
	/**
	 * 判断是否存在
	 */
	@Override
	public boolean articleExists(String title, String category) {
		String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, category).getResultList().size();
		return count > 0 ? true : false;
	}

}
