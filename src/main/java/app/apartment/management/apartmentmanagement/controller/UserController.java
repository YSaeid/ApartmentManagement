package app.apartment.management.apartmentmanagement.controller;

import app.apartment.management.apartmentmanagement.dto.user.add.AddUserRequestDTO;
import app.apartment.management.apartmentmanagement.dto.user.update.UpdateUserRequestDTO;
import app.apartment.management.apartmentmanagement.service.user.UserService;
import app.apartment.management.apartmentmanagement.swagger.AddUserResponse;
import app.apartment.management.apartmentmanagement.swagger.DeleteUserResponse;
import app.apartment.management.apartmentmanagement.swagger.GetUserResponse;
import app.apartment.management.apartmentmanagement.swagger.UpdateUserResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @ApiResponse(
            description = "Get List of Board User",
            responseCode = "200",
            content = {
                    @Content(
                            schema = @Schema(
                                    implementation = GetUserResponse.class
                            )
                    )
            }
    )
    @GetMapping
    public ResponseEntity<?> getUsers() {
        return service.getUser();
    }

    @ApiResponse(
            description = "Add New Board User",
            responseCode = "200",
            content = {
                    @Content(
                            schema = @Schema(
                                    implementation = AddUserResponse.class
                            )
                    )
            }
    )
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody AddUserRequestDTO request) {
        return service.addUser(request);
    }

    @ApiResponse(
            description = "Update Board User",
            responseCode = "200",
            content = {
                    @Content(
                            schema = @Schema(
                                    implementation = UpdateUserResponse.class
                            )
                    )
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable UUID id, @RequestBody UpdateUserRequestDTO request) {
        return service.updateUser(id, request);
    }

    @ApiResponse(
            description = "Update Board User",
            responseCode = "200",
            content = {
                    @Content(
                            schema = @Schema(
                                    implementation = DeleteUserResponse.class
                            )
                    )
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        return service.deleteUser(id);
    }
}
