<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/Home.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Wendy+One" rel="stylesheet">
<!-- <meta charset="ISO-8859-1"> -->
<title>Home</title>
</head>

<body >

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Data Analytics</a>
    </div>
    <!-- <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
       <li><a href="#">About</a></li>
      <li><a href="#">Page 2</a></li>
      <li><a href="#">Page 3</a></li>
    </ul> -->
  </div>
</nav>

<div class="cont">
	<div>
		<form action="submit" method="post">
  		<div class="form-group">
    	<label for="exampleFormControlFile1" >Select A File to Visualize</label>
    	<input type="submit" class="form-control-file" id="exampleFormControlFile1" value="Choose File" name="submit">
 	 </div>
</form>
	</div>
</div>

<div class="footer">
<h3 align="center">About</h3>
<p>Data visualization is the graphical representation of information and data. By using visual elements like charts, graphs, and maps,</p>
<p> data visualization tools provide an accessible way to see and understand trends, outliers, and patterns in data.</p>
</div>



	
</body>



</html>