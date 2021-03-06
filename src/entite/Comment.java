/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.Date;
import java.util.Objects;


/**
 *
 * @author SaharS
 */
public class Comment {
      private int id; 
    private String body;
    private Date created_at;

    public Comment() {
    }

    public Comment(int id, String body) {
        this.id = id;
        this.body = body;
    }

    public Comment(String body, Date created_at) {
        this.body = body;
        this.created_at = created_at;
    }
    
    

    public Comment(int id, String body, Date created_at) {
        this.id = id;
        this.body = body;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
    
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.body);
        hash = 13 * hash + Objects.hashCode(this.created_at);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comment other = (Comment) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.body, other.body)) {
            return false;
        }
        if (!Objects.equals(this.created_at, other.created_at)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", body=" + body + ", created_at=" + created_at + '}';
    }
    
    
    
    
}
