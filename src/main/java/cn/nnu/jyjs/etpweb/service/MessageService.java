package cn.nnu.jyjs.etpweb.service;

import cn.nnu.jyjs.etpweb.bean.Message;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MessageService {
    //List<Message> selectByFrom(String fromName);
    //List<Message> selectByTo(String toName);
    List<Message> selectByFromId(Integer fromId);

    List<Message> selectByToId(Integer toId);

    int insertMessage(Message message);
}
