package com.university.demo.service;

import com.university.demo.model.Lector;
import com.university.demo.repository.LectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectorService {

    private final LectorRepository lectorRepository;

    @Transactional(readOnly = true)
    public List<String> globalSearch(String template) {
        return lectorRepository.findAll().stream()
                .map(Lector::getName)
                .filter(name -> name.toLowerCase().contains(template.toLowerCase()))
                .collect(Collectors.toList());
    }
}
