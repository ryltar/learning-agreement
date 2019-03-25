package com.fges.rizomm.m1iii.learningagreementAPI.repository.user;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.User;
import com.fges.rizomm.m1iii.learningagreementAPI.util.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(" select u from User u  where u.username = ?1")
	Optional<User> findUserWithName(String name);
	
	User findByUsername(String email);

	@Query(nativeQuery = true, value = "select * from users where id in (select id_user from roles where role = :role)" )
	List<User> findByCurrentRole(@Param("role") String role);

	@Query("select u from User u where u.token = ?1 and u.passHasBeenSet = false")
	User findByToken(String token);
}