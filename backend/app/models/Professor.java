package models;
import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.persistence.Inheritance;
import java.util.List;

@Entity
@DiscriminatorValue("professor")
public class Professor extends User{

    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String department;

    @Constraints.Required
    public String courses;




}
