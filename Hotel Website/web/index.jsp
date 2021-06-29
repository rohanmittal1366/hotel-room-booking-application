<%-- 
    Document   : index
    Created on : 26-Apr-2021, 10:41:15 pm
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            body{
                margin: 0px;
                background-color: cyan;
            }
            .back{
                padding-top: 0px;
                background-image: url("images/Home.jpg");
                background-color: #cccccc;
                height: 650px;
                background-position: center;
                background-repeat: no-repeat;
                background-size: cover;
                position: relative;
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
                font-size: 25px;
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
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="back">

            <center style="padding-top: 10px"><h1>THE TAJ GROUP WELCOMES YOU</h1></center>
            <div style="padding-top: 400px; display:flex; justify-content:space-around">
                <a class="box" href="status.jsp">CHECK STATUS</a>
                <a class="box" href="room.jsp">BOOK ROOM</a>
            </div>
            
        </div>

    </body>
</html>
