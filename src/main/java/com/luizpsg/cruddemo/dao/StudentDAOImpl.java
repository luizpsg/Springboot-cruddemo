package com.luizpsg.cruddemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luizpsg.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDAOImpl implements StudentDAO{

  //define field for entity manager
  private EntityManager entityManager;


  //ingect entity manager using constructor injection
  //@Autowired
  public StudentDAOImpl(EntityManager theEntityManager){
    entityManager = theEntityManager;
  }


  //implement the save method
  @Override
  @Transactional
  public void save(Student theStudent) {
    entityManager.persist(theStudent);
  }


  @Override
  public Student findById(Integer id) {
    return entityManager.find(Student.class, id);
  }


  @Override
  public List<Student> findAll() {
    // create a query
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);

    // return query results
    return theQuery.getResultList();
  }


  @Override
  public List<Student> findByLastName(String theLastName) {
    // create a query
    TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData", Student.class);

    // set query parameter
    theQuery.setParameter("theData", theLastName);

    // return query results
    return theQuery.getResultList();
  }


  @Override
  @Transactional
  public void update(Student theStudent) {
    entityManager.merge(theStudent);
  }
}
