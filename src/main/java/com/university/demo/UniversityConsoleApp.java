package com.university.demo;

import com.university.demo.service.DepartmentService;
import com.university.demo.service.LectorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class UniversityConsoleApp implements CommandLineRunner {

    private final DepartmentService departmentService;
    private final LectorService lectorService;

    public UniversityConsoleApp(DepartmentService departmentService, LectorService lectorService) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);
        String command;

        while (true) {
            System.out.println("Please enter a command:");
            command = scanner.nextLine();

            if (command.startsWith("Who is head of department")) {
                handleHeadOfDepartment(command);
            } else if (command.startsWith("Show") && command.endsWith("statistics")) {
                handleDepartmentStatistics(command);
            } else if (command.startsWith("Show the average salary for the department")) {
                handleAverageSalary(command);
            } else if (command.startsWith("Show count of employee for")) {
                handleEmployeeCount(command);
            } else if (command.startsWith("Global search by")) {
                handleGlobalSearch(command);
            } else if (command.equalsIgnoreCase("exit")) {
                break;
            } else {
                System.out.println("Unknown command. Please try again.");
            }
        }

        scanner.close();
    }

    private void handleHeadOfDepartment(String command) {
        String departmentName = command.replace("Who is head of department", "").trim();
        String result = departmentService.getHeadOfDepartment(departmentName);
        System.out.println(result);
    }

    private void handleDepartmentStatistics(String command) {
        String departmentName = command.replace("Show", "").replace("statistics", "").trim();
        var stats = departmentService.getDepartmentStatistics(departmentName);
        if (stats != null) {
            System.out.println("assistants - " + stats.getOrDefault("ASSISTANT", 0L));
            System.out.println("associate professors - " + stats.getOrDefault("ASSOCIATE_PROFESSOR", 0L));
            System.out.println("professors - " + stats.getOrDefault("PROFESSOR", 0L));
        } else {
            System.out.println("Department not found.");
        }
    }


    private void handleAverageSalary(String command) {
        String departmentName = command.replace("Show the average salary for the department", "").trim();
        double avgSalary = departmentService.getAverageSalary(departmentName);
        System.out.printf("The average salary of %s is %.2f%n", departmentName, avgSalary);
    }

    private void handleEmployeeCount(String command) {
        String departmentName = command.replace("Show count of employee for", "").trim();
        int count = departmentService.getEmployeeCount(departmentName);
        System.out.printf("Employee count for %s: %d%n", departmentName, count);
    }

    private void handleGlobalSearch(String command) {
        String template = command.replace("Global search by", "").trim();
        var results = lectorService.globalSearch(template);
        if (!results.isEmpty()) {
            System.out.println(String.join(", ", results));
        } else {
            System.out.println("No results found.");
        }
    }
}
