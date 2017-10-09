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
    <h1 class="heading">Jdbc Question and Answer</h1>
    <div id="accordion">
      <h5>
        <b>Q1. What is the difference between Database and Database management system?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>Database is a collection of interrelated data. Database management system is a software which can
          be used to manage the data by storing it on to the data base and by retrieving it from the data base. And DBMS
          is a collection of interrelated data and some set of programs to access the data. There are 3 types of
          Database Management Systems.<br> 1. Relational DataBase Management Systems(RDBMS) <br>2. Object
          Oriented DataBase Management Systems(OODBMS) <br>3. Object Relational DataBase Management Systems(ORDBMS)
          <br>
        </p>
      </div>
      <h5>
        <b>Q2. How to establish a Database connection between java application and Database?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>If we want to establish a connection between java application and the database we will the
          following piece of code. Connection con=
          DriverManager.getConnection(“jdbc:odbc:nag”,”nag”,”system”,”manager”); Where getConnectin() is a static method
          from DriverManager class, which can be used to return connection object.
        </p>
      </div>
      <h5>
        <b>Q3. How to execute SQL Queries from a java application?</b>
      </h5>
      <div>
        <b>Ans: </b>To execute the sql queries we will use the following methods from Statement object.<br> 1.
        st.executeQuery()<br> 2. st.executeUpdate()<br> 3. st.execute()<br>

      </div>
      <h5>
        <b>Q4. What is a ResultSet? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>These objects hold data retrieved from a database after you execute an SQL query using Statement
          objects. It acts as an iterator to allow you to move through its data. The java.sql.ResultSet interface
          represents the result set of a database query.
        </p>
      </div>
      <h5>
        <b>Q5. What are the different types of JDBC Statements?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>Types of statements are:<br> 1. Statement (regular SQL statement)<br> 2.
          PreparedStatement (more efficient than statement due to pre-compilation of SQL)<br> 3. CallableStatement
          (to call stored procedures on the database)<br>

        </p>
      </div>
      <h5>
        <b>Q6. What is difference between statement and prepared statement?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>Prepared statements offer better performance, as they are pre-compiled. Prepared statements reuse
          the same execution plan for different arguments rather than creating a new execution plan every time. Prepared
          statements use bind arguments, which are sent to the database engine. This allows mapping different requests
          with same prepared statement but different arguments to execute the same execution plan. Prepared statements
          are more secure because they use bind variables, which can prevent SQL injection attack.
        </p>
      </div>
      <h5>
        <b>Q7. How does JDBC handle the data types of Java and database?</b>
      </h5>
      <div>
        <p>
          <b>Ans:</b> The JDBC driver converts the Java data type to the appropriate JDBC type before sending it to the
          database. It uses a default mapping for most data types. For example, a Java int is converted to an SQL
          INTEGER.
        </p>
      </div>

      <h5>
        <b>Q8. What is a transaction?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>A transaction is a logical unit of work. To complete a logical unit of work, several actions may
          need to be taken against a database. Transactions are used to provide data integrity, correct application
          semantics, and a consistent view of data during concurrent access.
        </p>
      </div>
      <h5>
        <b>Q9. How do you implement connection pooling</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>If you use an application server like WebLogic, WebSphere, jBoss, Tomcat. , then your application
          server provides the facilities to configure for connection pooling. If you are not using an application server
          then components like Apache Commons DBCP Component can be used.
        </p>
      </div>
      <h5>
        <b>Q10. How do you register a driver?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b> There are 2 approaches for registering the Driver:<br> Class.forName(): This method
          dynamically loads the driver's class file into memory, which automatically registers it. This method is
          preferable because it allows you to make the driver registration configurable and portable.<br>
          DriverManager.registerDriver(): This static method is used in case you are using a non-JDK compliant JVM, such
          as the one provided by Microsoft.<br>
        </p>
      </div>
    </div>
  </div>
</body>
</html>