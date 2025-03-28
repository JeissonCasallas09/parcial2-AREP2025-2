package edu.eci.arep.parcial2;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RoundRobin{
    //private final List<String> servers= Arrays.asList("http://localhost:8081/","http://localhost:8082/");
    private final List<String> servers= Arrays.asList("http://3.82.172.42:8080/","http://44.202.125.33:8080/");
    int currentIndex=0;

    public ResponseEntity<String> collatzsequence(int value){
        String url= servers.get(currentIndex)+"collatzsequence?value="+value;
        currentIndex=(currentIndex+1)%servers.size();
        return new RestTemplate().getForEntity(url,String.class); 

    }
}