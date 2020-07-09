<%-- 
    Document   : pre-homepage
    Created on : Aug 5, 2019, 10:59:27 AM
    Author     : tanyj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="css/Pre-homepage.css">
	
	
</head>
<style>
    :root {
  --container-bg-color: #333;
  --left-bg-color: rgba(133, 113, 24, 0.23);
  --left-button-hover-color: rgba(255, 64, 0, 0.3);
  --right-bg-color: rgba(43, 43, 43, 0.8);
  --right-button-hover-color: rgba(92, 92, 92, 0.3);
  --hover-width:75%;
  --other-width:25%;
  --time:2s;
}

html, body {
  padding:0;
  margin:0;
  
  width: 100%;
  height: 100%;
  overflow-x: hidden;
}
p{
   font-size: 1.5rem;
  color: #fff;
  position: absolute;
  left: 50%;
  top: 35%;
  transform: translateX(-50%);
  white-space: nowrap;
  text-shadow: 2px 2px 10px #111;
  letter-spacing: 3px;
}
h1 {
  font-size: 4rem;
  color: #fff;
  position: absolute;
  left: 50%;
  top: 20%;
  transform: translateX(-50%);
  white-space: nowrap;
  text-shadow: 2px 2px 10px #111;
  letter-spacing: 3px;
}

.button {
  display: block;
  position: absolute;
  left: 50%;
  top: 60%;
  height: 2.5rem;
  padding-top: 1.3rem;
  width: 15rem;
  text-align: center;
  color: #fff;
  border: #fff solid 0.2rem;
  font-size: 1rem;
  font-weight: bold;
  text-transform: uppercase;
  text-decoration: none;
  transform: translateX(-50%);
}

.split.left .button:hover {
  background-color: var(--left-button-hover-color);
  border-color: var(--left-button-hover-color);
}

.split.right .button:hover {
  background-color: var(--right-button-hover-color);
  border-color: var(--right-button-hover-color);
}

.container {
  position: relative;
  width: 100%;
  height: 100%;
  background: var(--container-bg-color);
}

.split{
	position: absolute;
	width: 50%;
	height: 100%;
	overflow: hidden;

}
.split.left{
	left: 0;
	background: url(https://images.pexels.com/photos/7097/people-coffee-tea-meeting.jpg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940);
	background-size: cover;

}

.split.left:before{
	position: absolute;
	content: "";
	width: 100%;
	height: 100%;
	background: var(--left-bg-color);
}

.split.right{
	right: 0;
	background: url(https://images.pexels.com/photos/1271619/pexels-photo-1271619.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940);
	background-size: cover;
background-attachment: fixed;

}

.split.right:before{
	position: absolute;
	content: "";
	width: 100%;
	height: 100%;
	background: var(--right-bg-color);
}

.split.left, .split.right, .split.right:before, .split.left:before {
  transition: 2s;
}

.hover-left .left {
  width: var(--hover-width);
}

.hover-left .right {
  width: var(--other-width);
}

.hover-left .right:before {
  z-index: 2;
}


.hover-right .right {
  width: var(--hover-width);
}

.hover-right .left {
  width: var(--other-width);
}

.hover-right .left:before {
  z-index: 2;
}


@media (max-width: 1000px){
	h1{
		font-size: 1.3rem;

	}
	.button{
width: 11rem;
	}
	
}
@media (max-height: 1000px)
{
	.button{
		top: 50%;
	}
}
</style>
<script type="text/javascript" src="js/prehomepage.js" defer></script>

<body>
  <audio src="business.mp3" loop autoplay="true"></audio>
<div class="container" id="container" >
 
  <div class="split left" id="left" > 
   
    <h1>Staff Login</h1>
    <a href="Login.jsp" class="button">Login</a>
  </div>
  <div class="split right" id="right">
     
    <h1>Traveller</h1>
    <p> </p>
    <a href="Homepage.jsp" class="button" >Search A Route</a>
  </div>
</div>

</body>
</html>