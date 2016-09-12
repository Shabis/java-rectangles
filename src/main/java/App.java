import static spark.Spark.*;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/start.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

    get("/square", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      int userLength = Integer.parseInt(request.queryParams("length"));
      int userWidth = Integer.parseInt(request.queryParams("width"));
      Rectangle userRectangle = new Rectangle(userLength, userWidth);
      boolean squareResult = userRectangle.isSquare();
      model.put("length", userLength);
      model.put("width", userWidth);
      model.put("squareResult", squareResult);
      model.put("template", "templates/square.vtl");
      return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());


    // System.out.println("Enter the length of your rectangle.");
    // String stringLength = myConsole.readLine();
    // int intLength = Integer.parseInt(stringLength);
    // System.out.println("Enter the width of your rectangle:");
    // String stringWidth = myConsole.readLine();
    // int intWidth = Integer.parseInt(stringWidth);
    // Rectangle rectangle = new Rectangle(intWidth, intLength);
    // boolean squareResult = rectangle.isSquare();
    // System.out.println("Is your rectangle a square, too? " + squareResult + "!");
  }
}
