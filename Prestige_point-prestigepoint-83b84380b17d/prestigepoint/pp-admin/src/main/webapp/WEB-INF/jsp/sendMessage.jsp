<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container clearfix">
	<div class="conact-form">
		<form:form method="POST" action="sendMessage.do"
			modelAttribute="Batch" enctype="multipart/form-data">
			<table width="70%" border="0">
				<tr>
					<td><div class="form-control">
							<label>
								<p>
									Batch<small class="required"></small>
								</p> <form:select path="batchId" class="inputControl">
									<form:option value="0" label="Select" />
									<c:forEach items="${batchList}" var="refBatch">
										<form:option value="${refBatch.batchId}"
											label="${refBatch.batchName}" />
									</c:forEach>
								</form:select>
							</label>
						</div></td>
				</tr>
				<tr>
					<td><div class="form-control">
							<label>
								<p>
									Message<small class="required"></small>
								</p> <form:textarea path="messageText" cols="50" rows="10"
									required="autofocus" />
							</label>
						</div></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Submit"
						class="btn lg-btn" /></td>
				</tr>
</table>
</form:form>
	</div>
</div>
