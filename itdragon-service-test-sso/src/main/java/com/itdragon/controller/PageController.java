package com.itdragon.controller;

import com.itdragon.pojo.ItdragonResult;
import com.itdragon.pojo.User;
import com.itdragon.utils.CookieUtils;
import com.itdragon.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class PageController {

	public static final String COOKIE_NAME = "USER_TOKEN";

//	@Value("${SSO_BASE_URL}")
	public String SSO_BASE_URL = "http://sso.server.com:8081";

	/**
	 * 打开首页
	 */
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		return page;
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		String token = CookieUtils.getCookieValue(request, COOKIE_NAME);
		if(!StringUtils.isEmpty(token)) {
			String json = HttpClientUtil.doGet(SSO_BASE_URL + "/user/logout/" + token);
			System.out.println("退出json 返回.: " + json);
			// 把json转换成ItdragonResult
			ItdragonResult result = ItdragonResult.formatToPojo(json, User.class);
			if (null != result && result.getStatus() == 200) {
				CookieUtils.deleteCookie(request, response, COOKIE_NAME);
			}
		}
		return "index";
	}
}
