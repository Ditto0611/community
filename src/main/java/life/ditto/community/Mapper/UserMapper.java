package life.ditto.community.Mapper;

import life.ditto.community.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author Ditto
 * @Date 2021/7/19 10:14
 * @Version 1.0
 */

@Mapper
public interface UserMapper {
    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modified,avatar_url) values (#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified},#{avatarurl})")
    void insert(User user);

    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);

//    @Select("select id id ,account_id accountId,name name,token token,gmt_create gmtcreate,gmt_modified gmtmodified,avatar_url avatarurl from user where id = #{id}")
    @Select("select * from user where id = ${id}")
    User finfById(@Param("id") Integer id);
}
