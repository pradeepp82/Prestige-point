<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#header {
	background-color: #873D80;
	color: white;
	text-align: center;
	padding: 5px;
}

#nav {
	line-height: 30px;
	background-color: #eeeeee;
	height: 600px;
	width: 400px;
	float: left;
	padding: 5px;
}
.pic {

	width: 350px;
	float: left;
	padding: 7.5px;
	background: url(http://localhost:9080/pp-web/img/images.jpg) no-repeat;
}
.pic1 {

	width: 350px;
	float: left;
	padding: 7.5px;
	background: url(http://localhost:9080/pp-web/img/pro1.jpg) no-repeat;
}


.text {
	width: 340px;
	height: 220px;
	background: #FFF;
	opacity: 0;
}

.pic:hover .text {
	opacity: 0.9;
	text-align: justify;
	color: #000000;
	font-size: 17px;
	font-weight: 680;
	font-family: "Times New Roman", Times, serif;
	padding: 30px;
}
.pic1:hover .text {
	opacity: 0.9;
	text-align: justify;
	color: #000000;
	font-size: 17px;
	font-weight: 680;
	font-family: "Times New Roman", Times, serif;
	padding: 30px;
}
</style>
</head>
<body>

	<div id="header">
		<h1>
			<b>FROM THE DIRECTOR's DESK</b>
		</h1>
	</div>
	<div id="nav">
		<img src="img/pp3.jpg" width="380px" />
	</div>
	<div class="pic" align="left">
		<div class="text">We are committed towards our students growth
			and excellent training in order to cater the growing demands 
			of the industry, At prestigepoint we enable students
			 become the best developers,We have the best of the 
			 faculties and some of our faculties are from IT Industry</div>
	</div>
	<div class="pic1" align="left">
		<div class="text">We are committed towards our students growth
			and excellent training in order to cater the growing demands 
			of the industry, At prestigepoint we enable students
			 become the best developers,We have the best of the 
			 faculties and some of our faculties are from IT Industry</div>
	</div>
</body>
</html>
