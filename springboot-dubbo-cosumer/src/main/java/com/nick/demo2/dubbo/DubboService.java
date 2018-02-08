package com.nick.demo2.dubbo;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Reference;

@Component
public class DubboService {
	@Reference(version = "1.0.0")
	public IArticleDubboService articleDubbo;
}
