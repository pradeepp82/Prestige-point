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
<title></title>
</head>
<body>
	<div class="container clearfix">
		<div class="conact-form">
			<h3 style="color: red;">${message}</h3>
			<form:form method="POST" action="saveDifferenceQuestionAndAnswer.do"
				modelAttribute="QuestionAnswer">
				<table width="100%" border="0">
					<tr>
						<td><div class="form-control">
						<form:errors path="subject.subjectId" class="label error-label"></form:errors>
								<label>
									<h3 style="color: #873d80;">Add Question and Answer</h3> <small
									class="required"></small> </label> <label>
									<p>
										Subject<small class="required"></small>
									</p> <form:select path="subject.subjectId" class="inputControl1">
										<form:option value="0" label="Select" />
										<c:forEach items="${subjectList}" var="sub">
											<form:option value="${sub.subjectId}"
												label="${sub.subjectName}" />
										</c:forEach>
									</form:select> </label>
							</div></td>
					</tr>
					<tr>
						<td><div class="form-control">
								<label>
									<p>
										Question<small class="required"></small>
									</p> <form:input path="question" class="inputControl1"
										placeholder="Question" required="autofocus" maxlength="150" />
								</label>
							</div></td>
					</tr>
					<tr>
						<td><div class="form-control">
								<label>
									<p>
										First Answer<small class="required"></small>
									</p> <form:textarea path="answer" cols="50" rows="10" /> </label>
							</div></td>
							<td><div class="form-control">
								<label>
									<p>
										Second Answer<small class="required"></small>
									</p> <form:textarea path="answer1" cols="50" rows="10" /> </label>
							</div></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit"
							class="btn lg-btn" />
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>