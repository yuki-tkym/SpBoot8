package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Spboot8Controller {
	@Autowired
    private SampleDao dao;
		
	@RequestMapping(value = "/", method =RequestMethod.GET)
	public ModelAndView index(ModelAndView mv) {
		try {
			dao.update();
		} catch(RuntimeException e) {
		System.out.println("更新失敗");
		}
		
		
		List texts = dao.select();
		System.out.println(texts);
		
		/*List results = dao.joinSelect();
		System.out.println(results);*/
		mv.setViewName("index");
		return mv;
	}
}
