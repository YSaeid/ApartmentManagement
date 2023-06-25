package app.apartment.management.apartmentmanagement.swagger;

import app.apartment.management.apartmentmanagement.dto.user.get.UserDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetUserResponse {
    @Schema(example = "200")
    private int code;
    @Schema(example = "true")
    private boolean success;
    private List<UserDTO> data;
}
