package kr.co.rland.web.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

//@RestController	//사용자에게 data를 바로 준다!
@Controller	//MVC로써 뷰 페이지를 사용자에게 준다!
@RequestMapping("/")
public class HomeController{
	
	//파일을 upload하기 위함.
	//클라이언트가 파일을 선택해서 (사용자의 의해서) 업로드 방법
	//클라이언트는 허락된 영역인 샌드박스에서 
		//버튼
		//drag
		//클립보드 cv
	@PostMapping("upload")
	@ResponseBody
	public String upload(MultipartFile img) {	//binary를 받기 위해서는? spring이 받아서 참조를 준다.
		
		//업로드 후 
		//뷰없이 예외적으로 데이터를 보낸다.
		//나는 뷰페이지를 요구하지 않습니다. 
		
		System.out.println(img);	
		return "GOOD";
		
		
		
	}
	@RequestMapping("index")
	public String index(Model model,HttpServletResponse response) throws UnsupportedEncodingException  {
		
//		String data = "Hello Data";
		
		String data = URLEncoder.encode("cookie 지륭~", "utf-8");
		
		
		//쿠키만들기
		Cookie cookie = new Cookie("my", data);
		response.addCookie(cookie);
		
	
		model.addAttribute("data", data);
		
		return "/WEB-INF/view/index.jsp";
		
	}
	
}