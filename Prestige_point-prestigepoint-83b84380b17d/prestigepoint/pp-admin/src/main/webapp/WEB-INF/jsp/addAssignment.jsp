<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Assignment</title>
<script type="text/javascript" src="js/page-js/dropdown.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/dropdown.css">

</head>
<body>
<div class="container clearfix">
	<div class="conact-form">
		<p>&nbsp;</p>
		<h3 style="color: red;">${message}</h3>
		<form:form method="POST" action="saveAssignment.do" modelAttribute="AssignmentDoc" autocomplete="off" enctype="multipart/form-data">
			<table width="100%" border="0">
				<tr>
					<td><div class="form-control">
							<form:errors path="addAssignment.subject.subjectId"
								class="label error-label"></form:errors>
							<label>
								<p>
									Title<small class="required"></small>
								</p> <form:select path="addAssignment.subject.subjectId"
									class="inputControl1" id="subject">
									<form:option value="0" label="Select" />
									<c:forEach items="${subjectList}" var="sub">
										<form:option value="${sub.subjectId}"
											label="${sub.subjectName}" />
									</c:forEach>
								</form:select>
							</label>
						</div></td>
					<td><div class="form-control">
							<label>
								<p>Topic</p> <form:input path="addAssignment.topic"
									class="inputControl" placeholder="Topic" required="autofocus"
									maxlength="200" id="topic"/>
									<form:hidden path="addAssignment.assignmentId"/>
							</label>
						</div></td>
				</tr>
				<tr>
					<td><div class="form-control">

							<label>
								<p>Description</p> <form:textarea
									path="addAssignment.description" id="description"
									class="inputControl" placeholder="Description"/>
							</label>
						</div></td>
				</tr>
				<tr>
					<td><div class="form-control">
							<label>
								<p>
									Attach file:<small class="required"></small>
								</p> <input type="file" path="assignmentDocName" name="fileUpload"
								size="60" multiple="multiple" />
							</label>
						</div></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit" id="check"
						class="btn lg-btn" /></td>
				</tr>
			</table>
			<c:set var="count" value="0" scope="page" />

			<display:table name="assignmentList" pagesize="8" class="basic-table"  uid="assignmentList" requestURI="assignmentView.do">
				<!-- uid is user define -->
				<c:set var="count" value="${count+1}" scope="page"/>
				<display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
				<display:column title="Title" >
				<label id="subject${count}">${assignmentList.subject.subjectName}</label>
				</display:column>
				<display:column title="Topic" >
				<label id="topic${count}">${assignmentList.topic}</label>
				</display:column>
				<display:column title="Batchs">
					<dl class="dropdown_${count}">
						<dt>
							<a href="javascript:void(0);"> <span class="hida_${count}">Select</span>
								<p class="multiSel_${count}"></p>
							</a>
						</dt>
						<dd>
							<div class="mutliSelect_${count}">
								<ul>
									<c:forEach items="${batchList}" var="refBatch">
										<li><form:checkbox path="addAssignment.batch.batchId" 
												value="${refBatch.batchId}" label="${refBatch.batchName}" class="chkbox${count}" />
										</li>
									</c:forEach>
								</ul> 
							</div>
						</dd>
					</dl>
					<script type="text/javascript">
				        $(function () {
				            $(".dropdown_${count} dt a").on('click', function () {
				                $(".dropdown_${count} dd ul").slideToggle('fast');
				            });
				
				            $(".dropdown_${count} dd ul li a").on('click', function () {
				                $(".dropdown_${count} dd ul").hide();
				            });
				
				            function getSelectedValue(id) {
				                return $("#" + id).find("dt a span.value").html();
				            }
				
				            $(document).bind('click', function (e) {
				                var $clicked = $(e.target);
				                if (!$clicked.parents().hasClass("dropdown_${count}")) $(".dropdown_${count} dd ul").hide();
				            });
				
				
				            $('.mutliSelect_${count} input[type="checkbox"]').on('click', function () {
				
				                var title = $(this).closest('.mutliSelect_${count}').find('input[type="checkbox"]').val(),
				                title = $(this).val() + ",";
				
				                if ($(this).is(':checked')) {
				                    var html = '<span title="' + title + '">' + title + '</span>';
				                    $('.multiSel_${count}').append(html);
				                    $(".hida_${count}").hide();
				                } 
				                else {
				                    $('span[title="' + title + '"]').remove();
				                    var ret = $(".hida_${count}");
				                    $('.dropdown_${count} dt a').append(ret);
				                }
				            });
				        });
				    </script>
				</display:column>
				 <display:column title="Edit">
                        <a href="editAssignment.do?assignmentId=${assignmentList.assignmentId}">Edit</a>
                    </display:column>
                     <display:column title="Delete">
                        <a href="deleteAssignment.do?assignmentId=${assignmentList.assignmentId}"
                            onclick="return confirm('Please confirm if you want to delete this assignment!');">Delete</a>
                    </display:column>
				  <display:column>
                 <a href="javascript:void(0);" onclick="sendEmail(${count},'${assignmentList.description}','${assignmentList.assignmentId}','${assignmentList.topic}');">Send Mail</a>
                </display:column>
			</display:table> 
		</form:form>
	</div>
</div>
</body>
</html>