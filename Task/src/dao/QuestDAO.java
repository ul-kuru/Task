package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;

import model.Quest;

public class QuestDAO {
	public ArrayList<Quest> findByIdList(ArrayList<Integer> questIds)throws Exception{
		ArrayList<Quest> quests= new ArrayList<Quest>();
		Connection conn = null;

		try {
			//DB接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = ConnectionFactory.createConnection();

			//SELECT文
			String sql = "SELECT quest_id, title, details, deadline, cleared, created_user_id,created_at FROM quest WHERE quest_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			//リストに該当するクエストを取り出す
			//TODO SQL操作でこのクラスいらなくなりそう？？
			Iterator<Integer> it = questIds.iterator();
			while(it.hasNext()) {
				int e = it.next();
				pStmt.setInt(1, e);
				//結果取得
				ResultSet rs = pStmt.executeQuery();
				if (rs.next()) {
					int questId = rs.getInt("quest_id");
					String title = rs.getString("title");
					String details = rs.getString("details");
					Timestamp deadline = rs.getTimestamp("deadline");
					boolean cleared = rs.getBoolean("cleared");
					String createdUserId = rs.getString("created_user_id");
					Timestamp createdAt = rs.getTimestamp("created_at");
					Quest quest = new Quest(questId, title, details, deadline, cleared, createdUserId, createdAt);

					quests.add(quest);
				}
			}

			return quests;
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
