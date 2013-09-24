/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpj2ee.personne;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author xtalandier
 */
@WebServlet(name = "PersonneServlet", urlPatterns = {"/PersonneServlet"})
public class PersonneServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		showJSP(request , response);
	}

	/**
	 * Handles the HTTP
	 * <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PersonneBean pers = new PersonneBean();
		pers.setNom((String) request.getParameter("txtnom"));
		pers.setPrenom((String) request.getParameter("txtprenom"));
		pers.setSexe((String) request.getParameter("cmbsexe"));
		pers.setCp((String) request.getParameter("txtcp"));
		pers.setTransport(request.getParameterValues("cmbtransport"));

		ServletContext ctx = getServletContext();
		ArrayList<PersonneBean> personnes = (ArrayList<PersonneBean>) ctx.getAttribute("personnes");
		if(personnes == null){
			personnes = new ArrayList<PersonneBean>();
		}
		personnes.add(pers);
		
		ctx.setAttribute("personnes", personnes);
		showJSP(request , response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>
	
	
	private void showJSP(HttpServletRequest request, HttpServletResponse response){
		ServletContext ctx = getServletContext();
		ArrayList<PersonneBean> personnes = (ArrayList<PersonneBean>) ctx.getAttribute("personnes");
		if(personnes == null){
			ctx.setAttribute("personnes", new ArrayList<PersonneBean>());
		}

		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException ex) {
			Logger.getLogger(PersonneServlet.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(PersonneServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
