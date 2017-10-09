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
    <h1 class="heading">Servlet Question and Answer</h1>
    <div id="accordion">
      <h5>
        <b>Q1. When servlet object will be created?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>The web-container creates object for a servlet when one of the following situations occur<br>
          a. When servlet gets first request from the browser.<br> b. For first request given to servlet after
          restarting the server.<br> c. For first request given to servlet after restarting the web-application.<br>
          d. For first request given to servlet after reloading the web-application.<br> e. During server startup
          or when web-application is deployed. When
          <load-on-startup> is enabled.<br>
        </p>
      </div>
      <h5>
        <b>Q2. Who will create Servlet Object ?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>WebServer Or Application server<br> Description : Creating servlet object managing servlet
          object by calling life cycle methods, processing request & destroying servlet object is the responsibility of
          the underlying “web-server/application server”. Programmer just writes the logic he wants to execute by taking
          the support of life cycle methods.

        </p>
      </div>
      <h5>
        <b>Q3. How can you say servlet is a single instance & multiple threads component?</b>
      </h5>
      <div>
        <b>Ans: </b>When you give multiple request to a java class acting as servlet, the web-server/applications server
        creates only one object of servlet but multiple threads will be started on that object representing multiple
        requests. Due to this server is called single instance & multiple threads based server side java component.
      </div>
      <h5>
        <b>Q4. Why Generic Servlet is abstract class ? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>GenericServlet class implements Servlet interface and it gives definition of all the methods
          present in Servlet interface except service() method. service() method is abstract in Generic Servlet class,
          that's why Generic Servlet is an abstract class.
        </p>
      </div>
      <h5>
        <b>Q5. Can we write a default constructor for servlet ?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>Yes.But not recommended. Because by default container generating default constructor.so we no need
          to write explicitly.
        </p>
      </div>
      <h5>
        <b>Q6. : How can you say servlet is “lazily” or “eager” loaded ? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>Lazy loading : if servlet is not loaded while server starting calls as Lazy loading. when ever
          that servlet gets first request then it will be load.<br> Eager loading : if servlet load while server
          starting that is nothing but Eager loading. If we mention
          <load-on-startup> to servlet that will be Eager loading. Otherwise it will be Lazy loading.
          Because by mention <load-on-startup> servlet will be load at server startup time then itself
          container will create object to that servlet. 
        </p>
      </div>
      <h5>
        <b>Q7. What are the advantages of Cookies ?</b>
      </h5>
      <div>
        <p>
          <b>Ans:</b>1. since cookies allocate memory at client side [client machine] they will not give burden on the
          server. <br>2. In memory cookies provide data secrecy. <br>3. Cookies concept work in all types of
          web, application servers And server side technologies

        </p>
      </div>

      <h5>
        <b>Q8. Why SingleThreadModel is invented ? What are the advantages and disadvantages ?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>In general a servlet is single instance and multiple thread model. i.e. several threads can access
          the same servlet object . Due to this some data inconsistency problems are occurred. That’s why sun people
          introduce SingleThreadModel. <br>1. if a servlet class implement SingleThreadModel interface then it can
          process only one request at a time . Main advantages of this is we can overcome data inconsistency problems
          but the main limitation is, it effects performance of the system <br> 2. hence sun people deprecated this
          interface in Servlet 2.0 version without introducing replacement.<br> 3. SingleThreadModel interface does
          not contain any methods. It is a marker interface.<br>

        </p>
      </div>
      <h5>
        <b>Q9. When cookies are disabled at client side ?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b> Due to the security constraints there may be a chance of (very rare) disabling cookies at client
          side .If cookies are disabled at client side, then the client is unable to see set-cookie response header
          .hence client is unable to get ‘JsessionID’ or cookies send by the server. Due to this client is unable to
          send session Id or cookie back to the server .Hence server is unable to remember client information across
          multiple requests so session management technique fails.
        </p>
      </div>
      <h5>
        <b>Q10. How many types of cookies are there , what are those cookies?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b> Two types<br> 1: Persistence Cookies <br> 2: Non Persistence Cookies.<br> <br>1.
          If we are setting max age to the cookie such type of the cookie are called persistence cookies. And there will
          be stored in the local file system. <br>2.if we are not setting any max age such type of cookies are
          called temporary or non persistence cookie.

        </p>
      </div>
    </div>
  </div>
</body>
</html>