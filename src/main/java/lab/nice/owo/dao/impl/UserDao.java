package lab.nice.owo.dao.impl;

import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.stereotype.Repository;

import lab.nice.owo.dao.IUserDao;
import lab.nice.owo.model.User;
import lab.nice.owo.uitl.KeyUitls;

@Repository
public class UserDao implements IUserDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDao.class);
	@Autowired
	private OwODao owoDao;

	@Override
	public <S extends User> void save(S entity) {
		Map<String, String> map = owoDao.getUserHashMapper().toHash(entity);
		owoDao.getUserRedisTemplate().boundHashOps(KeyUitls.uid(entity.getUid())).putAll(map);
	}

	@Override
	public <S extends User> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<User> findById(String id) {
		BoundHashOperations<String, String, String> userOps = owoDao.getUserRedisTemplate().boundHashOps(KeyUitls.uid(id));
		Map<String, String> map = userOps.entries();
		return Optional.of(owoDao.getUserHashMapper().fromHash(map));
	}

	@Override
	public boolean existsById(String id) {
		return owoDao.getUserRedisTemplate().hasKey(KeyUitls.uid(id));
	}

	@Override
	public Iterable<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<User> findAllById(Iterable<String> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends User> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
