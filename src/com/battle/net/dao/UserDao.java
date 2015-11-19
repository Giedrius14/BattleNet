package com.battle.net.dao;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component("usersDao")
public class UserDao {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	@Autowired
	private SessionFactory sessionFactory; 
	
	public Session session(){
		return sessionFactory.getCurrentSession();
	}
	
	/*	@Transactional
	public boolean create(User user) {
		
		//BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		
		MapSqlParameterSource params= new MapSqlParameterSource();
		params.addValue("username", user.getUsername());
		params.addValue("password", passwordEncoder.encode(user.getPassword()));
		params.addValue("email", user.getEmail());
		params.addValue("name", user.getName());
		params.addValue("enabled", user.isEnabled());
		params.addValue("authority", user.getAuthority());
		return jdbc.update("insert into users (username, name, password, email, enabled, authority) values (:username, :name, :password, :email, :enabled, :authority)", params) == 1;
	*/
	@Transactional
	public void create(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
		
	}

	public boolean exists(String username) {
		User user= getUser(username);
		return user != null;
	}
	
	public User getUser(String username) {
		Criteria crit = session().createCriteria(User.class);
		crit.add(Restrictions.idEq(username));
		return (User)crit.uniqueResult();
		
	}
	public User getUserByEmail(String email) {
		//return (User) session().createQuery("Select username from User WHERE email ="+"'"+email+"'");
		//String hql = "from User WHERE email ="+email;
		//Query query = session().createQuery(hql);
		//List results = query.list();
	//	return results;
		Criteria crit = session().createCriteria(User.class);
		crit.add(Restrictions.eq("email", email));
		return (User)crit.uniqueResult();
		/**
		 * 
 Session session = getSessionFactory().getCurrentSession();
Query query = session.createQuery("select value from table where ...");
query.setParameters("param1", value1);
result = (Type) query.uniqueResult(); //The type is you desired result type.
//test for null here if needed
		 */
		}

	public List<User> getAllUsers() {
		return session().createQuery("from User").list();  // User Bean name which your using with the data
	//	return jdbc.query("select * from users", BeanPropertyRowMapper.newInstance(User.class));
	}

	
	
}
