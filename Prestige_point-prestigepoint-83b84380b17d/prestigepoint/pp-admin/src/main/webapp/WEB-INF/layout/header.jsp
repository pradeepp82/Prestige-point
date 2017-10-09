<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Home</title>
<!--stylesheet begins here -->
<link rel="stylesheet" type="text/css" href="css/reset.css" media="all">
<link rel="stylesheet" type="text/css" href="fonts/font-class.css" media="all">
<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<!--javascript libraries begins here -->
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.1.custom.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/page-js/commonDate.js" charset="utf-8"></script>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.9.1.custom.min.css" />
</head>
<body>
  <!--header starts here-->
  <header> <section class="top-header">
  <div class="container clearfix">
    <ul class="contact-info">
      <li><i class="icon icon-email"></i><a href="mailto:hrd@prestigepoint.in">hrd@prestigepoint.in</a>
      </li>
      <li><i class="icon  icon-call"></i> 91-731-3087869</li>
    </ul>
    <div class="registration-alert">
      <font color="#873d80">WELCOME TO ADMIN PANEL</font>
    </div>
  </div>
  </section> <section class="main-header">
  <div class="container clearfix bottom-border">
    <nav>
    <ul>
      <c:if test="${sessionScope.login!=null}">
        <li><font color="#873d80"><c:out value="Welcome, ${sessionScope.login.firstName}" /> </font>
        </li>
        </li>
      </c:if>
    </ul>
    <br />
    <p>&nbsp;</p>
    <ul>
      <li><a href="welcome.do">Home</a></li>
      <li><c:if test="${sessionScope.login.adminType==1||sessionScope.login.adminType==2}">
			Add Master
				<ul>
            <li><a href="course.do">Add Courses</a>
            </li>
            <li><a href="batch.do">Add Batch</a>
            </li>

            <c:if test="${sessionScope.login.adminType==1}">
              <li><a href="signup.do">Add User</a>
              </li>
            </c:if>

            <li><a href="getFooterPhotoPage.do">Footer View</a>
            </li>
            <li><a href="scrollerView.do">Banner Image</a>
            </li>
            <li><a href="currentBatch.do">Current Batch</a>
            </li>
            <li><a href="adminEnquiry.do">Admin Enquiry</a>
         
            <li><a href="challenge.do">AddChallenge</a>
            </li>
             <li><a href="marquee.do">AddMarquee</a>
            </li>
            </li>
             <li><a href="viewUploadImages.do">UploadImages</a>
            </li>
             <li><a href="assignmentView.do">AddAssignment</a>
            </li>
             </li>
             <li><a href="uploadPlacedStudentImages.do">UploadPlacedStudentImages</a>
            </li>
          </ul>
        </c:if>
      </li>
      <li><a href="registration.do">Registration</a></li>
      <li>View Master
        <ul>
          <li><a href="viewStudentDetails.do">View Student Details</a></li>
          <li><a href="getEnquiry.do">View Enquiry</a></li>
          <li><a href="viewPlacedStudent.do">View Placed Student</a>
          </li>
          <li><a href="viewPlacedStudentDetail.do">Placed Student Salary Details</a>
          </li>
          <li><a href=persuingStudentDetail.do>Persuing Student Details</a>
          </li>
          

        </ul>
      </li>
      <li><a href="sendMailPage.do">Send Mail</a>
      </li>
      
      <li><a href="javascript:;">Reports</a>
        <ul>
          <li><a href="javascript:;">Enquiry Report</a>
            <ul>
              <li><a href="getEnquiryByMonth.do">By Month</a></li>
            </ul>
          </li>
           
        </ul>
       </li>
      <li><a href="javascript:;">More Options</a>
        <ul>
          <!--  <li><a href="uploadBanner.do">Upload Banner Image</a></li>	 -->
          <li><a href="upload.do">Upload Jar</a>
          </li>
          <li><a href="javascript:;">Question & Answer</a>
            <ul>
              <li><a href="questionAndAnswer.do">Simple Question</a></li>
              <li><a href="differenceQuestionAndAnswer.do">Difference Question</a>
              </li>
            </ul>
          </li>
          <li>
           <li><a href="sendMessagePage.do">Send Message</a>
          </li>
          
        </ul>
      </li>
      <c:if test="${sessionScope.login!=null}">
        <li><font color="#873d80"><a href="logout.do">Logout</a> </font></li>
      </c:if>

    </ul>
    </nav>
    <div class="brand-logo">
      <a href="welcome.do"><img src="img/logo-prestige-point.png" alt="Brand Logo"> </a>
    </div>
  </div>
  </section> </header>
  <!--header ends here-->