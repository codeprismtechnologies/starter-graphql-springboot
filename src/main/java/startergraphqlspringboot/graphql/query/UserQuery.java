package startergraphqlspringboot.graphql.query;

import startergraphqlspringboot.entity.User;
import startergraphqlspringboot.service.UserService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : Code Prism
 * @created : 20/09/2022, Friday 17:43
 * @organisation : Code prism Technologies Pvt Ltd
 **/

@Component
@Slf4j
public class UserQuery implements GraphQLQueryResolver {

    @Autowired
    private UserService userService;

    public List<User> getAllUser(Integer count) {
        log.info("Entered into UserQuery(getAllUser). User requested count was {} ",count);
        return this.userService.getAllUser(count);
    }

    public User getUser(Integer userId) {
        log.info("Entered into UserQuery(getUser). Requested user Id was {}", userId);
        return this.userService.getUser(userId);
    }
}
