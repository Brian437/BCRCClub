/*
 * BCRCAddBookServlet
 * Brian Chaves & RJ Coulton
 * Updated Febuary 25
 */
package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Brian Chaves
 */
public class BCRCAddBookServlet extends HttpServlet {

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

    Book book;
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        ServletContext context = this.getServletContext();
        String path= context.getRealPath("/WEB-INF/books.txt");
        //String path= context.getRealPath(request.getContextPath());

        String code=request.getParameter("code");
        //String firstName = request.getParameter("firstName");
        String description=request.getParameter("description");
        int intQuantity=0;
        String strQuantity=request.getParameter("quantity");
        boolean validQuantity=false;

        try
        {
            intQuantity= Integer.parseInt(strQuantity);
            if(intQuantity>0)
            {
                validQuantity=true;
            }
            else
            {
                validQuantity=false;
            }
        }
        catch(Exception exception)
        {
            validQuantity=false;
        }

        String url="";
        String message="";

        if(code=="")
        {
            message+="You must enter a code <br />";
        }
        
        if(description=="")
        {
            message+="You must enter a description <br />";
        }
        
        /*if(code=="" ||
            description=="")
        {

            message+="Code and Description must be filled <br />";
        }*/

        if(!validQuantity)
        {
            message+="Quantity must be a number greater then zero <br />";
        }

        if(message=="")
        {
            url="/BCRCDisplayBooks";
            book=new Book(code,description,intQuantity);
            BookIO.insert(book, path);
        }
        else
        {
            url="/BCRCBook.jsp";
        }

        request.setAttribute("message",message);
        request.setAttribute("code",code);
        request.setAttribute("description",description);
        request.setAttribute("quantity",strQuantity);

        //request.setAttribute("book", book);


        RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.
    //Click on the + sign on the left to edit the code.">
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
