package com.battle.net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.battle.net.dao.Message;
import com.battle.net.dao.MessagesDao;
import com.battle.net.dao.User;
import com.battle.net.dao.UserDao;

@Service("usersService")
public class UsersService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private MessagesDao messagesDao;

	
/*	@Autowired
	public void setOffersDao(UserDao userDao) {
		this.userDao = userDao;
	}
*/
	public void create(User user) {
		userDao.create(user);		// Sukuria nauja irasa
	}

	public boolean exists(String username) {
		return userDao.exists(username);
	}

	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	}
	
	public void sendMessage(Message message) {
		messagesDao.saveAndUpdate(message);
	}
	
	public void deleteMSG(int id) {
		messagesDao.delete(id);
	}
	
	public User getUser(String username){
		return userDao.getUser(username);
	}
	public User getUserByEmail(String email){
		return userDao.getUserByEmail(email);
	}

	public List<Message> getMessages(String username) {
		return messagesDao.getMessages(username);
	}
}
