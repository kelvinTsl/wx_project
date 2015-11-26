<%--
  Created by IntelliJ IDEA.
  User: kelvin
  Date: 15/11/26
  Time: 下午9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
  <div style="margin-top:10px;margin-left:10px;border:1px;">
    <div style="width:60%">
    <table style="width:100%;border-collapse:separate; border-spacing:10px; ">
      <tr>
        <td width="10%">姓名</td>
        <td width="20%"><input type="text" value="" name=""/></td>
        <td width="10%">性别</td>
        <td width="20%">
          <select>
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
        <td colspan="5"><input style="width: 80%" value=""/></td>
        <td>状态</td>
        <td>
          <select>
            <option value="">未联系</option>
            <option value="">联系不上</option>
            <option value="">已联系</option>
            <option value="">拒绝筛查</option>
            <option value="">确认筛查</option>
            <option value="">已来院</option>
          </select>
        </td>
      </tr>
    </table>
    </div>
    <div>
      <button>搜索</button>
    </div>
  </div>
  <div>
    <table>

    </table>
  </div>
</div>
