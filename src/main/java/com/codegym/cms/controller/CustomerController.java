package com.codegym.cms.controller;

import com.codegym.cms.model.Customer;
import com.codegym.cms.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;
    @GetMapping("/create-customer")
    private ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("customers/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }
    @PostMapping("/create-customer")
    private ModelAndView saveCustomer(@ModelAttribute ("customer") Customer customer){
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("customers/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message","New customer create successfully");
        return modelAndView;
    }
    @GetMapping("/customers")
    private ModelAndView listCustomer(){
        List<Customer> customers= customerService.findAll();
        ModelAndView modelAndView = new ModelAndView("customers/list");
        modelAndView.addObject("customers",customers);
        return modelAndView;
    }
}
