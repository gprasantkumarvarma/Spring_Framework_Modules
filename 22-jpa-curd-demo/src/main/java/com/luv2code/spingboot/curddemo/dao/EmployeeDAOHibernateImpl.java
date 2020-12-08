package com.luv2code.spingboot.curddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.spingboot.curddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	//define fields for entityManager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	EmployeeDAOHibernateImpl(EntityManager theEntityManager){
		entityManager=theEntityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<Employee> theQuery  = currentSession.createQuery("from Employee",Employee.class);
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the result
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Employee employee= currentSession.get(Employee.class, theId);
		
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		Session currentSession = entityManager.unwrap(Session.class);
	    //if the id=0 then insert else updtae
		currentSession.saveOrUpdate(theEmployee);
	
	
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeID");
		theQuery.setParameter("employeeID", theId);
		theQuery.executeUpdate();
		
	}
	

}
