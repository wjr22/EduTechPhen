package cn.nnu.jyjs.etpweb.mapper;

import cn.nnu.jyjs.etpweb.bean.Message;

import java.util.List;

public interface MessageMapper {
    List<Message> selectByFromId(Integer fromId);

    List<Message> selectByToId(Integer toId);

    int insertMessage(Message message);

}
