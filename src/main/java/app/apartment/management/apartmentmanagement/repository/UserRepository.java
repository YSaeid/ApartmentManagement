package app.apartment.management.apartmentmanagement.repository;

import app.apartment.management.apartmentmanagement.entity.ManagementUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<ManagementUser, UUID> {
}
