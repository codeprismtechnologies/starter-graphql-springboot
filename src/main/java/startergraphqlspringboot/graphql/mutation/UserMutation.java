package startergraphqlspringboot.graphql.mutation;

import startergraphqlspringboot.entity.User;
import startergraphqlspringboot.graphql.input.UserInput;
import startergraphqlspringboot.service.UserService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

/**
 * @author : Code Prism
 * @created : 20/09/2022, Friday 17:43
 * @organisation : Code prism Technologies Pvt Ltd
 **/

@Slf4j
@Component
@Validated
public class UserMutation implements GraphQLMutationResolver {

    @Autowired
    private UserService userService;

    public User signUp(@Valid UserInput input) {
        log.info("Entered into UserMutation(signUp). User Input was :: {}", input);
        return this.userService.signUp(input);
    }

    public User updateSignUp(@Valid UserInput userInput){
        log.info("Entered into UserMutation(updateSignUp). Requested userId was :: {} ",userInput.getUserId());
        return this.userService.updateSignUp(userInput);
    }

    public String deleteUser(Integer userId){
        log.info("Entered into UserMutation(deleteUser). Requested userId was :: {} ",userId);
        return this.userService.deleteUser(userId);
    }
}
