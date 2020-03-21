package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import model.LoginInfo;
import model.RegisterInfo;
import model.User;

public class UserDAO {
	//データベース接続情報
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/task?serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "Ulkuru3396yuuki";

	public User findByLogin(LoginInfo loginInfo) throws Exception{
		User user = null;
		Connection conn = null;

		try {
			//DB接続
			Class.forName( "com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

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
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

			//ユーザー情報
			String userId = registerInfo.getUserId();
			String pass = registerInfo.getPass();
			String mail = registerInfo.getMail();
			String userName = registerInfo.getUserName();
			Timestamp createdAt = registerInfo.getCreatedAt();


			//INSERT文
			String sql = "INSERT INTO user VALUES (?,?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1,userId);
			pStmt.setString(2,pass);
			pStmt.setString(3,mail);
			pStmt.setString(4,userName);
			pStmt.setTimestamp(5,createdAt);

			int result = pStmt.executeUpdate();
			if (result != 0) {
				//戻り値のUserインスタンス生成
				user = new User(userId,pass,mail,userName,createdAt);
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