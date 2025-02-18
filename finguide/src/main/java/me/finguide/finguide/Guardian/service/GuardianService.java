package me.finguide.finguide.Guardian.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import me.finguide.finguide.Guardian.domain.Guardian;
import me.finguide.finguide.Guardian.dto.AddGuardianRequest;
import me.finguide.finguide.Guardian.dto.UpdateGuardianRequest;
import me.finguide.finguide.Guardian.repository.GuardianRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GuardianService {
    private final GuardianRepository guardianRepository;

    public Guardian save(AddGuardianRequest request){
        return guardianRepository.save(request.toEntity());
    }

    public List<Guardian> findAll(){
        return guardianRepository.findAll();
    }

    public void delete(long id){
        guardianRepository.deleteById(id);
    }

    @Transactional
    public Guardian update(long id, UpdateGuardianRequest request){
        Guardian guardian = guardianRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("not found: " + id));

        String newGuardianName = request.getGuardian_name().orElse(guardian.getGuardian_name());
        String newPhoneNumber = request.getPhone_number().orElse(guardian.getPhone_number());

        guardian.update(newGuardianName, newPhoneNumber);

        return guardian;
    }
}
