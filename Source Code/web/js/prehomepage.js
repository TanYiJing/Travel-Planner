/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var left = document.getElementById("left");
var right = document.getElementById("right");
var container = document.getElementById("container");


left.addEventListener("mouseenter",function(){
   
   container.classList.add("hover-left");
  
   
   });


left.addEventListener("mouseleave",function(){

  container.classList.remove("hover-left");
  
});

right.addEventListener("mouseenter",function(){

  container.classList.add("hover-right");
 	

});

right.addEventListener("mouseleave", function(){
 
  container.classList.remove("hover-right");
  

});
