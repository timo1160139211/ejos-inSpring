package site.gaoyisheng.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import site.gaoyisheng.pojo.User;
import site.gaoyisheng.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminOpsController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/home")
	public ModelAndView home(HttpSession session) {
		
		User currentUser =(User) session.getAttribute("currentUser");
		System.out.println("home:" + currentUser.toString());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("currentUser",currentUser)
		  .setViewName("/admin/home");
		
		return mv;
	}
	
	@RequestMapping("/userList")
	public ModelAndView questionList(HttpSession session) {
		
		User currentUser =(User) session.getAttribute("currentUser");
		System.out.println("userList:" + currentUser.toString());
		
		List<User> userList = userService.selectAllUserExceptIdentity("student");

		ModelAndView mv = new ModelAndView();
		mv.addObject("userList",userList)
		  .setViewName("/admin/userList");
		
		return mv;
	}
	
	@RequestMapping("/users")
	public String toIndex(HttpServletRequest request,Model model){
		System.out.println(request.getParameter("id"));
		
		Integer userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserByPrimaryKey(userId);
		model.addAttribute("user", user);
		
		return "users";
	}
	
	@RequestMapping("/addUser")
	public ModelAndView addUser() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/admin/addUser");
		
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request) {
		
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("number"));
		System.out.println(request.getParameter("password"));
		System.out.println(request.getParameter("identity"));
		System.out.println(request.getParameter("idcard"));
		System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		
		User user = new User();
		
		user.setNumber(request.getParameter("number"));
		user.setPassword(request.getParameter("password"));
		user.setIdentity(request.getParameter("identity"));
		user.setName(request.getParameter("name"));
		user.setIdcard(request.getParameter("idcard"));
		user.setTeamId(null);
		user.setEmail("hahaha@qq.com");
		
		int i = userService.insertCacheId(user);
		
		System.out.println(user.toString());
		System.out.println("----------------"+i);

		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:" + "/admin/userList");
		
		return mv;
	}
	
}
