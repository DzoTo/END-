package kz.singularity.bankappdelivery.Repository;

import kz.singularity.bankappdelivery.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);

    User findUserById(Long id);

}
