package site.gaoyisheng.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.gaoyisheng.pojo.User;
import site.gaoyisheng.service.LoginService;

@Controller
@RequestMapping("/user")
public class LoginController {

	@Autowired
	private LoginService loginService;

	User currentUser;

	@RequestMapping("/login")
   @ResponseBody
	public String login(HttpServletRequest request, Model model, @RequestParam("number") String number,
			@RequestParam("password") String password) {

		System.out.println(password+number);
		
		if (!(number.equals("") && password.equals(""))) {// not null

			//ajax + jQuery find User in DB or not?
			currentUser = loginService.selectByNumberAndPassword(number, password);
			model.addAttribute("user", currentUser);
			
			return "home" + "?number=" + number;
		}else {
			
			return "errorPage";
		}
	}
}
