package org.bigjava18.shop.bean;

/**
 * �̳Ǻ�̨����Աʵ����
 * @author zgp
 *
 */
public class AdminUser {
	
	private Integer uid;			//����Աuid
	private String username;		//����Ա����
	private String password;		//����Ա����

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminUser [uid=" + uid + ", username=" + username + ", password=" + password + "]";
	}
		
}
