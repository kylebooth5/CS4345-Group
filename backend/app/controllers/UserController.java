package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Student;
import models.User;
import models.Professor;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


/**
 * @description: user reg/login
 * @author: Swati Bhat
 * @create: 2019-11-16 15:15
 */

public class UserController extends Controller {
    public Result authenticate() {

        System.out.println("In authenticate");
        JsonNode req = request().body().asJson();
        String username = req.get("username").asText();
        String password = req.get("password").asText();

        try {
            User user = User.findByName(username); // ( match where username and password both match )
            //print the user role
           // System.out.println("user role is: " + user.role);
            if(user!=null && username.equals(user.username) && password.equals(user.password)){
                return ok("true");
            }else{
                return ok("false");
            }
        }
        catch (Exception e) {
            return ok("false");
        }

    }

    //check the role of the user
    public Result checkRole() {
        System.out.println("In checkRole");
        JsonNode req = request().body().asJson();
        String username = req.get("username").asText();
        String password = req.get("password").asText();

        try {
            User user = User.findByName(username); // ( match where username and password both match )
            //print the user role
            System.out.println("user role is: " + user.role);
            if(user!=null && username.equals(user.username) && password.equals(user.password)){

                if (user.role.equals("student")) {
                    return ok("true");
                }
                else {
                    return ok("false");
                }
            }
            else{
                return ok("false");
            }
        }
        catch (Exception e) {
            return ok("false");
        }

    }


    /**
     * When a user register, check if the username is taken
     * save to database if valid
     * POST
     * @return success if valid, fail if already taken
     */
    public Result registerNew() {
        System.out.println("In register");
        JsonNode req = request().body().asJson();
        String username = req.get("username").asText();
        String password = req.get("password").asText();
        String firstname = req.get("firstname").asText();
        String lastname = req.get("lastname").asText();
        String smuID = req.get("smuID").asText();
        String email = req.get("email").asText();
        String role = req.get("role").asText();
        String major = req.get("major").asText();
        String minor = req.get("minor").asText();
        String gpa = req.get("gpa").asText();
        String year = req.get("year").asText();
        String department = req.get("department").asText();
        String courses = req.get("courses").asText();

        User u = User.findByName(username);
        ObjectNode result = null;
        if (u == null) {
            System.out.println("new user");
            result = Json.newObject();

            if (role.equals("student")) {
                Student student = new Student();
                student.username = username;
                student.password = password;
                student.firstname = firstname;
                student.lastname = lastname;
                student.smuID = smuID;
                student.email = email;
                student.role = role;
                student.major = major;
                student.minor = minor;
                student.gpa = gpa;
                student.year = year;
                student.save();
                result.put("body", username);
            }
            else {
                Professor professor = new Professor();
                professor.username = username;
                professor.password = password;
                professor.firstname = firstname;
                professor.lastname = lastname;
                professor.smuID = smuID;
                professor.email = email;
                professor.role = role;
                professor.department = department;
                professor.courses = courses;
                professor.save();
                result.put("body", username);
            }
        }

        return ok(result);
    }

}
