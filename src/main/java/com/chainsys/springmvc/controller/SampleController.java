package com.chainsys.springmvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class SampleController {
	
	@RequestMapping("/")
	public String index()
	{
		return "index";// index is the name of the view
		// Runtime will search for index for jsp in webapp/WEB-INF/view folder
	}
	
	@PostMapping("/print")
	public String print(@RequestParam("userName")String uName,Model model)
	{
		model.addAttribute("userName",uName);// to share data from the controller to view 
		return "print";
		// print is the name of the view
		// Runtime will search for print for jsp in webapp/WEB-INF/view folder
	}
}
