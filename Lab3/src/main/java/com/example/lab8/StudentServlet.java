package com.example.lab8;
import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
    private static final String filePath = "C:\\Users\\Pavel\\Desktop\\OOP\\lr3\\students.json";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String group = request.getParameter("group");
        String telephone_number = request.getParameter("telephone_number");
        String email = request.getParameter("email");

        JSONObject student = new JSONObject();
        student.put("name", name);
        student.put("age", age);
        student.put("group", group);
        student.put("telephone_number", telephone_number);
        student.put("email", email);

        JSONArray studentList = new JSONArray();

        try {
            JSONParser parser = new JSONParser();
            File file = new File(filePath);
            String fullPath = file.getAbsolutePath();
            System.out.println(fullPath);
            if (file.exists()) {
                studentList = (JSONArray) parser.parse(new FileReader(filePath));
            }

            studentList.add(student);
            FileWriter fileWriter = new FileWriter(filePath);

            fileWriter.write(studentList.toJSONString());
            fileWriter.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/Lab8");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JSONParser parser = new JSONParser();
            JSONArray studentList = (JSONArray) parser.parse(new FileReader(filePath));

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html><body><h2>Данные о студентах</h2><table border='1'><tr><th>Имя</th><th>Возраст</th><th>Группа</th><th>Номер телефона</th><th>Электронная почта</th></tr>");

            for (Object obj : studentList) {
                JSONObject student = (JSONObject) obj;
                out.println("<tr>" +
                        "<td>" + student.get("name") + "</td>" +
                        "<td>" + student.get("age") + "</td>" +
                        "<td>" + student.get("group") + "</td>" +
                        "<td>" + student.get("telephone_number") + "</td>" +
                        "<td>" + student.get("email") + "</td>" +
                        "</tr>" );
            }

            out.println("</table></body></html>");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}