package com.example.BookManager.controller;

import com.example.BookManager.dto.responses.StatsResponse;
import com.example.BookManager.service.CategoryService;
import com.example.BookManager.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/stats")
public class StatsController {
    @Autowired
    private StatsService statsService;
    @GetMapping()
    StatsResponse getStats()
    {
        return statsService.readStats();
    }
}
