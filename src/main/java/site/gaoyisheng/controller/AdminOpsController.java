package site.gaoyisheng.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import site.gaoyisheng.pojo.User;
import site.gaoyisheng.service.UserService;

@Controller
@RequestMapping("/manage")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/users")
	public String toIndex(HttpServletRequest request,Model model){
		System.out.println(request.getParameter("id"));
		
		Integer userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserByPrimaryKey(userId);
		model.addAttribute("user", user);
		
		return "users";
	}
	
	@RequestMapping("/adduser")
	public String addUser(HttpServletRequest request,Model model){
		
		//拿到用户
		System.out.println(request.getParameter("id"));
		
		
		//添加到数据库
		Integer userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserByPrimaryKey(userId);
		model.addAttribute("user", user);
		
		//反馈到前台
		return "users";
	}
	
}
