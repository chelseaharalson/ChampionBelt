package com.Controller;
import com.Model.JFunctions;
import java.util.Date;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chelsea
 */
public class Submit extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {           
            
            String winner = "";
            String gamedate = "";
            String requesteddate = request.getParameter("endDate");
            
            ResultSet resultSet = null;
            JFunctions jdb = new JFunctions();
            String sqlStatement = "WITH recursive winner(team1ID, gameDate) AS ( " +
                                  "SELECT team1ID, gameDate " +
                                  "FROM games " +
                                  "WHERE team2ID = 23 AND gameDate = '2013-10-30' " +
                                  "UNION ALL " +
                                  "SELECT g.team1ID, g.gameDate " +
                                  "FROM games AS g " +
                                  "JOIN winner AS w ON w.team1ID = g.team2ID " +
                                  "WHERE g.gameDate = getWinner2(w.team1ID, w.gameDate) " +
                                  ") " +
                                  "SELECT * FROM winner " +
                                  "JOIN teams ON teamID = team1ID " +
                                  "WHERE gameDate <= '"
                                    + requesteddate
                                    + "' " +
                                  "ORDER BY gameDate DESC " +
                                  "LIMIT 1;";
            
            try
            {
                resultSet = jdb.select(sqlStatement);
                if(resultSet.next())
                {
                    winner = resultSet.getString("teamname");
                    gamedate = resultSet.getString("gameDate");
                }
            }
            catch(SQLException e)
            {
                System.out.println(e);
            }
            
            response.sendRedirect("index.jsp?winner=" + winner + "&gamedate="+ gamedate + "&requesteddate="+ requesteddate);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
