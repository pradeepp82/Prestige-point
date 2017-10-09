<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:eval
	expression="@propertyConfigurer.getProperty('pp.showUploadPlacedStudentImages')"
	var="uploadPlacedStudentImagesPath" />
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Add images</title>
<script type="text/javascript" src="js/uploadImage.js"></script>
<script type="text/javascript" src="js/page-js/uploadImages.js"></script>
<script type="text/javascript">
  function uploadImages() {
    var src = $("#preview").attr("src");
    $('#uploadImagesPath').attr("value", src);
  }
</script>
</head>
<body>
  <div class="container clearfix">
    <div class="conact-form">
      <h3 style="color: red;">${message}</h3>
      <form:form method="POST" action="savePlacedStudentImages.do" modelAttribute="UploadPlacedStudentImages" enctype="multipart/form-data" autocomplete="off">
       <h3 style="color: #873d80;">Add images On home Page </h3>
       <table width="100%" border="0">
         <tr><td></td></tr> <tr><td></td></tr> <tr><td></td></tr>
         
          <tr>
           
              <td><div class="form-control">
             	<h4>
					<b>Please browse image</b>
				</h4>
				 <img id="preview" src="${uploadPlacedStudentImagesPath}${UploadPlacedStudentImages.studentImagesId}.png" style="width: 50px; height: 50px" />
             		<input type="file" name="image_file" path="nameOfStudentImages" id="image_file"
							onchange="fileSelected();" />
						
		<div id="fileinfo">
					<div id="filename"></div>
					<div id="filesize"></div>
					<div id="filetype"></div>
					<div id="filedim"></div>
				</div>
				</div>
            </td>
          </tr>
            <tr>
            <td colspan="2"><input type="submit" value="Submit" class="btn lg-btn" onclick="uploadImages()"/>
            </td>
          </tr>
        </table>
        	<form:hidden path="uploadPlacedStudentImagesPath" id="uploadImagesPath" />
       </form:form>
    </div>
  </div>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
</body>
</html>