package com.ss.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ss.model.Customer;



@RestController
public class CustomerRestController {
   
	private static Map<Integer, Customer>  userdata = new HashMap<Integer, Customer>();
	
   @PostMapping(value = "/addCustomer", consumes={"application/xml","application/json"})
	public String addCustomer(@RequestBody Customer c) {
	  // System.out.println("----addCustomer()-------------");
		if(userdata.containsKey(c.getCid())) {
			return "Customer already Exsist";
		}
		userdata.put(c.getCid(), c);
		System.out.println(userdata);
		return "Customer Added Successfully";
	}
	
   @GetMapping(value = "/getCustomer",produces= {"application/xml","application/json"} )
	public Customer getCustomer(@RequestParam (name = "cid") int cid) {
	 //  System.out.println("----getCustomer()-------------");

	   if(userdata.containsKey(cid)) {
		 //  System.out.println(userdata.get(cid));
		   return userdata.get(cid);
	   }
		   return null;
	}
}
