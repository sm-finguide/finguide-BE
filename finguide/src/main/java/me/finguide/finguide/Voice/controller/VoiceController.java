package me.finguide.finguide.Voice.controller;

import lombok.RequiredArgsConstructor;
import me.finguide.finguide.Guardian.dto.GuardianResponse;
import me.finguide.finguide.Voice.domain.Voice;
import me.finguide.finguide.Voice.dto.AddVoiceRequest;
import me.finguide.finguide.Voice.dto.VoiceResponse;
import me.finguide.finguide.Voice.service.VoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class VoiceController {
    private final VoiceService voiceService;
    //보이스 피싱 분석 요청 추가 예정 (람다)
    @PostMapping("/api/voice/upload")
    public ResponseEntity<Voice> addVoice(@RequestBody AddVoiceRequest request){
        Voice savedVoice = voiceService.save(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedVoice);
    }

    //모든 음성 파일 조회
    @GetMapping("/api/voice")
    public ResponseEntity<List<VoiceResponse>> findAllVoice(){
        List<VoiceResponse> voiceResponses = voiceService.findAll()
                .stream()
                .map(VoiceResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(voiceResponses);
    }
    

}
