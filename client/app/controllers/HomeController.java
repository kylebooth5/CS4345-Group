package controllers;

import play.data.Form;
import play.data.FormFactory;
import play.http.HttpEntity;
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
public class HomeController extends Controller {

    @Inject
    HttpExecutionContext ec;

    private FormFactory formFactory;

    @Inject
    public HomeController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    /**
     * Index page
     */
    public Result index() {
        return ok(views.html.login.render(""));
    }

    /**
     * Index page
     */
    public Result signup() {
        return ok(views.html.register.render(null));
    }

    //create a method that calls the checkRole function
    public CompletionStage<Result> checkRole() {

        Form<User> loginForm = formFactory.form(User.class).bindFromRequest();

        return loginForm.get().checkRole()
                .thenApplyAsync((WSResponse r) -> {
                    if (r.getStatus() == 200 && r.asJson() != null) {
                        System.out.println("success" + " check 1");
                        //System.out.println(r.asJson());

                        if (r.asJson().asText().equals("true")) {
                            System.out.println("success" + " check 2");
                            return ok("TADashboard");
                        } else if (r.asJson().asText().equals("false")) {
                            return ok("Professor");
                        }
                    }
                    System.out.println(r.getStatus());
                    return ok("error");
                }, ec.current());
}

    public CompletionStage<Result> loginHandler() {

        Form<User> loginForm = formFactory.form(User.class).bindFromRequest();
        if (loginForm.hasErrors()){
            return (CompletionStage<Result>) badRequest(login.render(""));  // send parameter like register so that user could know
        }

        return loginForm.get().checkAuthorized()
                .thenApplyAsync((WSResponse r) -> {
                    if (r.getStatus() == 200 && r.asJson() != null && r.asJson().asBoolean()) {
                        //System.out.println(r.asJson());
                        // add username to session
                        session("username",loginForm.get().getUsername());   // store username in session for your project
                        // redirect to index page, to display all categories
                        //call the checkRole function
                        HttpEntity check1 = checkRole().toCompletableFuture().join().body();
                       //print the result of the checkRole function

                        if (check1.contentLength().get().intValue() == 11)
                        {
                            System.out.println("success" + " check 3");
                            return ok(TADashboard.render("Welcome " + loginForm.get().getUsername() + "!"));
                        }
                        else if (check1.contentLength().get().intValue() == 9)
                        {
                            System.out.println("success" + " check 4");
                            return ok(index.render("Welcome " + loginForm.get().getUsername() + "!"));
                        }
                        else
                        {
                            System.out.println("success" + " check 5");
                            return ok("error");
                        }


                    }
                        System.out.println("response null");
                        String authorizeMessage = "Incorrect Username or Password ";
                        return badRequest(login.render(authorizeMessage));

                }, ec.current());
    }

    public CompletionStage<Result> signupHandler() {

        Form<User> registrationForm = formFactory.form(User.class).bindFromRequest();
        if (registrationForm.hasErrors()){
            return (CompletionStage<Result>) badRequest(views.html.register.render(null));
        }
        return registrationForm.get().registerUser()
                .thenApplyAsync((WSResponse r) -> {
                    if (r.getStatus() == 200 && r.asJson() != null) {
                        System.out.println("success");
                        System.out.println(r.asJson());
                        return ok(login.render(""));
                    } else {
                        System.out.println("response null");
                        return badRequest(views.html.register.render("Username already exists"));
                    }
                }, ec.current());

    }

}