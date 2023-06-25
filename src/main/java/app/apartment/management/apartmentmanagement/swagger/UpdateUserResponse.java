package app.apartment.management.apartmentmanagement.swagger;

import app.apartment.management.apartmentmanagement.dto.user.update.UpdateUserResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserResponse {
    @Schema(example = "200")
    private int code;
    @Schema(example = "true")
    private boolean success;
    private UpdateUserResponseDTO data;
}
