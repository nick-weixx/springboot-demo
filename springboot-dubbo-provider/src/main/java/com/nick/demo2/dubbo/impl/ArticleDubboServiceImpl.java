package com.nick.demo2.dubbo.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.nick.demo2.dubbo.IArticleDubboService;
import com.nick.demo2.entity.Article;
import com.nick.demo2.service.IArticleService;

@Service(version = "1.0.0")
public class ArticleDubboServiceImpl implements IArticleDubboService {
	@Autowired
	private IArticleService articleService;

	@Override
	public Article getArticleById(Integer id) {
		return articleService.getArticleById(id);
	}

}
