package com.example.batch.service;

import com.example.batch.dto.ResponseDto;
import com.example.batch.mapper.DataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j

public class BatchService {

    @Autowired
    private DataMapper dataMapper;


    public List<ResponseDto> getData(){
       return dataMapper.findAll();

    }
    public void deleteData(){
        dataMapper.deleteAll();
    }
}
