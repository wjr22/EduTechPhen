package cn.nnu.jyjs.etpweb.service.ServiceImpl;

import cn.nnu.jyjs.etpweb.bean.Message;
import cn.nnu.jyjs.etpweb.mapper.MessageMapper;
import cn.nnu.jyjs.etpweb.service.MessageService;
import cn.nnu.jyjs.etpweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "MessageService")
public class MessageServiceImpl implements MessageService {
    @Autowired(required = false)
    private MessageMapper messageMapper;

    private UserService userService;

    //@Override
    //public List<Message> selectByFrom(String fromName) {
    //    return messageMapper.selectByFromId(userService.selectByName(fromName).getUserId());
    //}

    //@Override
    //public List<Message> selectByTo(String toName) {
    //    int id = userService.selectByName(toName).getUserId();
    //    return messageMapper.selectByToId(id);
    //}

    @Override
    public List<Message> selectByFromId(Integer fromId) {
        return messageMapper.selectByFromId(fromId);
    }

    @Override
    public List<Message> selectByToId(Integer toId) {
        return messageMapper.selectByToId(toId);
    }

    @Override
    public int insertMessage(Message message) {
        return messageMapper.insertMessage(message);
    }
}
