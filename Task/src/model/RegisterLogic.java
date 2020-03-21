package model;

import dao.UserDAO;

public class RegisterLogic{
	public User execute(RegisterInfo registerInfo) {
		UserDAO userDAO = new UserDAO();
		User resultUser = null;
		try {
			resultUser = userDAO.registerUser(registerInfo);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return resultUser;
	}

}
