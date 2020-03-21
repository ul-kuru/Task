package model;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoginLogicTest {

	@Test public void loginByCorrectUser() throws Exception{//正常。登録済みのユーザーでログイン
		LoginInfo loginInfo = new LoginInfo("yuuki", "pass");

		LoginLogic loginLogic = new LoginLogic();
		User resultUser =loginLogic.execute(loginInfo);
		assertNotNull(resultUser);
	}

	@Test public void loginByIncorrectUser() throws Exception{//異常。登録されていないユーザーでログイン
		LoginInfo loginInfo = new LoginInfo("tomoki", "pass");

		LoginLogic loginLogic = new LoginLogic();
		User resultUser =loginLogic.execute(loginInfo);
		assertNull(resultUser);
	}

}
