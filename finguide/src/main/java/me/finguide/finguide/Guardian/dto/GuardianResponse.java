package me.finguide.finguide.Guardian.dto;

import lombok.Getter;
import me.finguide.finguide.Guardian.domain.Guardian;

@Getter
public class GuardianResponse {
    private final Long guardian_id;
    private final String guardian_name;
    private final String phone_number;

    public GuardianResponse(Guardian guardian){
        this.guardian_id = guardian.getGuardian_id();
        this.guardian_name = guardian.getGuardian_name();
        this.phone_number = guardian.getPhone_number();
    }
}
