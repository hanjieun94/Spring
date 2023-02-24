package kr.co.rland.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/menu")
public class MenuController {
	
	@RequestMapping("list")
	public String list() {
		return "menul list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		return "menu detail";
	}

}
