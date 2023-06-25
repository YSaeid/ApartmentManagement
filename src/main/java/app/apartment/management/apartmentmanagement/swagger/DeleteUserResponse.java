package app.apartment.management.apartmentmanagement.swagger;

import app.apartment.management.apartmentmanagement.dto.user.delete.DeleteUserResponseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteUserResponse {
    @Schema(example = "200")
    private int code;
    @Schema(example = "true")
    private boolean success;
    private DeleteUserResponseDTO data;
}
