package startergraphqlspringboot.graphql.input;

import startergraphqlspringboot.constant.Gender;
import startergraphqlspringboot.constant.LoginStatus;
import startergraphqlspringboot.constant.Provider;
import startergraphqlspringboot.constant.Role;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author : Code Prism
 * @created : 20/09/2022, Friday 17:43
 * @organisation : Code prism Technologies Pvt Ltd
 **/

@Data
public class UserInput {

    private Integer userId;
    @NotBlank(message = "display name can't be empty or null")
    private String displayName;
    @NotBlank(message = "firebase Id can't be empty or null")
    private String firebaseId;
    @Email(message = "Invalid email entered")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number entered")
    private String phoneNumber;
    @NotBlank(message = "date of birth can't be empty or null")
    private String dateOfBirth;
    private Gender gender;
    @NotBlank(message = "profile url can't be empty or null")
    private String profileUrl;
    private LoginStatus loginStatus;
    private Role role;
    private Provider provider;
    @NotNull(message = "language can't be null")
    private String language;
    @NotNull(message = "heart points can't be null")
    private Float heartPoints;
    @NotBlank(message = "state can't be empty or null")
    private String state;
    @NotBlank(message = "country can't be empty or null")
    private String country;
    @NotBlank(message = "city can't be empty or null")
    private String city;
    @NotBlank(message = "address can't be empty or null")
    private String address;
    @NotNull(message = "passportId can't be null")
    private String passportId;
    @NotNull(message = "taxId can't be null")
    private String taxId;
    @NotNull(message = "postalCode can't be null")
    private String postalId;
    @NotBlank(message = "timeZone can't be empty or null")
    private String timeZone;
    @NotNull(message = "cityZenShipCountry can't be null")
    private String cityZenShipCountry;
    private String createdAt;
    @NotBlank(message = "lastLogin can't be empty or null")
    private String lastLogin;

}
