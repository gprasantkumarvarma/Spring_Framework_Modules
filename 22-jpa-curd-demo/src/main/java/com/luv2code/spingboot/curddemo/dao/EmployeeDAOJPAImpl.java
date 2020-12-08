package com.luv2code.spingboot.curddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.spingboot.curddemo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOJPAImpl(EntityManager thentityManager) {
		entityManager=thentityManager;
	}
	
	
	@Override
	public List<Employee> findAll() {
		
		//create a query
		Query theQuery = entityManager.createQuery("from Employee");
		
		//exexute query and get result ist
		List<Employee> employee=		theQuery.getResultList();
		
		return employee;
	}

	@Override
	public Employee findById(int theId) {
		
		Employee employee = entityManager.find(Employee.class, theId);
		
		return employee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		Employee dbEmployee = entityManager.merge(theEmployee);

		//update wit id from db...so we can get generated id for save/insert
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		
		Query theQuery =entityManager.createQuery("delete from Employee where id=:employeID");
		theQuery.setParameter("employeID", theId);
		
		theQuery.executeUpdate();

	}

}
