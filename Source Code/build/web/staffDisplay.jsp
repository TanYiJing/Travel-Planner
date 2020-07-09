<%-- 
    Document   : map
    Created on : Jul 6, 2019, 12:43:06 AM
    Author     : User
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
<link href="css/use.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">


        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%       List<Location> forlda = new List<Location>();
        LocationDA lda = new LocationDA();
        forlda=lda.getAllLocation();        %>
       
        <style>
            .styled-select {
            background: url(http://i62.tinypic.com/15xvbd5.png) no-repeat 96% 0;
            height: 29px;
            overflow: hidden;
            width: 240px;
            
            
}

.product-grid6 .product-image6 img {
    /* width: 100%; */
    /* height: auto; */
    width: 216px;
    height: 134px;
    transition: all .5s ease 0s;
}
.product-grid6 .product-content {
    padding: 12px 12px 15px;
    transition: all .5s ease 0s;
    height: 100px;
}
.styled-select select {
   background: transparent;
   border: none;
   font-size: 14px;
   height: 29px;
   padding: 5px; /* If you add too much padding here, the options won't show in IE */
   width: 268px;
}

.semi-square {
   -webkit-border-radius: 5px;
   -moz-border-radius: 5px;
   border-radius: 5px;
}

/* -------------------- Colors: Background */
.blue    { background-color: #7d8b7d; 
color: white;
}
option{
    background-color: #7d8b7d;
    color: white;

}
        </style>
       

    <body>
        <a  href="AdminPage.jsp" class="btn btn-success"  > BACK </a>

    <div style="text-align: center;">
    <button  class="btn btn-success" value="search" name="reload" id="reload" style="     background-color: #7d8b7d; border-color:#7d8b7d;  "> <i class="fas fa-redo-alt"></i></button>
        
    <div style="display: inline-block;  font-size: 17pt; "> 𝐒𝐞𝐚𝐫𝐜𝐡 𝐛𝐲 𝐥𝐨𝐜𝐚𝐭𝐢𝐨𝐧 𝐭𝐲𝐩𝐞 :</div>
    
    <div class="styled-select blue semi-square" style="display: inline-block; transform: translate(0px,10px);   ">
   
        <select class="LocationType">
       <option value="s">Small City</option>
       <option value="m">Medium City</option>
       <option value="l">Large City</option>
       <option value="n">Natural Formation</option>
       <option value="p">Designated Park Or Reserve</option>
       <option value="k">Man-made Landmark</option>
    </select>
    </div>
    <button class="locationtypebtn btn" value="Send">Search</button>
    </div>
    

    <div id="loca_result" style="margin-top: 30px;">
        
    <div class="container">
    <div class="row row_my">
     
        <% 
            List<Location> temp_loc = new List <Location>() ;
           if(session.getAttribute("category")==null|| session.getAttribute("category").equals("country") ){
           categoriesDA cda = new categoriesDA();
           temp_loc=  cda.getAllcont();
            }
            
         for(int i = 0 ; i < temp_loc.size();i++) { %>
        
         <div class="col-md-3 col-sm-6">
            <div class="product-grid6">
                <div class="product-image6">
                         <a href="#" >
                            <img  class="pic-1" alt="" src="<%= temp_loc.getValueOf(i+1).getLink() %>" >
                        </a>
                        
                </div>
                <div class="product-content">
                    <h3 class="title"><a href="#"><%= temp_loc.getValueOf(i+1).getName() %></a></h3>
                    
                </div>
                    
                <ul class="social">
                    <li><button class="country_list btn btn-primary" id="country_list" value="<%= temp_loc.getValueOf(i+1).getCode_num()%>" > next</button></li>
                    <li><button name="display" class="Display btn btn-primary" value="<%= temp_loc.getValueOf(i+1).getCode_num()%>" > Display</button></li>
                    <li><button name="edit" class="Edit btn btn-primary" value="<%= temp_loc.getValueOf(i+1).getCode_num()%>" > Edit</button></li>
                    <li><button name="delete" class="Delete btn btn-primary" value="<%= temp_loc.getValueOf(i+1).getCode_num()%>" > Delete</button></li>

                </ul>
            </div>
        </div>
       <% } %>
    </div>
</div>
    </div>
    
    


    </body>
    
        
    
   

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>


<script type="text/javascript" class="remove">
 
     $(".locationtypebtn").click(function (e) {
      var x = $(".LocationType").val();
     e.preventDefault();
     $.ajax({
     url: "DisplayServlet",
    // type: "post",
     data: {locationtpye: x},
     cache: false,
     success: function(data) {
     $(".row").html(data).slideDown('slow');
     }
     });
      $(".remove").remove();
});
  
    $(".country_list").click(function (e) {
      var x = $(this).val();
     e.preventDefault();
     $.ajax({
     url: "DisplayServlet",
    // type: "post",
     data: {country_id: x},
     cache: false,
     success: function(data) {
     $(".row").html(data).slideDown('slow');
     }
     });
      $(".remove").remove();
});

$(".Display").click(function (e) {
      var x = $(this).val();
     e.preventDefault();
     $.ajax({
     url: "DisplayServlet",
    // type: "post",
     data: {display: x},
     cache: false,
     success: function(data) {
     $(".row").html(data).slideDown('slow');
     }
     });
      $(".remove").remove();
});

$(".Edit").click(function (e) {
      var x = $(this).val();
     e.preventDefault();
     $.ajax({
     url: "DisplayServlet",
    // type: "post",
     data: {edit: x},
     cache: false,
     success: function(data) {
     $(".row").html(data).slideDown('slow');
     }
     });
      $(".remove").remove();
});

$(".Delete").click(function (e) {
      var x = $(this).val();
     e.preventDefault();
     $.ajax({
     url: "DisplayServlet",
    // type: "post",
     data: {delete : x},
     cache: false,
     success: function(data) {
     $(".row").html(data).slideDown('slow');
     }
     });
      $(".remove").remove();
});
</script>
<script>
$("#reload").click( function(e){    
    var x ="reload";
    e.preventDefault();
    $.ajax({
     url: "DisplayServlet",
     data: {reload: x},
     cache: false,
     success: function(data) {
     $(".row").html(data).slideDown('slow');
     }
     });
});

$(".cost_btn").click(function(){
    $(".cost_in").show();
    $(".time_in").hide();    

})
$(".time_btn").click(function(){
    $(".time_in").show();
    $(".cost_in").hide();

})

</script>


</html>