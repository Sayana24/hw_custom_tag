<%--
  Created by IntelliJ IDEA.
  User: sayan
  Date: 11.04.2024
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="ctg" uri="customtags" %>
<html>
<head>
    <title>Rating Table</title>
</head>
<body>
<ctg:student-table rows="${st.size}" head="Students">
    ${st.rating}
</ctg:student-table>

</body>
</html>
