<%-- 
    Document   : AdminSearchTravel
    Created on : Jul 27, 2019, 10:09:09 PM
    Author     : tanyj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="domain.List"%>
<%@page import="domain.Location"%>
<%@page import="DA.LocationDA"%>
<!DOCTYPE html>
<html>
  <head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
      
    <style>
      /* Set the size of the div element that contains the map */
      #map {
        height: 400px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
       }
       input{
           margin: 10px;
       }
       button{
           margin: 10px;
          
       }
       #map{
           height: 520px;
           width: 1500px;
       }
       
       body {
  text-align: center;
  background: #ebf4fb;
  min-height: 95vh;
  margin: 0;
  padding: 0;
  border-bottom: 5vh solid #3694d7;
  font-family: "Myriad Pro","Arial",sans;
  font-size: 24px;
}

.dropdown-el {
  margin-top: 20vh;
  min-width: 12em;
  position: relative;
  display: inline-block;
  margin-right: 1em;
  min-height: 2em;
  max-height: 2em;
  overflow: hidden;
  top: .5em;
  cursor: pointer;
  text-align: left;
  white-space: nowrap;
  color: #444;
  outline: none;
  border: .06em solid transparent;
  border-radius: 1em;
  background-color: #cde4f5;
  transition: 0.3s all ease-in-out;
}
.dropdown-el input:focus + label {
  background: #def;
}
.dropdown-el input {
  width: 1px;
  height: 1px;
  display: inline-block;
  position: absolute;
  opacity: 0.01;
}
.dropdown-el label {
  border-top: .06em solid #d9d9d9;
  display: block;
  height: 2em;
  line-height: 2em;
  padding-left: 1em;
  padding-right: 3em;
  cursor: pointer;
  position: relative;
  transition: 0.3s color ease-in-out;
}
.dropdown-el label:nth-child(2) {
  margin-top: 2em;
  border-top: .06em solid #d9d9d9;
}
.dropdown-el input:checked + label {
  display: block;
  border-top: none;
  position: absolute;
  top: 0;
  width: 100%;
}
.dropdown-el input:checked + label:nth-child(2) {
  margin-top: 0;
  position: relative;
}
.dropdown-el::after {
  content: "";
  position: absolute;
  right: 0.8em;
  top: 0.9em;
  border: 0.3em solid #3694d7;
  border-color: #3694d7 transparent transparent transparent;
  transition: .4s all ease-in-out;
}
.dropdown-el.expanded {
  border: 0.06em solid #3694d7;
  background: #fff;
  border-radius: .25em;
  padding: 0;
  box-shadow: rgba(0, 0, 0, 0.1) 3px 3px 5px 0px;
  max-height: 15em;
}
.dropdown-el.expanded label {
  border-top: .06em solid #d9d9d9;
}
.dropdown-el.expanded label:hover {
  color: #3694d7;
}
.dropdown-el.expanded input:checked + label {
  color: #3694d7;
}
.dropdown-el.expanded::after {
  transform: rotate(-180deg);
  top: .55em;
}

    </style>

  </head>
  <body>
       <a href = "AdminPage.jsp" class="btn btn-success" > BACK </a>
      

      
      
      
      <form action="adminSearchTravel">
      <h1>Search Cheapest/Fastest Route Between Two Location</h1>
      Starting Location : 
      <input list="Startlocation" type="text" name="startlocation" id="start" required>    
   <datalist id="Startlocation">
         
       <%
                List<Location> location = new List<Location>();
                LocationDA locationDA= new LocationDA();
                location=locationDA.getAllLocation();
                
                for (int i =0;i< location.size();i++) { %>
                <option value="<%= location.getValueOf(i+1).getName() %>">
                
               <% }%>
                        
        </datalist>
               
        Destination : 
        <input list="Endlocation" type="text" name="endlocation" id="end" required>
        <datalist id="Endlocation">
            <%
                for (int i =0;i< location.size();i++) {%>
                <option value="<%= location.getValueOf(i+1).getName()%>" >
                
               <% }%>
               
        </datalist>
               <br><br>
               <input type="radio" name="searchOption" value="Fastest" id="fastest" checked="true"> 
               <label for="fastest">Fastest Route</label>
               <input type="radio" name="searchOption" value="Cheapest" id="chepest" > 
               <label for="chepest">Cheapest Route</label>
            <br>   
            <button type="submit"  >SUBMIT</button>
            </form>
    <!--The div element for the map -->
    <div id="map"></div>
   
   
    <script>
