package agenda;


import org.fasttrackit.dev.todolist.db.ToDoListDBAccess;
import org.fasttrackit.dev.todolist.ToDoBean;
import org.json.JSONObject;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/**
 * Created by condor on April 04, 2015
 * FastTrackIT, 2015
 */


/* didactic purposes

Some items are intentionally not optimized or not coded in the right way

FastTrackIT 2015

*/

@WebServlet("/agenda")
public class AgendaServlet extends HttpServlet {

    private static final String ACTION = "action";
    private static final String ADD = "add";
    private static final String DELETE = "delete";
    private static final String LIST = "list";

    public void service(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("mytask list service called now.");

        HttpSession session = request.getSession(true);

        String action = request.getParameter(ACTION);

        if (action != null && action.equals(ADD)) {
            addAction(request, response);
        } else if (action != null && action.equals(DELETE)) {
            deleteAction(request, response);
        } else if (action != null && action.equals(LIST)) {
            listAction(request, response);
        }


    }


    private void listAction(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("list action");
        HttpSession session = request.getSession(true);


//        ToDoListDBAccess atl = new ToDoListDBAccess();
//        List<ToDoBean> l = atl.getTaskList(iduser);
//
        JSONObject json = new JSONObject();
        json.put("tasks", l);

        returnJsonResponse(response, json.toString());
        System.out.println("end list action");
    }


    private void deleteAction(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("enter pe done");

        HttpSession session = request.getSession(true);

        String idS = request.getParameter("id");
        int id = Integer.parseInt(idS);

//        ToDoListDBAccess atl = new ToDoListDBAccess();
//        atl.markDone(id);


        System.out.println("i am done");
    }

    private void addAction(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("add action");

        HttpSession session = request.getSession(true);


        String name = request.getParameter("name");
        String phone = request.getParameter("phone");


//        ToDoListDBAccess atl = new ToDoListDBAccess();
//        atl.insertTaskList(value, iduser);

        System.out.println("now I am done");

    }

    /**/
    private void returnJsonResponse(HttpServletResponse response, String jsonResponse) {
        response.setContentType("application/json");
        PrintWriter pr = null;
        try {
            pr = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert pr != null;
        pr.write(jsonResponse);
        pr.close();
    }


}
