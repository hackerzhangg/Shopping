package org.bigjava18.shop.action;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.bigjava18.shop.bean.User;
import org.bigjava18.shop.biz.UserBiz;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * �û���Action
 * @author zgp
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	//����Userʵ������
	private User user=new User();
	
	//ʹ��ģ��������װǰ̨������ֵ
	@Override
	public User getModel() {
		
		return user;
	}
	
	//��UserAction��ע��UserBiz
	private UserBiz userBiz;
	
	//����UserBiz��set����
	public void setUserBiz(UserBiz userBiz) {
		
		this.userBiz = userBiz;
	}
	
	//ʹ�����Է�װ�ķ�ʽ��ȡǰ̨�������֤��
	private String checkcode;
	
	//����checkcode���Ե�set����
	public void setCheckcode(String checkcode) {
		
		this.checkcode = checkcode;
	}
	
	/**
	 * ���û�ע��ҳ��
	 * @return
	 */
	public String registerPage() {
		
		return "registerPage";
	}
	
	/**
	 * ����Ajax�첽У���û����Ƿ���ڵ�ִ�з���
	 * @return
	 * @throws IOException
	 */
	public String findByName() throws IOException{
		
		//�ں�̨�жԴ��ݵĲ�������URLDecoder����
		String username = URLDecoder.decode(user.getUsername(),"UTF-8");
		
		//����Biz���в�ѯ
		User existUser = userBiz.findByUsername(username);
		
		//���response����,��ҳ�����
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		
		//�ж��û����Ƿ����
		if(existUser !=null) {
			//��ѯ�����û�:�û����Ѿ�����
			response.getWriter().println("<font color='red'>�û����Ѿ�����</font>");
		}else {
			//û��ѯ�����û�:�û�������ʹ��
			response.getWriter().println("<font color='green'>�û�������ʹ��</font>");
		}
		
		return NONE;
	}
	
	/**
	 * �ύ�û�ע������
	 * @return
	 */
	public String register() {
		
		//�ж���֤��
		//��Session�л����֤������ֵ
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		
		//�ж���֤���Ƿ����
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			
			this.addActionError("��֤���������!");
			return "checkCodeFailRegister";
		}
		
		//����ע���û�
		userBiz.save(user);
		this.addActionMessage("ע��ɹ�!��ȥ���伤��!");
		return "msg";
	}
	
	/**
	 * �û�ע�ἤ��ķ���
	 * @return
	 */
	public String active() {
		
		//ͨ���������ѯ�û�
		User existUser=userBiz.findByCode(user.getCode());
		
		//�ж��û�existUser�Ƿ����
		if(existUser == null) {
			//�û����������
			this.addActionMessage("�� ! ����ʧ��:���������!");
		}else {
			//�û�����ɹ����޸��û�״̬Ϊ1
			existUser.setState(1);
			//�޸��û��ļ�����Ϊnull
			existUser.setCode(null);
			userBiz.updateUser(existUser);
			this.addActionMessage("�� ! ����ɹ�:��ȥ��¼!");
		}		
		return "msgActive";
	}
	
	/**
	 * ���û���¼ҳ��
	 * @return
	 */
	public String loginPage() {
		
		return "loginPage";
	}
	
	/**
	 * �û���¼
	 * @return
	 */
	public String login() {
		
		//�ж���֤��
		//��Session�л����֤������ֵ
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
				
		//�ж���֤���Ƿ����
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			
			this.addActionError("��֤���������!");
			return "checkCodeFailLogin";
		}
		
		//����Biz��ѯ�û�
		User existUser=userBiz.login(user);
		
		if(existUser == null) {
			// ��¼ʧ��
			this.addActionError("��¼ʧ��:�û��������������û�δ����!");
			return "login";
		}else {
			//��¼�ɹ�
			//���û�����Ϣ���뵽session��
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			// ҳ����ת
			return "loginSuccess";
		}
	}
	
	/**
	 * �û��˳���¼������session
	 * @return
	 */
	public String userQuit() {
		
		//����session
		ServletActionContext.getRequest().getSession().invalidate();
		
		return "userQuit";
	}
	
	/**
	 * ͨ���û���uid��ѯ�û�
	 * @return
	 */
	public String updateUserInformationPage() {
		
		System.out.println("�޸��û�uidΪ:"+user.getUid());
		
		//ͨ���û���uid��ѯ�û�
		User existUser=userBiz.findByUid(user.getUid());
		System.out.println("ͨ���û�uid��ѯ����Ϊ:"+existUser);
		
		if(existUser == null) {		//�û�������
			
			//�ص��̳���ҳ
			return "NofindUser";
		}else {			
			//���û�����Ϣ���浽session
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			
			//���޸��û���Ϣҳ��
			return "updateUserInformationPage";
		}
	}
	
	/**
	 * �û��������ݣ�����ע����Ϣ
	 * @return
	 */
	public String updateUserInformation() {
			
		System.out.println("�û��ύ��������Ϊ��"+user);
		
		//��session�л�ȡֵ
		User userSession=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		System.out.println("session�е�ȡֵΪ��"+userSession);
		
		//�ж������Ƿ���£���session�е������Ƿ�һ��
		if(user.getEmail().equals(userSession.getEmail())) {
			
			System.out.println("�û������Ƿ�һ�£�"+user.getEmail().equals(userSession.getEmail()));
			//�û�����δ�޸ĸ��¼��ɵ�¼
			user.setState(1);
			user.setCode(null);
			
			//�ύ��������
			userBiz.updateUserData(user);
			
			//����session:���»ص���¼ҳ��
			ServletActionContext.getRequest().getSession().invalidate();
			
			return "updateUserDataSuccess";
		}else {
			System.out.println("false:"+false);
			
			//�û������޸ģ���Ҫ���¼�������
			userBiz.saveUserUpdate(user);
			this.addActionMessage("�ף��û�������³ɹ� ����ȥ���伤��!");
			
			//����session:���»ص���¼ҳ��
			ServletActionContext.getRequest().getSession().invalidate();
			
			//�����³ɹ���Ϣҳ��
			return "updateUserMsg";
		}
	}
	
}
