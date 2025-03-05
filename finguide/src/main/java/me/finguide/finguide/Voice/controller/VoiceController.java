package me.finguide.finguide.Voice.controller;

import lombok.RequiredArgsConstructor;
import me.finguide.finguide.Guardian.dto.GuardianResponse;
import me.finguide.finguide.Voice.domain.Voice;
import me.finguide.finguide.Voice.dto.AddVoiceRequest;
import me.finguide.finguide.Voice.dto.VoiceResponse;
import me.finguide.finguide.Voice.service.VoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class VoiceController {
    private final VoiceService voiceService;
    //보이스 피싱 분석 요청 추가 예정 (람다)
    @PostMapping("/api/voice/upload")
    public ResponseEntity<Voice> addVoice(@RequestParam("file") MultipartFile file) {
        try {
            AddVoiceRequest request = new AddVoiceRequest(file);
            Voice savedVoice = voiceService.save(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedVoice);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // 예외 발생 시 500 응답
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(savedVoice);
        }
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
    @PostMapping("/api/prediction")
    public ResponseEntity<Map<String, Object>> receivePrediction(@RequestBody Map<String, Object> payload) {
        String prediction = (String) payload.get("prediction");

        System.out.println("Received Prediction:");
        System.out.println("Prediction: " + prediction);

        // 최근 업로드된 음성 파일의 score 업데이트
        Voice updatedVoice = voiceService.updateLatestPrediction(prediction);

        if (updatedVoice == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("status", "error", "message", "No voice file found to update"));
        }

        // 응답 JSON 생성
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("prediction", prediction);
        response.put("updated_voice", updatedVoice.getFile_path());

        return ResponseEntity.ok(response);
    }

}
