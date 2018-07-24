<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<script>
function checklogin(valuser) {     
    user = "";
    xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange=function(){
        if(xmlhttp.readyState==4){
            user = xmlhttp.responseText;
            alert("user: " + user);
            var divElement = document.getElementById('mydiv');
            divElement.innerHTML = user;
        } 
    }
    xmlhttp.open("GET","usercheck?uname="+valuser,true);
    xmlhttp.send(null); 
 }
 </script>
</head>
<body>


<h1>MOVIE TICKET BOOKING - LOGIN</h1>
<form action="movieLogin" method ="post">
<input type="text" name="login" onblur="checklogin(this.value)">
<input type="password" name="password">
<input type="submit" value="signup">

</form>
   <div id="mydiv">
   </div>
</body>
</html>