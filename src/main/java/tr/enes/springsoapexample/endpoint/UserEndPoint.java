/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.enes.springsoapexample.endpoint;

import localhost._8080.soap_example.GetUserRequest;
import localhost._8080.soap_example.GetUserResponse;
import localhost._8080.soap_example.User;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import tr.enes.springsoapexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author enes
 */
@Endpoint
public class UserEndPoint {
    
    @Autowired
    private UserService userService;
    
    @PayloadRoot(namespace = "http://localhost:8080/soap-example",
            localPart = "getuserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request){
        
        GetUserResponse response = new GetUserResponse();
        
        User user = userService.getUser(request.getName());
        
        response.setUser(user);
        
        return response;
    }
}
