package com.example.batch.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CsvWriterTest {
    @Autowired
    private CsvWriter csvWriter;


    @Test
    void myScheduledTask() {

        csvWriter.myScheduledTask();
    }
}