package me.finguide.finguide.Guardian.domain;

import jakarta.persistence.*;
import lombok.*;
import me.finguide.finguide.Notice.domain.Notice;
import org.openapitools.jackson.nullable.JsonNullable;

import java.util.ArrayList;
import java.util.List;

@Table(name = "guardian")
@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "guardian_id", updatable = false)
    private Long guardian_id;

    @Column(name = "guardian_name", nullable = false)
    private String guardian_name;

    @Column (name = "phone_number", nullable = false)
    private String phone_number;

//    @OneToMany(mappedBy = "guardian", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Notice> notices = new ArrayList<>();

    @Builder
    public Guardian(String guardian_name,String phone_number){
        this.guardian_name = guardian_name;
        this.phone_number = phone_number;
    }

    public void update(String guardian_name, String phone_number){
        this.guardian_name = guardian_name;
        this.phone_number = phone_number;
    }


}
