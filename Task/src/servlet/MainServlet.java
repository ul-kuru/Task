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
import model.SearchQuestsLogic;

/**
 * Servlet implementation class Main
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// userIdをセッションから取得してリストquestIdsを生成
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		SearchQuestsLogic searchQuestsLogic = new SearchQuestsLogic();
		ArrayList<Integer> questIds = searchQuestsLogic.searchByUserId(userId);
		assert questIds != null;
		// リスト中のクエストを表示
		DisplayQuestsLogic displayQuestsLogic = new DisplayQuestsLogic();
		ArrayList<Quest> quests = displayQuestsLogic.execute(questIds);
		assert quests != null;

			session.setAttribute("quests", quests);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
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
