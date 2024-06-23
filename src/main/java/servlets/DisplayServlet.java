package servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;
import java.util.HashMap;

import engine.UserManager;
import engine.UserManagerInterface;

@WebServlet(name = "Display", urlPatterns = "/display")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 2L;
	
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserManagerInterface userMng = UserManager.getSingleton();
		HashMap<Integer,User> userLst = userMng.displayUsers();
		request.setAttribute("users", userLst);
		RequestDispatcher dispatcher = request.getRequestDispatcher("gui/DisplayUsers.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserManagerInterface userMng = UserManager.getSingleton();
        String action = request.getParameter("action");
        if (action.equals("delete")) {
        	int userId = Integer.parseInt(request.getParameter("userId"));
        	userMng.deleteUser(userId);
        	HashMap<Integer,User> userLst = userMng.displayUsers();
    		request.setAttribute("users", userLst);
    		RequestDispatcher dispatcher = request.getRequestDispatcher("gui/DisplayUsers.jsp");
    		dispatcher.forward(request, response);
        	return;
        }
        doGet(request, response);
	}

}
