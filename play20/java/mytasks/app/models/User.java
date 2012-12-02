package models;

import java.util.*;
import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;
/**
 * Created with IntelliJ IDEA.
 * User: gongwenwei
 * Date: 11/29/12
 * Time: 4:29 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name="account")
public class User extends Model {

    @Id
    @Constraints.Required
    @Formats.NonEmpty
    public String email;

    @Constraints.Required
    public String name;

    @Constraints.Required
    public String password;

    // -- Queries

    public static Model.Finder<String,User> find = new Model.Finder(String.class, User.class);

    /**
     * Retrieve all users.
     */
    public static List<User> findAll() {
        return find.all();
    }

    /**
     * Retrieve a User from email.
     */
    public static User findByEmail(String email) {
        return find.where().eq("email", email).findUnique();
    }

    /**
     * Authenticate a User.
     */
    public static User authenticate(String email, String password) {
        return find.where()
                .eq("email", email)
                .eq("password", password)
                .findUnique();
    }

    // --

    public String toString() {
        return "User(" + email + ")";
    }

}

