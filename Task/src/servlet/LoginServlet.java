package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginInfo;
import model.LoginLogic;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータ取得
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");

		//ログイン実行
		LoginInfo loginInfo = new LoginInfo(userId, pass);
		LoginLogic logic = new LoginLogic();
		User resultUser = null;
		resultUser = logic.execute(loginInfo);


		if (resultUser != null) {//ログイン成功時
			//セッションスコープにuserId,userNameを保存
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("userName", resultUser.getUserName());

			//メインサーブレットにフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/MainServlet");
			dispatcher.forward(request, response);
		}else {//ログイン失敗時
			//リダイレクト
			response.sendRedirect("/Task/");
		}



	}

}
