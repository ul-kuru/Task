package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.LoginInfo;
import model.RegisterInfo;
import model.User;

public class UserDAO {


	public User findByLogin(LoginInfo loginInfo) throws Exception{
		User user = null;
		Connection conn = null;

		try {
			//DB接続
			Class.forName( "com.mysql.cj.jdbc.Driver");
			conn = ConnectionFactory.createConnection();

			//SELECT文
			String sql = "SELECT user_id, pass, mail, user_name, created_at FROM user WHERE user_id = ? AND pass = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,loginInfo.getUserId());
			pStmt.setString(2,loginInfo.getPass());

			//結果取得
			ResultSet rs = pStmt.executeQuery();

			if(rs.next()) {
				//一致するユーザーがいればそのUserインスタンスを返す
				String userId = rs.getString("user_id");
				String pass = rs.getString("pass");
				String mail = rs.getString("mail");
				String userName = rs.getString("user_name");
				Timestamp createdAt = rs.getTimestamp("created_at");

				user = new User(userId,pass,mail,userName,createdAt);
			}

			return user;

		}finally {

        	try {
        		if (conn != null) {
            		conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();			}
        }


	}


	public User registerUser(RegisterInfo registerInfo) throws Exception{
		User user = null;
		Connection conn = null;
		try {
			//DB接続
			Class.forName( "com.mysql.cj.jdbc.Driver");
			conn = ConnectionFactory.createConnection();

			//ユーザー情報
			String userId = registerInfo.getUserId();
			String pass = registerInfo.getPass();
			String mail = registerInfo.getMail();
			String userName = registerInfo.getUserName();


			//INSERT文
			String sql = "INSERT INTO user VALUES (?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,userId);
			pStmt.setString(2,pass);
			pStmt.setString(3,mail);
			pStmt.setString(4,userName);

			int result = pStmt.executeUpdate();
			if (result != 0) {
				//戻り値のUserインスタンス生成
				user = new User(userId,pass,mail,userName);
				return user;
			}else {return null;}


		}finally {

        	try {
        		if (conn != null) {
            		conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();			}
        }

	}
}
