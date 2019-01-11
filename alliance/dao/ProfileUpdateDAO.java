package com.alliance.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.alliance.model.UserModel;
import com.alliance.util.HibernateUtil;

public class ProfileUpdateDAO {

	public boolean update(UserModel um) {
		
	
		Transaction tx = null;
		boolean status = false;
		Session session = HibernateUtil.getSessionFactory();
		tx=session.beginTransaction();
		String city = um.getCity();
		String cno = um.getContactNumber();
		String cid = um.getCustomerID();
		String occu = um.getOccupation();
		String pass = um.getPassword();
		UserModel u=(UserModel) session.get(UserModel.class,um.getCustomerID());
		try {
	
			u.setCity(city);
			
		
			u.setContactNumber(cno);
			
		
			u.setPassword(pass);
		
		
			u.setOccupation(occu);
			status = true;
		
		session.saveOrUpdate(u);
		tx.commit();
		
		

			
		/*try {
			if (city != null || city.length() > 0) {
				Query qu=session.createQuery("update UserModel SET city=:p1 WHERE customerID=:p2");
				qu.setParameter("p1",city);
				qu.setParameter("p2",cid);
				tx = session.beginTransaction();
				int n=qu.executeUpdate();
				tx.commit();
				status = true;
			}
			if (cno != null || cno.length() > 0) {
				Query qu=session.createQuery("update UserModel SET contactNumber=:p1 WHERE customerID=:p2");
				qu.setParameter("p1",cno);
				qu.setParameter("p2",cid);
				tx = session.beginTransaction();
				int n=qu.executeUpdate();
				tx.commit();
				status = true;

			}
			if (pass != null || pass.length() > 0) {
				Query qu=session.createQuery("update UserModel SET password=:p1 WHERE customerID=:p2");
				qu.setParameter("p1",pass);
				qu.setParameter("p2",cid);
				tx = session.beginTransaction();
				int n=qu.executeUpdate();
				tx.commit();
				status = true;

			}
			if (occu != null || occu.length() > 0) {
				Query qu=session.createQuery("update UserModel SET occupation=:p1 WHERE customerID=:p2");
				qu.setParameter("p1",occu);
				qu.setParameter("p2",cid);
				tx = session.beginTransaction();
				int n=qu.executeUpdate();
				tx.commit();
				status = true;

			}*/
		} catch (Exception e) {
			
			status=false;
		}
		finally {
			session.close();
		}
		return status;
	}
}