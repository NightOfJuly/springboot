package com.qindy.service;

import com.qindy.dao.UserDao;
import com.qindy.entity.SysRole;
import com.qindy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ibm on 2017/5/19.
 */
@Service
public class LoginService implements UserDetailsService{

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {

        User user = userDao.findByName(loginName);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
        for (SysRole role : user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getLoginName(),
                user.getPassword(),authorities);
    }
}
