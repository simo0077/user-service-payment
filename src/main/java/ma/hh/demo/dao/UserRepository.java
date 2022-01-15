package ma.hh.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.hh.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
