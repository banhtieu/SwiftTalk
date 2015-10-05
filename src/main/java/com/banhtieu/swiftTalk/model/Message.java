package com.banhtieu.swiftTalk.model;

import org.springframework.data.annotation.Id;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Represent a message
 * Created by banhtieu on 10/4/2015.
 */
public class Message {

    /**
     * Id of the message
     */
    @Id
    private String id;

    /**
     * time when the message is sent
     */
    private Date sentTime;

    /**
     * Text of the message
     */
    private String text;

    /**
     * The html text
     */
    private String html;

    /**
     * The one who sent the message
     */
    private User sender;

    /**
     * List of attachment to the message
     */
    private List<Attachment> attachments;


    /**
     * create a message
     */
    public Message(){
        attachments = new ArrayList<>();
    }


    /**
     * Get attachment of a type
     * @param type the class of attachment to get
     * @param <T> attachment type
     * @return the attachment
     */
    @SuppressWarnings("unchecked")
    public <T> T getAttachment(Class<T> type){
        T result = null;

        for (Attachment attachment : attachments) {
            if (type.isInstance(attachment)) {
                result = (T) attachment;
            }
        }

        return result;
    }

    /**
     * Add an attachment
     * @param attachment the attachment to add
     */
    public void addAttachment(Attachment attachment) {
        attachments.add(attachment);
    }

    /**
     * get the Id of the message
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Set id of the message
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * get sent time
     * @return
     */
    public Date getSentTime() {
        return sentTime;
    }

    /**
     * Set sent time of the message
     * @param sentTime
     */
    public void setSentTime(Date sentTime) {
        this.sentTime = sentTime;
    }

    /**
     * Get body text
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * Set body text
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }


    /**
     * Get html
     * @return
     */
    public String getHTML() {
        return html;
    }

    /**
     * Set the html
     * @param html
     */
    public void setHTML(String html) {
        this.html = html;
    }

    /**
     * Get sender
     * @return
     */
    public User getSender() {
        return sender;
    }

    /**
     * set sender of the message
     * @param sender
     */
    public void setSender(User sender) {
        this.sender = sender;
    }

    /**
     * List of attachments
     * @return
     */
    public List<Attachment> getAttachments() {
        return attachments;
    }

    /**
     * set attachments
     * @param attachments
     */
    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
