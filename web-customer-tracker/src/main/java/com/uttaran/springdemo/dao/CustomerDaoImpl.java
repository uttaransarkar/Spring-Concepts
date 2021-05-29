package com.uttaran.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uttaran.springdemo.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDAO {
	
	//injecting session factory so that it can interact with DB
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		//getting current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		//creating a query
		Query<Customer> listQuery = session.createQuery("from Customer", Customer.class);
		
		//executing query and returning list
		List<Customer> customers = listQuery.getResultList();
		
		//returning the results
		return customers;
	}

}
