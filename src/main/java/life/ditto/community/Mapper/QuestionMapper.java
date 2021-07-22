package life.ditto.community.Mapper;

import life.ditto.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author Ditto
 * @Date 2021/7/20 14:38
 * @Version 1.0
 */
@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator_id,tag) values (#{title},#{description},#{gmtCreate},#{gmtModified},#{creatorId},#{tag})")

    void create(Question question);

//    @Select("select id id,title title,description description,tag tag,gmt_create gmtcreate,gmt_modified gmtmodified,creator_id creatorId,view_count viewCount,comment_count commentCount,like_count likeCount from question")
    @Select("select * from question")
    /**
    * @Description: 要在application.properties配置mybatis.configuration.map-underscore-to-camel-case=true
     * 否则sql语句变量要一一对应，不然会null
    * @Author: Ditto
    * @Date: 2021/7/22
    */
    List<Question> list();
}
