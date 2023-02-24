package kr.co.rland.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//index와 연관된 페이지 

//@RestController	//사용자에게 data를 바로 준다!
@Controller	//MVC로써 뷰 페이지를 사용자에게 준다!
public class HomeController{
	
	@RequestMapping("/index")
	public String index() {
		return "/WEB-INF/view/index.jsp";
	}
	
}