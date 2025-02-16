package me.finguide.finguide.Voice.service;

import lombok.RequiredArgsConstructor;
import me.finguide.finguide.Voice.domain.Voice;
import me.finguide.finguide.Voice.dto.AddVoiceRequest;
import me.finguide.finguide.Voice.repository.VoiceRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VoiceService {
    private final VoiceRepository voiceRepository;

    public Voice save(AddVoiceRequest request){
        return voiceRepository.save(request.toEntity());
    }
}
