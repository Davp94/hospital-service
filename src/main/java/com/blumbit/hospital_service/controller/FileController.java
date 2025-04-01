package com.blumbit.hospital_service.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blumbit.hospital_service.common.dto.FileRequestDto;
import com.blumbit.hospital_service.common.dto.FileResponseDto;
import com.blumbit.hospital_service.service.FileService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Resource> retrieveFile(@RequestParam String filePath) {
        try {
            File file = fileService.retrieveFile(FileResponseDto.builder().filePath(filePath).build());

            Path path = Paths.get(file.getAbsolutePath());
            Resource resource = new UrlResource(path.toUri());

            if (!resource.exists() || !resource.isReadable()) {
                throw new RuntimeException("Could not read the file");
            }

           String contentType = Files.probeContentType(path);
            if (contentType == null) {
                contentType = "application/octet-stream";
            }

            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(contentType))
                    .header(HttpHeaders.CONTENT_DISPOSITION, 
                            "attachment; filename=\"" + file.getName() + "\"")
                    .body(resource);

        } catch (IOException ex) {
            return ResponseEntity.internalServerError().build();
        }
    }
    

}
