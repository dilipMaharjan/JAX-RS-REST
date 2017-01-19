/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmaharjan.jaxrs.service;

import com.dmaharjan.jaxrs.database.ResourceDatabase;
import com.dmaharjan.jaxrs.model.Comment;
import com.dmaharjan.jaxrs.model.Message;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

/**
 *
 * @author dmaharjan
 */
public class MessageService {

    private Map<Long, Message> messages = ResourceDatabase.getMessages();
    private Map<Long, Comment> comments = ResourceDatabase.getComments();

    public MessageService() {
        messages.put(1L, new Message(1, "Hi there", "Dilip"));
        messages.put(2L, new Message(2, "Hi there as well", "Philip"));
        comments.put(1L, new Comment(1, "comment for id 1", "random"));
        comments.put(2L, new Comment(1, "comment for id 2", "random2"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<Message>(messages.values());
    }

    public List<Message> getAllMessagesForYear(int year) {
        List<Message> messagesForYear = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (Message message : getAllMessages()) {
            calendar.setTime(message.getCreated());
            if (calendar.get(Calendar.YEAR) == year) {
                messagesForYear.add(message);
            }
        }
        return messagesForYear;
    }

    public List<Message> getAllMessagesPaginated(int start, int size) {
        ArrayList<Message> messagesForPagination = new ArrayList<>(messages.values());
        if (start + size > messagesForPagination.size()) {
            return new ArrayList<Message>();
        }
        return messagesForPagination.subList(start, start + size);
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
