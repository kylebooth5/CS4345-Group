package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.concurrent.CompletionStage;

public class Applications {
    private String first_name;
    private String last_name;
    private String email;
    private String phone;
    private String GPA;
    private String major;
    private String year;
    private String studentId;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGPA() {
        return GPA;
    }

    public void setGPA(String GPA) {
        this.GPA = GPA;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public CompletionStage<WSResponse> createApplication() {
        WSClient ws = play.test.WSTestClient.newClient(9005);

        ObjectNode res = Json.newObject();
        res.put("first_name", this.first_name);
        res.put("last_name", this.last_name);
        res.put("email", this.email);
        res.put("phone", this.phone);
        res.put("GPA", this.GPA);
        res.put("major", this.major);
        res.put("year", this.year);
        res.put("studentId", this.studentId);

        WSRequest request = ws.url("http://localhost:9005/createApplication");
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }
}
