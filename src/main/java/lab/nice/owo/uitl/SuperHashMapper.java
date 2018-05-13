package lab.nice.owo.uitl;

import java.util.Map;

import org.springframework.data.redis.hash.BeanUtilsHashMapper;
import org.springframework.data.redis.hash.DecoratingStringHashMapper;
import org.springframework.data.redis.hash.HashMapper;

public class SuperHashMapper<T, K, V> implements HashMapper<T, K, V> {
	private HashMapper<T, K, V> mapper;
	
	@SuppressWarnings("unchecked")
	public SuperHashMapper(Class<T> tClazz, Class<K> kClazz, Class<V> vClazz) {
		super();
		this.mapper = (HashMapper<T, K, V>) new DecoratingStringHashMapper<T>(new BeanUtilsHashMapper<T>(tClazz));
	}

	@Override
	public Map<K, V> toHash(T object) {
		Map<K, V> map = mapper.toHash(object);
		map.remove("class");
		return map;
	}

	@Override
	public T fromHash(Map<K, V> hash) {
		return mapper.fromHash(hash);
	}

}
