package dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import model.Quest;

public class QuestDAOTest {
	//findByIdList
	@Test public void findQuests()throws Exception{//正常。登録済みのクエストIDでリストを作り検索
		ArrayList<Integer> questIds = new ArrayList<Integer>();
		questIds.add(00000001);
		questIds.add(00000002);

		QuestDAO dao = new QuestDAO();
		ArrayList<Quest> quests = dao.findByIdList(questIds);

		Iterator<Quest> it = quests.iterator();
		while(it.hasNext()) {
			Quest quest = it.next();
			assertNotNull(quest.getQuestId());
		}

	}

	@Test public void noSuchQuestFound()throws Exception{//異常。存在しないクエストIDで検索。
		ArrayList<Integer> questIds = new ArrayList<Integer>();
		questIds.add(00000004);
		questIds.add(00000003);

		QuestDAO dao = new QuestDAO();
		ArrayList<Quest> quests = dao.findByIdList(questIds);

		Iterator<Quest> it = quests.iterator();
		while(it.hasNext()) {
			Quest quest = it.next();
			assertNull(quest.getQuestId());
		}
		//assertThrows(SQLException.class,() -> dao.findByIdList(questIds));
	}

}
