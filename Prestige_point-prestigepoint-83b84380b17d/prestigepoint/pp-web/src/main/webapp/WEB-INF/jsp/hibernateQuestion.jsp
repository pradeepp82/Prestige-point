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
    <h1 class="heading">Hibernate Question and Answer</h1>
    <div id="accordion">
      <h5>
        <b>Q1. What are the Core interfaces of Hibernate framework?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>There are five core interfaces being used extensively in every Hibernate application. Using these
          interfaces you can store or retrieve any persistent objects and also control transactions.<br> 1. Session
          interface<br> 2. SessionFactory interface<br> 3. Configuration interface<br> 4. Transaction
          interface<br> 5. Query and Criteria interfaces<br>
        </p>
      </div>
      <h5>
        <b>Q2. What is the role of SessionFactory?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b> The application obtains session object from SessionFactory interface. Typically there should be
          only one sessionFacory for whole application and is loaded during application initialization. The
          SessionFactory caches generate SQL Statement and other mapping metadata that Hibernate use at runtime. It also
          hold cached data that has been read in one unit of work and can be reused in a future unit of work. You can
          get the instance of SessionFactory by the configuration object as below SessionFactory sessionFactory =
          configuration.buildSessionFactory();
        </p>
      </div>
      <h5>
        <b>Q3. What is Hibernate Query Language (HQL)?</b>
      </h5>
      <div>
        <b>Ans: </b>Hibernate offers a query language that embodies a very powerful and flexible mechanism to query,
        store, update, and retrieve objects from a database. This language, the Hibernate query Language (HQL), is an
        object-oriented extension to SQL.
      </div>
      <h5>
        <b>Q4. What is ORM? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b>ORM stands for Object/Relational mapping. It is the programmed and mapping of objects in a Java
          application in to the tables of a relational database using the metadata that describes the mapping between
          the objects and the database. It works by transforming the data from one representation to another. We are
          familiar with Model/Pojo class and Relational Database. Here Object means Mode/Pojo class and Relational means
          the databases. By hbm.xml file we represent the mapping between Object and Relational databases.
        </p>
      </div>
      <h5>
        <b>Q5. What does an ORM solution comprises of?</b>
      </h5>
      <div>
        <p>
          <b>Ans: </b> Hibernate should have an language or API for performing basic CRUD (Create, Read, Update, Delete)
          operations on objects of persistent classes where persistent means POJO classes that you create that represent
          the table in database to keep the state of object alive. It should have a language or an API for specifying
          queries that refer to the classes and the properties of classes an ability for specifying mapping metadata. It
          should have a technique for ORM implementation to interact with transactional objects to perform lazy
          association fetching, dirty checking, and other optimization functions.
        </p>
      </div>
      <h5>
        <b>Q6. : Difference between save, persist and saveOrUpdate methods in Hibernate? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b> After get vs load, this is another Hibernate Interview question which appears quite often. All
          three methods i.e. save(), saveOrUpdate() and persist() is used to save objects into database, but has subtle
          differences e.g. save() can only INSERT records but saveOrUpdate() can either INSERT or UPDATE records. Also,
          return type of save() is a Serializable object, while return type of persist() method is void. You can also
          check save vs persist vs saveOrUpdate for complete differences between them in hibernate.
        </p>
      </div>
      <h5>
        <b>Q7. What is Second level Cache in Hibernate?</b>
      </h5>
      <div>
        <p>
          <b>Ans:</b> This is one of the first interview question related to caching in Hibernate, you can expect few
          more. Second level Cache is maintained at SessionFactory level and can improve performance by saving few
          database round trip. Another worth noting point is that second level cache is available to whole application
          rather than any particular session.
        </p>
      </div>

      <h5>
        <b>Q8. What is difference between sorted and ordered collection in hibernate? </b>
      </h5>
      <div>
        <p>
          <b>Ans: </b> This is one of the easy Hibernate interview question you ever face. A sorted collection is sorted
          in memory by using Java Comparator, while a ordered collection uses database's order by clause for ordering.
          For large data set it's better to use ordered collection to avoid any OutOfMemoryError in Java, by trying to
          sort them in memory.
        </p>
      </div>
    </div>
  </div>
</body>
</html>