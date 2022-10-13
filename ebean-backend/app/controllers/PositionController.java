package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Positions;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;


/**
 * @description: user reg/login
 * @author: Swati Bhat
 * @create: 2019-11-16 15:15
 */

public class PositionController extends Controller {

    /**
     * When a user register, check if the username is taken
     * save to database if valid
     * POST
     * @return success if valid, fail if already taken
     */

    // create the position and add it to the database
    public Result createPosition() {
        System.out.println("Creating Position");
        JsonNode req = request().body().asJson();
        String course = req.get("course").asText();
        String preference = req.get("preference").asText();
        String numPositions = req.get("numPositions").asText();

       // Positions u = User.findByName(username);
        ObjectNode result = null;

        System.out.println("new position");
        result = Json.newObject();
        Positions pos = new Positions();
        pos.course=course;
        pos.preference=preference;
        pos.numPositions=numPositions;

        pos.save();
        result.put("body", course);

        return ok(result);
    }

}
