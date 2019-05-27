package com.mini.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

	@Value("${key}")
	private String value;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		LOGGER.debug("indsex");
		return "index";

	}

	@RequestMapping(value = "/index2", method = RequestMethod.GET)
	public String index2(ModelMap model) {
		return "index3";

	}

	@RequestMapping(value = "/index3", method = RequestMethod.GET)
	public String index3(ModelMap model) {
		return "index3";

	}
	
	@RequestMapping(value = "/post-right-sidebar", method = RequestMethod.GET)
	public String postrightsidebar(ModelMap model) {
		return "post-right-sidebar";

	}
	
	@RequestMapping(value = "/right-sidebar", method = RequestMethod.GET)
	public String rightSidebar(ModelMap model) {
		return "right-sidebar";

	}
	
	@RequestMapping(value = "/post-no-sidebar", method = RequestMethod.GET)
	public String noSidebar(ModelMap model) {
		return "post-no-sidebar";

	}
	
	@RequestMapping(value = "/author", method = RequestMethod.GET)
	public String author(ModelMap model) {
		return "author";

	}
	
	@RequestMapping(value = "/author-post", method = RequestMethod.GET)
	public String authorPost(ModelMap model) {
		return "author-post";

	}
	
}