package me.finguide.finguide.Guardian.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class UpdateGuardianRequest {
    private String guardian_name;
    private String phone_number;
}
