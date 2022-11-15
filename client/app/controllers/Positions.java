package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import play.libs.ws.WSResponse;

import java.util.concurrent.CompletionStage;

public class Positions {

    private String course;

    private String preference;

    private String numPositions;


    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getNumPositions() { return numPositions;}

    public void setNumPositions(String numPositions) { this.numPositions = numPositions; }

    //pass position info to the DB
    public  CompletionStage<WSResponse> createPosition() {

        WSClient ws = play.test.WSTestClient.newClient(9005);
        // send this. user
        ObjectNode res = Json.newObject();
        res.put("course", this.course);
        res.put("preference",this.preference);
        res.put("numPositions",this.numPositions);

        System.out.println(course);
        System.out.println(preference);
        System.out.println(numPositions);

        WSRequest request = ws.url("http://localhost:9005/createPosition");
        return request.addHeader("Content-Type", "application/json")
                .post(res)
                .thenApply((WSResponse r) -> {
                    return r;
                });
    }

}
