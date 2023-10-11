package com.infinite;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {
	@RequestMapping(value = "/login", method =RequestMethod.POST)
	public String display(HttpServletRequest req, Model m,@Valid @ModelAttribute("userForm") User userForm,
			BindingResult result){
		/*String name = req.getParameter("name");
			String pass = req.getParameter("pass");
			if(pass.equals("admin")) {
				String msg = "Hello" + name;
				// add a message to the model
				m.addAttribute("message", msg);
				return "viewpage";
				
			} else {
				String msg = "Sorry" + name + " , you entered wrong password";
				m.addAttribute("message", msg);
				return"errorpage";
			}*/
		
		if( result.hasErrors()){
			return "viewpage";
			
		}
		else {
			return "error";
		}
	}
	

}
