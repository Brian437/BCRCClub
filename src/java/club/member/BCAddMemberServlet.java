/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package club.member;

import club.business.Member;
import club.data.MemberDB;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Brian Chaves
 * April 8
 */
public class BCAddMemberServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        ServletContext context = this.getServletContext();
        HttpSession session = request.getSession();
        
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        String number = request.getParameter("number");
        String program = request.getParameter("program");
        String year = request.getParameter("year");
        
        int intYear;
        String errorMessage="";
        
        try
        {
            intYear= Integer.parseInt(year);
        }
        catch(Exception exception)
        {
            intYear=0;
        }
        
        Member member=new Member();
        
        member.setFullName(fullName);
        member.setEmailAddress(email);
        member.setPhoneNumber(number);
        member.setProgramName(program);
        member.setYearLevel(intYear);
        
        String url;
        
        if(!member.isValid())
        {
            errorMessage="Member information is not valid. "
                +"you must enter valid name and email."
                +"<br />";
        }
        
        if(MemberDB.emailExists(email))
        {
            errorMessage+="Email already exist in Member dadtbase. "
                + "You must enter a new email."
                +"<br />";
        }
        
        if(errorMessage.equals(""))
        {
            url="/BCRCDisplayMember.jsp";
            MemberDB.insert(member);
            session.setAttribute("member",member);
        }
        else
        {
            url="/BCRCRegister.jsp";
        }   

        session.setAttribute("errorMessage", errorMessage);
        
        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response); 
            
        session.setAttribute("errorMessage", "");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
