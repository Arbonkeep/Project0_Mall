package com.mmall.dao;

import com.mmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    //查询是否存在用户
    int checkUsername(String username);

    //校验是否存在email
    int checkEmail(String email);

    //查询登录账户密码是否匹配
    User selectLogin(@Param("username") String username, @Param("password") String password);

    //找回密码的问题
    String selectQuestionByUsername(String username);

    //找回密码问题的答案
    int checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);

    //根据用户名修改密码
    int updatePasswordByUsername(@Param("username")String username, @Param("passwordNew")String passwordNew);

    //通过userId校验密码
    int checkPassword(@Param("password")String password, @Param("userId")Integer userId);

    //通过userId校验email是否存在
    int checkEmailByUserId(@Param("eamil")String email, @Param("userId")Integer userId);
}