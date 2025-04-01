package com.blumbit.hospital_service.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.w3c.dom.Document;
import org.w3c.tidy.Tidy;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.blumbit.hospital_service.dto.response.ReservacionResponse;

import jakarta.transaction.Transactional;

@Service
public class ReportServiceImpl implements ReportService{

    private final ReservacionService reservacionService;

    private final SpringTemplateEngine springTemplateEngine;

    public ReportServiceImpl(ReservacionService reservacionService, SpringTemplateEngine springTemplateEngine) {
        this.reservacionService = reservacionService;
        this.springTemplateEngine = springTemplateEngine;
    }

    @Override
    @Transactional
    public File createReservacionesReport(String username) throws IOException{

        //update reservacion

        //create conditions ---- 

        //CREATE REPORT

        List<ReservacionResponse> reservacions = reservacionService.findReservacionesByPaciente(username);
        Context context = new Context();
        context.setVariable("reservaciones", reservacions);

        String html = springTemplateEngine.process("index", context);

        String xhtml = convertHtmlToXhtml(html); 

        

        //CONVERT XHTML TO FILE PDF
        File file = File.createTempFile("reservaciones", ".pdf");
        OutputStream outputStream = new FileOutputStream(file);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(xhtml, new ClassPathResource("/css/").getURL().toExternalForm());
        renderer.layout();
        renderer.createPDF(outputStream);
        outputStream.close();
        file.deleteOnExit();
        return file;   
    }

    private String convertHtmlToXhtml(String html){
        Tidy tidy = new Tidy();
        tidy.setXHTML(true);
        tidy.setIndentContent(true);
        tidy.setPrintBodyOnly(true);
        tidy.setInputEncoding("UTF-8");
        tidy.setOutputEncoding("UTF-8");
        tidy.setShowWarnings(false);
        tidy.setTidyMark(false);

        Document htmlDom = tidy.parseDOM(new ByteArrayInputStream(html.getBytes()), null);
        OutputStream outputStream = new ByteArrayOutputStream();
        tidy.pprint(htmlDom, outputStream);
        return outputStream.toString();
    }





}
