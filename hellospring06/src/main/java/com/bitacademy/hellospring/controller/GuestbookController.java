package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 *  @author bit
 *  
 *  @RequestMapping 예제
 *  class 단독 매핑
 */

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping("/list") //맵핑을 위에서 함!!
	public String list() {
		return "GuestbookController:list";
	}
	
	@ResponseBody
	@RequestMapping("/delete") //맵핑을 위에서 함!!
	public String delete() {
		return "GuestbookController:delete";
	}
}
