<%-- 
    Document   : AdminProfile
    Created on : Aug 5, 2019, 10:45:32 AM
    Author     : tanyj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
        video {
    width: 500px;
    height: 500px;
}
    </style>
    
    <head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <a href="AdminPage.jsp" class="btn btn-success"  > BACK </a>

        <div style="text-align:center;">
  <video id="screenshot-video" class="videostream" autoplay=""></video>
  <img id="screenshot-img">
  <p><button id="screenshot-button" hidden></button></p>
  <div>Staff Name : Tan Yi Jing</div>
  <div>Staff ID : 1001</div>

    </body>
    <script>
        function handleError(error) {
  console.error('navigator.getUserMedia error: ', error);
}
const constraints = {
  video: {width: {min: 1280}, height: {min: 720}}
};




(function() {
  const button = document.querySelector('#screenshot-button');
  const img = document.querySelector('#screenshot-img');
  const video = document.querySelector('#screenshot-video');

  const canvas = document.createElement('canvas');

  button.onclick = video.onclick = function() {
    canvas.width = video.videoWidth;
    canvas.height = video.videoHeight;
    canvas.getContext('2d').drawImage(video, 0, 0);
    // Other browsers will fall back to image/png
    img.src = canvas.toDataURL('image/webp');
  };

  function handleSuccess(stream) {
    video.srcObject = stream;
  }

  navigator.mediaDevices.getUserMedia(constraints).
      then(handleSuccess).catch(handleError);
})();



 setTimeout(function(){ 
 
 $( "#screenshot-button" ).trigger( "click" );
 
 }, 5000);



window.onload = function () {
    var fiveMinutes = 5,
        display = document.querySelector('#time');
    startTimer(fiveMinutes, display);
};
        </script>
</html>