// Initialize and add the map
var sourcelat=2.7456;
 var sourcelon=101.7072;
 var endlat=null;
 var endlon=null;
function initMap() {
  // The location of Uluru

 
 
  var uluru = {lat: sourcelat, lng: sourcelon};
   var uluru2 = {lat:endlat , lng: endlon};
  // The map, centered at Uluru
  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 10, center: uluru});
  // The marker, positioned at Uluru
  var marker = new google.maps.Marker({position: uluru, map: map});
   var marker = new google.maps.Marker({position: uluru2, map: map});
     
        var flightPlanCoordinates = [
          {lat: sourcelat, lng: sourcelon},
          {lat:endlat, lng: endlon}
         
        ];
        
   var flightPath = new google.maps.Polyline({
          path: flightPlanCoordinates,
          geodesic: true,
          strokeColor: '#FF0000',
          strokeOpacity: 1.0,
          strokeWeight: 2
        });
        flightPath.setMap(map);
}

function displayRadioValue() { 
            document.getElementById("demo").innerHTML = ""; 
            var ele = document.getElementsByName('searchOption'); 
              
            for(i = 0; i < ele.length; i++) { 
                  
                if(ele[i].type="radio") { 
                  
                    if(ele[i].checked) 
                        document.getElementById("demo").innerHTML 
                                += ele[i].name + " Value: " 
                                + ele[i].value + "<br>"; 
                } 
            }
            
        } 
        

function getlatnlon(){
 var source = document.getElementById("start").value;
 var end = document.getElementById("end").value;
 <% for(int i =0 ;i< location.size();i++)  {%>
 if(source == '<%=location.getValueOf(i+1).getName()  %>'){
      sourcelat = <%=location.getValueOf(i+1).getLat()%>
      sourcelon = <%=location.getValueOf(i+1).getLon()%>
 } <%}%>
 
  <% for(int i =0 ;i< location.size();i++)  {%>
 if(end == '<%=location.getValueOf(i+1).getName()  %>'){
      endlat = <%=location.getValueOf(i+1).getLat()%>
      endlon = <%=location.getValueOf(i+1).getLon()%>
 } <%}%>
 initMap();
}




  
  


    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
    
    var value = $("#fastest").val();
    
    $("#chepest").click(function (){
        value = $("#chepest").val();
    });
    
      $("#fastest").click(function (){
        value = $("#fastest").val();
    });

    
    



    $("#start").change(function(e) {
    
     source = document.getElementById("start").value;
 

 <% for(int i =0 ;i< location.size();i++)  {%>
 if(source == '<%=location.getValueOf(i+1).getName()  %>'){
      sourcelat = <%=location.getValueOf(i+1).getLat()%>
      sourcelon = <%=location.getValueOf(i+1).getLon()%>
     
 } <%}%>
 initMap();
  
});



 $("#end").change(function(e) {

 end = document.getElementById("end").value;
 <% for(int i =0 ;i< location.size();i++)  {%>
 if(end == '<%=location.getValueOf(i+1).getName()  %>'){
      endlat = <%=location.getValueOf(i+1).getLat()%>
      endlon = <%=location.getValueOf(i+1).getLon()%>
 } <%}%>
 initMap();
});


    $("#test").click(function(e){
        e.preventDefault();     
     $.ajax({
     url: "adminSearchTravel",
    // type: "post",
     data: {},
     cache: false,
     success: function(data) {
     
     $("#mfmf").html(data).slideDown('slow');
     }
     });
    });


</script>
    <script  defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBMrN4VR7U7lR2cxs4VgQ4E8vra5L6A1gk&callback=initMap">
    </script>

  </body>
</html>