package se.radley.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import se.radley.domain.model.User;
import se.radley.domain.repository.UserRepository;

@Controller
public class AdminController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/secure")
	public String secure(Model model) {
		model.addAttribute("users", userRepository.findActive());
		return "secure";
	}
}
