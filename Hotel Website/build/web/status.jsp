<%-- 
    Document   : status
    Created on : 27-Apr-2021, 2:26:42 pm
    Author     : DELL
--%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            html, body {
                width: 100%;
                height:100%;
            }

            body {
                background: linear-gradient(-45deg, #ee7752, #e73c7e, #23a6d5, #23d5ab);
                background-size: 400% 400%;
                animation: gradient 15s ease infinite;
            }

            @keyframes gradient {
                0% {
                    background-position: 0% 50%;
                }
                50% {
                    background-position: 100% 50%;
                }
                100% {
                    background-position: 0% 50%;
                }
            }

            .box {
                background: linear-gradient(to right, gold, darkorange);
                color: white;
                --width: 600px;
                --height: calc(var(--width) / 3);
                width: var(--width);
                height: var(--height);
                text-align: center;
                line-height: var(--height);
                font-size: 35px;
                font-family: sans-serif;
                letter-spacing: 0.2em;
                border: 2px solid darkgoldenrod;
                border-radius: 2em;
                transform: perspective(500px) rotateY(-15deg);
                text-shadow: 6px 3px 2px rgba(0, 0, 0, 0.2);
                box-shadow: 2px 0 0 5px rgba(0, 0, 0, 0.2);
                transition: 0.5s;
                position: relative;
                overflow: hidden;
            }

            .box:hover {
                transform: perspective(500px) rotateY(15deg);
                text-shadow: -6px 3px 2px rgba(0, 0, 0, 0.2);
                box-shadow: -2px 0 0 5px rgba(0, 0, 0, 0.2);
            }

            .box::before {
                content: '';
                position: absolute;
                width: 100%;
                height: 100%;
                background: linear-gradient(to right, transparent, white, transparent);
                left: -100%;
                transition: 0.5s;
            }

            .box:hover::before {
                left: 100%;
            }

            .form__label {
                font-family: 'Roboto', sans-serif;
                font-size: 1.2rem;
                margin-left: 2rem;
                margin-top: 0.7rem;
                display: block;
                transition: all 0.3s;
                transform: translateY(0rem);
            }



        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center style="padding-top: 20px; padding-bottom: 30px"><h1>GREETINGS</h1></center>
    <hr>
    <form action="status.jsp" method="POST">
    <div style="display:flex; justify-content: space-around; padding-top: 20px">
        <h3 style="">PLEASE ENTER YOUR ID</h3>
        <input name="id" type="text" placeholder="ENTER YOUR ID" size="35" height="10"style="border-radius: 25px; text-align: center">
        <button class="box" type="submit">Check</button>
        <!-- <a class="box" type="submit" href="status.jsp">Check</a> -->
    </div>
    </form>
    <br>
    <hr>
    <br>
    <br>
    <sql:setDataSource  driver = "com.mysql.jdbc.Driver"
                        url = "jdbc:mysql:///projecthms"
                        user = "root" password = ""
                        var="snapshot"/>

    <sql:query dataSource = "${snapshot}" var = "result">
        SELECT * from customer where number=<%= request.getParameter("id")%>;
    </sql:query>

    <table border = "5" width = "100%">
        <tr>
            <th>ID</th>
            <th>ID Number</th>
            <th>Name</th>
            <th>Room</th>
            <th>Deposit</th>
            <th>Status</th>
        </tr>

        <c:forEach var = "row" items = "${result.rows}">
            <tr>
                <td><c:out value = "${row.id}"/></td>
                <td><c:out value = "${row.number}"/></td>
                <td><c:out value = "${row.name}"/></td>
                <td><c:out value = "${row.room}"/></td>
                <td><c:out value = "${row.deposit}"/></td>
                <td><c:out value = "${row.status}"/></td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>