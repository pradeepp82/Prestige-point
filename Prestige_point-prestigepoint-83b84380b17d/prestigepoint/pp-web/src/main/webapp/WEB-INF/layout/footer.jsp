 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:eval
	expression="@propertyConfigurer.getProperty('pp.jspImagePath')"
	var="imgPath" />
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript" src="js/page-js/common.js"></script>
<script type="text/javascript" src="js/page-js/enquiry.js"></script>
</head>
<body>
  <!--footer begins here -->
  <footer>
  <div class="container clearfix">
    <div class="foot-nav">
      <ul class="clearfix">
        <li><a href="blog.do">Blog</a>
        </li>
        <li>-</li>
        <li><a href="javascript:;">Privacy</a>
        </li>
        <li>-</li>
        <li><a href="javascript:;">Terms&Condition </a>
        </li>
        <li>-</li>
        <li><a href="contactUs.do">Contact</a>
        </li>
      </ul>
      <p>Copyright &copy; 2013 Prestige Point</p>
      <div class="social-sites">
        <a href="https://twitter.com/@prestigepoint9" class="twitter" target="_blank"></a> <a
          href="https://facebook.com/prestigepointindore" class="fb" target="_blank"></a>
           <a href="https://www.linkedin.com/company/5354475?trk=tyah&trkInfo=tarId%3A1411721201794%2Ctas%3Aprestige%20point%2Cidx%3A1-1-1" class="yt" target="_blank"></a>
      </div>
    </div>
    <div class="eligibility">
      <h5>Eligibility</h5>
      <ul>
        <li>M.C.A., M.Sc(CS), M.Sc (IT), M.Tech</li>
        <li>BE- CS ,Mech , IT Engg, EC, Ex</li>
        <li>B.C.A, B.Sc (CS), B.Tech</li>
        <li>Excellent Communication skills</li>
      </ul>
    </div>
		
		 <div class="testimonial">
      <ul class="testimonialSlider">
      <c:forEach var="listValue" items="${allStudentDetail}">
        <li class="slide">
          <div class="image-icon">
            <img src="${imgPath}${listValue.studentId}.png" />
            <div class="icon-overlay"></div>
          </div>
          <div class="testimonial-txt">
            <div class="wrapper">
              <p>${listValue.studentComment}</p>
              <i class="postedBy">${listValue.studentName}</i> <span class="placedIn">${listValue.placedInCompany}</span><br>
              <span class="package">Package:&nbsp;${listValue.studentPackage}</span>
            </div>
          </div></li>
          </c:forEach>
          </ul>
          </div>
  </div>
  </footer>
  <div class="enquiry-form">
    <a href="javascript:;" class="enquiry-open"></a>
    <div class="formEnquiry">
      <h3>Prestige Point welcomes your feedback and enquiries.</h3>
      <div id="info" style="color: #863d7f;"></div>
      <form autocomplete="off">
        <div class="form-control">
          <span class="label error-label" id="nameMsg" style="display: none;">Please enter your name</span> <label>
            <input type="text" placeholder="Name" class="inputControl" id="name1" name="name1" maxlength="30"
            onkeypress="return Alphabets(event)" /> </label>
        </div>
        <div class="form-control">
          <span class="label error-label" id="emailMsg" style="display: none;">Please enter your email Id</span> <span
            id="emailMsg1" style="display: none;">Invalid Email Address</span> <label> <input type="text"
            placeholder="Email Id" class="inputControl" id="emailId1" name="emailId1" maxlength="50" /> </label>
        </div>
        <div class="form-control">
         <span class="label error-label" id="mobileMsg" style="display: none;">Please enter your mobile No.</span>
           <span class="label error-label" id="contact" style="display: none;">Contact No should be 10 digit</span> 
         <p id="msg1" style="font-size:14px; color:#FF0000; text-align:center;"></p>
           <label>
            <input type="text" placeholder="Phone No." class="inputControl" name="mobileNo1" id="mobileNo1"
            maxlength="10" onkeypress="return onlyNos(event,this);" onchange="checkLength()" /> </label>
        </div>
        <div class="form-control">
          <span class="label error-label" id="commentMsg" style="display: none;">Please enter your comment.</span> <label>
            <textarea placeholder="Comments" class="inputControl" id="comment1" name="comment1" maxlength="150"></textarea>
          </label>
        </div>
        <div class="form-control">
          <label> <input type="button" value="submit" class="btn lg-btn" onclick="saveEnquiry()" /> </label>
        </div>
      </form>
    </div>
  </div>
  <!--enquiry form ends here -->
  <!--javascript begins here -->
  <script src="js/functions.js"></script>
  <script src="js/jquery.flexisel.js"></script>
  <script type="text/javascript" src="js/page-js/footer.js"></script>
  <!--javascript ends here -->
  <!--footer ends here -->
</body>
</html>