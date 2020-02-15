/*
 * BCBRDeleteBookServlet
 * Brian Chaves & RJ Coulton
 * Updated Febuary 25
 */
package club.admin;

import club.business.Book;
import club.data.BookIO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Richard
 */
public class BCRCDeleteBookServlet extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        
        ServletContext context = this.getServletContext();
        String path = context.getRealPath("/WEB-INF/books.txt");
        String code = request.getParameter("code");
        String confirm = request.getParameter("confirm");

        book = BookIO.getBook(code, path);
       
        if (confirm.equals("no")) 
        {
            request.setAttribute("book", book); 

            String url="/BCRCConfirmDelete.jsp";

            RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
        else if (confirm.equals("confirm")) 
        {
            BookIO.delete(book, path);
            
            String url="/BCRCDisplayBooks";

            RequestDispatcher dispatcher =
            getServletContext().getRequestDispatcher(url);
            dispatcher.forward(request, response);
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods.
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
