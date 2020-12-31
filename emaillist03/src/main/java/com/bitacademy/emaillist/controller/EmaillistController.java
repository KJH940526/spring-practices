package com.bitacademy.emaillist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bitacademy.emaillist.rpository.EmaillistRepository;
import com.bitacademy.emaillist.vo.EmaillistVo;

@Controller
public class EmaillistController {

	@Autowired // 없으면 부모루트로 가서 찾는다!! -> 부모루트에서는 사용불가!
	private EmaillistRepository emaillistRepository;

	@RequestMapping("") // 데이터베이스!!
	public String index(Model model) {
		System.out.println(emaillistRepository);
		List<EmaillistVo> list = emaillistRepository.findAll();
		model.addAttribute("list", list);
		System.out.println("리스트--------- " + list);
		System.out.println("인덱스-------- " + model);

		for (EmaillistVo vo : list) {
			System.out.println(vo);
		}

		return "index"; // spring-servelt.xml에서 view Resolver 설정해줬음!

	}

	@RequestMapping(value = "/add", method = RequestMethod.GET) // 데이터베이스!!
	public String add() {
		return "add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST) // 데이터베이스!!
	public String add(EmaillistVo vo) {
		System.out.println("add " + vo);
		// 레포지토리
		emaillistRepository.insert(vo);
		return "redirect:/";
	}
}
