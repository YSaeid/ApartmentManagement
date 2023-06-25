package app.apartment.management.apartmentmanagement.service.user;

import app.apartment.management.apartmentmanagement.dto.base.BaseResponse;
import app.apartment.management.apartmentmanagement.dto.user.add.AddUserRequestDTO;
import app.apartment.management.apartmentmanagement.dto.user.add.AddUserResponseDTO;
import app.apartment.management.apartmentmanagement.dto.user.delete.DeleteUserResponseDTO;
import app.apartment.management.apartmentmanagement.dto.user.get.GetUserResponseDTO;
import app.apartment.management.apartmentmanagement.dto.user.get.UserDTO;
import app.apartment.management.apartmentmanagement.dto.user.update.UpdateUserRequestDTO;
import app.apartment.management.apartmentmanagement.dto.user.update.UpdateUserResponseDTO;
import app.apartment.management.apartmentmanagement.entity.ManagementUser;
import app.apartment.management.apartmentmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<?> getUser() {

        List<UserDTO> userList = new ArrayList<>();

        repository.findAll().forEach(managementUser -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(managementUser.getId());
            userDTO.setFullName(managementUser.getFullName());
            userDTO.setPosition(managementUser.getPosition());
            userList.add(userDTO);
        });

        GetUserResponseDTO dto = new GetUserResponseDTO();
        dto.setUserList(userList);

        BaseResponse<GetUserResponseDTO> response = new BaseResponse<>();
        response.setCode(200);
        response.setSuccess(true);
        response.setData(dto);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> addUser(AddUserRequestDTO request) {

        BaseResponse<AddUserResponseDTO> response = new BaseResponse<>();

        if (request.getFullName() == null || request.getFullName().isEmpty()) {
            response.setSuccess(false);
            response.setCode(400);
            response.setMessage("مقدار نام و نام خانوادگی نمی تواند خالی باشد");
            return ResponseEntity.ok(response);
        }

        if (request.getPosition() == null || request.getPosition().isEmpty()) {
            response.setSuccess(false);
            response.setCode(400);
            response.setMessage("مقدار سمت هیئت مدیره نمی تواند خالی باشد");
            return ResponseEntity.ok(response);
        }

        ManagementUser managementUser = new ManagementUser();
        managementUser.setFullName(request.getFullName());
        managementUser.setPosition(request.getPosition());

        ManagementUser savedManagementUser = repository.save(managementUser);

        if (savedManagementUser.getId() != null) {
            response.setSuccess(true);
            response.setCode(200);
            response.setData(new AddUserResponseDTO());
            return ResponseEntity.ok(response);
        }

        response.setSuccess(false);
        response.setCode(500);
        response.setMessage("خطایی سمت سرور رخ داده است");

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<?> updateUser(UUID id, UpdateUserRequestDTO request) {

        BaseResponse<UpdateUserResponseDTO> response = new BaseResponse<>();

        if (id == null) {
            response.setSuccess(false);
            response.setCode(400);
            response.setMessage("مقدار id نمی تواند خالی باشد");
            return ResponseEntity.ok(response);
        }

        if (request.getFullName() == null || request.getFullName().isEmpty()) {
            response.setSuccess(false);
            response.setCode(400);
            response.setMessage("مقدار نام و نام خانوادگی نمی تواند خالی باشد");
            return ResponseEntity.ok(response);
        }

        if (request.getPosition() == null || request.getPosition().isEmpty()) {
            response.setSuccess(false);
            response.setCode(400);
            response.setMessage("مقدار سمت هیئت مدیره نمی تواند خالی باشد");
            return ResponseEntity.ok(response);
        }

        ManagementUser managementUser = repository.getReferenceById(id);
        managementUser.setFullName(request.getFullName());
        managementUser.setPosition(request.getPosition());

        ManagementUser savedManagementUser = repository.save(managementUser);

        if (savedManagementUser.getId() != null) {
            response.setSuccess(true);
            response.setCode(200);
            response.setData(new UpdateUserResponseDTO());
            return ResponseEntity.ok(response);
        }

        response.setSuccess(false);
        response.setCode(500);
        response.setMessage("خطایی سمت سرور رخ داده است");

        return ResponseEntity.ok(response);

    }

    @Override
    public ResponseEntity<?> deleteUser(UUID id) {

        BaseResponse<DeleteUserResponseDTO> response = new BaseResponse<>();

        if (id == null) {
            response.setSuccess(false);
            response.setCode(400);
            response.setMessage("مقدار id نمی تواند خالی باشد");
            return ResponseEntity.ok(response);
        }

        repository.deleteById(id);

        response.setSuccess(true);
        response.setCode(200);
        response.setData(new DeleteUserResponseDTO());
        return ResponseEntity.ok(response);
    }
}
