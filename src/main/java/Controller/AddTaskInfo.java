package Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.AddTask;
import Dao.UserDao;

@WebServlet("/log")
public class AddTaskInfo extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		int days = Integer.parseInt(req.getParameter("days"));

		AddTask addtask = new AddTask();
		addtask.setName(name);
		addtask.setDescription(description);
		addtask.setStart(LocalDate.now());
		addtask.setComplete(LocalDate.now().plusDays(days));

		UserDao dao = new UserDao();

		dao.save(addtask);
		resp.getWriter().println("<h1 style='color:Red'>Task were added</h1>");
		req.setAttribute("list", dao.fetchAllTask());
		req.getRequestDispatcher("Home.jsp").include(req, resp);

	}
}
