package es.open4job.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.open4job.model.dao.AparcamientosDAO;
import es.open4job.model.vo.AparcamientosAccesosVO;

/**
 * Servlet implementation class MiPrimerServlet
 */
public class VisualizarOpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public VisualizarOpServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		/*
		// Controlador
		String driver = "oracle.jdbc.driver.OracleDriver";
		String host = "54.154.192.80";
		String puerto = "1521";
		String sid = "xe";
		String user = "open4job";
		String password = "open4job";
		String url = "jdbc:oracle:thin:" + user + "/" + password + "@" + host
				+ ":" + puerto + ":" + sid;
		*/
		
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

		// Obtener el objeto session
		HttpSession sesion = request.getSession();
		// Obtener el valor del primer parametro
		String strId = (String) sesion.getAttribute("Id");

		try {
			aparcamiento = aparcamientosDAO.getDatosaparcamiento(Integer
					.parseInt(strId));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
