package startergraphqlspringboot.exception;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;
import java.util.MissingResourceException;

/**
 * @author : Code Prism
 * @created : 20/09/2022, Friday 17:43
 * @organisation : Code prism Technologies Pvt Ltd
 **/

@Component
public class GraphQLExceptionHandler{

    @ExceptionHandler({GraphQLException.class, ConstraintViolationException.class, MissingResourceException.class, EntityNotFoundException.class, UserAlreadyExistException.class})
    public ThrowableGraphQLError exceptionHandler(Exception exception){
        return new ThrowableGraphQLError(exception);
    }

    @ExceptionHandler(RuntimeException.class)
    public ThrowableGraphQLError exceptionHandler(RuntimeException exception){
        return new ThrowableGraphQLError(exception, "Internal server error");
    }
}
