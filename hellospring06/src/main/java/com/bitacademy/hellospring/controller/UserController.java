package com.bitacademy.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitacademy.hellospring.vo.UserVo;

/*
 *  @author bit
 *  
 *  @RequestMapping 예제
 *  Class + Method(Handller) 매핑(추천)
 */

@Controller
@RequestMapping("/user")  //게스트북이랑 비교!!
public class UserController {
	
//	@RequestMapping(value="/joinform", method=RequestMethod.GET)
//	public String join() {
//		return "/WEB-INF/views/join.jsp";
//	}
									//들어오는 방식이 다르기 떄문에 조인으로 해도 됨!
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String join() {
		return "/join";
	}
	
	//오버로딩!
	@RequestMapping(value="/join", method=RequestMethod.POST)
//	public String join(String name, String email, String password) {
	public String join(UserVo vo) {
		System.out.println("UserController:join" + vo);
		//포워딩이 아니고 작업이 끝났기떄문에 리다이렉트!!
		return "redirect:/";  //아무것도 안 적었기 때문에 메인으로 간다!!
	}
	
	@ResponseBody //디버깅용
	@RequestMapping("/update") 		//이런식으로 생략되어있음!!  메소드가 안 적혀 있으면 둘 다 쓸수 있음!!
	public String update(@RequestParam(value="n", required=true, defaultValue="") String name) {
		/*
		 * 만일 n이라는 이름으로 파라미터가 전달되지 않으면 400 bad request 오류 발생!
		 */
		System.out.println("---" + name + "---");
		return "UserController:update2: " + name;
	}
	
	// 강추!!
	@ResponseBody //디버깅용
	@RequestMapping("/update2") 		//이런식으로 생략되어있음!!  메소드가 안 적혀 있으면 둘 다 쓸수 있음!!
	public String update2(@RequestParam(value="n", required=true, defaultValue="") String name,
 						@RequestParam(value="a",required=true, defaultValue="") int age){ //이름과 파라미터가 다른 경우는 적어줘야한다!!
							//적는게 좋음!! 이름이 같아도 쓰는게 좋고! 디폴트 처리와 리콰이어드 처리를 하자!
		System.out.println("---" + name + "---");
		return "UserController:update2: " + name;
	}
}
