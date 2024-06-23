package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.eclipse.jdt.core.compiler.InvalidInputException;

import engine.UserManager;


@WebServlet(name = "Register", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("gui/Registration.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserManager userMng = UserManager.getSingleton();
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String gender = request.getParameter("gender");
		String date = request.getParameter("date");
		String workAddress = request.getParameter("workAddress");
		String homeAddress = request.getParameter("homeAddress");
		try {
            checkValidity(name, surname, gender,date, workAddress, homeAddress);
            userMng.registerUserToDb(name, surname, gender,date, workAddress, homeAddress);
        } catch (InvalidInputException ex) {
            System.out.println(ex.getMessage());
            response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/errorPage"));
            return;
        }
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/"));
    }

    protected void checkValidity(String... userDetails) throws InvalidInputException {
        for (String s : userDetails) {
            if (s == null || s.isBlank()) {
                throw new InvalidInputException(s + " is empty or null: ");
            }
        }
    }
}