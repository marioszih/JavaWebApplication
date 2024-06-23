package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

import engine.UserManager;

@WebServlet(name = "UserDetails", urlPatterns = "/userDetails")
public class UserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 3L;
       
    public UserDetailsServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strUserId = request.getParameter("id");
		if(strUserId != null) {
			int userId = Integer.parseInt(strUserId);
			UserManager userMng = UserManager.getSingleton();
			User user = userMng.findUserById(userId);
			request.setAttribute("user", user);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("gui/UserDetails.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
