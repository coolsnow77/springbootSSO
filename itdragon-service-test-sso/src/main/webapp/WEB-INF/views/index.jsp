<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="initial-scale=1.0, width=device-width, user-scalable=no" />
		<title>首页sso-test-8082</title>
		<style type="text/css">
			*{margin:0;padding:0;}
			body{background: url(/static/images/bg.jpg) no-repeat;font-family: "微软雅黑";color: #fff; background-size:cover;}
			ul{width:180px;margin:300px auto;background-color: rgba(255,255,255,0.1);border-radius: 10px;border:1px solid rgba(255,255,255,0.2);}
			ul li{height: 52px;list-style: none;line-height: 52px;text-align: center;cursor:pointer;font-weight: bold;font-size: 20px;border-bottom: 1px solid rgba(255,255,255,0.2);}
			ul li:hover{background: rgba(255,255,255,0.1);}
			ul li a{color:#fff !important;text-decoration:none;}
		</style>
	</head>
	<body>
		<ul>
			<li>列表.</li>
			<li><a href="/needLogin">授权访问</a></li>
		</ul>
	</body>
</html>