package me.finguide.finguide.Guardian.service;

import lombok.RequiredArgsConstructor;
import me.finguide.finguide.Guardian.domain.Guardian;
import me.finguide.finguide.Guardian.dto.AddGuardianRequest;
import me.finguide.finguide.Guardian.repository.GuardianRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GuardianService {
    private final GuardianRepository guardianRepository;

    public Guardian save(AddGuardianRequest request){
        return guardianRepository.save(request.toEntity());
    }
}
