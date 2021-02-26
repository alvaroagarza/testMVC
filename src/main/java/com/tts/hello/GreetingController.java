package com.tts.hello;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

//add @Controller annotation
@Controller
public class GreetingController {
	@Autowired
	private GreetingRepository greetingRepository;
	
	
	
	//add @GetMapping annotation for /greeting
	@GetMapping(value= "/greeting")
	public String greeting(Greeting greeting, Model model) {
		return "greeting";
	}
	
	
	@PostMapping(value= "/greeting")
	  public String addNewGreet( Greeting greeting, Model model) {
		greetingRepository.save(new Greeting(greeting.getId(), greeting.getContent()));
			model.addAttribute("id", greeting.getId());
			model.addAttribute("content", greeting.getContent());
	    return "result";
	  }
	
}

