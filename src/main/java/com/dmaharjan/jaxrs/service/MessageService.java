/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmaharjan.jaxrs.service;

import com.dmaharjan.jaxrs.database.ResourceDatabase;
import com.dmaharjan.jaxrs.model.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dmaharjan
 */
public class MessageService {

    private Map<Long, Message> messages = ResourceDatabase.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1,"Hi there","Dilip"));
         messages.put(2L, new Message(2,"Hi there as well","Philip"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messages.values());
    }

    public Message getMessage(long id) {
        return messages.get(id);
    }

    public Message addMessage(Message message) {
        message.setId(messages.size() + 1);
        messages.put(message.getId(), message);
        return message;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(Long id) {
        return messages.remove(id);
    }
}
