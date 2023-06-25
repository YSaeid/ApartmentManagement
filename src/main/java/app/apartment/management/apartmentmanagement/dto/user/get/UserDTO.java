package app.apartment.management.apartmentmanagement.dto.user.get;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserDTO {

    private UUID id;
    @Schema(example = "محمد عرفان کرمی")
    private String fullName;
    @Schema(example = "هیئت مدیره")
    private String position;

}
