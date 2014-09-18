package se.radley.domain.repository;

import se.radley.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryCustom {

	public Optional<User> findByLogin(String login);

	public List<User> findActive();

}
