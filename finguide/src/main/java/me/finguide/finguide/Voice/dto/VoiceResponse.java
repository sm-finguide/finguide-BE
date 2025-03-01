package me.finguide.finguide.Voice.dto;

import lombok.Getter;
import me.finguide.finguide.Guardian.domain.Guardian;
import me.finguide.finguide.Voice.domain.Voice;

import java.time.LocalDateTime;

@Getter
public class VoiceResponse {
    private final Long voice_id;
    private final String file_path;
    private final Double score;
    private final LocalDateTime uploaded_at;

    public VoiceResponse(Voice voice){
        this.voice_id = voice.getVoice_id();
        this.file_path = voice.getFile_path();
        this.score = voice.getScore();
        this.uploaded_at = voice.getUploaded_at();
    }
}
