package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DisplayQuestsLogic;
import model.Quest;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//既存のクエストIDでリストを作成
		ArrayList<Integer> questIds = new ArrayList<Integer>();
		questIds.add(00000001);
		questIds.add(00000002);

		DisplayQuestsLogic displayQuestsLogic = new DisplayQuestsLogic();
		ArrayList<Quest> quests = displayQuestsLogic.execute(questIds);

			HttpSession session = request.getSession();
			session.setAttribute("quests", quests);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
	}

}
