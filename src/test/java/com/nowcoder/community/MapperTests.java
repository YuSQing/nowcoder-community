package com.nowcoder.community;

import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        //直接就用mybatis根据接口在底层创建的实现类对象调用方法
        System.out.println("user = " + user);
        user = userMapper.selectByName("liubei");
        System.out.println("user = " + user);
        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println("user = " + user);

    }
    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        int rows = userMapper.insertUser(user);
        System.out.println("rows = " + rows);
        System.out.println(user.getId());
    }


    @Test
    public void updateUser() {
        int rows = userMapper.updateStatus(150, 1);
        System.out.println("rows = " + rows);
        rows = userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
        System.out.println("rows = " + rows);
        rows = userMapper.updatePassword(150, "hello");
        System.out.println("rows = " + rows);
    }
    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test  //userid 为0 就不检索userid的条件  按管理员  发帖时间（最新）  排序
    public void testSelectPosts() {
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
        for(DiscussPost post:list){
            System.out.println(post);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println("rows = " + rows);
    }

}
