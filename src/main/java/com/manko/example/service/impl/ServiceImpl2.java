package com.manko.example.service.impl;

/**
 * @author Serhiy_Manko
 */
import com.manko.example.service.Service;

@org.springframework.stereotype.Service("service2")
public class ServiceImpl2 implements Service {

    @Override
    public void getName() {
	System.out.println("service2");
    }
    
}
