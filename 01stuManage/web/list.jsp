<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/18
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生列表页面</title>
    <script>
        function doDelete(sid) {
            var flag = confirm("是否删除？");
            if(flag){
                //访问servlet
                location.href = "/deleteServlet?sid=" + sid;
            }
        }
    </script>
</head>
<body>
<form action="searchStudentServlet" method="post">
    <table border="1" width="700">
        <tr>
            <td colspan="8">

                按姓名查询:<input type="text" name="sname"/>
                &nbsp;
                按性别查询:<select name="sgender">
                <option value="">--请选择--
                <option value="男">男
                <option value="女">女
            </select>
                &nbsp;&nbsp;&nbsp;
                <input type="submit" value="查询">
                &nbsp;&nbsp;&nbsp;
                <a href="add.jsp">添加</a>
            </td>
        </tr>

        <tr align="center">
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>电话</td>
            <td>生日</td>
            <td>爱好</td>
            <td>简介</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${list }" var="stu">
            <tr align="center">
                <td>${stu.sid }</td>
                <td>${stu.sname }</td>
                <td>${stu.gender }</td>
                <td>${stu.phone }</td>
                <td>${stu.birthday }</td>
                <td>${stu.hobby }</td>
                <td>${stu.info }</td>
                <td><a href="editServlet?sid=${stu.sid }">更新</a> <a href="#" onclick="doDelete(${stu.sid})">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
