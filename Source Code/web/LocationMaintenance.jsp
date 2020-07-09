<%-- 
    Document   : LocationMaintenance
    Created on : Jul 20, 2019, 4:02:22 PM
    Author     : Bosco
--%>

<%@page import="DA.categoriesDA"%>
<%@page import="domain.List" %>
<%@page import="domain.ListInterface" %>
<%@page import="domain.Location" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>JSP Page</title>
    </head>
    <body>

        <% categoriesDA cda = new categoriesDA();
            List<Location> all_loc = new List<Location>();
        %>
        <style>
            .inputtag{
                margin: 15px 15px;
            }
            button{
                margin:0 40%  ;
                width: 20%;
                }
            input{
                margin: 5px 5px;
            }
            .pos-rel{
                position:relative;
            }
            .pos-rel .nav-item{
                margin:0 1em;
            }
            .connected-line{
                border-bottom: 1px solid #000000;
                position: relative;
                top: -20px;
                z-index: -1;
            }
            .seminor-login-modal-body .close{
                position: relative;
                top: -45px;
                left: 10px;
                color: #1cd8ad;
            }
            .seminor-login-modal-body .close{
                opacity:0.75;
            }

            .seminor-login-modal-body .close:focus, .seminor-login-modal-body .close:hover {
                color: #39e8b0;
                opacity: 1;
                text-decoration: none;
                outline:0;
            }

            .seminor-login-modal .modal-dialog .modal-content{
                border-radius:0px;
            }

            /* form animation */
            .seminor-login-form .form-group {
                position: relative;
                margin-bottom: 1.5em !important;
            }
            .seminor-login-form .form-control{
                border: 0px solid #ced4da !important;
                border-bottom:1px solid #adadad !important;
                border-radius:0 !important;
            }
            .seminor-login-form .form-control:focus, .seminor-login-form .form-control:active{
                outline:none !important;
                outline-width: 0;
                border-color: #adadad !important;
                box-shadow: 0 0 0 0.2rem transparent;
            }
            *:focus {
                outline: none;
            }
            .seminor-login-form{
                padding: 2em 0 0;
            }

            .form-control-placeholder {
                position: absolute;
                top: 0;
                padding: 7px 0 0 13px;
                transition: all 200ms;
                opacity: 0.5;
                border-top: 0px;
                border-left: 0;
                border-right: 0;
            }

            .form-control:focus + .form-control-placeholder,
            .form-control:valid + .form-control-placeholder {
                font-size: 75%;
                -webkit-transform: translate3d(0, -100%, 0);
                transform: translate3d(0, -100%, 0);
                opacity: 1;
            }

            .container-checkbox input {
                position: absolute;
                opacity: 0;
                cursor: pointer;
            }
            .checkmark-box {
                position: absolute;
                top: -5px;
                left: 0;
                height: 25px;
                width: 25px;
                background-color: #adadad;
            }
            .container-checkbox {
                display: block;
                position: relative;
                padding-left: 40px;
                margin-bottom: 20px;
                cursor: pointer;
                font-size: 14px;
                font-weight: bold;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
                line-height: 1.1;
            }
            .container-checkbox input:checked ~ .checkmark-box:after {
                color: #fff;
            }
            .container-checkbox input:checked ~ .checkmark-box:after {
                display: block;
            }
            .container-checkbox .checkmark-box:after {
                left: 10px;
                top: 4px;
                width: 7px;
                height: 15px;
                border: solid white;
                border-width: 0 3px 3px 0;
                -webkit-transform: rotate(45deg);
                -ms-transform: rotate(45deg);
                transform: rotate(45deg);
            }
            .checkmark:after, .checkmark-box:after {
                content: "";
                position: absolute;
                display: none;
            }
            .container-checkbox input:checked ~ .checkmark-box {
                background-color: #f58220;
                border: 0px solid transparent;
            }
            .btn-check-log .btn-check-login {
                font-size: 16px;
                padding: 10px 0;
            }
            button.btn-check-login:hover {
                color: #fff;
                background-color: #f58220;
                border: 2px solid #f58220;
            }
            .btn-check-login {
                color: #f58220;
                background-color: transparent;
                border: 2px solid #f58220;
                transition: all ease-in-out .3s;
            }
            .btn-check-login {
                display: inline-block;
                padding: 12px 0;
                margin-bottom: 0;
                line-height: 1.42857143;
                text-align: center;
                white-space: nowrap;
                vertical-align: middle;
                -ms-touch-action: manipulation;
                touch-action: manipulation;
                cursor: pointer;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
                background-image: none;
                border-radius: 0;
                width: 100%;
            }
            .forgot-pass-fau a {
                text-decoration: none !important;
                font-size: 14px;
            }
            .text-primary-fau {
                color: #1959a2;
            }

            .select-form-control-placeholder{
                font-size: 100%;
                padding: 7px 0 0 13px;
                margin: 0;
            }
            /*
             * Copyright (c) 2013 Thibaut Courouble
             * http://www.cssflow.com
             * Licensed under the MIT License
             *
             * Sass/SCSS source: https://goo.gl/dR9lvb
             * PSD by Dylan Opet: https://goo.gl/K5zTOL
             */

            body {
                font: 13px/20px 'Helvetica Neue', Helvetica, Arial, sans-serif;
                color: #404040;
            }

            .sign-up {
                position: relative;
                margin: 20px auto;
                width: 388px;
                padding: 33px 25px 29px;
                background: white;
                border-bottom: 1px solid #c4c4c4;
                border-radius: 5px;
                -webkit-box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
                box-shadow: 0 1px 5px rgba(0, 0, 0, 0.25);
            }

            .sign-up:before, .sign-up:after {
                content: '';
                position: absolute;
                bottom: 1px;
                left: 0;
                right: 0;
                height: 10px;
                background: inherit;
                border-bottom: 1px solid #d2d2d2;
                border-radius: 4px;
            }

            .sign-up:after {
                bottom: 3px;
                border-color: #dcdcdc;
            }

            .sign-up-title {
                margin: -25px -25px 25px;
                padding: 15px 25px;
                line-height: 35px;
                font-size: 26px;
                font-weight: 300;
                color: #aaa;
                text-align: center;
                text-shadow: 0 1px rgba(255, 255, 255, 0.75);
                background: #f7f7f7;
            }

            .sign-up-title:before {
                content: '';
                position: absolute;
                top: 0;
                left: 0;
                right: 0;
                height: 8px;
                background: #c4e17f;
                border-radius: 5px 5px 0 0;
                background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
                background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
                background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
                background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
            }

            input {
                font-family: inherit;
                color: inherit;
                -webkit-box-sizing: border-box;
                -moz-box-sizing: border-box;
                box-sizing: border-box;
            }

            .sign-up-input {
                width: 100%;
                height: 50px;
                margin-bottom: 25px;
                padding: 0 15px 2px;
                font-size: 17px;
                background: white;
                border: 2px solid #ebebeb;
                border-radius: 4px;
                -webkit-box-shadow: inset 0 -2px #ebebeb;
                box-shadow: inset 0 -2px #ebebeb;
            }

            .sign-up-input:focus {
                border-color: #62c2e4;
                outline: none;
                -webkit-box-shadow: inset 0 -2px #62c2e4;
                box-shadow: inset 0 -2px #62c2e4;
            }

            .lt-ie9 .sign-up-input {
                line-height: 48px;
            }

            .sign-up-button {
                position: relative;
                vertical-align: top;
                width: 100%;
                height: 54px;
                padding: 0;
                font-size: 22px;
                color: white;
                text-align: center;
                text-shadow: 0 1px 2px rgba(0, 0, 0, 0.25);
                background: #f0776c;
                border: 0;
                border-bottom: 2px solid #d76b60;
                border-radius: 5px;
                cursor: pointer;
                -webkit-box-shadow: inset 0 -2px #d76b60;
                box-shadow: inset 0 -2px #d76b60;
            }

            .sign-up-button:active {
                top: 1px;
                outline: none;
                -webkit-box-shadow: none;
                box-shadow: none;
            }

            :-moz-placeholder {
                color: #ccc;
                font-weight: 300;
            }

            ::-moz-placeholder {
                color: #ccc;
                opacity: 1;
                font-weight: 300;
            }

            ::-webkit-input-placeholder {
                color: #ccc;
                font-weight: 300;
            }

            :-ms-input-placeholder {
                color: #ccc;
                font-weight: 300;
            }

            ::-moz-focus-inner {
                border: 0;
                padding: 0;
            }


        </style>
        <div> <a href="AdminPage.jsp" class="btn btn-success" style="color:white;">Back</a> </div>
        <div class="container-fluid" style="margin-top: 10px;">
            <div class="row">
                <div class="col-sm-12">
                    <div class="pos-rel">
                        <!-- Nav pills -->
                        <ul class="nav nav-pills justify-content-center nav-justified" role="tablist">
                            <li class="nav-item">
                                <a class="nav-link  btn btn-secondary" id="continent" data-toggle="pill" style="color:white ;">CONTINENT</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn btn-secondary" id="country" data-toggle="pill" style="color:white ;">COUNTRY</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn btn-secondary" id="state" data-toggle="pill" style="color:white ;">STATE</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link btn btn-secondary" id="location" data-toggle="pill" style="color:white ;">LOCATION</a>
                            </li>
                        </ul>
                        <div class="connected-line"></div>
                        <!-- Tab panes -->

                    </div>
                </div>
            </div>
        </div>
    </div>



    <div class="continent">
        <form class="sign-up" action="LocationMaintenance" method="Post">
            <h1 class="sign-up-title">Add Continent</h1>
            <div class="inputtag">  Continent Name:<input type="text" name="Name"> </div>
            <button class=" btn btn-success" type="submit" name="addcon">Add</button>
        </form>
    </div>

    <div class="country">

        <form class="sign-up" action="LocationMaintenance" method="Post">
            <h1 class="sign-up-title">Add Country</h1>
            <div class="inputtag"> Continent <input  list="all_continent" type="text" name="ID"></div>
            <div class="inputtag">  Country Name:<input type="text" name="Name"></div>
            <datalist id="all_continent"  style="height:20px; ">
                <% all_loc = cda.getAllcont();
                    for (int i = 0; i < all_loc.size(); i++) {%>
                <option ><%=all_loc.getValueOf(i + 1).getName()%> </option>
                <% }%>
            </datalist>        
            <div class="inputtag">Picture Link:<input type="text" name="Link"></div>
            <button class=" btn btn-success"type="submit" name="addcount">Add</button>
        </form>
    </div>

    <div class="state">

        <form class="sign-up" action="LocationMaintenance" method="Post">
            <h1 class="sign-up-title">Add State</h1>
            <div class="inputtag">  Country :<input list="all_country"type="text" name="ID"></div>
            <div class="inputtag">  State Name:<input type="text" name="Name"></div>
            <datalist id="all_country"  style="height:20px; ">
                <% all_loc = cda.getAllcountry();
                    for (int i = 0; i < all_loc.size(); i++) {%>
                <option ><%=all_loc.getValueOf(i + 1).getName()%> </option>
                <% }%>
            </datalist> 
            <div class="inputtag">Picture Link:<input type="text" name="Link"></div>
            <button class=" btn btn-success" type="submit" name="addstate">Add</button>

        </form>
    </div>

    <div class="location">

        <form class="sign-up" action="LocationMaintenance" method="Post">
            <h1 class="sign-up-title">Add Location</h1>
            <div class="inputtag">   State:<input list="all_state" type="text" name="ID"></div> 
            <div class="inputtag">   Longitude: <input type="text" name="Longitude"></div> 
            <div class="inputtag">    Latitude: <input type="text" name="Latitude"></div> 
            <div class="inputtag">    Location Name:<input type="text" name="Name"></div> 
            <div class="inputtag">   Location Type: <!--<input type="text" name="Type">--> <select  style="height: 30px" name ="Type" class="LocationType">
       <option value="s">Small City</option>
       <option value="m">Medium City</option>
       <option value="l">Large City</option>
       <option value="n">Natural Formation</option>
       <option value="p">Designated Park Or Reserve</option>
       <option value="k">Man-made Landmark</option>
    </select> </div> 
            <div class="inputtag">   Pickup:</div>  
            <div class="inputtag"> <input type="checkbox" name="Train">Train Station</div> 
            <div class="inputtag">   <input type="checkbox" name="Bus"> Bus Station </div> 
            <div class="inputtag">   <input type="checkbox" name="Airport"> Airport </div> 
            <datalist id="all_state"  style="height:20px; ">
                <% all_loc = cda.getAllstate();
                    for (int i = 0; i < all_loc.size(); i++) {%>
                <option ><%=all_loc.getValueOf(i + 1).getName()%> </option>
                <% }%>
            </datalist> 
            <div class="inputtag"> Picture Link:<input type="text" name="Link"></div> 
            <button class=" btn btn-success" type="submit" name="addlocation">Add</button>

        </form>
    </div>

</body>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
    $(".continent").show();
    $(".country").hide();
    $(".state").hide();
    $(".location").hide();
    $("#continent").click(function () {
        $(".continent").show();
        $(".country").hide();
        $(".state").hide();
        $(".location").hide();
    });
    $("#country").click(function () {
        $(".continent").hide();
        $(".country").show();
        $(".state").hide();
        $(".location").hide();
    });
    $("#state").click(function () {
        $(".continent").hide();
        $(".country").hide();
        $(".state").show();
        $(".location").hide();
    });
    $("#location").click(function () {
        $(".continent").hide();
        $(".country").hide();
        $(".state").hide();
        $(".location").show();
    });



</script>
</html>
