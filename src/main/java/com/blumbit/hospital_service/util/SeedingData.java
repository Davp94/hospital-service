package com.blumbit.hospital_service.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blumbit.hospital_service.entity.Doctor;
import com.blumbit.hospital_service.entity.Especialidad;
import com.blumbit.hospital_service.entity.Horario;
import com.blumbit.hospital_service.repository.DoctorRepository;
import com.blumbit.hospital_service.repository.EspecialidadRepository;
import com.blumbit.hospital_service.repository.HorarioRepository;
import com.blumbit.hospital_service.repository.PacienteRepository;

@Component
public class SeedingData implements CommandLineRunner{

    private final HorarioRepository horarioRepository;

    private final DoctorRepository doctorRepository;

    private final EspecialidadRepository especialidadRepository;

    private final PacienteRepository pacienteRepository;

    public SeedingData(HorarioRepository horarioRepository, DoctorRepository doctorRepository,
            EspecialidadRepository especialidadRepository, PacienteRepository pacienteRepository) {
        this.horarioRepository = horarioRepository;
        this.doctorRepository = doctorRepository;
        this.especialidadRepository = especialidadRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //CREATE ESPECIALIDADES
        Especialidad especialidad1 = Especialidad.builder()
                    .espId((short) (especialidadRepository.count() + 1))
                    .espNombre("Pediatria")
                    .espDescripcion("Servicio de pediatria")
                    .build();

        Especialidad especialidad2 = Especialidad.builder()
                    .espId((short) (especialidadRepository.count() + 1))
                    .espNombre("Traumatologia")
                    .espDescripcion("Servicio de traumatologia")
                    .build();
        List<Especialidad> especialidades = especialidadRepository.saveAll(List.of(especialidad1, especialidad2));
        //CREATE DOCTOR
        Doctor doctor1 = Doctor.builder()
                        .especialidad(especialidades.getFirst())
                        .docId((short)(doctorRepository.count()+1))
                        .docApellidos("Mendez Mendez")
                        .docNombre("Pedro")
                        .docRs("RS000001")
                        .build();
        
        List<Doctor> doctores = doctorRepository.saveAll(List.of(doctor1));
        //
        if(horarioRepository.count() == 0){
            Horario horario1 = Horario.builder()
                                .doctor(doctores.getLast())
                                .horDisponible(true)
                                .horFecha(LocalDateTime.now())
                                .horHoraFin(LocalTime.of(10, 00))
                                .horHoraInicio(LocalTime.of(9, 00))
                                .horId((int)(horarioRepository.count()+1))
                                .build();
            List<Horario> horarios = horarioRepository.saveAll(List.of(horario1));                       
        }
    }

}
