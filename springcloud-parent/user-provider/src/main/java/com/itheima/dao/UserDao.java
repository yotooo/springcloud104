package com.itheima.dao;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author ljh
 * @version 1.0
 * @date 2020/12/11 16:25
 * @description 标题
 * @package com.itheima.dao
 */
public interface UserDao {
    @Select(value = "select * from tb_user where id=#{id}")
    public User findById(Integer id);
}
