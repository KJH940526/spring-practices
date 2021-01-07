package com.bitacademy.aoptest.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.aoptest.service.ProductService;
import com.bitacademy.aoptest.vo.ProductVo;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		ProductService ps =  ac.getBean(ProductService.class);
//		ProductService ps = new ProductService(); 이것과 다를게 없는데 컨테이너를 만들고 메소드를 추가해서 넣었음!
		ProductVo vo = ps.find("TV");
		System.out.println(vo);
		
		((ConfigurableApplicationContext)ac).close();
	}

}
