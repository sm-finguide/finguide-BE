package me.finguide.finguide.Voice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.finguide.finguide.Voice.domain.Voice;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddVoiceRequest {
    private MultipartFile file_path;

    public Voice toEntity(String fileUrl){
        return Voice.builder()
                .file_path(fileUrl)
                .uploaded_at(LocalDateTime.now())
                .build();
    }
}
