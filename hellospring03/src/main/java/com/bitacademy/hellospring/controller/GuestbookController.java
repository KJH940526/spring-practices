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
@RequestMapping("/guestbook/*") //게스트북으로 온는건 다 받겟다!!
public class GuestbookController {
	// http://localhost:8080/hellospring03/guestbook는 
	// 맵핑이 2개여서 에러가 뜨고 매핑을 안하면 메소드 이름으로 맵핑하기 떄문에
	// http://localhost:8080/hellospring03/guestbook/list
	// 이런식으로 접근해야함
	
	@ResponseBody	//매핑을 안하면 메소드 이름으로 맵핑함!
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
