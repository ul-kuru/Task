package servlet;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterInfo;
import model.RegisterLogic;
import model.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//メイン画面へ
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//パラメータ取得
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String mail = request.getParameter("pass");
		String userName = request.getParameter("userName");
		Timestamp createdAt = new Timestamp(System.currentTimeMillis());//作成日時を記録

		//登録情報作成
		RegisterInfo registerInfo = new RegisterInfo(userId, pass, mail, userName, createdAt);

		//登録実行
		RegisterLogic registerLogic = new RegisterLogic();
		User resultUser = registerLogic.execute(registerInfo);//TODO 例外処理は必要？？

		//登録が成功すれば、ユーザーID、ユーザー名をセッションスコープに保存
		if (resultUser != null) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			session.setAttribute("userName", userName);

			//メイン画面へフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dispatcher.forward(request, response);
		}
	}

}
