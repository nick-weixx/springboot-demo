package com.nick.demo;

import java.net.URI;

import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.nick.demo.entity.Article;

public class RestClientUtil {
	/**
	 * get 操作，进行单个获取
	 */
	@Test
	public void getArticleByIdDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = getHost() + "/user/article/{id}";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Article> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Article.class, 1);
		Article article = responseEntity.getBody();
		System.out.println("Id:" + article.getArticleId() + ", Title:" + article.getTitle() + ", Category:"
				+ article.getCategory());
	}
	/**
	 * get 操作，获取所有
	 */
	@Test
	public void getAllArticlesDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = getHost() + "/user/articles";
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		ResponseEntity<Article[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity,
				Article[].class);
		Article[] articles = responseEntity.getBody();
		for (Article article : articles) {
			System.out.println("Id:" + article.getArticleId() + ", Title:" + article.getTitle() + ", Category: "
					+ article.getCategory());
		}
	}

	/**
	 * post 操作，进行添加
	 */
	@Test
	public void addArticleDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = getHost() + "/user/article";
		Article objArticle = new Article();
		objArticle.setTitle("Docker 技术入门与实战");
		objArticle.setCategory("docker");
		HttpEntity<Article> requestEntity = new HttpEntity<Article>(objArticle, headers);
		URI uri = restTemplate.postForLocation(url, requestEntity);
		System.out.println(uri.getPath());

	}

	/**
	 * http put 操作，进行修改
	 */
	@Test
	public void updateArticleDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = getHost() + "/user/article";
		Article objArticle = new Article();
		objArticle.setArticleId(1);
		objArticle.setTitle("Update:Java Concurrency");
		objArticle.setCategory("Java");
		HttpEntity<Article> requestEntity = new HttpEntity<Article>(objArticle, headers);
		restTemplate.put(url, requestEntity);
	}

	/**
	 * http delete 操作，删除
	 */
	@Test
	public void deleteArticleDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
		String url = getHost() + "/user/article/{id}";
		HttpEntity<Article> requestEntity = new HttpEntity<Article>(headers);
		restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);
	}

	public String getHost() {
		return "http://localhost:8080";
	}

}
