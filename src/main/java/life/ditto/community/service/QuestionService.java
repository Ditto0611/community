package life.ditto.community.service;

import life.ditto.community.Mapper.QuestionMapper;
import life.ditto.community.Mapper.UserMapper;
import life.ditto.community.dto.QuestionDTO;
import life.ditto.community.model.Question;
import life.ditto.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Ditto
 * @Date 2021/7/22 10:39
 * @Version 1.0
 */
@Service
public class QuestionService {
    @Autowired(required = false)
    private QuestionMapper questionMapper;
    @Autowired(required = false)
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questions){
            User user = userMapper.finfById(question.getCreatorId());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }

        return  questionDTOList;
    }
}
