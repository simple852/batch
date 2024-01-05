package com.example.batch.mapper;

import com.example.batch.dto.ResponseDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DataMapper {



    List<ResponseDto> findAll();

    void deleteAll();
}
