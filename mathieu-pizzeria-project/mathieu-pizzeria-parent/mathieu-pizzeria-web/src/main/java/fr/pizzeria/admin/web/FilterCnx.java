package fr.pizzeria.admin.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class FilterCnx
 */
@WebFilter("/pizzas/*")
public class FilterCnx implements Filter {

    /**
     * Default constructor. 
     */
    public FilterCnx() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		long before = System.currentTimeMillis();

		HttpServletRequest rqt = (HttpServletRequest) request; 

		if(rqt.getSession().getAttribute("user") != null || rqt.getRequestURI().contains("/Login")){
			chain.doFilter(request, response);
		} else {
			((HttpServletResponse) response).sendRedirect(rqt.getContextPath() +"/Login");
		}
			
		long after = System.currentTimeMillis();
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
