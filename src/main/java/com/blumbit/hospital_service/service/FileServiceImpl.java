package com.blumbit.hospital_service.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.blumbit.hospital_service.common.dto.FileRequestDto;
import com.blumbit.hospital_service.common.dto.FileResponseDto;

@Service
public class FileServiceImpl implements FileService {

    @Value("${file.upload.dir}")
    private String uploadDir;

    @Override
    public FileResponseDto createFile(FileRequestDto fileRequestDto) {
        Path fileStorageLocation = Paths.get(uploadDir)
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(fileStorageLocation);// home/david/springv6/2313223dsadsadsmi-archivo.pdf
        } catch (Exception e) {
            throw new RuntimeException("No se puede crear el directorio");
        }
        try {
            String uniqueFileName = generateUniqueFilename(fileRequestDto.getFile().getOriginalFilename());
            Path targetLocation = fileStorageLocation.resolve(uniqueFileName);
            Files.copy(
                    fileRequestDto.getFile().getInputStream(),
                    targetLocation,
                    StandardCopyOption.REPLACE_EXISTING);
            return FileResponseDto.builder().filePath(uniqueFileName).build();
        } catch (IOException e) {
            throw new RuntimeException("Error al crear el archivo");
        }
    }

    @Override
    public File retrieveFile(FileResponseDto fileResponseDto) {
        try {
            Path fileStorageLocation = Paths.get(uploadDir)
                    .toAbsolutePath().normalize();
            Path filePath = fileStorageLocation.resolve(fileResponseDto.getFilePath()).normalize();

            if (!filePath.startsWith(fileStorageLocation)) {
                throw new RuntimeException("Error al recuperar la ubicacion del archivo");
            }

            File file = filePath.toFile();
            if (!file.exists()) {
                throw new RuntimeException("Archivo no encontrado");
            }
            return file;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private String generateUniqueFilename(String fileName){
        //240425_214622FSDSAD434mi-archivo.pdf UUID
        String timestamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
        return timestamp + "_" + UUID.randomUUID().toString().substring(0, 8) + "_"
        + fileName;
    }

}
