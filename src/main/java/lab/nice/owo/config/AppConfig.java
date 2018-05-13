package lab.nice.owo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import lab.nice.owo.model.Post;
import lab.nice.owo.model.User;
import lab.nice.owo.uitl.SuperHashMapper;

@Configuration
public class AppConfig {

	@Bean
	public LettuceConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory(new RedisStandaloneConfiguration("localhost", 6379));
	}

	@Bean(name = "userRedisTemplate")
	RedisTemplate<String, User> getUserRedisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, User> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new FastJsonRedisSerializer<>(User.class));
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new StringRedisSerializer());
		return redisTemplate;
	}

	@Bean(name = "postRedisTemplate")
	RedisTemplate<String, Post> getPostRedisTemplate(RedisConnectionFactory connectionFactory) {
		RedisTemplate<String, Post> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(connectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new FastJsonRedisSerializer<>(User.class));
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new StringRedisSerializer());
		return redisTemplate;
	}

	@Bean(name = "userHashMapper")
	SuperHashMapper<User, String, String> getUserHashMapper() {
		return new SuperHashMapper<>(User.class, String.class, String.class);
	}

	@Bean(name = "postHashMapper")
	SuperHashMapper<Post, String, String> getPostHashMapper() {
		return new SuperHashMapper<>(Post.class, String.class, String.class);
	}

	@Bean
	public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory) {
		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
		stringRedisTemplate.setConnectionFactory(connectionFactory);
		return stringRedisTemplate;
	}
}
