package com.blumbit.hospital_service.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.hospital_service.common.dto.FileRequestDto;
import com.blumbit.hospital_service.common.dto.FileResponseDto;
import com.blumbit.hospital_service.service.FileService;

import java.io.File;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public FileResponseDto uploadFile(@ModelAttribute FileRequestDto fileRequestDto){
        return fileService.createFile(fileRequestDto);
    }

    @GetMapping
    public File retrieveFile(@RequestParam String filePath) {
        return fileService.retrieveFile(FileResponseDto.builder().filePath(filePath).build());
    }
    

}
