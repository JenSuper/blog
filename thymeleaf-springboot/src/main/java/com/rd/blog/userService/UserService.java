package com.rd.blog.userService;

import com.rd.blog.domain.User;
import com.rd.blog.userRepository.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * All rights Reserved, Designed By www.rongdasoft.com
 *
 * @version V1.0
 * @Title: UserService
 * @Description:
 * @author:jichao
 * @date: 2018/3/16
 * @Copyright: 2018/3/16 www.rongdasoft.com
 * Inc. All rights reserved.
 */
@Repository
public class UserService implements UserRepository {
    //自增id
    private AtomicLong atomicLong = new AtomicLong();
    //资源库
    private ConcurrentHashMap<Long,User> repositoryMap = new ConcurrentHashMap<>();
    @Override
    public User saveOrUpdate(User user) {
        long id = user.getId();
        if (StringUtils.isEmpty(String.valueOf(id))) {
            user.setId(atomicLong.incrementAndGet());
        }
        User userRet = this.repositoryMap.put(user.getId(), user);
        return userRet;
    }

    @Override
    public void delUserById(long id) {
        this.repositoryMap.remove(id);
    }

    @Override
    public User findById(long id) {
        User user = this.repositoryMap.get(id);
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> listRet = new ArrayList<>(this.repositoryMap.values());
        return listRet;
    }
}
