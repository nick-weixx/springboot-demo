package com.nick.dubbo.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nick.demo2.dubbo.DubboService;
import com.nick.demo2.entity.Article;

@Controller
@RequestMapping("user")
public class ArticleController {
	@Autowired
	public DubboService dubboService;

	/**
	 * 获取文章信息,设备get方式
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("article/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable("id") Integer id) {
		Article article = dubboService.articleDubbo.getArticleById(id);
		return new ResponseEntity<Article>(article, HttpStatus.OK);
	}
}
