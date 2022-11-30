package models;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Model;
import play.data.validation.Constraints;
import javax.persistence.MappedSuperclass;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("user")
public class User extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String username;

    @Constraints.Required
    public String password;

    @Constraints.Required
    public String firstname;

    @Constraints.Required
    public String lastname;

    @Constraints.Required
    public String smuID;

    @Constraints.Required
    public String email;

    @Constraints.Required
    public String role;

    public static Find<Long, User> find = new Find<Long, User>(){};

    public static User findByName(String name) {
        return User.find
                .where()
                .eq("username", name)
                .findUnique();
    }
}
