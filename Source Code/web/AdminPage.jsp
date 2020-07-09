<%-- 
    Document   : AdminPage
    Created on : July 27, 2019, 12:13:52 PM
    Author     : tanyj
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin menu</title>
    </head>
  
    <style class="cp-pen-styles">body {
            overflow: hidden;

        }

        .menu-toggler {
            position: absolute;
            display: block;
            top: 0;
            bottom: 0;
            right: 0;
            left: 0;
            margin: auto;
            width: 40px;
            height: 40px;
            z-index: 2;
            opacity: 0;
            cursor: pointer;
        }
        .menu-toggler:hover + label, .menu-toggler:hover + label:before, .menu-toggler:hover + label:after {
            background: white;
        }

        .menu-toggler:checked + label {
            background: transparent;
        }
        .menu-toggler:checked + label:before, .menu-toggler:checked + label:after {
            top: 0;
            width: 40px;
            -webkit-transform-origin: 50% 50%;
            transform-origin: 50% 50%;
        }
        .menu-toggler:checked + label:before {
            -webkit-transform: rotate(45deg);
            transform: rotate(45deg);
        }
        .menu-toggler:checked + label:after {
            -webkit-transform: rotate(-45deg);
            transform: rotate(-45deg);
        }

        .menu-toggler:checked ~ ul .menu-item {
            opacity: 1;
        }
        .menu-toggler:checked ~ ul .menu-item:nth-child(1) {
            -webkit-transform: rotate(0deg) translateX(-110px);
            transform: rotate(0deg) translateX(-110px);
        }
        .menu-toggler:checked ~ ul .menu-item:nth-child(2) {
            -webkit-transform: rotate(60deg) translateX(-110px);
            transform: rotate(60deg) translateX(-110px);
        }
        .menu-toggler:checked ~ ul .menu-item:nth-child(3) {
            -webkit-transform: rotate(120deg) translateX(-110px);
            transform: rotate(120deg) translateX(-110px);
        }
        .menu-toggler:checked ~ ul .menu-item:nth-child(4) {
            -webkit-transform: rotate(180deg) translateX(-110px);
            transform: rotate(180deg) translateX(-110px);
        }
        .menu-toggler:checked ~ ul .menu-item:nth-child(5) {
            -webkit-transform: rotate(240deg) translateX(-110px);
            transform: rotate(240deg) translateX(-110px);
        }
        .menu-toggler:checked ~ ul .menu-item:nth-child(6) {
            -webkit-transform: rotate(300deg) translateX(-110px);
            transform: rotate(300deg) translateX(-110px);
        }
        .menu-toggler:checked ~ ul .menu-item a {
            pointer-events: auto;
        }

        .menu-toggler + label {
            width: 40px;
            height: 5px;
            display: block;
            z-index: 1;
            border-radius: 2.5px;
            background: rgba(255, 255, 255, 0.7);
            transition: top 0.5s, -webkit-transform 0.5s;
            transition: transform 0.5s, top 0.5s;
            transition: transform 0.5s, top 0.5s, -webkit-transform 0.5s;
            position: absolute;
            display: block;
            top: 0;
            bottom: 0;
            right: 0;
            left: 0;
            margin: auto;
        }
        .menu-toggler + label:before, .menu-toggler + label:after {
            width: 40px;
            height: 5px;
            display: block;
            z-index: 1;
            border-radius: 2.5px;
            background: rgba(255, 255, 255, 0.7);
            transition: top 0.5s, -webkit-transform 0.5s;
            transition: transform 0.5s, top 0.5s;
            transition: transform 0.5s, top 0.5s, -webkit-transform 0.5s;
            content: "";
            position: absolute;
            left: 0;
        }
        .menu-toggler + label:before {
            top: 10px;
        }
        .menu-toggler + label:after {
            top: -10px;
        }

        .menu-item:nth-child(1) a {
            -webkit-transform: rotate(0deg);
            transform: rotate(0deg);
        }

        .menu-item:nth-child(2) a {
            -webkit-transform: rotate(-60deg);
            transform: rotate(-60deg);
        }

        .menu-item:nth-child(3) a {
            -webkit-transform: rotate(-120deg);
            transform: rotate(-120deg);
        }

        .menu-item:nth-child(4) a {
            -webkit-transform: rotate(-180deg);
            transform: rotate(-180deg);
        }

        .menu-item:nth-child(5) a {
            -webkit-transform: rotate(-240deg);
            transform: rotate(-240deg);
        }

        .menu-item:nth-child(6) a {
            -webkit-transform: rotate(-300deg);
            transform: rotate(-300deg);
        }

        .menu-item {
            position: absolute;
            display: block;
            top: 0;
            bottom: 0;
            right: 0;
            left: 0;
            margin: auto;
            width: 80px;
            height: 80px;
            display: block;
            opacity: 0;
            transition: 0.5s;
        }

        .menu-item a {
            display: block;
            width: inherit;
            height: inherit;
            line-height: 80px;
            color: rgba(255, 255, 255, 0.7);
            background: rgba(255, 255, 255, 0.2);
            border-radius: 50%;
            text-align: center;
            text-decoration: none;
            font-size: 40px;
            pointer-events: none;
            transition: .2s;
        }
        .menu-item a:hover {
            box-shadow: 0 0 0 2px rgba(255, 255, 255, 0.3);
            color: white;
            background: rgba(255, 255, 255, 0.3);
            font-size: 44.4444444444px;
        }
    </style>
    <body>
    <html lang="en" class=""><head><script src="//static.codepen.io/assets/editor/live/console_runner-1df7d3399bdc1f40995a35209755dcfd8c7547da127f6469fd81e5fba982f6af.js"></script><script src="//static.codepen.io/assets/editor/live/css_reload-5619dc0905a68b2e6298901de54f73cefe4e079f65a75406858d92924b4938bf.js"></script><meta charset="UTF-8"><meta name="robots" content="noindex"><link rel="shortcut icon" type="image/x-icon" href="//static.codepen.io/assets/favicon/favicon-8ea04875e70c4b0bb41da869e81236e54394d63638a1ef12fa558a4a835f1164.ico"><link rel="mask-icon" type="" href="//static.codepen.io/assets/favicon/logo-pin-f2d2b6d2c61838f7e76325261b7195c27224080bc099486ddd6dccb469b8e8e6.svg" color="#111"><link rel="canonical" href="https://codepen.io/anon/pen/OrQBJX">
            <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
            <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
            <style class="cp-pen-styles">body {
                    overflow: hidden;
                }

                .menu-toggler {
                    position: absolute;
                    display: block;
                    top: 0;
                    bottom: 0;
                    right: 0;
                    left: 0;
                    margin: auto;
                    width: 40px;
                    height: 40px;
                    z-index: 2;
                    opacity: 0;
                    cursor: pointer;
                }
                .menu-toggler:hover + label, .menu-toggler:hover + label:before, .menu-toggler:hover + label:after {
                    background: white;
                }

                .menu-toggler:checked + label {
                    background: transparent;
                }
                .menu-toggler:checked + label:before, .menu-toggler:checked + label:after {
                    top: 0;
                    width: 40px;
                    -webkit-transform-origin: 50% 50%;
                    transform-origin: 50% 50%;
                }
                .menu-toggler:checked + label:before {
                    -webkit-transform: rotate(45deg);
                    transform: rotate(45deg);
                }
                .menu-toggler:checked + label:after {
                    -webkit-transform: rotate(-45deg);
                    transform: rotate(-45deg);
                }

                .menu-toggler:checked ~ ul .menu-item {
                    opacity: 1;
                }
                .menu-toggler:checked ~ ul .menu-item:nth-child(1) {
                    -webkit-transform: rotate(0deg) translateX(-110px);
                    transform: rotate(0deg) translateX(-110px);
                }
                .menu-toggler:checked ~ ul .menu-item:nth-child(2) {
                    -webkit-transform: rotate(60deg) translateX(-110px);
                    transform: rotate(60deg) translateX(-110px);
                }
                .menu-toggler:checked ~ ul .menu-item:nth-child(3) {
                    -webkit-transform: rotate(120deg) translateX(-110px);
                    transform: rotate(120deg) translateX(-110px);
                }
                .menu-toggler:checked ~ ul .menu-item:nth-child(4) {
                    -webkit-transform: rotate(180deg) translateX(-110px);
                    transform: rotate(180deg) translateX(-110px);
                }
                .menu-toggler:checked ~ ul .menu-item:nth-child(5) {
                    -webkit-transform: rotate(240deg) translateX(-110px);
                    transform: rotate(240deg) translateX(-110px);
                }
                .menu-toggler:checked ~ ul .menu-item:nth-child(6) {
                    -webkit-transform: rotate(300deg) translateX(-110px);
                    transform: rotate(300deg) translateX(-110px);
                }
                .menu-toggler:checked ~ ul .menu-item a {
                    pointer-events: auto;
                }

                .menu-toggler + label {
                    width: 40px;
                    height: 5px;
                    display: block;
                    z-index: 1;
                    border-radius: 2.5px;
                    background: rgba(255, 255, 255, 0.7);
                    transition: top 0.5s, -webkit-transform 0.5s;
                    transition: transform 0.5s, top 0.5s;
                    transition: transform 0.5s, top 0.5s, -webkit-transform 0.5s;
                    position: absolute;
                    display: block;
                    top: 0;
                    bottom: 0;
                    right: 0;
                    left: 0;
                    margin: auto;
                }
                .menu-toggler + label:before, .menu-toggler + label:after {
                    width: 40px;
                    height: 5px;
                    display: block;
                    z-index: 1;
                    border-radius: 2.5px;
                    background: rgba(255, 255, 255, 0.7);
                    transition: top 0.5s, -webkit-transform 0.5s;
                    transition: transform 0.5s, top 0.5s;
                    transition: transform 0.5s, top 0.5s, -webkit-transform 0.5s;
                    content: "";
                    position: absolute;
                    left: 0;
                }
                .menu-toggler + label:before {
                    top: 10px;
                }
                .menu-toggler + label:after {
                    top: -10px;
                }

                .menu-item:nth-child(1) a {
                    -webkit-transform: rotate(0deg);
                    transform: rotate(0deg);
                }

                .menu-item:nth-child(2) a {
                    -webkit-transform: rotate(-60deg);
                    transform: rotate(-60deg);
                }

                .menu-item:nth-child(3) a {
                    -webkit-transform: rotate(-120deg);
                    transform: rotate(-120deg);
                }

                .menu-item:nth-child(4) a {
                    -webkit-transform: rotate(-180deg);
                    transform: rotate(-180deg);
                }

                .menu-item:nth-child(5) a {
                    -webkit-transform: rotate(-240deg);
                    transform: rotate(-240deg);
                }

                .menu-item:nth-child(6) a {
                    -webkit-transform: rotate(-300deg);
                    transform: rotate(-300deg);
                }

                .menu-item {
                    position: absolute;
                    display: block;
                    top: 0;
                    bottom: 0;
                    right: 0;
                    left: 0;
                    margin: auto;
                    width: 80px;
                    height: 80px;
                    display: block;
                    opacity: 0;
                    transition: 0.5s;
                }

                .menu-item a {
                    display: block;
                    width: inherit;
                    height: inherit;
                    line-height: 80px;
                    color: rgba(207,16,32, 0.7);
                    background: rgba(255, 255, 255, 0.7);
                    border-radius: 50%;
                    text-align: center;
                    text-decoration: none;
                    font-size: 40px;
                    pointer-events: none;
                    transition: .2s;
                }
                .menu-item a:hover {
                    box-shadow: 0 0 0 2px rgba(255, 255, 255, 0.6);
                    color: white;
                    background: rgba(255, 255, 255, 0.3);
                    font-size: 44.4444444444px;
                }


                body{
                    background-image: url(https://images.pexels.com/photos/2131790/pexels-photo-2131790.jpeg?cs=srgb&dl=agriculture-bicycles-dawn-2131790.jpg&fm=jpg);
                    background-size: cover;
                    background-position: top;
                    background-attachment: fixed;

                    overflow: hidden;
                    background-repeat: no-repeat;
                }
                
                .shift{
                    transform: rotate(0deg) translateX(-110px)
                }
            </style></head><body>
            <nav class="menu">
                <input checked="checked" class="menu-toggler" id="menu-toggler" type="checkbox">
                <label for="menu-toggler"></label>
                <ul>
                    <li class="menu-item">
                        <a class="fas fa-search" href="AdminSearchTravel.jsp" title="Search"></a>
                    </li>
                    <li class="menu-item">
                        <a class="fas fa-plus" href="LocationMaintenance.jsp"  title="Add Location"></a>
                    </li>
                    <li class="menu-item">
                        <a class="fas fa-map-marked-alt" href="staffDisplay.jsp"  title="Location Maintenance"></a>
                    </li>
                    <li class="menu-item">
                        <a class="fas fa-link" href="EditTravelLeg.jsp" title="Travel Leg Maintenance"></a>
                    </li>
                    <li class="menu-item">
                        <a class="fas fa-user" href="AdminProfile.jsp" title="View Profile"></a>
                    </li>
                    <li class="menu-item">
                        <button type="submit" style="border: none; background-color: Transparent;
    background-repeat:no-repeat;
    border: none;
    cursor:pointer; 
    size: 500px;"class="menu-item "><a class="fas fa-sign-out-alt" href="Login.jsp"  title="Log Out" class="shift"></a></button>
                    </li>
                    
                </ul>
            </nav>
  
            <script src="//static.codepen.io/assets/common/stopExecutionOnTimeout-de7e2ef6bfefd24b79a3f68b414b87b8db5b08439cac3f1012092b2290c719cd.js"></script>
            <script>/*********************************
             circle menu with toggle button
             - only css -         
             *********************************/
                //# sourceURL=pen.js
            </script>
        </body></html>
</body>
</html>
