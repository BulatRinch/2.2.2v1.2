package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
	private final CarService carService;

	@Autowired
	public HelloController(CarService carService) {
		this.carService=carService;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		List<String> messages = new ArrayList<>();
		messages.add("Hello!");
		messages.add("I'm Spring MVC application");
		messages.add("5.2.0 version by sep'19 ");
		model.addAttribute("messages", messages);
		return "index";
	}


	@GetMapping(value = "/cars")
	public String getCars (@RequestParam(value = "count", required = false) Integer count, Model model) {
		// count пришлось привести к обёртке Integer, так как на странице выходит ошибка при отсутствии параметров
		// при отсутствии параметров, им присваивается null, int не может быть null - поэтому ошибка

		model.addAttribute("auto", carService.showAll(count));
		return "cars";
	}
	
}