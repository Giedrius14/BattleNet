package com.battleNet.test.tests;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.battle.net.dao.Offer;
import com.battle.net.dao.OffersDAO;
import com.battle.net.dao.User;
import com.battle.net.dao.UserDao;

@ActiveProfiles("dev")
@ContextConfiguration(locations = {
		"classpath:com/BattleNet/src/com/battle/net/config/dao-context.xml",
		"classpath:com/BattleNet/src/com/battle/net/config/security-context.xml",
		"classpath:com/BattleNet/test/com/battleNet/test/config/datasource.xml" })

public class OfferDaoTest {

	@Autowired
	private OffersDAO offersDao;

	@Autowired
	private UserDao usersDao;

	@Autowired
	private DataSource dataSource;

	private User user1 = new User("johnwpurcell", "John Purcell", "hellothere",
			"john@caveofprogramming.com", true, "ROLE_USER");
	private User user2 = new User("richardhannay", "Richard Hannay",
			"the39steps", "richard@caveofprogramming.com", true, "ROLE_ADMIN");
	private User user3 = new User("suetheviolinist", "Sue Black",
			"iloveviolins", "sue@caveofprogramming.com", true, "ROLE_USER");
	private User user4 = new User("rogerblake", "Rog Blake", "liberator",
			"rog@caveofprogramming.com", false, "user");

	private Offer offer1 = new Offer(user1, "This is a test offer.");
	private Offer offer2 = new Offer(user1, "This is another test offer.");
	private Offer offer3 = new Offer(user2, "This is yet another test offer.");
	private Offer offer4 = new Offer(user3, "This is a test offer once again.");
	private Offer offer5 = new Offer(user3,
			"Here is an interesting offer of some kind.");
	private Offer offer6 = new Offer(user3, "This is just a test offer.");
	private Offer offer7 = new Offer(user4,
			"This is a test offer for a user that is not enabled.");

	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);

		jdbc.execute("delete from offers");
		jdbc.execute("delete from messages");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testDelete() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		offersDao.saveAndUpdate(offer2);
		offersDao.saveAndUpdate(offer3);
		offersDao.saveAndUpdate(offer4);
		offersDao.saveAndUpdate(offer5);
		offersDao.saveAndUpdate(offer6);
		offersDao.saveAndUpdate(offer7);
		
		Offer retrieved1 = offersDao.getOffer(offer2.getId());
		assertNotNull("Offer with ID " + retrieved1.getId() + " should not be null (deleted, actual)", retrieved1);
		
		offersDao.delete(offer2.getId());
		
		Offer retrieved2 = offersDao.getOffer(offer2.getId());
		assertNull("Offer with ID " + retrieved1.getId() + " should be null (deleted, actual)", retrieved2);
	}
	
	@Test
	public void testGetById() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		offersDao.saveAndUpdate(offer1);
		offersDao.saveAndUpdate(offer2);
		offersDao.saveAndUpdate(offer3);
		offersDao.saveAndUpdate(offer4);
		offersDao.saveAndUpdate(offer5);
		offersDao.saveAndUpdate(offer6);
		offersDao.saveAndUpdate(offer7);
		
		Offer retrieved1 = offersDao.getOffer(offer1.getId());
		assertEquals("Offers should match", offer1, retrieved1);
		
		Offer retrieved2 = offersDao.getOffer(offer7.getId());
		assertNull("Should not retrieve offer for disabled user.", retrieved2);
	}

	@Test
	public void testCreateRetrieve() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		
		offersDao.saveAndUpdate(offer1);

		List<Offer> offers1 = offersDao.getOffers();
		assertEquals("Should be one offer.", 1, offers1.size());

		assertEquals("Retrieved offer should equal inserted offer.", offer1,
				offers1.get(0));

		offersDao.saveAndUpdate(offer2);
		offersDao.saveAndUpdate(offer3);
		offersDao.saveAndUpdate(offer4);
		offersDao.saveAndUpdate(offer5);
		offersDao.saveAndUpdate(offer6);
		offersDao.saveAndUpdate(offer7);

		List<Offer> offers2 = offersDao.getOffers();
		assertEquals("Should be six offers for enabled users.", 6,
				offers2.size());

	}
	
	@Test
	public void testUpdate() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		offersDao.saveAndUpdate(offer2);
		offersDao.saveAndUpdate(offer3);
		offersDao.saveAndUpdate(offer4);
		offersDao.saveAndUpdate(offer5);
		offersDao.saveAndUpdate(offer6);
		offersDao.saveAndUpdate(offer7);
		
		offer3.setText("This offer has updated text.");
		offersDao.saveAndUpdate(offer3);
		
		Offer retrieved = offersDao.getOffer(offer3.getId());
		assertEquals("Retrieved offer should be updated.", offer3, retrieved);
	}

	@Test
	public void testGetUsername() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);

		offersDao.saveAndUpdate(offer1);
		offersDao.saveAndUpdate(offer2);
		offersDao.saveAndUpdate(offer3);
		offersDao.saveAndUpdate(offer4);
		offersDao.saveAndUpdate(offer5);
		offersDao.saveAndUpdate(offer6);
		offersDao.saveAndUpdate(offer7);

		List<Offer> offers1 = offersDao.getOffers(user3.getUsername());
		assertEquals("Should be three offers for this user.", 3, offers1.size());

		List<Offer> offers2 = offersDao.getOffers("sdfsfd");
		assertEquals("Should be zero offers for this user.", 0, offers2.size());

		List<Offer> offers3 = offersDao.getOffers(user2.getUsername());
		assertEquals("Should be 1 offer for this user.", 1, offers3.size());
	}

	

}
