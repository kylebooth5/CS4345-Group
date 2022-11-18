package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Applications;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class ApplicationController extends Controller{

        public Result createApplication() {
            System.out.print("Creating Application");
            JsonNode req = request().body().asJson();
            String first_name = req.get("first_name").asText();
            String last_name = req.get("last_name").asText();
            String email = req.get("email").asText();
            String phone = req.get("phone").asText();
            String GPA = req.get("GPA").asText();
            String major = req.get("major").asText();
            String year = req.get("year").asText();
            String studentId = req.get("studentId").asText();

            ObjectNode result = null;

            System.out.println("new application");
            result = Json.newObject();
            Applications app = new Applications();
            app.first_name=first_name;
            app.last_name=last_name;
            app.email=email;
            app.phone=phone;
            app.GPA=GPA;
            app.major=major;
            app.year=year;
            app.studentId=studentId;

            app.save();
            result.put("body", first_name);

            return ok(result);
        }

}
