package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

public class SearchQuestsLogicTest {
	@Test public void findByCorrectUserId() throws Exception{//正常。登録済みのユーザーIDで検索。


		SearchQuestsLogic logic = new SearchQuestsLogic();
		ArrayList<Integer> questIds = logic.searchByUserId("yuuki");

		Iterator<Integer> it = questIds.iterator();
		while(it.hasNext()) {
			Integer questId = it.next();
			assertNotNull(questId);
		}
	}

	@Test public void findByIncorrectUserId() throws Exception{//異常。登録済みでないユーザーIDで検索。

		SearchQuestsLogic logic = new SearchQuestsLogic();
		ArrayList<Integer> questIds = logic.searchByUserId("tomoki");

		Iterator<Integer> it = questIds.iterator();
		while(it.hasNext()) {
			Integer questId = it.next();
			assertNull(questId);
		}
	}

}
