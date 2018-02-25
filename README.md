# test-hibernate
For Demo


This project shows how to write query using Spring Data and Hibernare Criteria

There are two interfaces:
``` java
com.example.quiz.testhibernate.repositories.TestRepository

com.example.quiz.testhibernate.repositories.TestCustomRepository
```

The first interface uses pure Spring Data functionality:

``` java
@Query("select t.type from Test t where t.type = :type group by type")
List<String> customQueryGetTestTypeDistinctByType(@Param("type") String type);

@Query("select t.type from Test t group by type")
List<String> customQueryGetTestTypeDistinct();

```
This example uses SpEL expressions and queries are very understandable and readable.

The second interface and his implementation 
``` java
com.example.quiz.testhibernate.repositories.TestCustomRepositoryImpl
```
uses Hibernate criteria

``` java
public List<String> findTypesUsingCriteria() {

        Session session = entityManager.unwrap(Session.class);
        Criteria crit = session.createCriteria(Test.class).setProjection(
                Projections.distinct(Projections.projectionList()
                        .add(Projections.property("type"), "type")));
        List list = crit.list();
        return list;
    }
```

Also, this project contains Integration test class
``` java
com.example.quiz.testhibernate.TestHibernateApplicationTests
```
which tests all examples
