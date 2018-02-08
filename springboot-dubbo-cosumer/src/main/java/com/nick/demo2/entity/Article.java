package com.nick.demo2.entity;

import java.io.Serializable;

/**
 * model定义
 * 
 * @author weixinxing0226@gmail.com
 * @since 2018年2月4日 上午11:47:16
 */
public class Article implements Serializable {
//	private static final long serialVersionUID = -1491292595468157592L;
	private static final long serialVersionUID = 0;

	// 标明自增id，及列名
	private int articleId;

	// 标明文章标题
	private String title;

	// 标明文章类别
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

	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", title=" + title + ", category=" + category + "]";
	}

}
