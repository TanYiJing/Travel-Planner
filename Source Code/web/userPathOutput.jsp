<%-- 
    Document   : userPathOutput
    Created on : Jul 27, 2019, 12:01:36 PM
    Author     : User
--%>
<%@page import="DA.transportationDA"%>
<%@page import="domain.transport"%>
<%@page import="domain.transportation"%>
<%@page import="domain.List" %>
<%@page import="domain.ListInterface" %>
<%@page import="domain.linkedlist" %>
<%@page import="domain.linkedlistInterface" %>
<%@page import="domain.Location" %>
<%@page import="DA.LocationDA" %>
<%@page import="DA.categoriesDA" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <style>  
        * {
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            -ms-box-sizing: border-box;
            box-sizing: border-box;
        }

        .process-list {
            padding: 0;
            margin: 0;
            list-style-type: none;
            font-size: 0;
            display: block;
        }

        .process-step {
            display: inline-block;
            vertical-align: top;
            width: 100px;
            min-height: 20px;
            padding: 0;
            margin: 0;
            text-align: center;
            font-size: 16px;
        }

        .step-wrapper {
            padding: 30px 5px 0 5px;
            display: block;
            position: relative;
            overflow: hidden;
        }

        .step-wrapper:before {
            content: "";
            position: absolute;
            top: 10px;
            left: 0;
            height: 5px;
            width: 100px;
            background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAFAQMAAABGqu8rAAAAA1BMVEXgUSCWVqGnAAAACklEQVQI12NABQAADwABdYmHTwAAAABJRU5ErkJggg==);
            background-repeat: repeat-x;
        }

        .first .step-wrapper:before {
            left: 50px;
        }

        .last .step-wrapper:before {
            left: auto;
            right: 50px;
        }

        .step-wrapper:after {
            content: "";
            position: absolute;
            top: 2px;
            left: 0;
            right: 0;
            height: 20px;
            background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABQAAAA8CAMAAABRqGpkAAAAJ1BMVEUAAADgUSDgUSDgUSDgUSDgUSDgUSDgUSDgUSD////42tDrjm/yt6IPf6ysAAAACHRSTlMAZu67Ed2qmaQXgZMAAACJSURBVHja7ZPbCsAwCEO1dpt2+//vHYR2N/M8GOw82ZBQa1FAVSvuxbTKgU7emXRoi19YBMx+Y0bWH6hILajWFtFWlKV24xZg61aDLzrwmiDdhtiQFwTiAEcq0ji9iLZEm2fPZAPho+NDTt/x8w3e3qPBuUfZalk0SWnsEYGKNE4voi2l5l/dox3ttBONuskuxgAAAABJRU5ErkJggg==);
            background-repeat: no-repeat;
            background-position: top center;
        }

        .active .step-wrapper:after {
            background-position: bottom center;
        }


        .shopping-cart-wrapper {
            margin-top: 15px;
            padding: 20px;
        }
        .totals .totals-item {
            float: right;
            clear: both;
            width: 100%;
            margin-bottom: 10px;
        }
        .totals .totals-item label {
            float: left;
            clear: both;
            width: 79%;
            text-align: right;
        }
        .totals-value {
            float: right;
            width: 21%;
            text-align: right;
        }


        .checkout {
            float: right;
            border: 0;
            margin-top: 20px;
            padding: 6px 25px;
            background-color: #6b6;
            color: #fff;
            font-size: 25px;
            border-radius: 3px;
        }

        .checkout:hover {
            background-color: #494;
        }


    </style>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Abril+Fatface" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">

    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">


    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">
    <body>

