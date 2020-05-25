package com.lou.springboot.service.impl;

import com.lou.springboot.dao.AdminUserDao;
import com.lou.springboot.dao.AdminUserMapper;
import com.lou.springboot.entity.AdminUser;
import com.lou.springboot.service.AdminUserService;
import com.lou.springboot.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 13
 * @qq交流群 796794009
 * @email 2449207463@qq.com
 * @link http:13blog.site
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Resource
    private AdminUserMapper adminUserMapper;

    @Autowired
    private AdminUserDao adminUserDao;


    @Override
    public AdminUser getUserDetailById(Integer loginUserId) {
        return adminUserMapper.selectByPrimaryKey(loginUserId);
    }

    @Override
    public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            String originalPasswordMd5 = MD5Util.MD5Encode(originalPassword, "UTF-8");
            String newPasswordMd5 = MD5Util.MD5Encode(newPassword, "UTF-8");
            //比较原密码是否正确
            if (originalPasswordMd5.equals(adminUser.getLoginPassword())) {
                //设置新密码并修改
                adminUser.setLoginPassword(newPasswordMd5);
                if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                    //修改成功则返回true
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Boolean updateName(Integer loginUserId, String loginUserName, String nickName) {
        AdminUser adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
        //当前用户非空才可以进行更改
        if (adminUser != null) {
            //设置新密码并修改
            adminUser.setLoginUserName(loginUserName);
            adminUser.setNickName(nickName);
            if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
                //修改成功则返回true
                return true;
            }
        }
        return false;
    }

    @Override
    public PageResult getAdminUserPage(PageUtil pageUtil) {
        //当前页码中的数据列表
        List<AdminUser> users = adminUserDao.findAdminUsers(pageUtil);
        //数据总条数 用于计算分页数据
        int total = adminUserDao.getTotalAdminUser(pageUtil);
        PageResult pageResult = new PageResult(users, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public AdminUser updateTokenAndLogin(String userName, String password) {
        return null;
    }

//    @Override
//    public AdminUser updateTokenAndLogin(String userName, String password) {
//        AdminUser adminUser = adminUserDao.getAdminUserByUserNameAndPassword(userName, MD5Util.MD5Encode(password, "UTF-8"));
//        if (adminUser != null) {
//            //登录后即执行修改token的操作
//            String token = getNewToken(System.currentTimeMillis() + "", adminUser.getId());
//            if (adminUserDao.updateUserToken(adminUser.getId(), token) > 0) {
//                //返回数据时带上token
//                adminUser.setUserToken(token);
//                return adminUser;
//            }
//        }
//        return null;
//    }

    /**
     * 获取token值
     *
     * @param sessionId
     * @param userId
     * @return
     */
    private String getNewToken(String sessionId, Long userId) {
        String src = sessionId + userId + NumberUtil.genRandomNum(4);
        return SystemUtil.genToken(src);
    }

    @Override
    public AdminUser login(String userName, String password) {
        String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
        System.out.println(userName +" "+passwordMd5);
        return adminUserMapper.login(userName, passwordMd5);
    }



}
