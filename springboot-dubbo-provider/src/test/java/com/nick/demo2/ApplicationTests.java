package com.nick.demo2;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nick.demo2.dao.IArticleDao;
import com.nick.demo2.entity.Article;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {
	@Autowired
	private IArticleDao articleDao;

	@Test
	public void daoInsterTest() {
		Article ac = new Article();
		ac.setCategory("spark test");
		ac.setTitle("spark");
		int res = articleDao.addArticle(ac);
		System.out.println("insert " + res);

	}

	@Test
	public void daoUpdateTest() {
		Article ac2 = new Article();
		ac2.setArticleId(11);
		ac2.setTitle("spark");
		ac2.setCategory("spark test2");
		articleDao.updateArticle(ac2);
	}

	@Test
	public void daoExitTest() {
		System.out.println(articleDao.articleExists("spark", "spark test"));
	}

	@Test
	public void daoDeleteTest() {
		articleDao.deleteArticle(11);
	}

	@Test
	public void daoSelTest() {
		List<Article> articles2 = articleDao.getAllArticles();
		System.out.println("get all");
		for (Article article : articles2) {
			System.out.println(article);
		}
		Article articles3 = articleDao.getArticleById(11);
		System.out.println("get one");
		System.out.println(articles3);
	}

}
