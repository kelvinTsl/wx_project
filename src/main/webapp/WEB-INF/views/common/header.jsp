<%@ page language="java"  contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<div>
	<div class="logo">***后台管理系统</div>
	<div class="navigation">
		<ul>
			<li>欢迎您！</li>
			<li><a href=""><shiro:principal/></a></li>
			<li><a href="">修改密码</a></li>
			<li><a href="">设置</a></li>
			<li><a href="">退出</a></li>
		</ul>
	</div>
</div>