package com.finaldemo.canteen;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.catalina.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;




@ManagedBean
@SessionScoped

public class CustomerDAO {

	SessionFactory sFactory;
	
	public List<Customer> CustomerShow() {
		sFactory = SessionHelper.getConnection();
		Session session = sFactory.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		List<Customer> customerList = cr.list();
		return customerList;

	}
	public String GenerateCustomerid() {
		sFactory = SessionHelper.getConnection();
		Session session = sFactory.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		List<Customer> customerList = cr.list();
		session.close();
		if (customerList.size() == 0) {
			return "S001";

		} else {
			String id = customerList.get(customerList.size() - 1).getCust_id();
			int id1 = Integer.parseInt(id.substring(1));
			id1++;
			String id2 = String.format("S%03d", id1);
			return id2;
		}
	}

	public String addcustomer(Customer customer) {
		sFactory = SessionHelper.getConnection();
		Session session = sFactory.openSession();
		String customerid = GenerateCustomerid();
		customer.setCust_id(customerid);
		Criteria cr = session.createCriteria(Customer.class);
		org.hibernate.Transaction tran = session.beginTransaction();
		session.save(customer);
		tran.commit();
		return "customer details Added";
	}
	public String loginCheck(User user) {
		sFactory = SessionHelper.getConnection();
		Session session = sFactory.openSession();
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("username", user.getUsername()));
		cr.add(Restrictions.eq("password", user.getPassword()));
		List<Customer> listcustomer = cr.list();
		if(listcustomer.size()==1) {
			return "/JSF_FILES/ShowCustomer.xhtml?faces-redirect=true";
		}
		return "/Login.xhtml?faces-redirect=true";
	}
}