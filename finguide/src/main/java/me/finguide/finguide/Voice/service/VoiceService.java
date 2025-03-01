package me.finguide.finguide.Voice.service;

import lombok.RequiredArgsConstructor;
import me.finguide.finguide.Guardian.domain.Guardian;
import me.finguide.finguide.Voice.domain.Voice;
import me.finguide.finguide.Voice.dto.AddVoiceRequest;
import me.finguide.finguide.Voice.repository.VoiceRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class VoiceService {
    private final VoiceRepository voiceRepository;
    private final S3Service s3Service;

    public Voice save(AddVoiceRequest request) throws IOException {
        //save()메서드에서 IOException 발생 가능성 있으므로 꼭 throws IOExceiption 추가
        // S3에 파일 업로드
        String fileUrl = s3Service.uploadFile(request.getFile_path());
        // DB에 저장 (S3 URL을 저장)
        return voiceRepository.save(request.toEntity(fileUrl));
    }

    public List<Voice> findAll(){
        return voiceRepository.findAll();
    }
}
