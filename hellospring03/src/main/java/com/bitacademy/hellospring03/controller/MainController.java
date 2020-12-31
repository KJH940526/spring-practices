package com.bitacademy.hellospring03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@ResponseBody
	@RequestMapping({"","/main"})  //그냥 치고 들어올떄랑 /main으로 들어올떄 멀티맵핑!!
	public String main() {
		return "MainControoler:main";
	}
}
