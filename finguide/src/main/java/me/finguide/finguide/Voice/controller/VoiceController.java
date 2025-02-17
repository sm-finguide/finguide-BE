package me.finguide.finguide.Voice.controller;

import lombok.RequiredArgsConstructor;
import me.finguide.finguide.Voice.domain.Voice;
import me.finguide.finguide.Voice.dto.AddVoiceRequest;
import me.finguide.finguide.Voice.service.VoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class VoiceController {
    private final VoiceService voiceService;

    @PostMapping("/api/voice/upload")
    public ResponseEntity<Voice> addVoice(@RequestBody AddVoiceRequest request){
        Voice savedVoice = voiceService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedVoice);
    }

}
