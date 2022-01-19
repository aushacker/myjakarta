package com.github.aushacker.web;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/ds")
public class DataSourceServlet extends HttpServlet {

    @Resource(lookup = "java:jboss/datasources/mynw_mysql")
    private DataSource northwindDS;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintStream out = new PrintStream(resp.getOutputStream());

        try (Connection conn = northwindDS.getConnection())
        {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT 1");
            out.println("Connected to database OK");
        }
        catch (SQLException e) {
            e.printStackTrace(out);
        }
    }
}
