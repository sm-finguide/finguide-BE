package me.finguide.finguide.Guardian.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.openapitools.jackson.nullable.JsonNullable;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class UpdateGuardianRequest {
    private JsonNullable<String> guardian_name = JsonNullable.undefined();
    private JsonNullable<String> phone_number = JsonNullable.undefined();
}
