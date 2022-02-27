package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Корень %d";
	private int x;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "a", defaultValue = "0") int a,
							 @RequestParam(value = "b", defaultValue = "0") int b,
							 @RequestParam(value = "x1", defaultValue = "1") int x1,
							 @RequestParam(value = "x2", defaultValue = "0") int x2) {
		x = b - a;
		if(x >= x1 && x <= x2)
			return new Greeting(String.format(template, x));
		else
			return new Greeting("Нет корня");
	}
}