package com.university.demo.repository;

import com.university.demo.model.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    @Query("""
               SELECT COUNT(l) FROM Lector l
               JOIN l.departments d
               WHERE d.name = :departmentName
            """)
    int countLectorsByDepartmentName(String departmentName);

    @Query("""
               SELECT AVG(l.salary) FROM Lector l
               JOIN l.departments d
               WHERE d.name = :departmentName
            """)
    double averageSalaryByDepartmentName(String departmentName);

    @Query("""
               SELECT l.degree, COUNT(l) FROM Lector l 
               JOIN l.departments d 
               WHERE d.name = :departmentName GROUP BY l.degree
            """)
    List<Object[]> getStatisticsByDepartmentName(String departmentName);

}
