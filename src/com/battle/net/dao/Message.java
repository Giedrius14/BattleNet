package com.battle.net.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="messages")
public class Message implements Serializable{
	
	
	private static final long serialVersionUID = -4368111868603647925L;
	
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min=4)
	private String subject;

	@Size(min=4)
	private String content;
	
	//  Name of user Sending the message

	@Size(min=4)
	private String name;
	
	private String email;
	
	// Send msg TO this username
	private String username;

	public Message(){   //Jei nori patikrint ar veikia visas Model thing.. tai cia galima i hardcodint

	}
	
	public Message(String subject, String content, String name, String email,
			String username) {
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.email = email;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", subject=" + subject + ", content="
				+ content + ", name=" + name + ", email=" + email
				+ ", username=" + username + "]";
	}

}
