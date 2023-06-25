package app.apartment.management.apartmentmanagement.service.user;

import app.apartment.management.apartmentmanagement.dto.user.add.AddUserRequestDTO;
import app.apartment.management.apartmentmanagement.dto.user.delete.DeleteUserRequestDTO;
import app.apartment.management.apartmentmanagement.dto.user.update.UpdateUserRequestDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface UserService {

    ResponseEntity<?> getUser();
    ResponseEntity<?> addUser(AddUserRequestDTO request);
    ResponseEntity<?> updateUser(UUID id, UpdateUserRequestDTO request);
    ResponseEntity<?> deleteUser(UUID id);

}
