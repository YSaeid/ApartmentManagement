package app.apartment.management.apartmentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ApartmentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApartmentManagementApplication.class, args);
    }

}
