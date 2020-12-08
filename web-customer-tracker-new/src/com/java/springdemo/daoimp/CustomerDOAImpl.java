package com.java.springdemo.daoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.springdemo.dao.CustomerDAO;
import com.java.springdemo.entity.Customer;

@Repository
public class CustomerDOAImpl implements CustomerDAO {

	// need to inject the session factor
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currSession = sessionFactory.getCurrentSession();

		// create query
		Query<Customer> theQuery = currSession.createQuery("from Customer", Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {

		// get the current hibernat session
		Session session = sessionFactory.getCurrentSession();

		// save the customer
		session.saveOrUpdate(theCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {

		Session session = sessionFactory.getCurrentSession();

		Customer theCustomer = session.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// get the current hibernat session
		Session session = sessionFactory.getCurrentSession();

		Query query = session.createQuery("delete from Customer where id=:customerId");
		query.setParameter("customerId", theId);

		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomer(String theSearchName) {

		Session session = sessionFactory.getCurrentSession();

		Query query = null;

		if (theSearchName != null && theSearchName.trim().length() > 0) {

			query = session.createQuery(
					"from Customer where lower(first_name) like :theName" + " or lower(last_name) like :theName ",
					Customer.class);
			query.setParameter("theName", "%" + theSearchName + "%");
		} else {
			query = session.createQuery("from Customer", Customer.class);
		}

		List<Customer> customers = query.getResultList();

		return customers;
	}

}
