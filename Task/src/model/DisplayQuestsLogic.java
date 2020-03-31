package model;

import java.util.ArrayList;

import dao.QuestDAO;

public class DisplayQuestsLogic {
	public ArrayList<Quest> execute(ArrayList<Integer> questIds) {
		QuestDAO dao = new QuestDAO();
		ArrayList<Quest> resultQuests = null;

		try {
			resultQuests = dao.findByIdList(questIds);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return resultQuests;
	}

}
