/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package murach.survey;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import murach.business.User;
import murach.business.User;
/**
 *
 * @author ASUS
 */
public class SurveyListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.html";
        
        String action = request.getParameter("action");
        if(action == null){
            action = "join";
        }
        
        if(action.equals("join")){
            url = "/index.html";
        }
        else if(action.equals("add")){
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String doB=request.getParameter("doB");
            String hearAboutMe = request.getParameter("hearAboutMe");
            System.out.println(hearAboutMe);
            String checkBox1 = request.getParameter("check1") != null ? "Yes I'd like that." : null;
            String checkBox2 = request.getParameter("check2") != null ? "Yes, please send me email announcements" : null;
            String contactMethod = request.getParameter("contact");
            User user = new User(firstName, lastName, email,doB);
            user.setHearAboutMe(hearAboutMe);
            user.setReceive(checkBox1,checkBox2);
            user.setContact(contactMethod);
            request.setAttribute("user", user);
            // Check for checkboxes
            
            
            url = "/thanks.jsp";
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
                
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
