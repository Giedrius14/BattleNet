package com.battle.net.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("messagesDao")
public class MessagesDao {


	@Autowired
	private SessionFactory sessionFactory; 
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
/*	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
*/
	@SuppressWarnings("unchecked")
	public List<Message> getMessages() {
		Criteria crit= session().createCriteria(Message.class);
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Message> getMessages(String username) {
		Criteria crit= session().createCriteria(Message.class);
		crit.add(Restrictions.eq("username", username));
		return crit.list();
	}
	
	public void saveAndUpdate(Message message) {
		//System.out.println("MsgDAO"+message);
		session().saveOrUpdate(message);
		
	}
	
	public boolean delete(int id) {       // Message yra noridytas Object, o ne Table name, nes cia HQL
		Query query= session().createQuery("delete from Message where id=:id");
		query.setLong("id", id);
		return query.executeUpdate()==1;
	}

	public Message getMessage(int id) {
		Criteria crit= session().createCriteria(Message.class);
		crit.add(Restrictions.idEq(id));
		return (Message)crit.uniqueResult();
		}
}
