package com.krf.twocs.mapper;

import com.krf.twocs.domain.po.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author ASUS
* @description 针对表【user】的数据库操作Mapper
* @createDate 2024-10-25 11:43:45
* @Entity po.domain.com.krf.twocs.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




