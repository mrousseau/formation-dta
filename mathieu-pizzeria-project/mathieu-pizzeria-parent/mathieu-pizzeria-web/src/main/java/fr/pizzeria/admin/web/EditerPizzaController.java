package fr.pizzeria.admin.web;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.enumeration.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class EditerPizzaController
 */
@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditerPizzaController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PizzaDao pizzaDao = new PizzaDaoJPA();
		ArrayList<Pizza> o = (ArrayList<Pizza>) pizzaDao.findAll();
		Pizza piz = (o.stream().filter(p -> p.getId()==Integer.parseInt(request.getParameter("pizzasID"))).findFirst()).get();
		request.setAttribute("pizza", piz);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/pizzas/editerPizza.jsp");
		dispatcher.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PizzaDao pizzaDao = new PizzaDaoJPA();
		
		Pizza piz = new Pizza(Integer.parseInt((String) request.getParameter("id")),
				(String) request.getParameter("code"), 
				(String) request.getParameter("nom"), 
				Double.parseDouble((String) request.getParameter("prix")) , 
				CategoriePizza.valueOf((String) request.getParameter("categorie")), 
				(String) request.getParameter("url"));
		
		pizzaDao.updatePizza(Integer.parseInt(request.getParameter("id")), piz);
		response.sendRedirect(request.getContextPath() +"/pizzas/list");
	}

}
