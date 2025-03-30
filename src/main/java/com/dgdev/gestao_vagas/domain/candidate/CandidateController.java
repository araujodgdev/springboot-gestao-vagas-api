package com.dgdev.gestao_vagas.domain.candidate;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/")
    public String create(@RequestBody CandidateEntity candidate) {

       return(" Candidado: " + candidate.getName() + ".");
    }
}
