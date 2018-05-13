package lab.nice.owo.model;

import java.io.Serializable;
import java.util.Set;

import lab.nice.owo.common.FollowType;

public class Follow implements Serializable {
	
	private static final long serialVersionUID = -1740803664901161838L;
	
	private String uid;
	private FollowType type;
	private Set<String> follows;

	public Follow() {
		super();
	}

	public Follow(String uid, FollowType type) {
		super();
		this.uid = uid;
		this.type = type;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public FollowType getType() {
		return type;
	}

	public void setType(FollowType type) {
		this.type = type;
	}

	public Set<String> getFollows() {
		return follows;
	}

	public void setFollows(Set<String> follows) {
		this.follows = follows;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((follows == null) ? 0 : follows.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Follow other = (Follow) obj;
		if (follows == null) {
			if (other.follows != null)
				return false;
		} else if (!follows.equals(other.follows))
			return false;
		if (type != other.type)
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Follow [uid=" + uid + ", type=" + type + ", follows=" + follows + "]";
	}

}
