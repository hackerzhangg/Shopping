package org.bigjava18.shop.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.User;
import org.bigjava18.shop.biz.UserBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨�û�����Action
 * @author zgp
 *
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<User>{
	
	//����Userʵ������
	private User user=new User();

	//ʹ��ģ��������װ����ֵ
	public User getModel() {
		
		return user;
	}
	
	//��AdminUserAction��ע��UserBiz
	private UserBiz userBiz;

	public void setUserBiz(UserBiz userBiz) {
		
		this.userBiz = userBiz;
	}
	
	//ʹ�����Է�װ����ǰ̨page
	private Integer page;
	
	public void setPage(Integer page) {
		
		this.page = page;
	}

	/**
	 * ���û��б�ҳ��
	 * @return
	 */
	public String userListPage() {
		
		//��ѯ�����û�
		PageBean<User> pageBean=userBiz.findAllUser(page);
		
		//����ѯ�����û����浽ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "userListPage";
	}
	
	/**
	 * ���û�����ҳ��
	 * @return
	 */
	public String updateUserPage() {
		
		User userData=userBiz.findByUid(user.getUid());
		
		//���û����ݱ��浽ֵ����
		ServletActionContext.getRequest().getSession().setAttribute("userData", userData);
		return "updateUserPage";
	}
	
	/**
	 * ͨ���û���id�����û�
	 * @return
	 */
	public String updateUser() {
		
		userBiz.updateUserInfo(user);
		
		return "updateUser";
	}
	
	/**
	 * ͨ���û���uidɾ���û�
	 * @return
	 */
	public String deleteUser() {
		
		User deleteUser=userBiz.findByUid(user.getUid());
		userBiz.deleteUser(deleteUser);
		
		return "deleteUser";
	}
	
}
