package lab.nice.owo.model;

import java.io.Serializable;

public class Post implements Serializable{

	private static final long serialVersionUID = -4754787338126101142L;
	
	private String pid;
	private String uid;
	private String content;
	private String time = String.valueOf(System.currentTimeMillis());
	private String replyToPid;

	public Post() {
		super();
	}

	public Post(String uid, String content) {
		super();
		this.uid = uid;
		this.content = content;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getReplyToPid() {
		return replyToPid;
	}

	public void setReplyToPid(String replyToPid) {
		this.replyToPid = replyToPid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result + ((replyToPid == null) ? 0 : replyToPid.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		Post other = (Post) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		if (replyToPid == null) {
			if (other.replyToPid != null)
				return false;
		} else if (!replyToPid.equals(other.replyToPid))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
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
		return "Post [pid=" + pid + ", uid=" + uid + ", content=" + content + ", time=" + time + ", replyToPid="
				+ replyToPid + "]";
	}

}
