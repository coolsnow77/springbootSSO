package com.itdragon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itdragon.pojo.ItdragonResult;
import com.itdragon.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public ItdragonResult userLogin(String username, String password,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			ItdragonResult result = userService.userLogin(username, password, request, response);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return ItdragonResult.build(500, "");
		}
	}

    /**
     *  注销登录
     * @param token
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value="/logout/{token}")
    @ResponseBody
	public Object logout(@PathVariable String token, HttpServletRequest request, HttpServletResponse response) {
		// 思路是从Redis中删除key，实际情况请和业务逻辑结合
		int ret = userService.logout(token, request, response);
		ItdragonResult itdragonResult = null;
		if(ret > 0) {
            itdragonResult = ItdragonResult.ok(ret);
        } else {
		    itdragonResult = ItdragonResult.build(500, "退出失败..");
        }
//		return "index";
        return itdragonResult;
	}
	
	@RequestMapping("/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token) {
		ItdragonResult result = null;
		try {
			result = userService.queryUserByToken(token);
		} catch (Exception e) {
			e.printStackTrace();
			result = ItdragonResult.build(500, "");
		}
		return result;
	}
}
