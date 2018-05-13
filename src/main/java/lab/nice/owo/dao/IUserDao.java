package lab.nice.owo.dao;

import java.util.HashMap;
import java.util.Map;

import lab.nice.owo.model.User;

public interface IUserDao extends CrudDao<User, String> {
	default String getKey(User user){
		return String.format("uid:%s", user.getUid());
	}
	
	default String getKey(String uid){
		return String.format("uid:%s", uid);
	}
	
	default Map<String, String> getValue(User user){
		Map<String, String> values = new HashMap<>();
		values.put("name", user.getName());
		return values;
	}
	
	default User mapToUser(String uid, Map<String, String> values){
		return new User(uid, values.getOrDefault("name", null));
	}
}
