package com.example.ejb;

import javax.ejb.Stateless;

@Stateless
public class HelloBean {
    public String sayHello() {
        return "Hello, JavaEE 7 with JAX-RS and CDI!";
    }
}
