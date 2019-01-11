package com.alliance.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alliance.bo.ProfileUpdateBO;
import com.alliance.model.UserModel;


public class UpdateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public UpdateProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("This is profile update controller");
		RequestDispatcher rd = null;
		ProfileUpdateBO pubo = new ProfileUpdateBO();
		UserModel um = new UserModel();
		HttpSession session=request.getSession();
		String userid=(String) session.getAttribute("customerID");
		String cno = request.getParameter("cno");
		String city = request.getParameter("city");
		String occu = request.getParameter("occupation");
		String passnew = request.getParameter("password1");
		um.setCity(city);
		um.setContactNumber(cno);
		um.setOccupation(occu);
		um.setPassword(passnew);
		um.setCustomerID(userid);
		boolean b=pubo.update(um);
		
		if(b) {
			rd=request.getRequestDispatcher("views/profile.jsp");
		}
		else {
			rd=request.getRequestDispatcher("views/error.jsp");
		}
	}

	}

	
