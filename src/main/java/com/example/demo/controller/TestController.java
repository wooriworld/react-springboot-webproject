package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping
    public String testController() {
        return "Hello world";
    }

    @GetMapping("{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id) {
        return "Hello world" + id;
    }

    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id) {
        return "Hello world" + id;
    }

    @PostMapping("/testRequestBody")
    public String testControllerReqeustBody(@RequestBody TestRequestBodyDTO dto) {
        return "Hello world" + dto;
    }

    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody() {
        List<String > list = new ArrayList<>();
        list.add("test1");
        return ResponseDTO.<String>builder().data(list).build();
    }

    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity() {
        List<String > list = new ArrayList<>();
        list.add("test1");
        ResponseDTO<String> responseDTO = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(responseDTO);
    }
}
