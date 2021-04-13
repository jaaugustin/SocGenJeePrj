package com.jee.JPA_demo;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class Controleur extends HttpServlet {
    ActionsBD actionsBD;
    ArrayList<UsersEntity> listeUsers;
    String messErrLogin;
    HttpSession session;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        session = request.getSession();
        String loginInput = request.getParameter("loginForm");
        String mdpInput = request.getParameter("pwdForm");
        String action = request.getParameter("action");

        if (action == null){
            request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
        }else if (action.equals("Validez")){
            listeUsers = new ArrayList<>();
            listeUsers.addAll(actionsBD.getUtilisateurs());

            for (UsersEntity user : listeUsers) {
                if (loginInput.equals(user.getLogin())
                        && mdpInput.equals(user.getMdp())) {
                    request.setAttribute("keyEmployes", actionsBD.getListeEmployes());
                    request.getRequestDispatcher("/WEB-INF/bienvenue.jsp").forward(request, response);
                } else {
                    messErrLogin = "Echec de la connexion! Vérifiez votre login ou votre mot de passe et essayez à nouveau.";
                    request.setAttribute("keyErrLogin", messErrLogin);
                    request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
                }
            }
        }else if (action.equals("Supprimez")){
            actionsBD.supprimerEmploye(request.getParameter("idEmpl"));
            listeUsers.clear();
            listeUsers.addAll(actionsBD.getUtilisateurs());
            session.setAttribute("keyEmployes", actionsBD.getListeEmployes());
            response.sendRedirect("/WEB-INF/bienvenue.jsp");
        }

    }

    public void init() {
        actionsBD = new ActionsBD();
    }

    public void destroy() {
    }
}