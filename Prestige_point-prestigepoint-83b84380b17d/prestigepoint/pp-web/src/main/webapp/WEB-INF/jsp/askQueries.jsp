<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Public Forum</title>
<script type="text/javascript" src="js/page-js/registration.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/showdown.js"></script>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery.datetimepicker.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery-ui-1.9.1.custom.min.css" />
	<link rel="stylesheet" type="text/css" href="css/wmd.css" />
</head>
<body>
<!--section for ask question start  -->
  <section class="inner-banner">
  <div class="container">
    <ul class="breadcrumb">
      <li>
      <form><input type="button" value="Ask Question" class="btn lg-btn" style="width: 178px;" onclick="askQueries.do"/></form>
      </li>
    </ul>
  </div>
  </section>
<!--Section for ask question ends   -->

<!--Section for instruction starts-->
<section>
  <div class="container innercontent">
  <h1><p>Welcome to Perstige Point!</p></h1>
  
  <h1 class="heading">How to Ask</h1>
		<p>Have you thoroughly searched for an answer before asking your
			question? Sharing your research helps everyone. Tell us what you
			found (on this site or elsewhere) and why it didn’t meet your needs.
			This demonstrates that you’ve taken the time to try to help yourself,
			it saves us from reiterating obvious answers, and above all, it helps
			you get a more specific and relevant answer!</p>
			
	<h1 class="heading">Be specific on topic and the programming language</h1>
		<p>If you ask a vague question, you’ll get a vague answer. But if
			you give us details and context, we can provide a useful, relevant
			answer. The answer to your question may not always be the one you
			wanted, but that doesn’t mean it is wrong. A conclusive answer isn’t
			always possible. When in doubt, ask people to cite their sources, or
			to explain how/where they learned something. Even if we don’t agree
			with you, or tell you exactly what you wanted to hear, remember:
			we’re just trying to help.</p>
	</div>
  </section>
<!--Section for instruction ends   -->

	<div class="container clearfix">
		<div class="conact-form">
		<form:form method="POST" action="askQuestions.do" modelAttribute="ForumQuestion" autocomplete="off">
			<h3 style="color: red;">${message}</h3>
			<p>&nbsp;</p>
				<table width="100%" border="0">
					<tr>
						<td><div class="form-control">
								<%-- <form:errors path="firstName"  class="label error-label"></form:errors> --%>
								<label>
									<p>
										Title<small class="required">*</small>
									</p>
										<form:select path="subject.subjectId" class="inputControl">
          									<form:option value="0" label="Select" />
          											<c:forEach items="${forumList}" var="sub">
           													<form:option value="${sub.subjectId}"
            													label="${sub.subjectName}" />
          											</c:forEach>
         											</form:select>
								</label>
							</div></td>

					</tr>
					<tr>
						<td><div class="form-control">
								<%-- <form:errors path="firstName"  class="label error-label"></form:errors> --%>
								<label>
			<%-- 					<div id="wmd-editor" class="wmd-panel">
			<div id="wmd-button-bar"></div>
			<form:textarea path="forumQuestion"  id="wmd-input"></form:textarea>
		</div> --%>
		<!-- <div id="wmd-preview" class="wmd-panel"></div> -->
		<!-- <div id="wmd-output" class="wmd-panel"></div> -->
		
		<p>
		Ask Question<small class="required"></small>
		</p><form:textarea path="forumQuestion"  rows="5" cols="65" style="width: 1000px;" placeholder="Ask your question" required ="autofocus"/>
								</label>
							</div>
					</tr>
					<tr>
						<td colspan="2"><input type="submit"
							value="Post Your Question" class="btn lg-btn"
							"
              style="width: 178px; float: right;" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<script type="text/javascript" src="js/wmd.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.9.1.custom.min.js"
		charset="utf-8"></script>
	<script type="text/javascript" src="js/page-js/commonDate.js"
		charset="utf-8"></script>
</body>
</html>