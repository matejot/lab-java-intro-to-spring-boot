package ironhack.com.lab9.controller;


import ironhack.com.lab9.model.Patient;
import ironhack.com.lab9.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor

public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.findAll();
    }

    @GetMapping("/{patientId}")
    public Optional<Patient> getPatientById(@PathVariable("patientId") Long patientId) {
        return patientService.findById(patientId);
    }

    @GetMapping("/date-range")
    public List<Patient> getPatientByDateBetween(@RequestParam String startDate, @RequestParam String endDate){
        return patientService.findPatientByDateBetween(startDate, endDate);
    }

    @GetMapping("/department-admitted_by")
    public List<Patient> getPatientByDoctorDepartment(@RequestParam String department){
        return patientService.findPatientByDoctorDepartment(department);
    }

    @GetMapping("/doctor-status-off")
    public List<Patient> getPatientByDoctorStatusOff() {
        return patientService.findPatientByDoctorStatusOff();
    }

}
