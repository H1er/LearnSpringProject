package com.example.demo.controllers;

import com.example.demo.domain.Animal;
import com.example.demo.domain.Owner;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log
public class OwnerController {
    @GetMapping(path = "/owners")
    public Owner retrieveOwner()
    {
        return Owner.builder()
                .id(1L)
                .age(22L)
                .name("ziskito")
                .address("C/street, 123")
                .build();
    }

    @PostMapping(path = "/owners")
    public Owner createOwner(@RequestBody final Owner owner)
    {
        log.info("got owner "+owner.toString());
        return owner;
    }
}
