package com.github.aushacker.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;

@WebServlet("/ts")
public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintStream out = new PrintStream(resp.getOutputStream());

        try {
            out.println(InetAddress.getByName("mynorthwind"));
        }
        catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
