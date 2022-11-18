package models;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Applications extends Model {
    private static final long serialVersionUID = 1L;

    @Id
    public Long id;

    @Constraints.Required
    public String first_name;

    @Constraints.Required
    public String last_name;

    @Constraints.Required
    public String email;

    @Constraints.Required
    public String phone;

    @Constraints.Required
    public String GPA;

    @Constraints.Required
    public String major;

    @Constraints.Required
    public String year;

    @Constraints.Required
    public String studentId;
    public static Find<Long, Applications> find = new Find<Long, Applications>(){};

    public static Applications findById(Long id) {
        return Applications.find
            .where()
            .eq("id", id)
            .findUnique();
    }

    public static List<Applications> getApplications () {
        return Applications.find.all();
    }
 }
