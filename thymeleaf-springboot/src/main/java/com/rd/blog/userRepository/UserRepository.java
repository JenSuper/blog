package com.rd.blog.userRepository;

import com.rd.blog.domain.User;

import java.util.List;

/**
 * All rights Reserved, Designed By www.rongdasoft.com
 *
 * @version V1.0
 * @Title: userRepository
 * @Description:
 * @author:jichao
 * @date: 2018/3/16
 * @Copyright: 2018/3/16 www.rongdasoft.com
 * Inc. All rights reserved.
 */
public interface UserRepository {

    /**
     * 保存用户
     * @param user
     * @return
     */
    User saveOrUpdate(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void delUserById(long id);

    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User findById(long id);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();
}
