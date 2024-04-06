package com.nowcoder.community.dao;

import com.nowcoder.community.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper //相当于@Repository  要想实现这个类需要配置文件
//配置文件里需要为每个方法提供它所需要的sql  mybatis底层会自动帮我们生成实现类
public interface UserMapper {
    User selectById(int id);
    User selectByName(String username);
    User selectByEmail(String email);
    int insertUser(User user);//添加一个用户 返回一个插入数据的行数
    int updateStatus(int id,int status);
    int updateHeader(int id,String headerUrl);
    int updatePassword(int id,String password);

}
