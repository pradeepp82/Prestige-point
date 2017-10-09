<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


						
						<form:form method="POST" action="getQuestionList.do"
				modelAttribute="QuestionAnswer" autocomplete="off">
				<table width="100%" align="center" border="0">
					<tr>
												<td><div class="form-control">
																<form:errors path="subject.subjectId"
																		class="label error-label"></form:errors> 
																<label>
																		 <small class="required"></small>
																
																		<p>
																				Search SubjectWise Question<small class="required"></small>
																		</p> <form:select path="subject.subjectId"
																				class="inputControl1" id="subject">
																				<form:option value="0" label="Select" />
																				<c:forEach items="${subjectList}" var="sub">
																						<form:option value="${sub.subjectId}"
																								label="${sub.subjectName}" />
																				</c:forEach>
																		</form:select>
																</label>
														</div></td>
										</tr><tr>
												<td colspan="2"><input type="submit" value="Submit"
														class="btn lg-btn" /></td>
										</tr>
</table></form:form> 

						<form:form method="POST" action="saveQuestionAnwser.do"
								modelAttribute="QuestionAnswer" onsubmit="return validateForm()">
								<table width="100%" border="0">
										<tr>
												<td><div class="form-control">
																<form:errors path="subject.subjectId"
																		class="label error-label"></form:errors>
																<label>
																		<h3 style="color: #873d80;">Add Question and
																				Answer</h3> <small class="required"></small>
																</label> <label>
																		<p>
																				Subject<small class="required"></small>
																		</p> <form:select path="subject.subjectId"
																				class="inputControl1" id="subject">
																				<form:option value="0" label="Select" />
																				<c:forEach items="${subjectList}" var="sub">
																						<form:option value="${sub.subjectId}"
																								label="${sub.subjectName}" />
																				</c:forEach>
																		</form:select>
																</label>
														</div></td>
										</tr>
										<tr>
												<td><div class="form-control">
																<label>
																		<p>
																				Question<small class="required"></small>
																		</p> <form:input path="question" class="inputControl1"
																				placeholder="Question" required="autofocus"
																				maxlength="150" />
																</label>
														</div></td>
										</tr>
										<tr>
												<td><div class="form-control">
																<label>
																		<p>
																				Answer<small class="required"></small>
																		</p> <form:textarea path="answer" cols="50" rows="10" />
																</label>
														</div></td>
										</tr>
										<tr>
												<td colspan="2"><input type="submit" value="Submit"
														class="btn lg-btn" /></td>
										</tr>
								</table>
						</form:form>


						<c:set var="count" value="0" scope="page" />
						<display:table name="questionAnswerList" pagesize="12"
								class="basic-table" uid="quesion"
								requestURI="questionAndAnswer.do">
								<c:set var="count" value="${count+1}" scope="page" />
								<display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
								<display:column property="question" title="Question" />
								<display:column title="Delete">
										<a
												href="deleteQuestionAnswer.do?questionId=${quesion.questionId}"
												onclick="return confirm('Please confirm if you want to delete this question!');">Delete</a>
								</display:column>
						</display:table>

						<c:if test="${questionList != null }"> 
								<c:set var="count" value="0" scope="page" />
								<display:table name="questionList" pagesize="12"
										class="basic-table" uid="quesion1" requestURI="getQuestionList.do">
										<c:set var="count" value="${count+1}" scope="page" />
										<display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
										<display:column property="question" title="Question" />
										<display:column title="Delete">
										<a
												href="deleteQuestionAnswer.do?questionId=${quesion1.questionId}"
												onclick="return confirm('Please confirm if you want to delete this question!');">Delete</a>
								</display:column>

								</display:table>
						 </c:if> 
				</div>
		</div>
</body>
</html>