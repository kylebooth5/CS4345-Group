package models;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Positions extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String course;

    @Constraints.Required
    public String preference;

    @Constraints.Required
    public String numPositions;

    //add user id
   // public static Find<Long, User> find = new Find<Long, User>(){};
/*
    public static User findByName(String name) {
        return User.find
                .where()
                .eq("username", name)
                .findUnique();
    }
*/


}
