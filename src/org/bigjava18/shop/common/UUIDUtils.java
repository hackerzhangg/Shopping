package org.bigjava18.shop.common;

import java.util.UUID;

/**
 * ��������ַ����Ĺ�����
 * @author zgp
 *
 */
public class UUIDUtils {
	
	/**
	 * ���������ַ���
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}

