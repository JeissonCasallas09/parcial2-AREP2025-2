package edu.eci.arep.parcial2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController{


    @GetMapping("/collatzsequence")
    public ResponseEntity<Map<String,Object>> collatzsequence(@RequestParam int value){
        String result= formatArray(collatzSequenceImplementation(value));
        //ArrayList<Integer> result2= collatzSequenceImplementation(value);
        Map<String,Object> response= new HashMap<>();
        response.put("operation:","collatzsequence");
        response.put("input:",value);
        response.put("output:", result);

        return ResponseEntity.ok(response);
    }

    public static ArrayList<Integer> collatzSequenceImplementation(int value) {
        ArrayList<Integer> response = new ArrayList<>();
        
        while (value != 1) {
            if (value % 2 == 0) {
                value = value / 2; 
                response.add(value);
            } else {
                value = (3 * value) + 1;
                response.add(value);
            }
        }
        System.out.println(response);
    
        return response;
    }
    
    
    
    public String formatArray(ArrayList<Integer> list){
        StringBuilder answer= new StringBuilder();
        for(int i=0; i <= list.size()-1;i++){
            answer.append(list.get(i));
            if(i < list.size()-1){
                 answer.append("->");
             }
        }
        return answer.toString();
    }
}