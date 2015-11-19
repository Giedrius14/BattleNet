package com.battle.net.controllers;


import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.battle.net.dao.Message;
import com.battle.net.dao.User;
import com.battle.net.service.UsersService;

@Controller
public class LoginController {

		private UsersService usersService;

		@Autowired
		private MailSender mailSender;
		
		@Autowired
		public void setUsersService(UsersService usersService) {
			this.usersService = usersService;
		}

		@RequestMapping("/login")
		public String showLogin(){
			return "login";
		}
		
	/*	@RequestMapping("/userprofile")
		public String showUserProfile(){
			return "userprofile";
		}*/
		
		@RequestMapping("/denied")
		public String showDenied(){
			return "denied";
		}
		
		@RequestMapping("/messages")
		public String showMessages(){
			return "messages";
		}
		
		@RequestMapping("/admin")
		public String showAdmin(Model model){
			
			List<User> users=usersService.getAllUsers();
			
			model.addAttribute("user", users);
			return "admin";
		}
		
		@RequestMapping("/loggedout")
		public String showLoggedOut(){
			return "loggedout";
		}
		
		@RequestMapping("/createacc")
		public String showCreateAcc(Model model){	
			model.addAttribute("user", new User());
			return "createacc";
		}

		
		@RequestMapping("/acccreated")
		public String showAccCreated(@Valid User user, BindingResult result){	
			//System.out.println(offer);
			
			if(result.hasErrors()){
				return "createacc";
			}
			
			user.setAuthority("ROLE_USER");
			user.setEnabled(true);
			
			if(usersService.exists(user.getUsername())){
				System.out.println("Duplicate");
				result.rejectValue("username", "DuplicateKey.user.username");
				return "createacc";
			}
			
			usersService.create(user);
			return "acccreated";
		}
		

		
		@RequestMapping(value="/getmessages", method= RequestMethod.GET, produces="application/json")
		@ResponseBody
		public Map<String, Object> getMessages(Principal principal, HttpServletResponse response) throws IOException{
			List<Message> messages = null;
			
			if(principal==null){
				messages= new ArrayList<Message>();
			}else{
				String username= principal.getName();
				messages= usersService.getMessages(username);
			}
			Map<String, Object> data= new HashMap<String, Object>();

			data.put("messages", messages);
			data.put("number", messages.size());
			return data;
		}
		
		
		@RequestMapping(value="/deletemsg", method= RequestMethod.POST, produces="application/json")
		@ResponseBody
		public String deleteMSG(Principal principal, @RequestBody Map<String, Object> data){
			int id=(int)data.get("id");
			
			usersService.deleteMSG(id);
			return "messages";
		}
		
		@RequestMapping(value="/sendmessage", method= RequestMethod.POST, produces="application/json")
		@ResponseBody
		public Map<String, Object> sendMessages(Principal principal, @RequestBody Map<String, Object> data){
		
			String text= (String)data.get("text");
			String name= (String)data.get("name");
			String email= (String)data.get("email");
			//String username= (String)data.get("username");
			User msgSender= usersService.getUserByEmail(email);
			String username= msgSender.getUsername();

		//	Integer target=	(Integer)data.get("target");
			
			Message message= new Message();
			message.setName(principal.getName()); // siuntejo
			message.setUsername(username);    // Gavejo
			message.setEmail(email);
			message.setContent(text);
			message.setSubject("Reply from: "+name);
			
			System.out.println(name+" "+email+" "+text);
			
			SimpleMailMessage mail= new SimpleMailMessage();
			mail.setFrom("giedriauswebapp@gmail.com");
			mail.setTo(email);
			mail.setSubject("Reply from: "+name);
			mail.setText(text);
			
			usersService.sendMessage(message);

			try{
				mailSender.send(mail);
			} catch (Exception e){
				e.printStackTrace();
				System.out.println("Cant send");
			}
			
			Map<String, Object> reply= new HashMap<String, Object>();
			reply.put("success", true);
		//	reply.put("target", target);

			return reply;
		}
}
