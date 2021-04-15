package org.bigjava18.shop.bean;

/**
 * 商城后台管理员实体类
 * @author zgp
 *
 */
public class AdminUser {
	
	private Integer uid;			//管理员uid
	private String username;		//管理员名称
	private String password;		//管理员密码

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
