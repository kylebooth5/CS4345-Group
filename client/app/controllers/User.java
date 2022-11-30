package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.concurrent.CompletionStage;


public class User {

    private String username;

    private String password;

    private String firstname;
    private String lastname;

    private String smuID;
    private String email;

    private String role;



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() { return firstname;}

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public String getLastname() { return lastname;}

    public void setLastname(String lastname) { this.lastname = lastname; }


    public CompletionStage<WSResponse> checkAuthorized() {

        WSClient ws = play.test.WSTestClient.newClient(9005);
        //add username password
        WSRequest request = ws.url("http://localhost:9005/login");
        ObjectNode res = Json.newObject();
        res.put("username", this.username);
        res.put("password",this.password);
        res.put("firstname",this.firstname);
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }

    //check user role
    public CompletionStage<WSResponse> checkRole() {

        WSClient ws = play.test.WSTestClient.newClient(9005);
        //add username password
        WSRequest request = ws.url("http://localhost:9005/checkRole");
        ObjectNode res = Json.newObject();
        //print the username
        res.put("username", this.username);
        res.put("password",this.password);
        res.put("firstname",this.firstname);
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }



    public  CompletionStage<WSResponse> registerUser() {

        WSClient ws = play.test.WSTestClient.newClient(9005);
        // send this. user
        ObjectNode res = Json.newObject();
        res.put("username", this.username);
        res.put("password",this.password);
        res.put("firstname",this.firstname);
        res.put("lastname",this.lastname);
        res.put("smuID",this.smuID);
        res.put("email",this.email);
        res.put("role",this.role);
        res.put("major","");
        res.put("minor","");
        res.put("gpa","");
        res.put("year","");
        res.put("department","");
        res.put("courses","");


        System.out.println(username);
        System.out.println(password);
        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(smuID);
        System.out.println(email);
        System.out.println(role);

        WSRequest request = ws.url("http://localhost:9005/signup");
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }

}
