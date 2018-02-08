package com.nick.demo2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.nick.demo2.entity.Article;

@Mapper
public interface IArticleDao {

	@Select("SELECT article_id,title,category FROM articles")
	@Results({ @Result(property = "articleId", column = "article_id", javaType = Integer.class),
			@Result(property = "title", column = "title"), @Result(property = "category", column = "category")

	})
	List<Article> getAllArticles();
	
	@Select("SELECT article_id,title,category FROM articles where article_id=#{articleId}")
	@Results({ @Result(property = "articleId", column = "article_id", javaType = Integer.class),
			@Result(property = "title", column = "title"), @Result(property = "category", column = "category")
	})
	Article getArticleById(int articleId);
	
	@Insert("INSERT INTO articles(title,category) VALUES(#{title},#{category})")
//	@Options(useGeneratedKeys = true, keyProperty = "articleId")  
	int addArticle(Article article);
	@Update("UPDATE articles SET category=#{category} WHERE article_id=#{articleId}")
	void updateArticle(Article article);
	
	@Delete("DELETE FROM articles WHERE article_id=#{articleId}")
	void deleteArticle(@Param("articleId") int articleId);
	
	@Select("SELECT article_id FROM articles WHERE title=#{title} AND category=#{category}")
	Integer articleExists(@Param("title") String title, @Param("category") String category);
}
