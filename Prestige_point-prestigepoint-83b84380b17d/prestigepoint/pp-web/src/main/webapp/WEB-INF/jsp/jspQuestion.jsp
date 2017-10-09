<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>jQuery UI Accordion - Default functionality</title>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" media="all">
<script src="js/jquery-ui.js"></script>
<script>
  $(function() {
    $("#accordion").accordion();
  });
</script>
</head>
<body>
  <div class="container innercontent">
    <h1 class="heading">Jsp Question and Answer</h1>
    <div id="accordion">
      <h5>
        <b>Q1. What are the JSP implicit objects? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>Implicit objects are by default available to the JSP. Being JSP author we can use these and not
          required to create it explicitly. <br>1. request <br> 2. response <br> 3. pageContext <br>
          4. session <br> 5. application <br> 6. out <br> 7. config <br> 8. page <br> 9.
          exception <br>
        </p>
      </div>
      <h5>
        <b>Q2. What are the advantages of JSP over Servlet? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>1. Best suitable for view components<br> 2. we can separate presentation and business logic <br>
          3. The JSP author not required to have strong java knowledge<br> 4. If we are performing any changes to
          the JSP, then not required to recompile and reload explicitly<br> 5. We can reduce development time.<br>

        </p>
      </div>
      <h5>
        <b>Q3. Explain the life-cycle mehtods in JSP? </b>
      </h5>
      <div>
        <b>Ans: </b><b>The jspInit()-</b> The container calls the jspInit() to initialize te servlet instance.It is
        called before any other method, and is called only once for a servlet instance. <br> <b>The
          _jspservice()-</b> The container calls the _jspservice() for each request, passing it the request and the response
        objects. <br> <b>The jspDestroy()-</b> The container calls this when it decides take the instance out of
        service. It is the last method called n the servlet instance.

      </div>
      <h5>
        <b>Q4. Is JSP technology extensible? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>Yes, it is. JSP technology is extensible through the development of custom actions, or tags, which
          are encapsulated in tag libraries.
        </p>
      </div>
      <h5>
        <b>Q5. is the difference between ServletContext and PageContext?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>ServletContext: Gives the information about the container and it represents an application.
          PageContext: Gives the information about the Request and it can provide all other implicit JSP objects .
        </p>
      </div>
      <h5>
        <b>Q6. What are the different scopes available fos JSPs ? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>There are four types of scopes are allowed in the JSP. <br> <b>1. page</b> - with in the same
          page <br> <b>2.request</b> - after forward or include also you will get the request scope data. <br>
           <b>3.session </b>- after senRedirect also you will get the session scope data. All data stored in
          session is available to end user till session closed or browser closed. <br> <b>4.application</b> - Data
          will be available throughout the application. One user can store data in application scope and other can get
          the data from application scope.

        </p>
      </div>
      <h5>
        <b>Q7. Can you make use of a ServletOutputStream object from within a JSP page? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>By using getOutputStream() method on response implicit object we can get it.
        </p>
      </div>

      <h5>
        <b>Q8. What is the page directive is used to prevent a JSP page from automatically creating a session? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>session object is by default available to the JSP. We can make it unavailable by using page
          directive as follows.
        </p>
      </div>
      <h5>
        <b>Q9. Explain about autoflush?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b> This command is used to autoflush the contents. If a value of true is used it indicates to flush
          the buffer whenever it is full. In case of false it indicates that an exception should be thrown whenever the
          buffer is full. If you are trying to access the page at the time of conversion of a JSP into servlet will
          result in error.
        </p>
      </div>
      <h5>
        <b>Q10. when do use application scope? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b> If we want to make our data available to the entire application then we have to use application
          scope.
        </p>
      </div>

    </div>
  </div>
</body>
</html>