package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.ws.WSResponse;
import views.html.*;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * Software Service Market Place
 */
public class PositionController extends Controller {

    @Inject
    HttpExecutionContext ec;

    private FormFactory formFactory;

    @Inject
    public PositionController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    /**
     * Index page
     */
    public Result index() {
        return ok(views.html.login.render(""));
    }

    //add function to create new position

    //displays the createPosition html page
    public Result createPosition() {
        return ok(views.html.createPosition.render(null));}

    //gets form input and passes position info the createPosition function in Positions
    public CompletionStage<Result> positionHandler() {

        Form<Positions> createPositionForm = formFactory.form(Positions.class).bindFromRequest();
        if (createPositionForm.hasErrors()){
            return (CompletionStage<Result>) badRequest(views.html.createPosition.render(null));
        }
        return createPositionForm.get().createPosition()
                .thenApplyAsync((WSResponse r) -> {
                    if (r.getStatus() == 200 && r.asJson() != null) {
                        System.out.println("success");
                        System.out.println(r.asJson());
                        return ok(views.html.index.render("Position successfully created for " + createPositionForm.get().getCourse() + "!"));
                    } else {
                        System.out.println("response null");
                        return badRequest(views.html.createPosition.render("Position already exists"));
                    }
                }, ec.current());

    }
}