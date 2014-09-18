package se.radley.domain.repository;

import com.mysema.query.jpa.impl.JPAQuery;
import se.radley.domain.model.QUser;
import se.radley.domain.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepositoryCustom {

	private final QUser qUser =  new QUser("u");

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Optional<User> findByLogin(String login) {
		JPAQuery query = new JPAQuery(entityManager);
		User user = query
			.from(qUser)
			.where(
				qUser.locked.isFalse(),
				qUser.login.equalsIgnoreCase(login)
			)
			.singleResult(qUser);

		return Optional.ofNullable(user);
	}

	@Override
	public List<User> findActive() {
		JPAQuery query = new JPAQuery(entityManager);

		return query
			.from(qUser)
			.where(
				qUser.locked.isFalse()
			)
			.list(qUser);
	}
}
