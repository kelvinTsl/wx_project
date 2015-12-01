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
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<style>
  #surveyList tr td {text-align:center}

</style>

<div>
  <div style="margin-top:10px;margin-left:10px;border:1px; height:120px">
    <div style="width:80%;float:left">
      <form id="searchForm" action="<co:url value='/rest/survey/list'/>" method="post">
        <input type="hidden" id="curPage" name="curPage" value="${pageDTO.curPage}"/>
        <input type="hidden" id="order" name="order" value="${pageDTO.order}" />
        <input type="hidden" id="orderType" name="orderType" value="${pageDTO.orderType}" />
      <table style="width:100%;border-collapse:separate; border-spacing:10px; ">
      <tr>
        <td width="10%">姓名</td>
        <td width="20%"><input type="text" value="${survey.candidate.candidateName}" name="candidate.candidateName"/></td>
        <td width="10%">性别</td>
        <td width="20%">
          <select id="candidateSex" name="candidate.candidateSex">
            <option value="">全部</option>
            <option value="M">男</option>
            <option value="W">女</option>
          </select>
        </td>
        <td width="10%">年龄</td>
        <td width="20%"><input type="text" name="candidate.candidateAge" value="${survey.candidate.candidateAge}"/></td>
        <td width="10%">风险</td>
        <td width="20%">
          <select id="risk" name="risk">
            <option value="">全部</option>
            <option value="H">高风险</option>
            <option value="M">中风险</option>
            <option value="L">低风险</option>
          </select>
        </td>
      </tr>
      <tr></tr>
      <tr style="margin-top: 10px">
        <td>联系电话</td>
        <td colspan="5"><input style="width: 80%" value="${survey.candidate.candidateCellphone}" name="candidate.candidateCellphone" value=""/></td>
        <td>状态</td>
        <td>
          <select id="status" name="status">
            <option value="">全部</option>
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
    </form>
    <div style="float:left; width:15%">
      <button onclick="submit();" type="button" style="width:100px;height:60px;margin-top:10px">搜索</button>
    </div>

  </div>
  <div style="width:100%">
    <table id="surveyList" style=" width:90%">
      <thead>
      <tr style="height: 30px">
        <th style="width:5%;">序号</th>
        <th style="width:10%">姓名</th>
        <th style="width:5%"性别</th>
        <th style="width:5%" onclick="order('candidate.candidateAge','DESC')">年龄</th>
        <th style="width:20% " onclick="order('candidate.candidateCellphone','DESC')">联系电话</th>
        <th style="width:10%" onclick="order('surveyScore','DESC')">风险</th>
        <th style="width:10%">状态</th>
        <th style="width:30%">备注</th>
        <th></th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${surveys}" var="survey" varStatus="index">
      <tr style="height: 30px">
        <td style="text-align:center">${index.count}</td>

        <td>${survey.candidate.candidateName}</td>
        <td>${survey.candidate.candidateSex}</td>
        <td></td>
        <td>${survey.candidate.candidateCellphone}</td>
        <td>${survey.surveyScore}</td>
        <td>
          <select id="survey_status_${index.count}">
            <option value="0">未联系</option>
            <option value="1">联系不上</option>
            <option value="2">已联系</option>
            <option value="3">拒绝筛查</option>
            <option value="4">确认筛查</option>
            <option value="5">已来院</option>
          </select>
          <script type="text/javascript" >
            $("#survey_status_${index.count}").val("${survey.status}");
          </script>
        </td>
        <td><input style="width:90%" id="remark_${index.count}" value="${survey.remark}"/></td>
        <td><button onclick="update('${survey.surveyId}','${index.count}');">提交</button></td>
      </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <div>
    ${pageDTO.curPage}/${pageDTO.pageSize}
    <button onclick="lastPage()">上一页</button>
    <button onclick="nextPage()">下一页</button>
  </div>
</div>

<script type="text/javascript">
  var pageSize = parseFloat("${pageDTO.pageSize}");

  $(function(){
    $("#candidateSex").val('${survey.candidate.candidateSex}');
    $("#risk").val('${risk}');
    $("#status").val('${survey.status}');
  })

  function lastPage(){
    var curPage = parseFloat($("#curPage").val());
    if(curPage > 1){
      $("#curPage").val(curPage - 1);
    }
    $("#searchForm").submit();
  }

  function nextPage(){
    var curPage = parseFloat($("#curPage").val());
    if(curPage < pageSize){
      $("#curPage").val(curPage + 1);
    }
    $("#searchForm").submit();
  }

  function submit(){
    $("#curPage").val("1");
    $("#searchForm").submit();
  }

  function order(order, orderType){
    $("#order").val(order);
    var orderType = $("#orderType").val();
    if(orderType == "DESC"){
      $("#orderType").val("ASC");
    }else{
      $("#orderType").val("DESC");
    }

    submit();
  }

  function update(surveyId, index){
    debugger;
    var remark = $("#remark_"+index).val();
    var status = $("#survey_status_"+index).val();
    $.ajax({
      url: "<c:url value="/rest/survey/updateStatus"/>",
      type: "post",
      data: {remark:remark, status:status, surveyId:surveyId},
      success: function(data){
        if(data.status == "success"){
          alert("提交成功");
        }else{
          alert("提交失败");
        }
      },
      dataType: "json",
      error:function(XMLHttpRequest, textStatus, errorThrown)
      {
        alert(textStatus);
      }
    })
  }
</script>


