<%-- 
    Document   : staff_function
    Created on : Jul 27, 2019, 3:45:11 PM
    Author     : Bosco
--%>
<%@page import="domain.List" %>
<%@page import="domain.ListInterface" %>
<%@page import="domain.Location" %>
<%@page import="DA.LocationDA" %>
<%@page import="DA.categoriesDA" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .sign-up {
                position: relative;
                margin: 20px auto;
                width: 350px;
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
    </head>
    <body>
        <% Location l = null;
            LocationDA lda = new LocationDA();
            categoriesDA cda = new categoriesDA();
            String id = null;

            if (session.getAttribute("display") != null || session.getAttribute("edit") != null || session.getAttribute("delete") != null) {
                if (session.getAttribute("display") != null) {
                    l = (Location) session.getAttribute("display");
                    id = Integer.toString(l.getCode_num());
                } else if (session.getAttribute("edit") != null) {
                    l = (Location) session.getAttribute("edit");
                    id = Integer.toString(l.getCode_num());
                } else if (session.getAttribute("delete") != null) {
                    l = (Location) session.getAttribute("delete");
                    id = Integer.toString(l.getCode_num());
                }
            } else if (request.getParameter("display") != null) {
                l = lda.get_one_loc(1, (String) request.getParameter("display"));
            } else if (request.getParameter("edit") != null) {
                id = (String) request.getParameter("edit");
                l = lda.get_one_loc(1, (String) request.getParameter("edit"));
            } else if (request.getParameter("delete") != null) {
                id = (String) request.getParameter("delete");
                l = lda.get_one_loc(1, (String) request.getParameter("delete"));
            }
            //session.removeAttribute("display");
            //session.removeAttribute("edit");
            //session.removeAttribute("delete");

        %>



        <%  if (request.getParameter("edit") != null || session.getAttribute("edit") != null) { %>
        <%  if (id.charAt(0) == '1') {%>
        <form class="sign-up" action="ModifyServlet" method="Post">
            <h1 class="sign-up-title">Edit Continent</h1> 
            <div class="inputtag">    Continent ID:<input type="text" name="CONID" value="<%= l.getCode_num()%>" readonly> </div>
            <div class="inputtag">  Continent Name:<input type="text" name="Name" value="<%= l.getName()%>" ></div>
            <button type="submit" name="modifycon">Modify</button>

        </form>
        <%} else if (id.charAt(0) == '2') {%>
        <form class="sign-up" action="ModifyServlet" method="Post">
            <h1 class="sign-up-title">Edit Country</h1> 
            <div class="inputtag"> Country ID:<input type="text" name="COUNTID" readonly value="<%= l.getCode_num()%>">   </div>
            <div class="inputtag">   Country Name:<input type="text" name="Name"  value="<%= l.getName()%>"></div>
            <div class="inputtag">   Continent Parent:<input type="text" name="ID" readonly value="<%= cda.get_one_Continent_detail(Integer.toString(l.getUpper())).getName()%>"></div>
            <div class="inputtag">   Link:<input type="text" name="Link" value="<%= l.getLink()%>"></div>
            <button type="submit" name="modifycount">Modify</button>

        </form>
        <%} else if (id.charAt(0) == '3') {%>
        <form class="sign-up" action="ModifyServlet" method="Post">
            <h1 class="sign-up-title">Edit State</h1> 
            <div class="inputtag">   State ID:<input type="text" name="COUNTID"  readonly value="<%= l.getCode_num()%>">   </div>
            <div class="inputtag">   State Name:<input type="text" name="Name"  value="<%= l.getName()%>"></div>
            <div class="inputtag">   Country Parent:<input type="text" name="ID"  readonly value="<%= cda.get_one_Country_detail(Integer.toString(l.getUpper())).getName()%>"></div>
            <div class="inputtag">   Link:<input type="text" name="Link"  value="<%= l.getLink()%>"></div>
            <button type="submit" name="modifystate">Modify</button>

        </form>
        <% } else if (id.charAt(0) == '5') {%>    
        <form class="sign-up" action="ModifyServlet" method="Post">
            <h1 class="sign-up-title">Edit Location</h1> 
            <div class="inputtag">   Location ID: <input type="text" name="STATEID" readonly value="<%= l.getCode_num()%>">  </div>         
            <div class="inputtag">    Location Name:<input type="text" name="Name"  value="<%= l.getName()%>"></div>
            <div class="inputtag">  Longitude: <input type="text" name="Longitude"  value="<%= l.getLon()%>"></div>
            <div class="inputtag">    Latitude: <input type="text" name="Latitude"  value="<%= l.getLat()%>"></div>
            <div class="inputtag">    Location Type: <input type="text" name="Type"  value="<%= l.getType()%>" > </div>
            <div class="inputtag">    Pickup:</div>
            <div class="inputtag"> <input type="checkbox" name="Train"  <%if (l.isT_station()) {%> checked <%}%> > Train Station</div>
            <div class="inputtag">  <input type="checkbox" name="Bus"  <%if (l.isB_station()) {%> checked <%}%>> Bus Station </div>
            <div class="inputtag">  <input type="checkbox" name="Airport"  <%if (l.isFlight()) {%> checked <%}%>> Airport </div>
            <div class="inputtag">  State Parent:<input type="text" name="ID"  readonly value="<%= cda.get_one_State_detail(Integer.toString(l.getUpper())).getName()%>"></div>
            <div class="inputtag">   Link:<input type="text" name="Link"  value="<%= l.getLink()%>"></div>
            <button type="submit" name="modifylocation">Modify</button>
        </form>
        <% } %>
        <% } else if (session.getAttribute("display") != null || request.getParameter("display") != null) {%>
        <form class="sign-up" action="" method="Post">
            <h1 class="sign-up-title">Display Location</h1> 
            <div class="inputtag"> Location ID: <input type="text" name="STATEID" readonly value="<%= l.getCode_num()%>">  </div>         
            <div class="inputtag">  Location Name:<input type="text" name="Name" readonly value="<%= l.getName()%>"></div>
            <div class="inputtag">  Longitude: <input type="text" name="Longitude" readonly value="<%= l.getLon()%>"></div>
            <div class="inputtag"> Latitude: <input type="text" name="Latitude" readonly value="<%= l.getLat()%>"></div>
            <div class="inputtag"> Location Type: <input type="text" name="Type" readonly value="<%= l.getType()%>" > </div>
            <div class="inputtag">  Pickup: </div>
            <div class="inputtag">  <input type="checkbox" name="Train" disabled <%if (l.isT_station()) {%> checked <%}%> > Train Station</div>
            <div class="inputtag">  <input type="checkbox" name="Bus" disabled <%if (l.isB_station()) {%> checked <%}%>> Bus Station </div>
            <div class="inputtag"> <input type="checkbox" name="Airport" disabled <%if (l.isFlight()) {%> checked <%}%>> Airport </div>
            <div class="inputtag">  State Parent:<input type="text" name="ID" readonly value="<%= l.getUpper()%>"></div>
            <div class="inputtag">  Link:<input type="text" name="Link" readonly value="<%= l.getLink()%>"></div>
            <button type="submit" name="modifylocation" >
                <a style="text-decoration:none"  href="staffDisplay.jsp" >OK</a>
            </button>

        </form>

        <% } else if (session.getAttribute("delete") != null || request.getParameter("delete") != null) { %>
        <%  if (id.charAt(0) == '1') {%>
        <form class="sign-up" action="DeleteServlet" method="Post">
            <h1 class="sign-up-title">Delete Location</h1> 
            <div class="inputtag">  Continent ID:<input type="text" name="CONID" value="<%= l.getCode_num()%>" readonly></div>
            <div class="inputtag">  Continent Name:<input type="text" name="Name" value="<%= l.getName()%>" ></div>
            <button type="submit" name="deletecon">Delete</button>

        </form>
        <%} else if (id.charAt(0) == '2') {%>
        <form class="sign-up" action="DeleteServlet" method="Post">
            <h1 class="sign-up-title">Delete Country</h1> 
            <div class="inputtag">  Country ID:<input type="text" name="COUNTID" readonly value="<%= l.getCode_num()%>"> </div>  
            <div class="inputtag">  Country Name:<input type="text" name="Name"  value="<%= l.getName()%>"></div>
            <div class="inputtag">  Continent Parent:<input type="text" name="ID" readonly value="<%= cda.get_one_Continent_detail(Integer.toString(l.getUpper())).getName()%>"></div>
            <div class="inputtag">  Link:<input type="text" name="Link" value="<%= l.getLink()%>"></div>
            <button type="submit" name="deletecount">Delete</button>

        </form>
        <%} else if (id.charAt(0) == '3') {%>
        <form class="sign-up" action="DeleteServlet" method="Post">
            <h1 class="sign-up-title">Delete State</h1> 
            <div class="inputtag"> State ID:<input type="text" name="STATEID"  readonly value="<%= l.getCode_num()%>">  </div> 
            <div class="inputtag"> State Name:<input type="text" name="Name"  value="<%= l.getName()%>"></div>
            <div class="inputtag">  Country Parent:<input type="text" name="ID"  readonly value="<%= cda.get_one_Country_detail(Integer.toString(l.getUpper())).getName()%>"></div>
            <div class="inputtag">   Link:<input type="text" name="Link"  value="<%= l.getLink()%>"></div>
            <button type="submit" name="deletestate">Delete</button>

        </form>
        <% } else if (id.charAt(0) == '5') {%>    
        <form class="sign-up" action="DeleteServlet" method="Post">
            <h1 class="sign-up-title">Delete State</h1> 
           <div class="inputtag"> Location ID: <input type="text" name="LOCATIONID" readonly value="<%= l.getCode_num()%>">  </div>         
           <div class="inputtag"> Location Name:<input type="text" name="Name"  value="<%= l.getName()%>"></div>
          <div class="inputtag">  Longitude: <input type="text" name="Longitude"  value="<%= l.getLon()%>"></div>
          <div class="inputtag">  Latitude: <input type="text" name="Latitude"  value="<%= l.getLat()%>"></div>
         <div class="inputtag">   Location Type: <input type="text" name="Type"  value="<%= l.getType()%>" > </div>
          <div class="inputtag">  Pickup:</div>
            <div class="inputtag">  <input type="checkbox" name="Train"  <%if (l.isT_station()) {%> checked <%}%> > Train Station</div>
           <div class="inputtag"> <input type="checkbox" name="Bus"  <%if (l.isB_station()) {%> checked <%}%>> Bus Station </div>
          <div class="inputtag">  <input type="checkbox" name="Airport"  <%if (l.isFlight()) {%> checked <%}%>> Airport </div>
           <div class="inputtag"> State Parent:<input type="text" name="ID"  readonly value="<%= cda.get_one_State_detail(Integer.toString(l.getUpper())).getName()%>"></div>
          <div class="inputtag">  Link:<input type="text" name="Link"  value="<%= l.getLink()%>"></div>
            <button type="submit" name="deletelocation">Delete</button>
        </form>
        <% } %>
        <% } %>
        <%
            session.removeAttribute("display");
            session.removeAttribute("edit");
            session.removeAttribute("delete");

        %>
    </body>
</html>
