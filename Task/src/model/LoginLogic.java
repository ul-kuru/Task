package model;
import dao.UserDAO;

public class LoginLogic {
	public User execute(LoginInfo loginInfo) {
		UserDAO userDAO = new UserDAO();
		User resultUser = null;
		try {
			resultUser = userDAO.findByLogin(loginInfo);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return resultUser;
	}

}
