package com.blumbit.hospital_service.service;

import java.io.File;

import com.blumbit.hospital_service.common.dto.FileRequestDto;
import com.blumbit.hospital_service.common.dto.FileResponseDto;

public interface FileService {

    FileResponseDto createFile(FileRequestDto fileRequestDto);

    File retrieveFile(FileResponseDto fileResponseDto);

}
