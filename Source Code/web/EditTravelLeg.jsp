<%-- 
    Document   : EditTravelLeg
    Created on : Aug 3, 2019, 9:51:50 PM
    Author     : tanyj
--%>

<%@page import="DA.adjencyDA"%>
<%@page import="DA.LocationDA"%>
<%@page import="domain.Location"%>
<%@page import="domain.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
<html>
<head>
	<title>Angular & PHP Crud</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
	<script src="app.js"></script>
</head>

<body>
           <a href="AdminPage.jsp" class="btn btn-success"  > BACK </a>

<div class="container">
     
	<hr>
	
	<h1>All Travel Leg</h1>
	<span class="clearfix"></span>
	<hr>

	
	<div class="table-responsive">
            
            <% 
                if(session.getAttribute("error")!=null) {%>
            <div class="alert alert-danger alert-dismissable" ng-if="messageInfo">
	  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
          <%= session.getAttribute("error").toString() %>
	</div>
            <%}%>
            <% session.removeAttribute("error"); %>
            <% 
                if(session.getAttribute("sucess")!=null) {%>
            <div class="alert alert-success alert-dismissable" ng-if="messageInfo">
	  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
          <%= session.getAttribute("sucess").toString() %>
	</div>
            <%} session.removeAttribute("sucess");%>
          
            
		<table class="table table-striped  table-responsive table-hover ">
			<thead>
				<tr class="info">
					<th>Location ID</th>
					<th>Location Name</th>
					<th>Current Travel Leg Number</th>
                                        <th>View</th>
					<th>Add</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				 <% LocationDA locaDA = new LocationDA();
                                  adjencyDA adDA = new adjencyDA();
                              List<Location> locaList = new  List<Location>(); 
                              locaList=locaDA.getAllLocation();
                         for (int i=0;i<locaList.size();i++) {%>
                          
                         <tr ng-repeat="user in users">
                                   
                                <td><%= locaList.getValueOf(i+1).getCode_num()%> </td>
					<td><%= locaList.getValueOf(i+1).getName() %></td>
                                        <td><%= adDA.getNumberofTravelLeg(locaList.getValueOf(i+1).getCode_num()) %></td>
                                        <td><button type="button" class="btn btn-success view" data-toggle="modal" data-target="#View<%=locaList.getValueOf(i+1).getCode_num()%>" >View</button></td>
                                        <td><button type="button" class=" btn btn-info editbtn" data-toggle="modal" data-target="#modaledit" ng-click="selectUser(user)" value="<%= locaList.getValueOf(i+1).getCode_num()%>" >Edit</button></td>
					
                                        <td><button type="button" class="btn btn-danger delete" data-toggle="modal" data-target="#<%=locaList.getValueOf(i+1).getCode_num()%>" ng-click="selectUser(user)">Delete</button></td>
                                        
                                </tr>
                                <%}%>
			</tbody>
		</table>
	</div>
</div>

                        
 <%for (int i=0; i< locaList.size();i++ ) { %>                   
 <div class="modal fade" id="View<%= locaList.getValueOf(i+1).getCode_num() %>" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">View All Travel Leg of <%= locaList.getValueOf(i+1).getName()%></h4>
			</div>
                        
                        <table class="table table-striped  table-responsive table-hover ">
			<thead>
				<tr class="info">
					<th>Location ID</th>
					<th>Location Name</th> 
				</tr>
			</thead>
                        <% 
                            List<Location> viewAll = adDA.selectDeleteLocation(String.valueOf(locaList.getValueOf(i+1).getCode_num()), String.valueOf(locaList.getValueOf(i+1).getCode_num())); 
                            for(int j =0 ;j<viewAll.size();j++){
                        %>
                        <tr>
                            <td><%= viewAll.getValueOf(j+1).getCode_num() %></td>
                            <td><%= viewAll.getValueOf(j+1).getName()%></td>
                        </tr>
                        <%}%>
                        </table>
                        
                        
                        
                    
			<div class="modal-footer">
					<button type="submit" class="btn btn-info pull-right" data-dismiss="modal" >Close</button>		
			</div>
		</div>
	</div>
</div>
 <%}%>                      
  
                        
                        
                        
