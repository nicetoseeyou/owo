package lab.nice.owo.model;

import java.io.Serializable;
import java.util.Set;

import lab.nice.owo.common.TimelineType;

public class Timeline implements Serializable{

	private static final long serialVersionUID = -8878466540121574977L;
	private String tid;
	private String uid;
	private TimelineType type;
	private Set<String> posts;

	public Timeline() {
		super();
	}

	public Timeline(String uid, TimelineType type) {
		super();
		this.uid = uid;
		this.type = type;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public TimelineType getType() {
		return type;
	}

	public void setType(TimelineType type) {
		this.type = type;
	}

	public Set<String> getPosts() {
		return posts;
	}

	public void setPosts(Set<String> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((posts == null) ? 0 : posts.hashCode());
		result = prime * result + ((tid == null) ? 0 : tid.hashCode());
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
		Timeline other = (Timeline) obj;
		if (posts == null) {
			if (other.posts != null)
				return false;
		} else if (!posts.equals(other.posts))
			return false;
		if (tid == null) {
			if (other.tid != null)
				return false;
		} else if (!tid.equals(other.tid))
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
		return "Timeline [tid=" + tid + ", uid=" + uid + ", type=" + type + ", posts=" + posts + "]";
	}

}
