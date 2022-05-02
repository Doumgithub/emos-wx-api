package com.example.emos.wx.db.mapper;

import com.example.emos.wx.db.pojo.TbUser;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 81020
* @description 针对表【tb_user(用户表)】的数据库操作Mapper
* @createDate 2022-04-26 14:41:34
* @Entity com.example.emos.wx.db.pojo.TbUser
*/
@Mapper
public interface TbUserMapper {

    public boolean haveRootUser();

    public int insert();

}
