package lab.nice.owo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.TestCase;
import lab.nice.owo.dao.impl.UserDao;
import lab.nice.owo.model.User;
import lab.nice.owo.service.impl.UserIDService;
import lab.nice.owo.uitl.SuperHashMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:application-config.xml", "classpath*:spring-mvc.xml" })
@WebAppConfiguration
public class SpringRedisTest extends TestCase {
	@Autowired
	private RedisTemplate<String, User> userRedisTemplate;
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private UserIDService userIDService;
	@Autowired
	private UserDao userDao;

	@SuppressWarnings("unchecked")
	@Test
	public void test() {
		User user = new User("Admin");
		final Long uid = userIDService.nextID();
		user.setUid(String.valueOf(uid));
		userDao.save(user);
		System.out.println(userDao.findById(String.valueOf(uid)));
	}

}
