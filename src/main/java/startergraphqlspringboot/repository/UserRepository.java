package startergraphqlspringboot.repository;

import startergraphqlspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author : Code Prism
 * @created : 20/09/2022, Friday 17:43
 * @organisation : Code prism Technologies Pvt Ltd
 **/

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByDisplayName(String displayName);
}
