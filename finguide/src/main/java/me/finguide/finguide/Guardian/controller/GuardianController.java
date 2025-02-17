package me.finguide.finguide.Guardian.controller;

import lombok.RequiredArgsConstructor;
import me.finguide.finguide.Guardian.domain.Guardian;
import me.finguide.finguide.Guardian.dto.AddGuardianRequest;
import me.finguide.finguide.Guardian.service.GuardianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GuardianController {
    private final GuardianService guardianService;

    @PostMapping("api/guardian/register")
    public ResponseEntity<Guardian> addGuardian(@RequestBody AddGuardianRequest request){
        Guardian savedGuardian = guardianService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedGuardian);
    }

}
