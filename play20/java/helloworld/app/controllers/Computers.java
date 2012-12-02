package controllers;

import play.*;
import play.mvc.*;
import play.data.*;
import play.data.validation.Constraints.*;

import java.util.*;

import views.html.*;

/**
 * Created with IntelliJ IDEA.
 * User: gongwenwei
 * Date: 11/30/12
 * Time: 9:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Computers extends Controller {

    public static class Computer {
        public String cpu;
        public String memory;
        //@Required public String mainboard;
        //@Required public String harddisk;
        //public String monitor;
        //public String keyboard;
        //public String mouse;
        @Required @Min(1) @Max(100) public Integer repeat;
        public String color;
    }

    public static Result addComputerPage() {
        return ok(
                computeradd.render(form(Computer.class))
        );
    }

    /**
     * Handles the form submission.
     */
    public static Result addComputer() {
        Form<Computer> form = form(Computer.class).bindFromRequest();
        if(form.hasErrors()) {
            return badRequest(computeradd.render(form));
        } else {
            Computer data = form.get();
            return ok(
                    computeraddresult.render(data.cpu,data.memory,data.color)
            );
        }
    }
}
