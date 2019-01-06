package cn.nnu.jyjs.etpweb.bean;

import java.util.Date;

public class Message {
    private Integer fromId;
    private String from;
    private Integer toId;
    private String to;
    private String message;
    private Date createTime;
    private Integer mID;

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getToId() {
        return toId;
    }

    public void setToId(Integer toId) {
        this.toId = toId;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getmID() {
        return mID;
    }

    public void setmID(Integer mID) {
        this.mID = mID;
    }
}
