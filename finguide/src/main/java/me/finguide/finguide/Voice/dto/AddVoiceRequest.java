package me.finguide.finguide.Voice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.finguide.finguide.Voice.domain.Voice;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddVoiceRequest {
    private String file_path;
    private Double score;

    public Voice toEntity(){
        return Voice.builder()
                .file_path(file_path)
                .score(score)
                .uploaded_at(LocalDateTime.now())
                .build();
    }
}
