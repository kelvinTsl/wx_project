<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java"  contentType="text/html; charset=utf-8" %>





				<spring:message code="abc" />
                <spring:message code="abc" />
                <spring:message code="abc" />

                <spring:message code="ccc" />

                11111 ${abc} 22222

                <h2>Hello World! 中文</h2>
                <h2>${message}</h2>
                <h2>${name}1111111111</h2>
                <a href="${path}/index?name=中文名字">点击</a>

                <form action="/product/index" method="post">
                	<input name="name" value="中文名字"/>
                	<button type="submit">提交</button>
                </form>
