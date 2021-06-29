<%-- 
    Document   : room
    Created on : 26-Apr-2021, 11:43:53 pm
    Author     : DELL
--%>

<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>


<%@page import="java.beans.Statement"%>
<%@page import="java.sql.Connection"%>
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

            .form-style-5{
                max-width: 500px;
                padding: 10px 20px;
                background: #f4f7f8;
                margin: 10px auto;
                padding: 20px;
                background: #f4f7f8;
                border-radius: 8px;
                font-family: Georgia, "Times New Roman", Times, serif;
            }
            .form-style-5 fieldset{
                border: none;
            }
            .form-style-5 legend {
                font-size: 1.4em;
                margin-bottom: 10px;
            }
            .form-style-5 label {
                display: block;
                margin-bottom: 8px;
            }
            .form-style-5 input[type="text"],
            .form-style-5 input[type="date"],
            .form-style-5 input[type="datetime"],
            .form-style-5 input[type="email"],
            .form-style-5 input[type="number"],
            .form-style-5 input[type="search"],
            .form-style-5 input[type="time"],
            .form-style-5 input[type="url"],
            .form-style-5 textarea,
            .form-style-5 select {
                font-family: Georgia, "Times New Roman", Times, serif;
                background: rgba(255,255,255,.1);
                border: none;
                border-radius: 4px;
                font-size: 15px;
                margin: 0;
                outline: 0;
                padding: 10px;
                width: 100%;
                box-sizing: border-box; 
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box; 
                background-color: #e8eeef;
                color:#8a97a0;
                -webkit-box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
                box-shadow: 0 1px 0 rgba(0,0,0,0.03) inset;
                margin-bottom: 30px;
            }
            .form-style-5 input[type="text"]:focus,
            .form-style-5 input[type="date"]:focus,
            .form-style-5 input[type="datetime"]:focus,
            .form-style-5 input[type="email"]:focus,
            .form-style-5 input[type="number"]:focus,
            .form-style-5 input[type="search"]:focus,
            .form-style-5 input[type="time"]:focus,
            .form-style-5 input[type="url"]:focus,
            .form-style-5 textarea:focus,
            .form-style-5 select:focus{
                background: #d2d9dd;
            }
            .form-style-5 select{
                -webkit-appearance: menulist-button;
                height:35px;
            }
            .form-style-5 .number {
                background: #1abc9c;
                color: #fff;
                height: 30px;
                width: 30px;
                display: inline-block;
                font-size: 0.8em;
                margin-right: 4px;
                line-height: 30px;
                text-align: center;
                text-shadow: 0 1px 0 rgba(255,255,255,0.2);
                border-radius: 15px 15px 15px 0px;
            }

            .form-style-5 input[type="submit"],
            .form-style-5 input[type="button"]
            {
                position: relative;
                display: block;
                padding: 19px 39px 18px 39px;
                color: #FFF;
                margin: 0 auto;
                background: #1abc9c;
                font-size: 18px;
                text-align: center;
                font-style: normal;
                width: 100%;
                border: 1px solid #16a085;
                border-width: 1px 1px 3px;
                margin-bottom: 10px;
            }
            .form-style-5 input[type="submit"]:hover,
            .form-style-5 input[type="button"]:hover
            {
                background: #109177;
            }

        </style>
        <meta charset="UTF-8">
        <title>Room Booking</title>
    </head>
    <body>
    <center style="padding-top: 20px"><h1>TAJ HOTEL ONLINE ROOM BOOKING</h1></center>
    <br>
    <hr>
    <br>

    <sql:setDataSource  driver = "com.mysql.jdbc.Driver"
                        url = "jdbc:mysql:///projecthms"
                        user = "root" password = ""
                        var="snapshot"/>

    <sql:query dataSource = "${snapshot}" var = "result1">
        SELECT * from room where available="Available" and bed_type="Single Bed";
    </sql:query>

    <sql:query dataSource = "${snapshot}" var = "result2">
        SELECT * from room where available="Available" and bed_type="Double Bed";
    </sql:query>

    <div class="form-style-5">
        <form action="customer.jsp" method="POST">
            <fieldset>
                <legend><span class="number">1</span> Customer Info</legend>
                <input type="text" name="name" placeholder="Your Name">
                <input type="text" name="number" placeholder="Your Number">
                <label for="gender">Gender:</label>
                <select id="gender" name="gender">
                    <optgroup label="gender">
                        <option value="Male">Male</option>
                        <option value="Female">Female</option>
                    </optgroup>
                </select>
                <label for="id">ID Proof:</label>
                <select id="id" name="id">
                    <optgroup label="id">
                        <option value="Aadhar Card">Aadhar Card</option>
                        <option value="Driving License">Driver License</option>
                        <option value="Voter ID">Voter ID</option>
                        <option value="Passport">Password</option>
                    </optgroup>
                </select>      
            </fieldset>
            <fieldset>
                <legend><span class="number">2</span> Additional Info</legend>
                <input type="text" name="country" placeholder="Your Country">
                <label for="deposit">Deposit:</label>
                <input type="text" name="deposit" value="2000">
                <label for="id">Room No.:</label>
                <select id="room" name="room">
                    <optgroup label="Single Bed">
                        <c:forEach var = "row" items = "${result1.rows}">
                            <option value="${row.room_number}">${row.room_number} (Rs.${row.price})</option>
                        </c:forEach>
                    </optgroup>
                    <optgroup label="Double Bed">
                        <c:forEach var = "row" items = "${result2.rows}">
                            <option value="${row.room_number}">${row.room_number} (Rs.${row.price})</option>
                        </c:forEach>
                    </optgroup>
                </select>  
            </fieldset>
            <!-- <button class="box" type="submit">Book</button> -->
            <input type="submit" value="Apply" />
        </form>
    </div>
    
    
        
</body>
</html>
