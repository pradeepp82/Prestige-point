<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:eval
	expression="@propertyConfigurer.getProperty('pp.showuploadImages')"
	var="uploadImagesPath" />
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
      <form:form method="POST" action="saveUploadImages.do" modelAttribute="UploadImages" enctype="multipart/form-data" autocomplete="off">
       <h3 style="color: #873d80;">Add images On home Page </h3>
       <table width="100%" border="0">
         <tr><td></td></tr> <tr><td></td></tr> <tr><td></td></tr>
         
          <tr>
           
              <td><div class="form-control">
             	<h4>
					<b>Please browse image</b>
				</h4>
				 <img id="preview" src="${uploadImagesPath}${UploadImages.imagesId}.png" style="width: 50px; height: 50px" />
             		<input type="file" name="image_file" path="nameOfimages" id="image_file"
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
        	<form:hidden path="uploadImagesPath" id="uploadImagesPath" />
         <c:set var="count" value="0" scope="page" />
                <display:table name="uploadImagesList" pagesize="8" class="basic-table" uid="uploadImagesList" requestURI="viewUploadImages.do">
                    <!-- uid is user define -->
                    <c:set var="count" value="${count+1}" scope="page" />
                    <display:column title="S.NO" style="width:1%;">
     ${count}
                      </display:column>
                      <display:column title="IMAGES" class="showHeading" style="width:1%;">
                      <img id="preview" src="${uploadImagesPath}${uploadImagesList.imagesId}.png" style="width: 50px; height: 50px" />
                     </display:column>
                    <display:column title="Is_Active">
                        <c:if test="${uploadImagesList.isActive==1}">
                            <form:checkbox path="isActive" checked="checked" value="${uploadImagesList.imagesId}"
                                id="checkboxId${uploadImagesList.imagesId}" onclick="enableUploadImageStatus(this);" />
                        </c:if>
                        <c:if test="${uploadImagesList.isActive==0}">
                            <form:checkbox path="isActive" value="${uploadImagesList.imagesId}"
                                id="checkboxId${uploadImagesList.imagesId}" onclick="enableUploadImageStatus(this);" />
                        </c:if>
                    </display:column>
                    <display:column title="Delete">
                         <a href="deleteUploadImages.do?imagesId=${uploadImagesList.imagesId}"
                            onclick="return confirm('Please confirm if you want to delete this batch!');">Delete</a> 
                    </display:column> 
                </display:table>
       </form:form>
    </div>
  </div>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
</body>
</html>