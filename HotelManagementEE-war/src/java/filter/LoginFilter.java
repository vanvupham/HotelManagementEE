/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import managedbean.AccountManagedBean;

/**
 *
 * @author Willi
 */
public class LoginFilter implements Filter {

    /**
     * Checks if user is logged in. If not it redirects to the login.xhtml page.
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Get the loginBean from session attribute
        HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpSession session = hrequest.getSession();
        String user = (String) session.getAttribute("username");
        String contextPath = ((HttpServletRequest) request).getContextPath();
        
	// For the first application request there is no loginBean in the session so user needs to log in
        // For other requests loginBean is present but we need to check if user has logged in successfully
        if (user == null || contextPath.contains("login")) {
            ((HttpServletResponse) response).sendRedirect(contextPath + "/login.xhtml");
        }
        chain.doFilter(request, response);

    }

    public void init(FilterConfig config) throws ServletException {
        // Nothing to do here!
    }

    public void destroy() {
        // Nothing to do here!
    }

}
