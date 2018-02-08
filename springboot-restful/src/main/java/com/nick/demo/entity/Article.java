package com.nick.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * model定义
 * @author weixinxing0226@gmail.com
 * @since 2018年2月4日 上午11:47:16
 */
@Entity//标明为Entity
@Table(name = "articles")//标明映射的表名
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	//标明自增id，及列名
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "article_id")
	private int articleId;
	
	//标明文章标题
	@Column(name = "title")
	private String title;
	
	//标明文章类别
	@Column(name = "category")
	private String category;

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
