package site.gaoyisheng.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import site.gaoyisheng.pojo.User;
import site.gaoyisheng.service.LoginService;

@Controller
@RequestMapping("/user")
@SessionAttributes(types = { User.class }) // 设置会话属性
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request,
			@RequestParam(value = "number", required = true) String number,
			@RequestParam(value = "password", required = true) String password) {

		ModelAndView mv = new ModelAndView();

		if (!(number.equals("") && password.equals(""))) {// not null

			Map<String, Object> parameterMap = new HashMap<String, Object>();
			parameterMap.put("number", number);
			parameterMap.put("password", password);
			// ajax + jQuery find User in DB or not?
			User currentUser = loginService.selectByNumberAndPassword(parameterMap);
			mv.addObject("currentUser", currentUser)
			  .setViewName(
					  "redirect:../" + currentUser.getIdentity() + "/home"
					  );

			return mv;
		} else {
			return new ModelAndView("error");
		}
	}
}
