<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Charge</title>
<script type="text/javascript" src="js/page-js/stuRegistration.js"></script>
</head>
<body>
	<div class="container clearfix">
		<div class="conact-form">

			<p>&nbsp;</p>
			<h3 style="color: red;">${message}</h3>
			<form:form method="POST" action="saveChangePassword.do"
				modelAttribute="Registration" autocomplete="off">

				<table width="100%" border="0">
					<tr>

						<td><div class="form-control">
								<label>
									<p>Old Password</p> <form:input path="password" type="password"
										id="oldPassword" class="inputControl2"
										placeholder="Old Password" required="autofocus" maxlength="10" />
								</label>
							</div></td>
					</tr>
					<tr>
						<td><div class="form-control">
								<label>
									<p>New Password</p> <form:input path="newPassword" type="password"
										class="inputControl2" id="password" placeholder="New Password"
										required="autofocus" maxlength="10" />
								</label>
								<form:hidden path="registrationId" />
							</div></td>

					</tr>
					<tr>
						<td><div class="form-control">
								<label>
									<p>
										Confirm Password<small class="required"></small>
									</p> <input path="newPassword" type="password" id="confirmPassword"
									class="inputControl2" placeholder="Confirm Password"
									required="autofocus" maxlength="10"
									onchange="return validate();" />
								</label>
							</div></td>

					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit"
							class="btn lg-btn2" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>