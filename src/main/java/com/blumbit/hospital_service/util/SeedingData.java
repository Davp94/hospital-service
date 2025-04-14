package com.blumbit.hospital_service.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.blumbit.hospital_service.entity.Doctor;
import com.blumbit.hospital_service.entity.Especialidad;
import com.blumbit.hospital_service.entity.Horario;
import com.blumbit.hospital_service.entity.Paciente;
import com.blumbit.hospital_service.repository.DoctorRepository;
import com.blumbit.hospital_service.repository.EspecialidadRepository;
import com.blumbit.hospital_service.repository.HorarioRepository;
import com.blumbit.hospital_service.repository.PacienteRepository;

@Component
public class SeedingData implements CommandLineRunner {

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
        // CREATE ESPECIALIDADES
        if (especialidadRepository.count() == 0 && doctorRepository.count() == 0 && horarioRepository.count() == 0 && pacienteRepository.count() == 0) {
        
            Paciente paciente = Paciente.builder()
                        .pacId((short) (especialidadRepository.count() + 1))
                        .pacApellidos("Gonzales Medina")
                        .pacDni("12345678")
                        .pacEstado((short)1)
                        .pacFoto("iamgeUsuario.jpg")
                        .pacNombres("Alan Andres")
                        .pacPassword("$2a$12$uWmvVFg9IGQnFMbY2JVt1eDgM1hlZ5qFb5j6pQiE7Xaft4ywgEArC")
                        .pacUsername("alan_andres")
                        .build();
                        pacienteRepository.save(paciente);    
            Especialidad especialidad1 = Especialidad.builder()
                    .espId((short) (especialidadRepository.count() + 1))
                    .espNombre("Pediatria")
                    .espDescripcion("Servicio de pediatria")
                    .build();
            especialidadRepository.save(especialidad1);
            Especialidad especialidad2 = Especialidad.builder()
                    .espId((short) (especialidadRepository.count() + 1))
                    .espNombre("Traumatologia")
                    .espDescripcion("Servicio de traumatologia")
                    .build();
            especialidadRepository.save(especialidad2);
            Especialidad especialidad3 = Especialidad.builder()
                    .espId((short) (especialidadRepository.count() + 1))
                    .espNombre("Dermatologia")
                    .espDescripcion("Servicio de dermatologia")
                    .build();
                    especialidadRepository.save(especialidad3);
            Especialidad especialidad4 = Especialidad.builder()
                    .espId((short) (especialidadRepository.count() + 1))
                    .espNombre("Medicina Interna")
                    .espDescripcion("Servicio de medicina interna")
                    .build();
                    especialidadRepository.save(especialidad4);
            Especialidad especialidad5 = Especialidad.builder()
                    .espId((short) (especialidadRepository.count() + 1))
                    .espNombre("Odontologia")
                    .espDescripcion("Servicio de odontologia")
                    .build();
                    especialidadRepository.save(especialidad5);
            List<Especialidad> especialidades = especialidadRepository.findAll();
            // CREATE DOCTOR
            short nextId = (short) (doctorRepository.count() + 1);
            Doctor doctor1 = Doctor.builder()
                    .especialidad(especialidades.getFirst())
                    .docId(nextId++)
                    .docApellidos("Mendez Mendez")
                    .docNombre("Pedro")
                    .docRs("RS000001")
                    .build();

            Doctor doctor2 = Doctor.builder()
                    .especialidad(especialidades.getFirst())
                    .docId(nextId++)
                    .docApellidos("Suarez Suarez")
                    .docNombre("Manuel")
                    .docRs("RS000002")
                    .build();
            Doctor doctor3 = Doctor.builder()
                    .especialidad(especialidades.get(1))
                    .docId(nextId++)
                    .docApellidos("Sanchez Sanchez")
                    .docNombre("Ana")
                    .docRs("RS000003")
                    .build();
            Doctor doctor4 = Doctor.builder()
                    .especialidad(especialidades.getFirst())
                    .docId(nextId++)
                    .docApellidos("Zelada Zelada")
                    .docNombre("Nancy")
                    .docRs("RS000004")
                    .build();
            Doctor doctor5 = Doctor.builder()
                    .especialidad(especialidades.get(2))
                    .docId(nextId++)
                    .docApellidos("GOmez Gomez")
                    .docNombre("Juan")
                    .docRs("RS000005")
                    .build();
            Doctor doctor6 = Doctor.builder()
                    .especialidad(especialidades.get(2))
                    .docId(nextId++)
                    .docApellidos("Vargas Vargas")
                    .docNombre("Andres")
                    .docRs("RS000006")
                    .build();
            Doctor doctor7 = Doctor.builder()
                    .especialidad(especialidades.get(3))
                    .docId(nextId++)
                    .docApellidos("Garcia Garcia")
                    .docNombre("Jhon")
                    .docRs("RS000007")
                    .build();
            Doctor doctor8 = Doctor.builder()
                    .especialidad(especialidades.get(3))
                    .docId(nextId++)
                    .docApellidos("Ramirez Ramirez")
                    .docNombre("Daniel")
                    .docRs("RS000008")
                    .build();
            Doctor doctor9 = Doctor.builder()
                    .especialidad(especialidades.get(4))
                    .docId(nextId++)
                    .docApellidos("Burgos Burgos")
                    .docNombre("Kevin")
                    .docRs("RS000009")
                    .build();
            Doctor doctor10 = Doctor.builder()
                    .especialidad(especialidades.get(4))
                    .docId(nextId++)
                    .docApellidos("Ramos Ramos")
                    .docNombre("Ines")
                    .docRs("RS000010")
                    .build();

            List<Doctor> doctores = doctorRepository.saveAll(
                    List.of(doctor1, doctor2, doctor3, doctor4, doctor5, doctor6, doctor7, doctor8, doctor9, doctor10));

            LocalDate date1 = LocalDate.of(2025, 4, 9);
            for (int i = 0; i < 5; i++) {
                LocalTime startTime = LocalTime.of(9 + i, 0);
                LocalTime endTime = LocalTime.of(10 + i, 0);

                Horario horario = Horario.builder()
                        .doctor(doctores.getFirst())
                        .horDisponible(true)
                        .horFecha(date1.atStartOfDay())
                        .horHoraInicio(startTime)
                        .horHoraFin(endTime)
                        .horId((int) (horarioRepository.count() + 1))
                        .build();

                horarioRepository.save(horario);
            }

            LocalDate date2 = LocalDate.of(2025, 4, 10);
            for (int i = 0; i < 5; i++) {
                LocalTime startTime = LocalTime.of(9 + i, 0);
                LocalTime endTime = LocalTime.of(10 + i, 0);

                Horario horario = Horario.builder()
                        .doctor(doctores.getFirst())
                        .horDisponible(true)
                        .horFecha(date2.atStartOfDay())
                        .horHoraInicio(startTime)
                        .horHoraFin(endTime)
                        .horId((int) (horarioRepository.count() + 1))
                        .build();

                horarioRepository.save(horario);
            }

            for (int i = 0; i < 5; i++) {
                LocalTime startTime = LocalTime.of(9 + i, 0);
                LocalTime endTime = LocalTime.of(10 + i, 0);

                Horario horario = Horario.builder()
                        .doctor(doctores.get(1))
                        .horDisponible(true)
                        .horFecha(date1.atStartOfDay())
                        .horHoraInicio(startTime)
                        .horHoraFin(endTime)
                        .horId((int) (horarioRepository.count() + 1))
                        .build();

                horarioRepository.save(horario);
            }

            for (int i = 0; i < 5; i++) {
                LocalTime startTime = LocalTime.of(9 + i, 0);
                LocalTime endTime = LocalTime.of(10 + i, 0);

                Horario horario = Horario.builder()
                        .doctor(doctores.get(1))
                        .horDisponible(true)
                        .horFecha(date2.atStartOfDay())
                        .horHoraInicio(startTime)
                        .horHoraFin(endTime)
                        .horId((int) (horarioRepository.count() + 1))
                        .build();

                horarioRepository.save(horario);
            }
        }
    }
}
