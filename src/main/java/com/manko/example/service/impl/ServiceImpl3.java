package com.manko.example.service.impl;

/**
 * @author Serhiy_Manko
 */
import com.manko.example.service.Service;

@org.springframework.stereotype.Service("service3")
public class ServiceImpl3 implements Service {

    @Override
    public void getName() {
	System.out.println("service3");
    }
    
}
