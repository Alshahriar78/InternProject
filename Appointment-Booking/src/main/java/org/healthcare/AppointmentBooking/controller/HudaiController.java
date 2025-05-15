package org.healthcare.AppointmentBooking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class HudaiController {

    @GetMapping("/Hello")
    public String getHello() {
        return "Hello";
    }
}
