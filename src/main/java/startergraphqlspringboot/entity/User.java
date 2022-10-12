package startergraphqlspringboot.entity;

import startergraphqlspringboot.constant.Gender;
import startergraphqlspringboot.constant.LoginStatus;
import startergraphqlspringboot.constant.Provider;
import startergraphqlspringboot.constant.Role;
import startergraphqlspringboot.graphql.input.UserInput;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;

/**
 * @author : Code Prism
 * @created : 20/09/2022, Friday 17:43
 * @organisation : Code prism Technologies Pvt Ltd
 **/
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String displayName;
    private String firebaseId;
    private String email;
    private String phoneNumber;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String profileUrl;
    private LoginStatus loginStatus;
    private Role role;
    private Provider provider;
    private String language;
    private Float heartPoints;
    private String state;
    private String country;
    private String city;
    private String address;
    private String passportId;
    private String taxId;
    private String postalId;
    private String timeZone;
    private String cityZenShipCountry;
    private OffsetDateTime createdAt;
    private OffsetDateTime lastLogin;

    public static User valueOf(UserInput userInput){
        return builder()
                .displayName(userInput.getDisplayName())
                .firebaseId(userInput.getFirebaseId())
                .email(userInput.getEmail())
                .phoneNumber(userInput.getPhoneNumber())
                .gender(userInput.getGender())
                .profileUrl(userInput.getProfileUrl())
                .loginStatus(userInput.getLoginStatus())
                .role(userInput.getRole())
                .provider(userInput.getProvider())
                .heartPoints(userInput.getHeartPoints())
                .state(userInput.getState())
                .country(userInput.getCountry())
                .city(userInput.getCity())
                .address(userInput.getAddress())
                .passportId(userInput.getPassportId())
                .taxId(userInput.getTaxId())
                .postalId(userInput.getPostalId())
                .timeZone(userInput.getTimeZone())
                .cityZenShipCountry(userInput.getCityZenShipCountry())
                .createdAt(OffsetDateTime.now(ZoneId.of("Etc/UTC")))
                .build();
    }
}
