package com.blumbit.hospital_service.service;

import java.io.File;
import java.io.IOException;

public interface ReportService {

    File createReservacionesReport(String username) throws IOException;
}
