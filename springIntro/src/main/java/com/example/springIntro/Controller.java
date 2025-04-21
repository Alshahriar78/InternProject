package com.example.springIntro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    private final UserService userService;


    public Controller(UserService userService) {
        this.userService = userService;

    }

    @PostMapping("/api/v1/user")
    public String saveUser(@RequestBody UserDTO dto ) {
        userService.userDetailsSave(dto);
        return "User saved successfully";
    }



    @GetMapping("/api/v1/user/Seach/{id}")
    public UserDTO getUserById(@PathVariable("id") Long id) {
        return userService.userFindById(id);
    }

    @DeleteMapping("/api/v1/user/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
    @GetMapping("/")
    private  ResponseEntity<String>  helloWord(){
        System.out.println("Hello Word");
        return ResponseEntity.ok("Hello Word");
    }

    @PutMapping("/api/v1/user/update/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id,  @RequestBody UserDTO dto) {
        UserDTO updated = userService.updateUser(id, dto);
        return ResponseEntity.ok(updated);
    }






}