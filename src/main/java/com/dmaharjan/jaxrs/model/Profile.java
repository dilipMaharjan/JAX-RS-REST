/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dmaharjan.jaxrs.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmaharjan
 */
@XmlRootElement
public class Profile {

    private long id;
    private String profileName;
    private String lastName;
    private Date created;

    public Profile() {
    }

    public Profile(long id, String profileName, String lastName) {
        this.id = id;
        this.profileName = profileName;
        this.lastName = lastName;
        this.created=new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    


}
