package me.finguide.finguide.Voice.domain;

import jakarta.persistence.*;
import lombok.*;
import me.finguide.finguide.Notice.domain.Notice;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Voice {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    @Column(name = "voice_id", updatable = false)
    private Long voice_id;

    @Column(name = "file_path", nullable = false)
    private String file_path;

    @Column(name = "score", nullable = false)
    private Double score;

    @CreatedDate
    @Column(name = "uploaded_at", nullable = false)
    private LocalDateTime uploaded_at = LocalDateTime.now();

//    @OneToMany(mappedBy = "voice", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Notice> notices = new ArrayList<>();

    @Builder
    public Voice(String file_path, Double score, LocalDateTime uploaded_at){
        this.file_path = file_path;
        this.score = score;
        this.uploaded_at = uploaded_at;
    }


}
