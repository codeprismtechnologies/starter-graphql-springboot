package startergraphqlspringboot.service;

import startergraphqlspringboot.entity.User;
import startergraphqlspringboot.exception.UserAlreadyExistException;
import startergraphqlspringboot.graphql.input.UserInput;
import startergraphqlspringboot.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.time.*;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : Code Prism
 * @created : 20/09/2022, Friday 17:43
 * @organisation : Code prism Technologies Pvt Ltd
 **/

@Slf4j
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * This method will create new entry to user DB table
     * @param input {@link UserInput}
     * @return {@link User}
     */
    @Transactional
    public User signUp(UserInput input) throws UserAlreadyExistException {
        log.info("Entered into signUp service method. user displayName was :: {} ", input.getDisplayName());
        // Step 1 : Java locale object created to validate language and country
        Locale locale = new Locale(input.getLanguage(),input.getCountry());
        // Step 2 : converting requested user input to user entity
        User newUser = User.valueOf(input);
        newUser.setDateOfBirth(LocalDate.parse(input.getDateOfBirth()));
        newUser.setLanguage(locale.getISO3Language().toUpperCase());
        newUser.setCountry(locale.getISO3Country());
        newUser.setLastLogin(Timestamp.valueOf(input.getLastLogin()).toLocalDateTime().atZone(ZoneId.of( "Etc/UTC" )).toOffsetDateTime());
        // Step 3 : saving new user in DB
        User savedUser;
        if (!userRepository.existsByDisplayName(input.getDisplayName())) {
            savedUser = userRepository.save(newUser);
        } else {
            log.error("User already exist in DB. user name was :: {} ", input.getDisplayName());
            throw new UserAlreadyExistException("User already exist in DB. requested user name was :: " + input.getDisplayName());
        }
        log.info("User details was saved successfully. saved user details was :: {} ",savedUser);
        // Step 4 : returning user saved details
        return savedUser;
    }

    /**
     * This method used get whole user list
     * @param count
     * @return {@link List<User>}
     */
    @Transactional(readOnly = true)
    public List<User> getAllUser(Integer count) {
        log.info("Entered into getAllUser service method. user requested count was :: {} ",count);
        return this.userRepository.findAll().stream().limit(count).collect(Collectors.toList());
    }

    /**
     * This method used to get single user details
     * @param userId
     * @return {@link User
     */
    @Transactional(readOnly = true)
    public User getUser(Integer userId) {
        log.info("Entered into getUser service method. Requested user Id was :: {} ",userId);
        return this.userRepository.findById(Long.valueOf(userId)).orElseThrow(() -> new EntityNotFoundException("could not found user details in DB for requested userId "+userId));
    }

    /**
     * This method used to update user details if exist in DB or else signUp
     * @param userInput {@link UserInput}
     * @return {@link User}
     */
    @Transactional
    public User updateSignUp(UserInput userInput) {
        log.info("Entered into updateSignUp. requested userId was :: {} ",userInput.getUserId());
        // Step 1 : validating user Id in DB
        return userRepository.findById(Long.valueOf(userInput.getUserId())).map(user -> {
            // Step 2 : updating existing user object to new updated object
            user.setDisplayName(userInput.getDisplayName());
            user.setEmail(userInput.getEmail());
            user.setPhoneNumber(userInput.getPhoneNumber());
            user.setAddress(userInput.getAddress());
            user.setCity(userInput.getCity());
            user.setState(userInput.getState());
            user.setCountry(userInput.getCountry());
            user.setDateOfBirth(LocalDate.parse(userInput.getDateOfBirth()));
            user.setGender(userInput.getGender());
            user.setProfileUrl(userInput.getProfileUrl());
            user.setCreatedAt(OffsetDateTime.now(ZoneOffset.UTC));
            user.setLanguage(userInput.getLanguage());
            user.setCityZenShipCountry(userInput.getCityZenShipCountry());
            user.setHeartPoints(userInput.getHeartPoints());
            user.setLastLogin(Timestamp.valueOf(userInput.getLastLogin()).toLocalDateTime().atOffset(ZoneOffset.UTC));
            user.setProvider(userInput.getProvider());
            user.setRole(userInput.getRole());
            user.setLoginStatus(userInput.getLoginStatus());
            user.setTaxId(userInput.getTaxId());
            user.setTimeZone(userInput.getTimeZone());
            user.setPostalId(userInput.getPostalId());
            user.setPassportId(userInput.getPassportId());
            user.setHeartPoints(userInput.getHeartPoints());
            // Step 3 : saving updated user details in DB
            return userRepository.save(user);
            // Step 4 : else making new entry to DB
        }).orElseGet(() -> this.signUp(userInput));
    }

    /**
     * This method used to delete user details in DB
     * @param userId
     * @return {@link String}
     */
    @Transactional
    public String deleteUser(Integer userId){
        log.info("Entered into deleteUser service method. userId was :: {} ",userId);
        Optional<User> user = userRepository.findById(Long.valueOf(userId));
        if (user.isPresent()){
            userRepository.delete(user.get());
            return "User deleted successfully in DB. for this userId :: "+ userId +" !";
        } else {
            return "Could not found requested userId :: "+userId+" !";
        }
    }
}
