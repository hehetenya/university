package com.university.demo.service;

import com.university.demo.model.Department;
import com.university.demo.repository.DepartmentRepository;
import com.university.demo.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final LectorRepository lectorRepository;

    @Transactional(readOnly = true)
    public String getHeadOfDepartment(String departmentName) {
        Department department = departmentRepository.findByName(departmentName);
        if (department != null && department.getHead() != null) {
            return "Head of " + departmentName + " department is " + department.getHead().getName();
        }
        return "Department or head not found";
    }

    @Transactional(readOnly = true)
    public Map<String, Long> getDepartmentStatistics(String departmentName) {
        return lectorRepository.getStatisticsByDepartmentName(departmentName).stream()
                .collect(Collectors.toMap(array -> array[0].toString(), array -> (Long) array[1]));
    }

    @Transactional(readOnly = true)
    public double getAverageSalary(String departmentName) {
        return lectorRepository.averageSalaryByDepartmentName(departmentName);
    }

    @Transactional(readOnly = true)
    public int getEmployeeCount(String departmentName) {
        return lectorRepository.countLectorsByDepartmentName(departmentName);
    }
}
