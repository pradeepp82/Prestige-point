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
    <h1 class="heading">Struts Question and Answer</h1>
    <div id="accordion">
      <h5>
        <b>Q1. What are the main classes which are used in struts application?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>This is another beginner's level Struts interview question which is used to check how familiar
          candidate is with Struts framework and API. Main classes in Struts Framework are: <br> <b>Action
            servlet:</b> it's a back-bone of web application it's a controller class responsible for handling the entire
          request. <br> <b>Action class:</b> using Action classes all the business logic is developed us call model
          of the application also. <br> <b>Action Form: </b>it's a java bean which represents our forms and
          associated with action mapping. And it also maintains the session state its object is automatically populated
          on the server side with data entered from a form on the client side. <br> <b>Action Mapping: </b>using
          this class we do the mapping between object and Action. <br> <b>ActionForward:</b> this class in Struts
          is used to forward the result from controller to destination. <br>
        </p>
      </div>
      <h5>
        <b>Q2. How to use DispatchAction?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>We can use the Dispatch Action we executing following steps:<br> <br> Create a class
          that extends DispatchAction.<br> In a new class, add a method: method has the same signature as the
          execute() method of an Action class.<br> Do not override execute() method.<br> Add an entry to
          struts-config.xml<br>
        </p>
      </div>
      <h5>
        <b>Q3. What is ActionServlet?</b>
      </h5>
      <div>
        <b>Ans: </b>ActionServlet is a simple servlet which is the backbone of all Struts applications. It is the main
        Controller component that handles client requests and determines which Action will process each received
        request. It serves as an Action factory – creating specific Action classes based on user’s request.
      </div>
      <h5>
        <b>Q4. What is role of Action Class? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>An Action Class performs a role of an adapter between the contents of an incoming HTTP request and
          the corresponding business logic that should be executed to process this request.
        </p>
      </div>
      <h5>
        <b>Q5. What is Struts framework?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>Struts framework is an open-source framework for developing the web applications in Java EE, based
          on MVC-2 architecture. It uses and extends the Java Servlet API. Struts is robust architecture and can be used
          for the development of application of any size. Struts framework makes it much easier to design scalable,
          reliable Web applications with Java.
        </p>
      </div>
      <h5>
        <b>Q6. What is the role of Action/ Model ?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>Actions in Struts are POJO , is also considered as a Model. The role of Action are to execute
          business logic or delegate call to business logic by the means of action methods which is mapped to request
          and contains business data to be used by the view layer by means of setters and getters inside the Action
          class and finally helps the framework decide which result to render
        </p>
      </div>
      <h5>
        <b>Q7. What is the relation between ValueStack and OGNL ?</b>
      </h5>
      <div>
        <p>
          <b>Ans:</b>A ValueStack is a place where all the data related to action and the action itself is stored. OGNL
          is a mean through which the data in the ValueStack is manipulated.
        </p>
      </div>

      <h5>
        <b>Q8. What is interceptor in Struts2?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>Interceptors are the backbone of Struts2 Framework. Struts2 interceptors are responsible for most
          of the processing done by the framework, such as passing request params to action classes, making Servlet API
          request, response, session available to Action classes, validation, i18n support, etc. ActionInvocation is
          responsible to incapsulate Action classes and interceptors and to fire them in order. The most important
          method for use in ActionInvocation is invoke() method that keeps track of the interceptor chain and invokes
          the next interceptor or action.
        </p>
      </div>
      <h5>
        <b>Q9. Does Struts2 action and interceptors are thread safe?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>Struts2 Action classes are thread safe because an object is instantiated for every request to
          handle it. Struts2 interceptors are singleton classes and a new thread is created to handle the request, so
          it’s not thread safe and we need to implement them carefully to avoid any issues with shared data.
        </p>
      </div>
      <h5>
        <b>Q10. Which interceptor is responsible for mapping request parameters to action class Java Bean
          properties?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b> com.opensymphony.xwork2.interceptor.ParametersInterceptor interceptor is responsible for mapping
          request parameters to the Action class java bean properties. This interceptor is configured in struts-default
          package with name “params”. This interceptor is part of basicStack and defaultStack interceptors stack.
        </p>
      </div>
    </div>
  </div>
</body>
</html>