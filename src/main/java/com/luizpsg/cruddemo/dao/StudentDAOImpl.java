package com.luizpsg.cruddemo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luizpsg.cruddemo.entity.Student;

import jakarta.persistence.EntityManager;

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
}
