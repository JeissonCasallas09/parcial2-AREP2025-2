package edu.eci.arep.parcial2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proxy")
public class ProxyController{

    @Autowired
    RoundRobin roundRobin;


    @GetMapping("/collatzsequence")
    public ResponseEntity<String> collatzSequence(@RequestParam int value){
        return roundRobin.collatzsequence(value);
    }

}