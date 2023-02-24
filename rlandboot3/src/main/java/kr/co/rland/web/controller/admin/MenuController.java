package kr.co.rland.web.controller.admin;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@RestController("adminMenuController")
@Controller("adminMenuController")
@RequestMapping("/admin/menu")
public class MenuController {
	
//	@RequestMapping("/admin/menu/list")
//	@RequestMapping("list")
	@GetMapping("list")
	public String list(
			@RequestParam(name="p", defaultValue="1") int page,
			@RequestParam(name="q", required=false) String query,
			//@RequestParam쓸 경우, 파라미터가 필수적으로 와야한다.
			
			//decoding이 안되어서 직접 해야한다. 
			@CookieValue("my") String myCookie,
//			HttpServletRequest request) {
			
			@RequestHeader("Accept-language") String language 
			) throws UnsupportedEncodingException {

			System.out.printf("Accept-language :%s/n", language);
		
			
//		String myCookie = "";
//		Cookie[] cookies = request.getCookies();
//		for(Cookie cookie : cookies)
//			if(cookie.getName().equals("my")) {
//				myCookie = cookie.getValue();
//				break;
//			}
		
		myCookie = URLDecoder.decode(myCookie, "utf-8");
		System.out.printf("page:%d, query:%s\n", page, myCookie);
//		System.out.printf("page: %d\n", page);
//		for(int i=0; i<page; i++) {
//			
//			System.out.print(query);
//			System.out.println();
//		}
		
		return "/WEB-INF/view/admin/menu/list.jsp";
	}
	
	@GetMapping("detail")
	public String detail() {
		return "admin menu detail";
	}

	
	// admin/menu/reg
	// admin/menu/reg.html
	// admin/menu/reg.jsp	-> 요청할 수 없었다. 

	
	//등록폼을 주세요!
	//등록하기 위한 페이지
	//@RequestMapping("reg")				//-> service(): Get/Post를 내가 다 처리하는 매핑!
	@GetMapping("reg")
	public String reg() {
		return "/WEB-INF/view/admin/menu/reg.jsp";
	}
	
	
	//폼 입력해서 제출!
	//데이터를 받아서 등록 전달(제출)
	//@RequestMapping("reg")
	@PostMapping("reg")
	public String reg(String title) {
		//등록하고,
		System.out.println("메뉴 등록 완료!");
//		return "WEB-INF/view/admin/menu/list.jsp";
		return "redirect:list"; //서버가 응답으로 list로 가!라는 응답을 한 것!
			//list라는 url로 redirection 페이지를 찾지 않는다. 
			//red는 클라이언트가 현재 경로에서 list페이지를 다시 요청!
			//클라이언트게 어디로 가세요. 경로는? 현재 경로에서 list로!
			//응답을 받고 클라이언트가 다시 list를 요청한다. 
	}
	
}
