package controllers;

import play.libs.Json;
import play.mvc.*;
import models.Applications;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;

public class SearchController extends Controller {
    public Result index() {
        return ok();
    }
    
    public Result getApplications() {
        ObjectNode result = null;
        List<Applications> applications = Applications.getApplications();
        result = Json.newObject();
        if (applications != null) {
            JsonNode jsonApplications = Json.toJson(applications);
            result.put("body", jsonApplications);
        }
        if(result != null){
            return ok(result);
        }
        return notFound();
    }

    public Result getApplicationById(Long id) {
        ObjectNode result = null;
        Applications application = Applications.findById(id);
        result = Json.newObject();
        if (application != null){
            JsonNode jsonApplication = Json.toJson(application);
            result.put("body", jsonApplication);
        }
        if(result != null){
            return ok(result);
        }
        return notFound();
    }
}
