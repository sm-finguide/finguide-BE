package me.finguide.finguide.Guardian.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.finguide.finguide.Guardian.domain.Guardian;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddGuardianRequest {
    private String guardian_name;
    private String phone_number;

    public Guardian toEntity(){
        return Guardian.builder()
                .guardian_name(guardian_name)
                .phone_number(phone_number)
                .build();
    }
}
