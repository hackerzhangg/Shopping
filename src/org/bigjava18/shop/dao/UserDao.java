package org.bigjava18.shop.dao;

import java.util.List;

import org.bigjava18.shop.bean.User;

/**
 * 用户数据库访问接口
 * @author zgp
 *
 */
public interface UserDao {
	
	/**
	 * 通过用户名查询用户
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
	
	/**
	 * 提交用户注册数据
	 * @param user
	 */
	public void save(User user);
	
	/**
	 * 登录用户
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 通过用户的激活码查询用户
	 * @param code
	 * @return
	 */
	public User findByCode(String code);
	
	/**
	 * 用户更新成功，激活用户
	 * @param existUser
	 */
	public void updateUser(User existUser);
	
	/**
	 * 通过用户的uid查询用户
	 * @param uid
	 * @return
	 */
	public User findByUid(Integer uid);
	
	/**
	 * 提交更新数据:更新个人数据
	 * @param user
	 */
	public void updateUserData(User user);
	
	/**
	 * 提交更新数据:更新个人数据，需要激活邮箱
	 * @param user
	 */
	public void saveUserUpdate(User user);
	
	/**
	 * 查询用户的数量
	 * @return
	 */
	public int findUserCount();
	
	/**
	 * 查询用户集合带分页
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<User> findByPage(int begin, int limit);
	
	/**
	 * 通过用户的id更新用户
	 * @param user
	 */
	public void updateUserInfo(User user);
	
	/**
	 * 通过用户的uid删除用户
	 * @param deleteUser
	 */
	public void deleteUser(User deleteUser);

}
