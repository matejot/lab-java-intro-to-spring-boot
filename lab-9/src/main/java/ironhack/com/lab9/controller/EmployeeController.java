package ironhack.com.lab9.controller;

import ironhack.com.lab9.model.Employee;
import ironhack.com.lab9.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor

public class EmployeeController {

    private final EmployeeService employeeService;

    private final Set<String> validStatuses = new HashSet<>(Arrays.asList("on", "on_call", "off"));

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{employeeId}")
    public Optional<Employee> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        return employeeService.findById(employeeId);
    }

    @GetMapping("/status/{status}")
    public List<Employee> getEmployeesStatus(@PathVariable("status") String status) {
        if (!validStatuses.contains(status)){
            throw new IllegalArgumentException("Invalid status: " + status +
                                               "\n Please try one of the valid statuses: on, on_call, off");
        }
        return employeeService.findAllByStatus(status);
    }

    @GetMapping("/department/{department}")
    public List<Employee> getEmployeesDepartment(@PathVariable("department") String department) {
        return employeeService.findAllByDepartment(department);
    }





}
