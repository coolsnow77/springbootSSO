package com.itdragon.controller;

import com.itdragon.repository.JedisClient;
import com.itdragon.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {

	@Autowired
	private JedisClient jedisClient;

	private static final String COOKIE_NAME = "USER_TOKEN";
	private static final String REDIS_USER_SESSION_KEY = "REDIS_USER_SESSION";

	@RequestMapping("/login")
	public ModelAndView showLogin(String redirect, Model model,
								  HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model2 = new ModelAndView();
		model.addAttribute("redirect", redirect);
		model2.addObject("redirect", redirect);
		// 检查用户是否已经登录:
		String tokenCk = CookieUtils.getCookieValue(request, COOKIE_NAME);
		//
		String token = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + tokenCk);
		System.out.println("show Login redirect, token:" + String.format("%s?token=%s", redirect, tokenCk));
		if(!StringUtils.isEmpty(token) && !StringUtils.isEmpty(redirect)) {
			System.out.println("show redirect, token#######:" + String.format("%s?token=%s", redirect, tokenCk));
			return new ModelAndView(new RedirectView(String.format("%s?token=%s", redirect, tokenCk)));
		}else{
			// redis 中失效， 清理cookies ..
			CookieUtils.deleteCookie(request, response, COOKIE_NAME);
		}
//		return "login";
		model2.setViewName("login");
		return model2;
	}

	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
}
