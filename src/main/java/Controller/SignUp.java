package Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import Dto.User;

@WebServlet("/signup")
public class SignUp extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String name = req.getParameter("name");
	String email = req.getParameter("email");
	String mobile = req.getParameter("mobile");
	String password = req.getParameter("password");
	String gender = req.getParameter("gender");
	String dob = req.getParameter("dob");
	String address = req.getParameter("address");
	
	UserDao dao = new UserDao();
	
	User user = dao.fetchByEmail(email);
	
	if(user == null) {
	user = new User();
	user.setName(name);
	user.setPassword(password);
	user.setDob(LocalDate.parse(dob));
	user.setAddress(address);
	user.setEmail(email);
	user.setMobile(Long.parseLong(mobile));
	user.setGender(gender);
	
	
	dao.save(user);
	resp.getWriter().println("<h1 style= color:green>Perfectlly data has been stroed in DATABASE</h1>");
	req.getRequestDispatcher("LoginForm.html").include(req, resp);
	}else {
		resp.getWriter().println("<h1 style= color:red>Already existing mail</h1>");
		req.getRequestDispatcher("SignUp.html").include(req, resp);
		
	}
		}
	
}
	