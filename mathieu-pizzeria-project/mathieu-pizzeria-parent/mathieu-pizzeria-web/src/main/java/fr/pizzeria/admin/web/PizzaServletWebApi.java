package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.dao.service.PizzaDaoFactory;
import fr.pizzeria.dao.service.PizzaFactoryJPA;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class PizzaServletWebApi
 */
@WebServlet("/PizzaServletWebApi")
public class PizzaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaServletWebApi() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PizzaDao pizzaDao = new PizzaDaoJPA();
		List<Pizza> o = pizzaDao.findAll();
		o.toString();
		response.getWriter().append(o.toString());
		o.forEach(p -> {
			try {
				response.getWriter().append(p.getNom());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
