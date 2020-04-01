package model;

import java.util.ArrayList;

import dao.TakesDAO;

public class SearchQuestsLogic {
	public ArrayList<Integer> searchByUserId(String userId){
		TakesDAO dao = new TakesDAO();
		ArrayList<Integer> questIds = null;

		try {
			questIds = dao.findByUserId(userId);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return questIds;
	}

}
