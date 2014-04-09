package com.manko.example.controller;

/**
 * @author Serhiy_Manko
 */
import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
class IndexController {
    private static final Log LOG = LogFactory.getLog(IndexController.class);

    @PostConstruct
    void init() {
	LOG.info(" - - - - - IndexController inited");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
	LOG.info(" - - - - - IndexController /");
	return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
	LOG.info(" - - - - - IndexController /index");
	return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
	LOG.info(" - - - - - IndexController /admin");
	return "admin";
    }

}