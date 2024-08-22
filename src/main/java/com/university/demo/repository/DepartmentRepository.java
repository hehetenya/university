package com.university.demo.repository;


import com.university.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    @Query("""
               SELECT d FROM Department d WHERE d.name = :name 
            """)
    Department findByName(String name);
}
