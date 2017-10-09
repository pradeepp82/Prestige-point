<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.basic-table {
  width: 110%;
}
</style>
</head>
<body>
  <div class="container clearfix">
    <div class="conact-form">
      <c:set var="count" value="0" scope="page" />
      <p>&nbsp;</p>
      <display:table name="jarlist" pagesize="15" class="basic-table" uid="cat" requestURI="downloadJars.do">
        <c:set var="count" value="${count+1}" scope="page" />
        <display:column title="S.NO" class="showHeading" style=" width:1%;">
     ${count}
    </display:column>
        <display:column property="jarType" title="Type" />
        <display:column property="nameOfJar" title="NAME" />
        <display:column>
          <a href="getJar.do?jarName=${cat.nameOfJar}&jarType=${cat.jarType}">Download</a>
        </display:column>
      </display:table>
    </div>
  </div>
</body>
</html>