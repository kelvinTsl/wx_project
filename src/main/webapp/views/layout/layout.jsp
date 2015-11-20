<%@ page language="java"  import="java.util.*" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台模板管理系统</title>
<link type="text/css" rel="stylesheet" href='<c:url value="/assets/css/style.css"></c:url>' />
<script type="text/javascript" src='<c:url value="/assets/js/jquery-1.8.3.min.js"></c:url>'></script>
<script type="text/javascript" src='<c:url value="/assets/js/menu.js"></c:url>'></script>
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
    <div class="m-right">
    	<div class="right-nav">
			<ul>
				<li style="margin-left:25px;">您当前的位置：</li>
				<li><a id="nav_1" href="#">系统公告</a></li>
				<li>></li>
				<li><a id="nav_2" href="#">最新公告</a></li>
			</ul>
		</div>
		<div class="main">
		</div>
    </div>
	<div>
	  <tiles:insertAttribute name="body" />
	</div>
</div>
<div class="bottom"></div>
<div id="footer">
  <tiles:insertAttribute name="footer" />
</div>
<script type="text/javascript">
	navList(12);

	function nav_change(obj){
		alert(obj);
		$("#nav_2").html($(obj).html);
		$("#nav_2").attr("href",href);
	}
</script>
</body>
</html>
