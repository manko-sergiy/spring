package com.manko.example.service.impl;

/**
 * @author Serhiy_Manko
 */
import com.manko.example.service.Service;

@org.springframework.stereotype.Service("service")
public class ServiceImpl implements Service {

    @Override
    public void getName() {
	System.out.println("service");
    }
    
}
