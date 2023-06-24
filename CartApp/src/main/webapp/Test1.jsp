<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
  <body>
  
 <%if(request.getAttribute("qty")==null)
	 request.setAttribute("qty", 0); %>
   <button onclick="myFunction(id,1)">What is the time?</button>
      <p id="demo"></p>
      <p id="counter"></p>
       <a href="test2.jsp" onclick="myfun2()">hello</a>
       
       
       <p>Field1: <input type="text" id="field1" value="0"></p>
      <p>Field2: <input type="text" id="quantity" value=<%=request.getAttribute("qty") %>></p>
    <pre id="arrPrint"></pre>
    <script>
      
    let arr = ["Jack", "John", "James"];
      document.getElementById("arrPrint").innerHTML = arr;
      function myFunction(id, quantity) 
      {
    	  document.getElementById('demo').innerHTML=Date();
    	  document.getElementById('field1').value =Number(document.getElementById('quantity').value)+Number('1'); 
    	  document.getElementById('quantity').value = Number(document.getElementById('quantity').value)+1;
    	  var temp1Val = Number(document.getElementById('quantity').value); 
    	
    	  
      }
      
      </script>
  </body>

</html>