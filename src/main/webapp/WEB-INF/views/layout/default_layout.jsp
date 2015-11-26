<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
    <head>
    	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport"
			content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<meta HTTP-EQUIV="pragma" CONTENT="no-cache">
		<meta HTTP-EQUIV="Cache-Control" CONTENT="no-store, must-revalidate">
		<meta HTTP-EQUIV="expires" CONTENT="0">
		<title></title>
    </head>
    <body>
    	<input type="hidden" value="<%=request.getContextPath()%>" id="req_path"/>
   		<div>
    	</div>
    	
    	<div>
			<tiles:insertAttribute name="body" />
		</div>
		<br/>
    </body>
</html>