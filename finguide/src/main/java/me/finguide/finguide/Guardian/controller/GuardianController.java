package me.finguide.finguide.Guardian.controller;

import lombok.RequiredArgsConstructor;
import me.finguide.finguide.Guardian.domain.Guardian;
import me.finguide.finguide.Guardian.dto.AddGuardianRequest;
import me.finguide.finguide.Guardian.dto.GuardianResponse;
import me.finguide.finguide.Guardian.dto.UpdateGuardianRequest;
import me.finguide.finguide.Guardian.service.GuardianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class GuardianController {
    private final GuardianService guardianService;

    @PostMapping("/api/guardian/register")
    public ResponseEntity<Guardian> addGuardian(@RequestBody AddGuardianRequest request){
        Guardian savedGuardian = guardianService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedGuardian);
    }

    @GetMapping("/api/guardian")
    public ResponseEntity<List<GuardianResponse>> findAllGuardian(){
        List<GuardianResponse> guardianResponses = guardianService.findAll()
                .stream()
                .map(GuardianResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(guardianResponses);
    }

    @DeleteMapping("/api/guardian/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") long id){
        guardianService.delete(id);

        return ResponseEntity.ok()
                .build();
    }

    @PutMapping("/api/guardian/modification/{id}")
    public ResponseEntity<Guardian> updateGuardian(@PathVariable("id") long id, @RequestBody UpdateGuardianRequest request){
        Guardian updateGuardian = guardianService.update(id, request);

        return ResponseEntity.ok()
                .body(updateGuardian);
    }

}
