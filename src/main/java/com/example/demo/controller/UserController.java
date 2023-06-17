package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUsers")
    public List<UserDTO> getUser(){
        return userService.getAllUsers();
    }

    @PostMapping("/saveUser")
    public UserDTO saveuser(@RequestBody UserDTO userDTO){
       return userService.saveUser(userDTO);
    }
    @PutMapping("/updateUser")
    public UserDTO updateuser(@RequestBody UserDTO userDTO){
        return userService.updateUser(userDTO);
    }
    @DeleteMapping("/deleteUser")
    public boolean deleteuser(@RequestBody UserDTO userDTO){
        return userService.deleteUser(userDTO);
    }


    @GetMapping("/getUserByUserId/{userID}")
    public UserDTO getUserByUserID(@PathVariable String userID){
        return userService.getUserByUserID(userID);
    }
    //this code snippet defines a GET request handler that takes a user ID as a path variable,
    // delegates to the userService to retrieve a UserDTO object based on the provided ID,
    // and then returns the retrieved UserDTO object as the response from the controller method.



    @GetMapping("/getUserByUserIDAndAddress/{userID}/{address}")
    public UserDTO getUserByUserIDAndAddress(@PathVariable String userID, @PathVariable String address){
        System.out.println("user ID :"+ userID + "user address :"+ address);
        return userService.getUserByUserIDAndAddress(userID, address);

        // defines a GET request handler that takes a user ID and address as path variables,
        // prints them to the console, and then delegates to the userService to retrieve a UserDTO object based on the provided ID and address.
        // The retrieved UserDTO object is then returned as the response from the controller method.
    }
}
