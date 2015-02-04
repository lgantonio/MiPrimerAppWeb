package es.open4job.web;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.open4job.model.dao.AparcamientosDAO;
import es.open4job.model.vo.AparcamientosAccesosVO;

/**
 * Servlet implementation class MiPrimerServlet
 */
public class MiPrimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MiPrimerServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// Modelo
		AparcamientosDAO aparcamientosDAO = null;
		AparcamientosAccesosVO aparcamiento = null;

		try {
			aparcamientosDAO = new AparcamientosDAO();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String id = (String) request.getParameter("id");
		try {
			aparcamiento = aparcamientosDAO.getDatosaparcamiento(Integer
					.parseInt(id));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * // Vista PrintWriter out = response.getWriter(); if (aparcamiento !=
		 * null) { out.println("<html>"); out.println("<body>");
		 * out.println("<h1> Aparcamiento: " + aparcamiento.toString() +
		 * "</h1>"); out.println("</body>"); out.println("</html>"); } else {
		 * out.println("<html>"); out.println("<body>");
		 * out.println("<h1> Aparcamiento no encontrado </h1>");
		 * out.println("</body>"); out.println("</html>"); }
		 */

		if (aparcamiento != null) {
			request.setAttribute("AparcamientoVO", aparcamiento);
			request.getRequestDispatcher("MiPrimerJSP.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("Error.jsp")
					.forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
