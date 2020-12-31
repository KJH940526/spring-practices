package com.bitacademy.hellospring03.controller;

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
@RequestMapping("/guestbook/*") //게스트북으로 온는건 다 받겟다!!
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping //맵핑을 위에서 함!!
	public String list() {
		return "GuestbookController:list";
	}
	
	@ResponseBody
	@RequestMapping //맵핑을 위에서 함!!
	public String delete() {
		return "GuestbookController:delete";
	}
}
