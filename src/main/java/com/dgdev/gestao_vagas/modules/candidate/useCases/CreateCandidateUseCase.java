package com.dgdev.gestao_vagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dgdev.gestao_vagas.exceptions.UserFoundException;
import com.dgdev.gestao_vagas.modules.candidate.CandidateEntity;
import com.dgdev.gestao_vagas.modules.candidate.CandidateRepository;


@Service
public class CreateCandidateUseCase {
    @Autowired
    private CandidateRepository candidateRepo;


    public CandidateEntity execute(CandidateEntity candidate) {
        this.candidateRepo
            .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
            .ifPresent((_) -> {
                throw new UserFoundException();
            });

        return this.candidateRepo.save(candidate);

    }
}
