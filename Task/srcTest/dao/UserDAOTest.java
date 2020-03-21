package dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Timestamp;

import org.junit.Test;

import model.LoginInfo;
import model.RegisterInfo;
import model.User;


public class UserDAOTest {
	//findByLogin
	@Test public void findedUser() throws Exception{//正常。ユーザーが見つかる場合
		LoginInfo loginInfo = new LoginInfo("yuuki", "pass");
		//登録済みのユーザー情報(yuuki,pass,nail,yuukiname,2020-03-13 18:55:00))

		UserDAO dao = new UserDAO();
		User resultUser = dao.findByLogin(loginInfo);

		assertNotNull(resultUser);
	}

	@Test public void noSuchUserFound( ) throws Exception{//異常。一致するユーザーが見つからない場合Nullが返される
		LoginInfo loginInfo = new LoginInfo("tomoki", "pass");
		UserDAO dao = new UserDAO();
		User resultUser = dao.findByLogin(loginInfo);

		assertNull(resultUser);
	}

	//registerUser
	@Test public void registeredUser() {//例外。登録済みのユーザーIDで登録

		Timestamp registerTime = new Timestamp(System.currentTimeMillis());
		RegisterInfo registerInfo = new RegisterInfo("yuuki2", "pass", "mail", "yuukiname", registerTime);
		UserDAO dao = new UserDAO();
		assertThrows(SQLException.class,() -> dao.registerUser(registerInfo) );

	}
	//TODO ユーザーの削除機能が完成したらテスト後に登録したユーザーを削除する新規ユーザー登録テスト（正常）を追加

	@Test public void NullRegisterInfo() {//例外。RegisterInfoにnullフィールドが含まれる場合
		Timestamp registerTime = new Timestamp(System.currentTimeMillis());
		RegisterInfo registerInfo = new RegisterInfo("yuuki3", "pass", null, "yuukiname", registerTime);
		UserDAO dao = new UserDAO();
		assertThrows(SQLException.class,() -> dao.registerUser(registerInfo) );

	}

}
