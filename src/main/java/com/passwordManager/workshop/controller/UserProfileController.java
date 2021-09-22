package com.passwordManager.workshop.controller;
import javax.servlet.http.HttpServletRequest;

	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.passwordManager.workshop.models.UserData;
import com.passwordManager.workshop.security.JwtTokenProvider;
import com.passwordManager.workshop.service.UserDataService;

import io.swagger.annotations.ApiOperation;

@RestController
public class UserProfileController {

    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    UserDataService userDataService;

    @ApiOperation(value = "Create a new User", consumes = "application/json", produces = "application/json")
    @PostMapping(value="/signUp")
    public ResponseEntity<?> createUser(@RequestBody UserData user) throws Exception{
        UserData newUser= userDataService.createUser(user);
        return ResponseEntity.ok("Created User" + newUser);
    }

    @ApiOperation(value = "Get user's info", produces = "application/json")
    @GetMapping(value="/user")
    public ResponseEntity <?> getUserInfo(HttpServletRequest request) throws Exception{
        String userToken= jwtTokenProvider.extractId(request);
        UserData user;
        try{
            user=userDataService.readUserById(0);
        }catch(Exception ex){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);
    }

    
}