<% if ((session.getAttribute("cheapestPathList") == null) && (session.getAttribute("source") == null) ){%>

        <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light scrolled awake" id="ftco-navbar">
            <div class="container">
                <a class="navbar-brand" href="Homepage.jsp">Adventure</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="oi oi-menu"></span> Menu
                </button>

                <div class="collapse navbar-collapse" id="ftco-nav">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active"><a href="Homeoage.jsp" class="nav-link">Home</a></li>
                        <li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
                        <li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li>
                        <li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
                    </ul>
                </div>
            </div>
        </nav>
<% } else { %>
       <a href = "AdminSearchTravel.jsp" class="btn btn-success" > BACK </a>

<%}%>
        <% //linkedlist<Location> result = new linkedlist<Location>();
            linkedlist<Location> result = (linkedlist<Location>) session.getAttribute("aStar_Path");
            List<List<List<Location>>> many_path = (List<List<List<Location>>>) session.getAttribute("bStar_Path");
            Double astartime = (Double) session.getAttribute("astartime");
            Double time = (Double) session.getAttribute("time");
            Double cost = (Double) session.getAttribute("cost");
            List<String> travelmode = (List<String>) session.getAttribute("travelmode");
            transportation t = new transportation();
            boolean truepath = true;
        %>


   <% if (session.getAttribute("cheapestPathList") != null) { %>
        <div class="form-group" style="margin-top: 10%; text-align: center;"><label >Cheapest Result</label></div>
   <% } else if (session.getAttribute("source") != null) {%>
           <div class="form-group" style="margin-top: 10%; text-align: center;"><label >Fastest Result</label></div>
   <% } else {%>
           <div class="form-group" style="margin-top: 10%; text-align: center;"><label > Result</label></div>
   <% } %>
        <% if (result != null) { %>
        <% if (astartime >= time) {%>
        <div class="process-wrapper" style=" text-align: center;">
            <div class="travelmode" style=" text-align: center; display: inline-block; width: 100%">
                <% for (int i = 0; i < travelmode.size(); i++) {%>
                <% if (travelmode.getValueOf(i + 1).equals("car")) {%>
                <cincai style="margin: 0px  30px;" ><img alt="" src="https://image.flaticon.com/icons/svg/635/635678.svg" style="width:40px ; height: 40px; "></cincai>
                    <%} else {%>
                <cincai style="margin: 0px  30px;"><img alt="" src=" https://image.flaticon.com/icons/svg/635/635683.svg" style="width:40px ; height: 40px; "></cincai>
                    <% } %>
                    <% } %>
                <cincai style="margin: 0px  30px;"><img alt="" src="https://www.ledr.com/colours/white.jpg" style="width:40px ; height: 40px; "></cincai>
                <cincai style="margin: 0px  30px;"><img alt="" src="https://www.ledr.com/colours/white.jpg" style="width:40px ; height: 40px; "></cincai>

            </div>

            <ul class="process-list">

                <% for (int i = 0; i < result.getNumberOfEntries(); i++) {
                        if (i == 0) { %>
                <li class="process-step first"> 
                    <% } else if (i == result.getNumberOfEntries() - 1) {%> 
                <li class="process-step last"> 
                    <% } else {%>
                <li class="process-step "> <% }%>  

                    <div class="step-wrapper">
                        <!-- <img  alt="" src="https://cdn4.iconfinder.com/data/icons/urban-transport-3/50/48-512.png" > -->
                        <a href="#"><%= result.getEntry(i + 1).getName()%></a>
                    </div>
                </li>
                <% }%>
                <li style="display: inline-block;">
                    <ul class="process-list">
                        <li class="process-step"><i class="far fa-clock"> Duration: <%= String.format("%d", time.intValue())%>h<%= String.format("%1.0f", (time - time.intValue()) * 60)%>m </i><br><i class="fas fa-dollar-sign"> Cost : RM<%= String.format("%.2f", cost)%></i></li>
                    </ul>
                </li>
                <li style="display: inline-block;">
                    <ul class="process-list">
                        <li class="process-step">   <input type="radio" class="price" checked value="<%=cost%>" ></li>
                    </ul>
                </li>
            </ul>

        </div>
        <%} else {%>         <div style="text-align: center;" > Path Not Found</div> <% } %>
        <% } else if (many_path != null) { %>

        <%for (int i = 0; i < many_path.size(); i++) {
                for (int j = 0; j < many_path.getValueOf(i + 1).size(); j++) {
                    if (t.trannsportmode(many_path.getValueOf(i + 1).getValueOf(j + 1)).getValueOf(1).getTotalCost() * many_path.size() > cost) {
                        truepath = false;
                    }

                }
            }
        %>
        <% if (truepath) {%>
        <%for (int i = 0; i < many_path.size(); i++) {%>
        <div>
            <div style="text-align:  center;"> Path <%=i + 1%> : <%= many_path.getValueOf(i + 1).getValueOf(1).getValueOf(1).getName()%> <i class="far fa-arrow-alt-circle-right"></i> <%= many_path.getValueOf(i + 1).getValueOf(1).getValueOf(many_path.getValueOf(i + 1).getValueOf(1).size()).getName()%> </div>
            <% for (int j = 0; j < many_path.getValueOf(i + 1).size(); j++) {%>

            <div class="process-wrapper" style=" text-align: center;">
                <div class="travelmode" style=" text-align: center; display: inline-block; width: 100%">
                    <% List<transport> transportmode = t.trannsportmode(many_path.getValueOf(i + 1).getValueOf(j + 1));
                        for (int k = 0; k < transportmode.size(); k++) {%>
                    <% if (transportmode.getValueOf(k + 1).getName().equals("Car")) {%>
                    <cincai style="margin: 0px  30px;" ><img alt="" src="https://image.flaticon.com/icons/svg/635/635678.svg" style="width:40px ; height: 40px; "></cincai>
                        <%} else if (transportmode.getValueOf(k + 1).getName().equals("Airplane")) {%>
                    <cincai style="margin: 0px  30px;"><img alt="" src=" https://image.flaticon.com/icons/svg/635/635683.svg" style="width:40px ; height: 40px; "></cincai>
                        <%} else if (transportmode.getValueOf(k + 1).getName().equals("Bus")) {%>
                    <cincai style="margin: 0px  30px;"><img alt="" src=" https://image.flaticon.com/icons/svg/130/130262.svg" style="width:40px ; height: 40px; "></cincai>
                        <%} else if (transportmode.getValueOf(k + 1).getName().equals("Train")) {%>
                    <cincai style="margin: 0px  30px;"><img alt="" src=" https://image.flaticon.com/icons/svg/1532/1532079.svg" style="width:40px ; height: 40px; "></cincai>
                        <% } %>             
                        <% } %>
                    <cincai style="margin: 0px  30px;"><img alt="" src="https://www.ledr.com/colours/white.jpg" style="width:40px ; height: 40px; "></cincai>
                    <cincai style="margin: 0px  30px;"><img alt="" src="https://www.ledr.com/colours/white.jpg" style="width:40px ; height: 40px; "></cincai>

                </div>

                <ul class="process-list">
                    <% for (int n = 0; n < many_path.getValueOf(i + 1).getValueOf(j + 1).size(); n++) {%>

                    <%
                        if (n == 0) { %>
                    <li class="process-step first"> 
                        <% } else if (n == many_path.getValueOf(i + 1).getValueOf(j + 1).size() - 1) {%> 
                    <li class="process-step last"> 
                        <% } else {%>
                    <li class="process-step "> <% }%>  

                        <div class="step-wrapper">
                            <a href="#"><%=  many_path.getValueOf(i + 1).getValueOf(j + 1).getValueOf(n + 1).getName()%></a>
                        </div>
                    </li>


                    <%}%>
                    <li style="display: inline-block;">
                        <ul class="process-list">
                            <li class="process-step"><i class="far fa-clock"> Duration: &nbsp; <%= t.trannsportmode(many_path.getValueOf(i + 1).getValueOf(j + 1)).getValueOf(1).getHours()%> h <%= t.trannsportmode(many_path.getValueOf(i + 1).getValueOf(j + 1)).getValueOf(1).getMinutes()%>m </i><br><i class="fas fa-dollar-sign"> Cost : RM <%= t.trannsportmode(many_path.getValueOf(i + 1).getValueOf(j + 1)).getValueOf(1).getTotalCost()%> </i></li>
                        </ul>
                    </li>
                    <li style="display: inline-block;">
                        <ul class="process-list">
                            <li class="process-step">   <input type="radio" class="price" name="set<%=i%>"  value="<%= t.trannsportmode(many_path.getValueOf(i + 1).getValueOf(j + 1)).getValueOf(1).getTotalCost()%>" ></li>
                        </ul>
                    </li>

                </ul>
            </div>
            <%}%>

        </div>
        <% } %>
        <% } else {%>
        <div style="text-align: center;" > Path Not Found</div>
        <% } %>
        <% } else if (session.getAttribute("source") != null) { %>
        <%         LocationDA lda = new LocationDA();
            categoriesDA cda = new categoriesDA();
            linkedlist<Location> all_link_loc = lda.getAlllinkLocation();

            linkedlist<Location> linkloc = new linkedlist<Location>();
            linkloc.add(lda.get_one_loc((String) session.getAttribute("source")));
            if (!cda.checkSameCountry((String) session.getAttribute("source"), (String) session.getAttribute("destination"))) {
                linkloc.add(lda.get_nearest_airport((String) session.getAttribute("source")));
                linkloc.add(lda.get_nearest_airport((String) session.getAttribute("destination")));
            }
            linkloc.add(lda.get_one_loc((String) session.getAttribute("destination")));

            for (int i = 0; i < linkloc.getNumberOfEntries(); i++) {
                for (int j = 0; j < all_link_loc.getNumberOfEntries(); j++) {
                    if (linkloc.getEntry(1).getName().equals(all_link_loc.getEntry(j + 1).getName())) {
                        linkloc.add(all_link_loc.getEntry(j + 1));
                        linkloc.remove(1);
                        break;
                    }
                }
            }
            linkedlist<Location> result_loc = new linkedlist<Location>();
            result_loc.add(linkloc.getEntry(1));
            for (int i = 0; i < linkloc.getNumberOfEntries() - 1; i++) {
                if (cda.checkSameCountry(linkloc.getEntry(i + 1).getName(), linkloc.getEntry(i + 2).getName())) {
                    System.out.println(cda.checkSameCountry(linkloc.getEntry(i + 1).getName(), linkloc.getEntry(i + 2).getName()));
                    Location.starsearch(linkloc.getEntry(i + 1), linkloc.getEntry(i + 2));
                    Location.adjust(linkloc.getEntry(i + 1), linkloc.getEntry(i + 2), result_loc);
                } else {
                    System.out.println(cda.checkSameCountry(linkloc.getEntry(i + 1).getName(), linkloc.getEntry(i + 2).getName()));
                    result_loc.add(linkloc.getEntry(i + 2));
                }

            }
            transportationDA tda = new transportationDA();
            List<transport> tan = new List<transport>();
            tan =  tda.getAllTransportData();
            travelmode= new List<String>() ;
            cost = 0.0 ;
            time = 0.0 ;
           for(int i = 0 ; i< result_loc.getNumberOfEntries()-1;i++){
                if(result_loc.getEntry(i+1).isFlight()&& result_loc.getEntry(i+2).isFlight()){
                cost+= result_loc.getEntry(i+1).distance(result_loc.getEntry(i+2))* tan.getValueOf(4).getCost();
                time +=  result_loc.getEntry(i+1).distance(result_loc.getEntry(i+2))/tan.getValueOf(4).getSpeed();
                travelmode.add("flight");
                }else{
                travelmode.add("car");
                 cost+= result_loc.getEntry(i+1).distance(result_loc.getEntry(i+2))* tan.getValueOf(3).getCost();
                time +=  result_loc.getEntry(i+1).distance(result_loc.getEntry(i+2))/tan.getValueOf(3).getSpeed();              
                }
            }
        %>


        <div class="process-wrapper" style=" text-align: center;">
            <div class="travelmode" style=" text-align: center; display: inline-block; width: 100%">
                <% for (int i = 0; i < travelmode.size(); i++) {%>
                <% if (travelmode.getValueOf(i + 1).equals("car")) {%>
                <cincai style="margin: 0px  30px;" ><img alt="" src="https://image.flaticon.com/icons/svg/635/635678.svg" style="width:40px ; height: 40px; "></cincai>
                    <%} else {%>
                <cincai style="margin: 0px  30px;"><img alt="" src=" https://image.flaticon.com/icons/svg/635/635683.svg" style="width:40px ; height: 40px; "></cincai>
                    <% } %>
                    <% } %>
                <cincai style="margin: 0px  30px;"><img alt="" src="https://www.ledr.com/colours/white.jpg" style="width:40px ; height: 40px; "></cincai>

            </div>

            <ul class="process-list">

                <% for (int i = 0; i < result_loc.getNumberOfEntries(); i++) {
                        if (i == 0) { %>
                <li class="process-step first"> 
                    <% } else if (i == result_loc.getNumberOfEntries() - 1) {%> 
                <li class="process-step last"> 
                    <% } else {%>
                <li class="process-step "> <% }%>  

                    <div class="step-wrapper">
                        <!-- <img  alt="" src="https://cdn4.iconfinder.com/data/icons/urban-transport-3/50/48-512.png" > -->
                        <a href="#"><%= result_loc.getEntry(i + 1).getName()%></a>
                    </div>
                </li>
                <% }%>
                <li style="display: inline-block;">
                    <ul class="process-list">
                        <li class="process-step"><i class="far fa-clock"> Duration: <%= String.format("%d", time.intValue())%>h<%= String.format("%1.0f", (time - time.intValue()) * 60)%>m </i><br><i class="fas fa-dollar-sign"> Cost : RM<%= String.format("%.2f", cost)%></i></li>
                    </ul>
                </li>          
            </ul>

        </div>

        <% } else if (session.getAttribute("cheapestPathList") != null) { %>

        <% List<Location> yj = (List<Location>) session.getAttribute("cheapestPathList");  %>

        <div class="process-wrapper" style=" text-align: center;">
            <div class="travelmode" style=" text-align: center; display: inline-block; width: 100%">
                <%   List<transport> transportmode = (List<transport>) session.getAttribute("cheapestTransportList");
                    for (int k = 0; k < transportmode.size(); k++) {%>
                <% if (transportmode.getValueOf(k + 1).getName().equals("Car")) {%>
                <cincai style="margin: 0px  30px;" ><img alt="" src="https://image.flaticon.com/icons/svg/635/635678.svg" style="width:40px ; height: 40px; "></cincai>
                    <%} else if (transportmode.getValueOf(k + 1).getName().equals("Airplane")) {%>
                <cincai style="margin: 0px  30px;"><img alt="" src=" https://image.flaticon.com/icons/svg/635/635683.svg" style="width:40px ; height: 40px; "></cincai>
                    <%} else if (transportmode.getValueOf(k + 1).getName().equals("Bus")) {%>
                <cincai style="margin: 0px  30px;"><img alt="" src=" https://image.flaticon.com/icons/svg/130/130262.svg" style="width:40px ; height: 40px; "></cincai>
                    <%} else if (transportmode.getValueOf(k + 1).getName().equals("Train")) {%>
                <cincai style="margin: 0px  30px;"><img alt="" src=" https://image.flaticon.com/icons/svg/1532/1532079.svg" style="width:40px ; height: 40px; "></cincai>
                    <% } %>             
                    <% } %>
                <cincai style="margin: 0px  30px;"><img alt="" src="https://www.ledr.com/colours/white.jpg" style="width:40px ; height: 40px; "></cincai>

            </div>

            <ul class="process-list">

                <% for (int i = 0; i < yj.size(); i++) {
                        if (i == 0) { %>
                <li class="process-step first"> 
                    <% } else if (i == yj.size() - 1) {%> 
                <li class="process-step last"> 
                    <% } else {%>
                <li class="process-step "> <% }%>  

                    <div class="step-wrapper">
                        <!-- <img  alt="" src="https://cdn4.iconfinder.com/data/icons/urban-transport-3/50/48-512.png" > -->
                        <a href="#"><%= yj.getValueOf(i + 1).getName()%></a>
                    </div>
                </li>
                <% }%>
                <li style="display: inline-block;">
                    <ul class="process-list">
                        <li class="process-step"><i class="far fa-clock"> Duration: <%= transportmode.getValueOf(1).getHours() %>h<%= transportmode.getValueOf(1).getMinutes()%>m </i><br><i class="fas fa-dollar-sign"> Cost : RM<%= transportmode.getValueOf(1).getTotalCost() %></i></li>
                    </ul>
                </li>          
            </ul>

        </div>

        <% } %>

        <% if ((session.getAttribute("cheapestPathList")== null) && (session.getAttribute("source")== null) ){%>

        <div class="totals" style="margin-right: 10%; margin-top: 5%;">
            <div class="totals-item">
                <label>Subtotal</label>
                <div class="totals-value totalprice" id="cart-subtotal">0</div>
            </div>
            <div class="totals-item">
                <label>Tax (5%)</label>
                <div class="totals-value tax" id="cart-tax">0</div>
            </div>

            <div class="totals-item totals-item-total">
                <label>Grand Total</label>
                <div class="totals-value gtotal" id="cart-total">0</div>
            </div>
        <button class="checkout">Checkout</button>
        </div>
<% } %>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            var totalprice = 0;
            $('.price').click(function () {
                totalprice = 0;
                $('.price').each(function () {
                    if ($(this).prop('checked')) {
                        totalprice += parseFloat($(this).val());
                    }
                });
                totalprice = totalprice.toFixed(2);
                $('.totalprice').text(totalprice);
                $('.tax').text((totalprice * 5 / 100).toFixed(2));
                totalprice = parseFloat(totalprice);
                $('.gtotal').text((totalprice + (totalprice * 5 / 100)).toFixed(2));


            });

            <%  LocationDA lda = new LocationDA();
                List<Location> l = lda.getsomeLocation(1, "2");
            %>
        </script>
        <%   session.removeAttribute("aStar_Path");
            session.removeAttribute("bStar_Path");
            session.removeAttribute("time");
            session.removeAttribute("cost");
            session.removeAttribute("travelmode");
            session.removeAttribute("source");
            session.removeAttribute("destination");
            session.removeAttribute("cheapestPathList");
            session.removeAttribute("cheapestTransportList");

        %>

    </body>
</html>
