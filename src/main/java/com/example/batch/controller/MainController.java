package com.example.batch.controller;


import com.example.batch.dto.ResponseDto;
import com.example.batch.service.BatchService;
import com.example.batch.service.CsvWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MainController {

    private final BatchService batchService;
    private final CsvWriter csvWriter;

    @GetMapping("/test")
    public List<ResponseDto> test(){

        return batchService.getData();
    }

    @GetMapping("/schedule")
    public void schedule(){
        csvWriter.myScheduledTask();
    }

}
