/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.enes.springsoapexample.service;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import localhost._8080.soap_example.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author enes
 */
@Service
public class UserService {
    
    private static final Map<String, User> users = new HashMap<>();
    
    @PostConstruct
    public void initialize(){
        
        User peter = new User();
        peter.setName("Peter");
        peter.setEmpId(1111);
        peter.setSalary(12000);

        User sam = new User();
        sam.setName("Sam");
        sam.setEmpId(1112);
        sam.setSalary(32000);
        User ryan = new User();
        ryan.setName("Ryan");
        ryan.setEmpId(1113);
        ryan.setSalary(16000);

        users.put(peter.getName(), peter);
        users.put(sam.getName(), sam);
        users.put(ryan.getName(), ryan);
        
    }

    public User getUser(String name) {
        return users.get(name);
    }
    
    
}
