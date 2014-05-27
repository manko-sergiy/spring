package com.manko.example.controller;

/**
 * @author Serhiy_Manko
 */
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manko.example.service.Service;
import com.manko.example.service.impl.ServiceImpl3;

@Controller
class IndexController {
    private static final Log LOG = LogFactory.getLog(IndexController.class);
    
    Service service;

    @Autowired
    @Qualifier("service2")
    Service serviceTwo;
    
    @Autowired
    Service service3;
    
    @Autowired
    ServiceImpl3 serviceImpl3;
    
    @Autowired
    ApplicationContext applicationContext;
    
    BeanFactory s;
    
    @PostConstruct
    void init() {
	service = (Service) applicationContext.getBean("service");
	service.getName();
	LOG.info(" - - - - - IndexController inited");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex() {
	LOG.info(" - - - - - IndexController /");
	return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() throws UnsupportedFlavorException, IOException {
	LOG.info(" - - - - - IndexController /index");
	serviceTwo.getName();
	service3.getName();
	serviceImpl3.getName();
	return "index";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
	LOG.info(" - - - - - IndexController /admin");
	return "admin";
    }

}