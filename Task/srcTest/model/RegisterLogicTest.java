package model;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.Test;

public class RegisterLogicTest {
	//registerUser
		@Test public void registeredUser() throws Exception {//正常。正常なユーザー情報で登録

			Timestamp registerTime = new Timestamp(System.currentTimeMillis());
			RegisterInfo registerInfo = new RegisterInfo("yuuki2", "pass", "mail", "yuukiname", registerTime);
			RegisterLogic registerLogic = new RegisterLogic();
			User resultUser = registerLogic.execute(registerInfo);
			assertNotNull(resultUser);

		}

		@Test public void NullRegisterInfo()throws Exception  {//異常。RegisterInfoにnullフィールドが含まれる場合
			Timestamp registerTime = new Timestamp(System.currentTimeMillis());
			RegisterInfo registerInfo = new RegisterInfo("yuuki2", "pass", null, "yuukiname", registerTime);
			RegisterLogic registerLogic = new RegisterLogic();
			User resultUser = registerLogic.execute(registerInfo);
			assertNull(resultUser);

		}

}
