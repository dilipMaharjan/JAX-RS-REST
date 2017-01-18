/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmaharjan.jaxrs.resources;

import com.dmaharjan.jaxrs.model.Message;
import com.dmaharjan.jaxrs.service.MessageService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author dmaharjan
 */
@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    private MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@QueryParam("year") int year, @QueryParam("start") int start, @QueryParam("size") int size) {
        if (year > 0) {
            return messageService.getAllMessagesForYear(year);
        }
        if (start >= 0 && size >= 0) {
            return messageService.getAllMessagesPaginated(start, size);
        }
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{id}")
    public Message getMessage(@PathParam("id") long id) {
        return messageService.getMessage(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Message addMessage(Message message) {
        return messageService.addMessage(message);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Message updateMessage(Message message, @PathParam("id") long id) {
        message.setId(id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{id}")
    public Message removeMessage(@PathParam("id") long id) {
        return messageService.removeMessage(id);
    }
}