<div class="modal fade" id="modaledit" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Add New Travel Leg</h4>
                                <h5>Editing: <div id="sourceLoca"></div></h5>
			</div>
			<div class="modal-body">
                            <form class="form-horizontal" action="editServelet">
                                <input id="sourceCode" name="sourceCode" hidden>
					<div class="form-group">
						<label class="control-label col-md-2">Location Name</label>
						<div class="col-md-10">
                                                    <input list="location" type="text"  id="locaName" name="locaName" class=" form-control">
							 <datalist id="location">
                                                             <%for (int i =0;i< locaList.size();i++) { %>

                                                             <option value="<%= locaList.getValueOf(i+1).getName()%>" >
                                                                 <%}%>
                                                             </datalist>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">Location Code</label>
						<div class="col-md-10">
                                                    <input type="text" class=" form-control" id="locaCode" name="locaCode" readonly="true">
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-2 col-md-offset-2">
                                                    <button type="submit" class="btn btn-info "   name="button" value="update">ADD</button>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
					<button type="submit" class="btn btn-info pull-right" data-dismiss="modal" >Close</button>		
			</div>
		</div>
	</div>
</div>
                        
                        
 
 <%for (int i=0; i< locaList.size();i++ ) { %>
 <form action="editServelet">
 <div class="modal fade" id="<%= locaList.getValueOf(i+1).getCode_num() %>" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title">Deleting Travel Leg</h4>
			</div>
			<div class="modal-body">
                            <input list="<%=locaList.getValueOf(i+1).getName()%>" type="text"  class=" form-control" name="delDest">
                            <datalist id="<%=locaList.getValueOf(i+1).getName()%>">
                           <%
                               List<List<Location>> delLoca = new List<List<Location>>();
                               delLoca.add(adDA.selectDeleteLocation(String.valueOf(locaList.getValueOf(i+1).getCode_num()), String.valueOf(locaList.getValueOf(i+1).getCode_num())));
                               for(int j =0;j < delLoca.getValueOf(1).size();j++){
                                %>
                                   
                                <option value="<%= delLoca.getValueOf(1).getValueOf(j+1).getName() %>">  
                               <%}%>
                             </datalist>
                            
                               <input value="<%= locaList.getValueOf(i+1).getCode_num()%>" name="delSource" hidden >
                            
			</div>
			<div class="modal-footer">
                            <button type="submit" class="btn btn-info " >Yes</button> 
				<button type="button" class="btn btn-info " data-dismiss="modal" >No</button>		
	
			</div>
		</div>
	</div>
</div>
</form>
<%}%>
</body>
</html>
    </body>
</html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
  
    
    
    
     $("#locaName").change(function(){
        var location = document.getElementById("locaName").value;

    <% for(int i =0 ;i< locaList.size();i++){ %>   
    if(location == '<%= locaList.getValueOf(i+1).getName() %>'){
         $("#locaCode").val("<%= locaList.getValueOf(i+1).getCode_num()  %>") ;
    }
    <%}%>
}
    );
    
  $(".editbtn").click(function(e){
         sourceCode = $(this).val();
      <% for(int i =0 ;i< locaList.size();i++){ %>   
    if(sourceCode == '<%= locaList.getValueOf(i+1).getCode_num()%>'){
        $("#sourceLoca").html("Name : <%= locaList.getValueOf(i+1).getName() %> <br/> Location Code : <%= locaList.getValueOf(i+1).getCode_num()%>");
        $("#sourceCode").val("<%= locaList.getValueOf(i+1).getCode_num()%>");
    }
    <%}%>
       
      
    });  
    
  
  
  
  
</script>
