<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prestige Point</title>
<script type="text/javascript" src="ckeditor.js"></script>
<script type="text/javascript" src="js/page-js/JavaEditor.js" charset="utf-8"></script>
<style>
      myHero {
        display:block;
        background-color:#ddd;
        padding: 50px;
      
      }  
  </style>
</head>
<body>
<h1>Prestige Point Editor</h1>

<form action="editor.do" method="post">
<myHero>
<textarea cols="78" rows="16" id="content" name="content">
<%if((String)request.getAttribute("input")!=null){ %>
				<%=(String)request.getAttribute("input") %>
				<%} else { %>
			
        class Main{
        public static void main(String args[]){
        
        System.out.println("hello");
        }
        }
        <%} %>
        </textarea>
<input type="Button" value="run" id="editor" onclick="myexecuteProgram();"/>

<textarea id="output" cols="78" rows="16" name="result">

</textarea>
</myHero>
</form>
</body>

</html>
