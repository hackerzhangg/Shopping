package org.bigjava18.shop.bean;

/**
 * ÓÃ»§ÁôÑÔ±í
 * @author zgp
 *
 */
public class Message {
	
	private int id;				//ÁôÑÔid
	private String message;		//ÁôÑÔÄÚÈİ

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
