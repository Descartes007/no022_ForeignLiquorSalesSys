package cn.itbaizhan.shop.adminuser.service;

import org.springframework.transaction.annotation.Transactional;

import cn.itbaizhan.shop.adminuser.dao.AdminUserDao;
import cn.itbaizhan.shop.adminuser.vo.AdminUser;
@Transactional
public class AdminUserService {
	// 注入Dao
	private AdminUserDao adminUserDao;

	public void setAdminUserDao(AdminUserDao adminUserDao) {
		this.adminUserDao = adminUserDao;
	}

	
	public AdminUser login(AdminUser adminUser) {
		return adminUserDao.login(adminUser);
	}
	
}
