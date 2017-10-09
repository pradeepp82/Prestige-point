<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:eval
	expression="@propertyConfigurer.getProperty('pp.showScrollerInJsp')"
	var="imgPath" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <!--banner starts here -->
<section class="jumbotron clearfix">
   <section class="banner-slider">
  
   <div id="slider">
    <ul id="banner">
    <%--  <c:forEach var="listValue" items="${allImages}"> --%>
   <li>
        <div class="banner-slide two">
         <%--  <img src="${imgPath}${listValue.imageId}.png" /> --%>
        </div>
      </li>
        <li>
         <div class="banner-slide one">
         <%--  <img src="${imgPath}${listValue.imageId}.png" /> --%>
          <div class="container">
            <div class="lead-txt">
              <h3>Over <b>300+</b> Students placed in various<br>
                companies in last year.</h3>
            </div>
          </div>
        </div>
      </li>
      <li>
        <div class="banner-slide three">
           <%--  <img src="${imgPath}${listValue.imageId}.png" /> --%>
        </div>
      </li>
          <%-- </c:forEach> --%>
    </ul>
    <a href="javascript:;" class="prev control_prev"></a> 
    <a href="javascript:;" class="next control_next"></a>
    </div>
 
  </section>
 
</section>
  <!--banner ends here -->

  <!--courses section begins here  -->
  <section class="offered-courses">
  <div class="container">
    <div class="lead-text">
      <h4 class="featurette-heading">Courses We Offer</h4>
      <p>Mostly Practical Sessions for every course in our institute.</p>
    </div>
    <div class="course-slider">
      <ul class="clearfix">
        <li>
          <div class="course-logo">
            <img src="img/java.png" alt="Java" />
          </div>
          <h3 class="course-name">JAVA</h3>
          <p class="course-description">Complete conceptual development in Core & Advanced java. Advanced
            infrastructure frameworks viz. Springs & Hibernate also covered.</p></li>
        <li>
          <div class="course-logo">
            <img src="img/ios.png" alt="Dot Net" />
          </div>
          <h3 class="course-name">iOS and Android</h3>
          <p class="course-description">Complete core concepts covered and an extra emphasis is laid to build up
            real-time scenarios through rigorous practical trainings.</p></li>
        <li>
          <div class="course-logo">
            <img src="img/oracle.png" alt="Oracle" />
          </div>
          <h3 class="course-name">ORACLE</h3>
          <p class="course-description">Core PL\SQL concepts covered in full length along with specialized oracle
            concepts like architecture and warehousing.</p></li>
        <li>
          <div class="course-logo">
            <img src="img/php.png" alt="PHP" />
          </div>
          <h3 class="course-name">PHP</h3>
          <p class="course-description">Training imparted through real-time scenario implementation through
            web-pages. Core concepts clarity provided in detail.</p></li>
      </ul>
    </div>
  </div>
  </section>
</body>
<script type="text/javascript" src="js/accordion.js"></script>
<script type="text/javascript" src="js/banner.js"></script>
<script type="text/javascript" src="js/page-js/welcome.js"></script>

</html>