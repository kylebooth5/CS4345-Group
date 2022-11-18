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

public class ApplicationController extends Controller{

    @Inject
    HttpExecutionContext ec;

    private FormFactory formFactory;

    @Inject
    public ApplicationController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    public Result index() {
        return ok(views.html.login.render(""));
    }

    public Result createApplication() {
        return ok(views.html.createApplication.render(null));
    }

    public CompletionStage<Result> applicationHandler() {

        Form<Applications> createApplicationForm = formFactory.form(Applications.class).bindFromRequest();
        if (createApplicationForm.hasErrors()){
            return (CompletionStage<Result>) badRequest(views.html.createApplication.render(null));
        }
        return createApplicationForm.get().createApplication()
                .thenApplyAsync((WSResponse r) -> {
                    if (r.getStatus() == 200 && r.asJson() != null) {
                        System.out.println("success");
                        System.out.println(r.asJson());
                        return ok(views.html.index.render("Application successfully created for " + createApplicationForm.get().getFirst_name() + "!"));
                    } else {
                        System.out.println("response null");
                        return badRequest(views.html.createApplication.render("Application already exists"));
                    }
                }, ec.current());
    }
}
