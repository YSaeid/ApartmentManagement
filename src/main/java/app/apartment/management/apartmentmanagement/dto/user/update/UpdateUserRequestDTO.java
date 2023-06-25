package app.apartment.management.apartmentmanagement.dto.user.update;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestDTO {

    @Schema(example = "محمد عرفان کرمی")
    private String fullName;
    @Schema(example = "هیئت مدیره")
    private String position;

}
