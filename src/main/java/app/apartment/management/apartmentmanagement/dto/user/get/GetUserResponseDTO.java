package app.apartment.management.apartmentmanagement.dto.user.get;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetUserResponseDTO {

    private List<UserDTO> userList;

}
