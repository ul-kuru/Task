package dao;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

public class TakesDAOTest {
	@Test public void findByCorrectUserId() throws Exception{//正常。登録済みのユーザーIDで検索。

		TakesDAO dao = new TakesDAO();
		ArrayList<Integer> questIds = dao.findByUserId("yuuki");

		Iterator<Integer> it = questIds.iterator();
		while(it.hasNext()) {
			Integer questId = it.next();
			assertNotNull(questId);
		}
	}

	@Test public void findByIncorrectUserId() throws Exception{//異常。登録済みでないユーザーIDで検索。

		TakesDAO dao = new TakesDAO();
		ArrayList<Integer> questIds = dao.findByUserId("tomoki");

		Iterator<Integer> it = questIds.iterator();
		while(it.hasNext()) {
			Integer questId = it.next();
			assertNull(questId);
		}
	}
}
