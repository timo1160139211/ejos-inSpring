package site.gaoyisheng.controller;

import java.util.HashMap;
import java.util.Map;

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
	public String login(HttpServletRequest request, Model model,
			@RequestParam(value = "number", required = true) String number,
			@RequestParam(value = "password", required = true) String password) {

		System.out.println(number + "\n" + password + "\n");

		if (!(number.equals("") && password.equals(""))) {// not null

			System.out.println("finding");

			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("number", number);
			parameterMap.put("password", password);
			// ajax + jQuery find User in DB or not?
			currentUser = loginService.selectByNumberAndPassword(parameterMap);
			model.addAttribute("user", currentUser);

			if (null != currentUser) {
				 System.out.println(currentUser.toString());
			} else {
				 System.out.println("currentUser == null" );
			}

			return "home" + "?number=" + number;
		} else {

			return "errorPage";
		}
	}
}
