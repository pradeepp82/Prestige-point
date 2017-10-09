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
    <h1 class="heading">Spring Question and Answer</h1>
    <div id="accordion">
      <h5>
        <b>Q1. Explain different modes of auto wiring?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>The autowiring functionality has five modes which can be used to instruct Spring container to use
          autowiring for dependency injection:<br>
          <br> <b>byName:</b> When autowiring byName, the Spring container looks at the properties of the beans on
          which autowire attribute is set to byName in the XML configuration file. It then tries to match and wire its
          properties with the beans defined by the same names in the configuration file.<br> <b>byType:</b> When
          autowiring by datatype, the Spring container looks at the properties of the beans on which autowire attribute
          is set to byType in the XML configuration file. It then tries to match and wire a property if its type matches
          with exactly one of the beans name in configuration file. If more than one such beans exist, a fatal exception
          is thrown.<br> <b>constructor:</b> This mode is similar to byType, but type applies to constructor
          arguments. If there is not exactly one bean of the constructor argument type in the container, a fatal error
          is raised.<br> <b>autodetect:</b> Spring first tries to wire using autowire by constructor, if it does
          not work, Spring tries to autowire by byType<br>
        </p>
      </div>
      <h5>
        <b>Q2. What is Spring IoC container?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>The Spring IoC creates the objects, wire them together, configure them, and manage their complete
          lifecycle from creation till destruction. The Spring container uses dependency injection (DI) to manage the
          components that make up an application.
        </p>
      </div>
      <h5>
        <b>Q3. What are Spring beans?</b>
      </h5>
      <div>
        <b>Ans: </b>The objects that form the backbone of your application and that are managed by the Spring IoC
        container are called beans. A bean is an object that is instantiated, assembled, and otherwise managed by a
        Spring IoC container. These beans are created with the configuration metadata that you supply to the container,
        for example, in the form of XML
        <bean />
        definitions.
      </div>
      <h5>
        <b>Q4. What is bean auto wiring?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>The Spring container is able to autowire relationships between collaborating beans. This means
          that it is possible to automatically let Spring resolve collaborators (other beans) for your bean by
          inspecting the contents of the BeanFactory without using
          <constructor-arg> and <property> elements. 
        </p>
      </div>
      <h5>
        <b>Q5. What does @Autowired annotation mean?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>This annotation provides more fine-grained control over where and how autowiring should be
          accomplished. The @Autowired annotation can be used to autowire bean on the setter method just like @Required
          annotation, constructor, a property or methods with arbitrary names and/or multiple arguments.
        </p>
      </div>
      <h5>
        <b>Q6. : What is Spring Java Based Configuration? Give some annotation example.</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>Java based configuration option enables you to write most of your Spring configuration without XML
          but with the help of few Java-based annotations. For example: Annotation @Configuration indicates that the
          class can be used by the Spring IoC container as a source of bean definitions. The @Bean annotation tells
          Spring that a method annotated with @Bean will return an object that should be registered as a bean in the
          Spring application context
        </p>
      </div>
      <h5>
        <b>Q7. What is Spring MVC framework?</b>
      </h5>
      <div>
        <p>
          <b>Ans:</b>The Spring web MVC framework provides model-view-controller architecture and ready components that
          can be used to develop flexible and loosely coupled web applications. The MVC pattern results in separating
          the different aspects of the application (input logic, business logic, and UI logic), while providing a loose
          coupling between these elements.
        </p>
      </div>

      <h5>
        <b>Q8. What is a DispatcherServlet?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>The Spring Web MVC framework is designed around a DispatcherServlet that handles all the HTTP
          requests and responses.
        </p>
      </div>
      <h5>
        <b>Q9. What is WebApplicationContext ?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b> The WebApplicationContext is an extension of the plain ApplicationContext that has some extra
          features necessary for web applications. It differs from a normal ApplicationContext in that it is capable of
          resolving themes, and that it knows which servlet it is associated with.
        </p>
      </div>
      <h5>
        <b>Q10. Explain the @Controller annotation.</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b> Two types<br> The @Controller annotation indicates that a particular class serves the role
          of a controller. Spring does not require you to extend any controller base class or reference the Servlet API.
        </p>
      </div>
    </div>
  </div>
</body>
</html>