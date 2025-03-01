package me.finguide.finguide.Notice.domain;

import jakarta.persistence.*;
import lombok.*;
import me.finguide.finguide.Guardian.domain.Guardian;
import me.finguide.finguide.Voice.domain.Voice;

@Table(name = "notice")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "notice_id", updatable = false)
    private Long notice_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="voice_id", nullable = false)
    private Voice voice_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guardian_id", nullable = false)
    private Guardian guardian_id;

    @Builder
    public Notice(Voice voice_id, Guardian guardian_id){
        this.voice_id = voice_id;
        this.guardian_id = guardian_id;
    }

}
