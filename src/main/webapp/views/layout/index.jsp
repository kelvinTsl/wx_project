<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台模板管理系统</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="/assets/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="/assets/js/menu.js"></script>
</head>

<body>
<div class="top"></div>
<div id="header">
	<tiles:insertAttribute name="header" />
</div>
<div id="content">
	<div class="left_menu">
      <tiles:insertAttribute name="left_menu" />
    </div>
	<div>
	  <tiles:insertAttribute name="body" />
	</div>
</div>
<div class="bottom"></div>
<div id="footer">
  <tiles:insertAttribute name="footer" />
</div>
<script>navList(12);</script>
</body>
</html>
