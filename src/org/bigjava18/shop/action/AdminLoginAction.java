package org.bigjava18.shop.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.bigjava18.shop.bean.AdminUser;
import org.bigjava18.shop.bean.Message;
import org.bigjava18.shop.biz.AdminLoginBiz;
import org.bigjava18.shop.biz.MessageBiz;
import org.bigjava18.shop.biz.ProductBiz;
import org.bigjava18.shop.biz.UserBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * �̳Ǻ�̨����Ա��¼Action
 * @author zgp
 *
 */
public class AdminLoginAction extends ActionSupport implements ModelDriven<AdminUser>{
	
	//����AdminUserʵ������
	private AdminUser adminUser=new AdminUser();
	
	//ʹ��ģ����������ǰ̨�ı�ֵ
	@Override
	public AdminUser getModel() {
		
		return adminUser;
	}
	
	//��AdminLoginAction��ע��AdminLoginBiz
	private AdminLoginBiz adminLoginBiz;

	//����adminLoginBiz��set����
	public void setAdminLoginBiz(AdminLoginBiz adminLoginBiz) {
		
		this.adminLoginBiz = adminLoginBiz;
	}
	
	private UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		
		this.userBiz = userBiz;
	}
	
	private ProductBiz productBiz;
	
	public void setProductBiz(ProductBiz productBiz) {
		
		this.productBiz = productBiz;
	}
	
	//��AdminLoginActionע��messageBiz
	private MessageBiz messageBiz;
	
	public void setMessageBiz(MessageBiz messageBiz) {
		
		this.messageBiz = messageBiz;
	}

	/**
	 * ����̨�û���¼ҳ��
	 * @return
	 */
	public String adminUserLoginPage() {
		
		//��̨��ѯ��Ʒ������
		int productCount=productBiz.adminProductCount();
		
		//����ֵջ
		ActionContext.getContext().getSession().put("productCount", productCount);
		
		//��̨��ѯ�û�������
		int userCount=userBiz.adminUserCount();
		
		//����ֵջ
		ActionContext.getContext().getSession().put("userCount", userCount);
		
		//��̨��ѯ�����û�������Ϣ
		List<Message> messages=messageBiz.findAllMessage();
		System.out.println("�û�������ϢΪ��"+messages);
		
		//����ֵջ
		ActionContext.getContext().getSession().put("messages", messages);
		
		return "adminUserLoginPage";
	}
	
	/**
	 * ����Ա�û���¼
	 * @return
	 */
	public String adminLogin() {
		
		//����Bizʵ�ֹ���Ա��¼
		AdminUser admin=adminLoginBiz.adminLogin(adminUser);
		
		if(admin == null) {
			
			this.addActionError("����Ա�û������ڣ����������룡");
			return "adminFile";
		}else {
			
			//����Ա�û���¼�ɹ������û����뵽sessionֵ����
			ServletActionContext.getRequest().getSession().setAttribute("admin", admin);			
			return "adminLogin";
		}
	}
	
	/**
	 * ������Ա����Ϣҳ��
	 * @return
	 */
	public String adminInfoPage() {
		
		//ͨ������Ա��uid��ѯ����
		AdminUser admin=adminLoginBiz.adminInfoPage(adminUser.getUid());
		
		//����ֵջ��
		ActionContext.getContext().getValueStack().set("admin", admin);
		
		return "adminInfoPage";
	}
	
	/**
	 * ���¹���Ա��Ϣ
	 * @return
	 */
	public String updateAdminUser() {
		
		adminLoginBiz.updateAdminUser(adminUser);	
		
		//����session
		ServletActionContext.getRequest().getSession().invalidate();
		
		return "updateAdminUser";
	}
	
	/**
	 * ����Ա�˳���¼
	 * @return
	 */
	public String adminQuitLogin() {
		
		//����session
		ServletActionContext.getRequest().getSession().invalidate();
		
		//�ص���¼ҳ��
		return "adminQuitLogin";
	}
	
}
