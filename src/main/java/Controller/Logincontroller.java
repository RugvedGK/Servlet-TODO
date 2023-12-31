package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dao.UserDao;
import Dto.AddTask;
import Dto.User;

@WebServlet("/login")
public class Logincontroller extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserDao dao = new UserDao();
		User user = dao.fetchByEmail(email);

		if (user == null) {
			resp.getWriter().print("<h1>Invalid Email</h1>");
			req.getRequestDispatcher("SignUp.html").include(req, resp);
		} else {
			if (user.getPassword().equals(password)) {
				resp.getWriter().print("<h1>Login Success full</h1>");
				List<AddTask> list = dao.fetchAllTask();
				req.setAttribute("list", list);
				req.getRequestDispatcher("Home.jsp").include(req, resp);
			} else {
				resp.getWriter().print("<h1>Invalid Password</h1>");
				req.getRequestDispatcher("LoginForm.html").include(req, resp);
			}
		}
		

	}
}
