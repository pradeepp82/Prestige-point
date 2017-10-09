<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AddPlacedStudent</title>
<script type="text/javascript">
$( document ).ready(function() {
						var firstName = "${fname}";
						if (document.getElementById('fcheck').checked) {
							$("#year").hide();
						} else {
							$("#year").hide();
						}
						if (document.getElementById('echeck').checked) {
							$("#year").show();
						}
						$("#fcheck").click(function() {
							$("#year").hide();
						});
						$("#echeck").click(function() {
							$("#year").show();
						});
						if (firstName != null && firstName != '') {
							document.getElementById("firstName").value = "${fname}";
							document.getElementById("lastName").value = "${lname}";
							document.getElementById("registrationId").value = "${registrationId}";
						}
					});
</script>
</head>
<body>
    <div class="container clearfix">
        <div class="conact-form">

            <p>&nbsp;</p>
            <h3 style="color: red;">${message}</h3>
            <form:form method="POST" action="savePlacedStudent.do" modelAttribute="AddPlacedStudent"
                autocomplete="off">

                <table width="100%" border="0">
                    <tr>

                        <td><div class="form-control">
                                <label>
                                    <p>First Name</p> <form:input path="registration.firstName" id="firstName"
                                        class="inputControl" placeholder="First Name" required="autofocus"
                                        maxlength="50"  onkeypress="return Alphabets(event)" /> <form:hidden path="studentId" /> <form:hidden
                                        path="registration.registrationId" id="registrationId"/>
                                </label>
                            </div></td>
                        <td><div class="form-control">

                                <label>
                                    <p>Last Name</p> <form:input path="registration.lastName" id="lastName"
                                        class="inputControl" placeholder="Last Name" required="autofocus" maxlength="50" onkeypress="return Alphabets(event)" />
                                </label>
                            </div></td>
                    </tr>
                    <tr>


                        <td><div class="form-control">

                                <label>
                                    <p>Company Name</p> <form:input path="companyName" class="inputControl"
                                        placeholder="Company Name" required="autofocus" maxlength="50" onkeypress="return Alphabets(event)"/>
                                </label>
                            </div></td>
                        <td><div class="form-control">

                                <label>
                                    <p>Package</p> <form:input path="studentPackage" class="inputControl"
                                        placeholder="Package" required="autofocus" maxlength="4"/>
                                </label>
                            </div></td>
                    </tr>
                    <tr>
                        <td><div class="form-control">
                                <label>
                                    <p>Joining date in placed company</p> <form:input path="joiningDate" id="datepick"
                                        class="inputControl" placeholder="Joining date in placed company"
                                        required="autofocus" maxlength="30" readonly="true" />
                                </label>
                            </div></td>

                        <td><div class="form-control">
                                <label>
                                    <p>Release date from Aartek</p> <form:input path="releaseDateFromAartek" id="picker"
                                        class="inputControl" placeholder="Release from Aartek" required="autofocus"
                                        maxlength="30" readonly="true" />
                                </label>
                            </div></td>
                    </tr>
                    <tr>
                        <td><div class="form-control">
                                <label>
                                    <p>Job Location</p> <form:input path="jobLocation" class="inputControl"
                                        placeholder="Job Location" required="autofocus" maxlength="50" onkeypress="return Alphabets(event)" />
                                </label>
                            </div></td>
                        <td><div class="form-control">
                       
                                <label>
                                    <p>As</p> Fresher<form:radiobutton path="experience" value="fresher" id="fcheck"  required="autofocus" />
                                </label> <label>Experience<form:radiobutton path="experience" value="experience"
                                        id="echeck" />
                                </label>
                            <div id="year">
                                    year
                                    <form:input path="year" placeholder="Year" maxlength="4"/>
                                </div>
                            </div></td>
                        </label>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Submit" class="btn lg-btn" /></td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</body>
</html>
