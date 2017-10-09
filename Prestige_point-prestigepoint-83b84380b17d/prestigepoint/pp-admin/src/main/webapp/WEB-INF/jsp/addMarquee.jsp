<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Marquee</title>
<script type="text/javascript" src="js/page-js/marquee.js" charset="utf-8"></script>
</head>
<body>
    <div class="container clearfix">
        <div class="conact-form">

            <p>&nbsp;</p>
            <h3 style="color: red;">${message}</h3>
            <form:form method="POST" action="saveMarquee.do" modelAttribute="AddMarquee" autocomplete="off">

                <table width="100%" border="0">
                    <tr>
                        <td><div class="form-control">

                                <label>
                                    <p>Marquee Description</p> <form:textarea path="discription" id="discription"
                                        class="inputControl" placeholder="Discription" required="autofocus"
                                        maxlength="130"  onkeypress="return Alphabets(event)" />
                                        <form:hidden path="marqueeId" />
                                </label>
                            </div></td>
                    </tr>
                     <tr>
                        <td colspan="2"><input type="submit" value="Submit" class="btn lg-btn" /></td>
                    </tr>
                </table>
        <c:set var="count" value="0" scope="page" />
      <display:table name="marqueeList" pagesize="8" class="basic-table" uid="marqueeList" requestURI="marquee.do">
        <c:set var="count" value="${count+1}" scope="page" />
        <display:column title="S.NO" class="showHeading" style="width:1%;">
     ${count}
    </display:column>
        <display:column property="discription" title="MARQUEE_DISCRIPTION" />
        <display:column title="Edit">
                        <a href="editMarqueeDescription.do?marqueeId=${marqueeList.marqueeId}">Edit</a>
                    </display:column>
         <display:column title="Delete">
                        <a href="deleteMarqueeDescription.do?marqueeId=${marqueeList.marqueeId}"
                            onclick="return confirm('Please confirm if you want to delete this marquee description!');">Delete</a>
                    </display:column>
          <display:column title="Is_Active">
                        <c:if test="${marqueeList.isActive==1}">
                            <form:checkbox path="isActive" checked="checked" value="${marqueeList.marqueeId}"
                                id="checkboxId${marqueeList.marqueeId}" onclick="enableMarqueeStatus(this);" />
                        </c:if>
                        <c:if test="${marqueeList.isActive==0}">
                            <form:checkbox path="isActive" value="${marqueeList.marqueeId}"
                                id="checkboxId${marqueeList.marqueeId}" onclick="enableMarqueeStatus(this);" />
                       </c:if>
                    </display:column>
                </display:table>

            </form:form>
        </div>
    </div>
</body>
</html>