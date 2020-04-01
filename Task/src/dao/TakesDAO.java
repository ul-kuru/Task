package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TakesDAO {
	public ArrayList<Integer> findByUserId(String userId)throws Exception{
		ArrayList<Integer> questIds= new ArrayList<>();
		Connection conn = null;

		try {
			//DB接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = ConnectionFactory.createConnection();

			//SELECT文
			//受け取ったユーザーが受注しているクエストを検索してquestIdをリストに加える。
			String sql = "SELECT take_id FROM takes WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);
			//結果取得
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				questIds.add(rs.getInt("take_id"));

			}

			return questIds;
		} finally {
			try {
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
