package models;
import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.persistence.Inheritance;
import java.util.List;

@Entity
@DiscriminatorValue("student")
public class Student extends User {

    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String major;

    @Constraints.Required
    public String minor;

    @Constraints.Required
    public String gpa;

    @Constraints.Required
    public String year;





   // public static Find<Long, Student> find = new Find<Long, Student>(){};





}
