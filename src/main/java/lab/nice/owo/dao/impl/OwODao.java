package lab.nice.owo.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import lab.nice.owo.model.Post;
import lab.nice.owo.model.User;
import lab.nice.owo.uitl.SuperHashMapper;

@Repository(value = "owoDao")
public class OwODao {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, User> userRedisTemplate;

	@Autowired
	private SuperHashMapper<User, String, String> userHashMapper;

	@Autowired
	private RedisTemplate<String, Post> postRedisTemplate;

	@Autowired
	private SuperHashMapper<Post, String, String> postHashMapper;

	public StringRedisTemplate getStringRedisTemplate() {
		return stringRedisTemplate;
	}

	public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
		this.stringRedisTemplate = stringRedisTemplate;
	}

	public RedisTemplate<String, User> getUserRedisTemplate() {
		return userRedisTemplate;
	}

	public void setUserRedisTemplate(RedisTemplate<String, User> userRedisTemplate) {
		this.userRedisTemplate = userRedisTemplate;
	}

	public SuperHashMapper<User, String, String> getUserHashMapper() {
		return userHashMapper;
	}

	public void setUserHashMapper(SuperHashMapper<User, String, String> userHashMapper) {
		this.userHashMapper = userHashMapper;
	}

	public RedisTemplate<String, Post> getPostRedisTemplate() {
		return postRedisTemplate;
	}

	public void setPostRedisTemplate(RedisTemplate<String, Post> postRedisTemplate) {
		this.postRedisTemplate = postRedisTemplate;
	}

	public SuperHashMapper<Post, String, String> getPostHashMapper() {
		return postHashMapper;
	}

	public void setPostHashMapper(SuperHashMapper<Post, String, String> postHashMapper) {
		this.postHashMapper = postHashMapper;
	}

}
