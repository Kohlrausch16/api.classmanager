package com.classmanager.api.controllers;

import com.classmanager.api.entities.Language;
import com.classmanager.api.entities.exceptions.CustomNotFoundException;
import com.classmanager.api.repositories.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping
    public List<Language> getLanguages(){
        return languageRepository.findAll();
    }

    @GetMapping("{id}")
    public Language getLanguageById(@PathVariable UUID id){
        try{
            Optional<Language> language = languageRepository.findById(id);
            return language.get();
        } catch (NoSuchElementException e) {
            throw new CustomNotFoundException(id.toString());
        }
    }

    @PostMapping void postLanguage(Language language){
        languageRepository.save(language);
    }
}