package org.bigjava18.shop.bean;

/**
 * �û����Ա�
 * @author zgp
 *
 */
public class Message {
	
	private int id;				//����id
	private String message;		//��������

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		
		return "Message [id=" + id + ", message=" + message + "]";
	}
	
}
