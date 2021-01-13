package container.user;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import container.config.user.AppConfig01;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = {AppConfig01.class})
@ContextConfiguration(locations = {"/container/config/user/applicationContext02.xml"})
public class XmlConfigTest {
	
	@Autowired
	@Qualifier("user2")        //타입이 많아서 에러가생김!! -> id를 받음!
	private User user;
	
	
	@Test
	public void testUserNotNull() {
		assertNotNull(user);
	}
	
	@Test
	public void testGetName() {
		assertEquals(user.getName(), "둘리");   //user의 value를 다르게하면 false가 뜸!!
	}
	
}
