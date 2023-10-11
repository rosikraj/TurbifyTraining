package com.infinite.web2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpringWeb2 {
	@RequestMapping("/infinite")
	public String display() {

		return "index";
	}

}
