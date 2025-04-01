package com.blumbit.hospital_service.controller;

import org.springframework.web.bind.annotation.RestController;

import com.blumbit.hospital_service.dto.request.LoginRequest;
import com.blumbit.hospital_service.dto.response.LoginResponse;
import com.blumbit.hospital_service.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportService reportService;
    
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/r1")
    public void getReportR1(@RequestParam() String username, HttpServletResponse response) {      
        try {
            Path file = Paths.get(reportService.createReservacionesReport(username).getAbsolutePath());
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename"+file.getFileName());
            Files.copy(file, response.getOutputStream());
            response.getOutputStream().flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
