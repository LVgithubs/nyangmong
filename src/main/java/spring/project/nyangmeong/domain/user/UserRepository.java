package spring.project.nyangmeong.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserByEmail(String email);

    User findUserById(Long id);

    @Query(value = "SELECT * FROM user WHERE username = :username AND password = :password", nativeQuery = true)
    User mLogin(@Param("username") String username, @Param("password") String password);

    // PlaceLikes findPlaceLikesByBoardsAndUser(Boards boards, User user);

    boolean existsByusername(String username);

    // @Modifying
    // @Query(value = "UPDATE user SET password = :password, email = :email, addr =
    // :addr WHERE id = :id", nativeQuery = true)
    // void mUpdate(@Param("password") String password, @Param("email") String
    // email, @Param("addr") String addr, @Param("id") Integer id);
}