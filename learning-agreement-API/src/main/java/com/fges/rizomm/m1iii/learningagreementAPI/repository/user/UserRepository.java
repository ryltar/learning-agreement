package com.fges.rizomm.m1iii.learningagreementAPI.repository.user;

import java.util.List;
import java.util.Optional;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(" select u from User u  where u.username = ?1")
	Optional<User> findUserWithName(String name);

	List<User> findByPlaceId(Long idPlace);

	User findByUsername(String email);

	@Query("select u from User u where u.token = ?1 and u.passHasBeenSet = false")
	User findByToken(String token);
}