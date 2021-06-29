<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<%@include file="index.jsp" %>

<html>
    <head>
        <title>SELECT Operation</title>
    </head>

    <body>
        <sql:setDataSource  driver = "com.mysql.jdbc.Driver"
                            url = "jdbc:mysql:///projecthms"
                            user = "root" password = ""
                            var="snapshot"/>


        <sql:update dataSource = "${snapshot}" var = "result">
            <%--INSERT INTO customer VALUES (<%= request.getParameter("id")%>, <%= request.getParameter("number")%>, <%= request.getParameter("name")%>, <%= request.getParameter("gender")%>, <%= request.getParameter("country")%>, <%= request.getParameter("room")%>, 'Checked Out' , <%= request.getParameter("deposit")%>);--%>
            INSERT INTO customer VALUES ('<%= request.getParameter("id")%>', '<%= request.getParameter("number")%>', '<%= request.getParameter("name")%>', '<%= request.getParameter("gender")%>', '<%= request.getParameter("country")%>', '<%= request.getParameter("room")%>', 'Checked Out' , '<%= request.getParameter("deposit")%>');
            <%--UPDATE room SET available='Occupied' where room_number=<%= request.getParameter("room")%>--%>
        </sql:update>
        <sql:update dataSource = "${snapshot}" var = "result">
            UPDATE room SET available='Occupied' where room_number=<%= request.getParameter("room")%>
        </sql:update>
        
        
        
    </body>
</html>


