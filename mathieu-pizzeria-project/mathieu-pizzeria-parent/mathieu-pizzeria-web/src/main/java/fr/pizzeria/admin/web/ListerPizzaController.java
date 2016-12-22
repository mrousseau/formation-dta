package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import fr.pizzeria.dao.pizza.PizzaDao;
import fr.pizzeria.dao.pizza.PizzaDaoJPA;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class ListerPizzaController
 */
@WebServlet("/pizzas/list")
public class ListerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListerPizzaController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		Logger logger = Logger.getLogger(ListerPizzaController.class.getName());
//		logger.log(Level.WARNING, "taille du tableau : " + o.size(), "");
//		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/view/pizzas/listerPizzas.jsp");
		PizzaDao pizzaDao = new PizzaDaoJPA();
		List<Pizza> o = null; 
		
		
			
		if(request.getParameter("All")!=null && Boolean.parseBoolean(request.getParameter("All").toString())==true){
			o = pizzaDao.findAll();
			request.setAttribute("link", "/pizzas/list");
			request.setAttribute("btnList", "Retour");
		}else{
			o = pizzaDao.findAll().stream().filter(p -> p.isArchive()==false).collect(Collectors.toList());
			request.setAttribute("link", "/pizzas/list?All=true");
			request.setAttribute("btnList", "Tout afficher");
		}
		
		request.setAttribute("listePizzas", o);
		
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
