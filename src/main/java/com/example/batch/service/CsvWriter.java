package com.example.batch.service;

import com.example.batch.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Component
@RequiredArgsConstructor
@EnableScheduling
@Slf4j
public class CsvWriter  {
    private final BatchService batchService;


    @Scheduled(cron = "0 55 16 * * ?")
    public void myScheduledTask(){
        List<ResponseDto> data = batchService.getData();

        createCSVFile(data);
        batchService.deleteData();
    }

    public void createCSVFile(List<ResponseDto> data){
        StringBuilder csvData = new StringBuilder();
        csvData.append("시군구,조회수\n");
        for (ResponseDto csv : data) {
            csvData.append(
                     csv.getLocation())
                    .append(',')
                    .append(String.valueOf(csv.getCount()))
                    .append("\n");

        }


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmm");

        String now = dateFormat.format(new Date());
        log.info(now.toString());
        String csvFilePath = "C:\\Users\\Administrator\\Desktop\\국비\\JSP Project\\batch\\src\\main\\resources\\"+now+"_통계.csv";

        log.info(csvData.toString());
        try {
            // CSV 데이터를 파일로 저장
            Files.writeString(Path.of(csvFilePath), "\uFEFF" + csvData.toString(), StandardCharsets.UTF_8, StandardOpenOption.CREATE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
