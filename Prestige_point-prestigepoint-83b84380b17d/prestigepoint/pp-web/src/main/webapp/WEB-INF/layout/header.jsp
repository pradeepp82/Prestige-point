<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" type="text/css" href="fonts/font-class.css"
	media="all">
<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<!--javascript libraries begins here -->
<script type="text/javascript" src="js/jquery-1.10.1.min.js"></script>
<script src="js/jquery.easing.1.3.js"></script>
<!-- Google Analytics code start  -->
<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga');
	ga('create', 'UA-54942023-3', 'auto');
	ga('send', 'pageview');
</script>
<!-- Google Analytics code end  -->
</head>
<body>
	<!--header starts here-->
	<header> <section class="top-header">
	<div class="container clearfix">
		<ul class="contact-info">
			<c:choose>
				<c:when test="${sessionScope.registration!=null}">
					<li><i></i><font color="#873d80"><c:out
								value="Welcome," /><a href="viewProfile.do">&nbsp;&nbsp;<c:out
									value="${sessionScope.registration.firstName}" />
						</a> </font>&nbsp;&nbsp;</li>
				</c:when>
			</c:choose>
			<li>&nbsp;&nbsp;</li>
			<li><i class="icon icon-email"></i><a
				href="mailto:hrd@prestigepoint.in">hrd@prestigepoint.in</a></li>
			<li><i class="icon  icon-call"></i> 91-731-3087869</li>
		</ul>
		<div class="registration-alert">
			<img src="img/icon-new.png" alt=" " />Registration open for new <span>JAVA
				BATCH</span>
		</div>
	</div>
	</section> <section class="main-header">
	<div class="container clearfix bottom-border">
		<nav>
		<ul>
			<li><a href="welcome.do">Home</a></li>
			<li><a href="#">Prestigepoint</a>
				<ul>
					<li><a href="aboutUs.do">About Us</a></li>
			<!-- 	<li><a href="directorMessage.do">Director Message</a></li> -->
				<!-- 	<li><a href="keyPeople.do">Key People</a></li> -->
				</ul></li>
			   <li><a href="#">Courses</a>
				<ul>
					<li><a href="coursesDeclear.do">C,C++</a></li>
					<li><a href="java.do">Java</a></li>
					<li><a href="industrialTraining.do">Industrial Training</a></li>
					<li><a href="corporateTraining.do">Corporate Training</a></li>
				</ul>
			</li>
			<li><a href="viewCurrentBatch.do">Current Batch</a></li>
			<li><a href="placementCell.do">Placement Cell</a></li>
			<!-- <li><a href="#">Events</a>
			<ul>
					<li><a href="photoGallery.do">Photo Gallery</a></li>
					<li><a href="#">Up Coming Event</a></li>
					<li><a href="#">Roll bar</a></li>
				</ul>
				</li> -->
			<!-- <li><a href="features.do">Features</a></li> -->
			<li><a href="contactUs.do">Contact</a></li>
			<c:choose>
				<c:when test="${sessionScope.registration!=null}">
					<li><a href="javascript:;">Student Utilities</a>
						<ul>
							<li><a href="javascript:;">Interview Question</a>
								<ul>
									<c:forEach items="${subjectList}" var="sub">
										<li><a
											href="QuestionAndAnswer.do?subjectId=${sub.subjectId}">${sub.subjectName}</a>
										</li>
									</c:forEach>
								</ul></li>
							<li><a href="downloadJars.do">Download jar</a></li>
						<!--     <li><a href="forum.do">Forum</a></li> -->
							<li><a href="viewProfile.do">Profile</a></li>
							<li><a href="viewChallengeDetails.do">Challenge Title</a></li>
							<c:choose>
				           <c:when test="${sessionScope.registration.batch.batchId!=null}">
							<li><a href="viewAssignment.do">Assignment</a></li>
							</c:when>
						 </c:choose>
						
							<!-- <li><a href="editor.do">Java Editor</a></li> -->
						</ul></li>
					<!--  <li><a href="viewProfile.do">Profile</a></li> -->
					<li class="link-login"><a href="logout.do">Logout</a></li>
				</c:when>
				<c:otherwise>

					<li class="link-login"><a href="login.do">Login</a></li>
					<li><a class="btn" href="stuRegistration.do">Signup</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
		</nav>
		<div class="brand-logo">
			<a href="welcome.do"><img src="img/logo-prestige-point.png"
				alt="Brand Logo"> </a>
		</div>
	</div>
	</section> </header>
	<!--header ends here-->
</body>
</html>