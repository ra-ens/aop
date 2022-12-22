package com.abdelhakimrafik.springaop.services;

import com.abdelhakimrafik.springaop.aspects.Has;
import com.abdelhakimrafik.springaop.aspects.Log;
import org.springframework.stereotype.Service;

@Service
public class BusinessLogic implements IBusiness {
    @Override
    @Log
    @Has(roles = {"ADMIN"})
    public void process() {
        System.out.println("Business process....");
    }

    @Override
    @Has(roles = {"WRITER"})
    public double compute() {
        return 0;
    }
}
