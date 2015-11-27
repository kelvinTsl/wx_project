<%--
  Created by IntelliJ IDEA.
  User: kelvin
  Date: 15/11/26
  Time: 下午9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="co" uri="http://java.sun.com/jstl/core"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
  <div style="margin-top:10px;margin-left:10px;border:1px;">
    <form action="list" method="get">
      <input type="hidden" name="curPage" value="2"/>
    <div style="width:80%">
      <table style="width:100%;border-collapse:separate; border-spacing:10px; ">
      <tr>
        <td width="10%">姓名</td>
        <td width="20%"><input type="text" value="" name="candidate.candidateName"/></td>
        <td width="10%">性别</td>
        <td width="20%">
          <select name="candidate.candidateSex">
            <option value="">男</option>
            <option value="">女</option>
          </select>
        </td>
        <td width="10%">年龄</td>
        <td width="20%"><input type="text" value=""/></td>
        <td width="10%">风险</td>
        <td width="20%">
          <select>
            <option value="">高风险</option>
            <option value="">中风险</option>
            <option value="">低风险</option>
          </select>
        </td>
      </tr>
      <tr></tr>
      <tr style="margin-top: 10px">
        <td>手机</td>
        <td colspan="5"><input style="width: 80%" name="candidate.candidateCellphone" value=""/></td>
        <td>状态</td>
        <td>
          <select name="status">
            <option value="0">未联系</option>
            <option value="1">联系不上</option>
            <option value="2">已联系</option>
            <option value="3">拒绝筛查</option>
            <option value="4">确认筛查</option>
            <option value="5">已来院</option>
          </select>
        </td>
      </tr>
    </table>
    </div>
    <div>
      <button onclick="nextPage()">搜索</button>
    </div>
    </form>
  </div>
  <div style="height:650px; width:100%">
    <table style=" width:90%">
      <thead>
      <tr>
        <th style="width:25%">Date</th>
        <th style="width:25%">Start time</th>
        <th style="width:25%">End time</th>
        <th style="width:25%">Name</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${surveys}" var="survey">
      <tr>
        <td>${survey.candidate.candidateCellphone}</td>
        <td>${survey.candidate.candidateName}</td>
        <td>${survey.candidate.candidateSex}</td>
        <td>${survey.status}</td>
      </tr>
      </c:forEach>
      </tbody>
    </table>

  </div>
</div>


