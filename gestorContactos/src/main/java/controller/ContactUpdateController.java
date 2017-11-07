package controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Contact;
import model.repository.ContactRepository;

/**
 * Servlet implementation class DeleteContactController
 */
public class ContactUpdateController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(ContactUpdateController.class.getName());

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUpdateController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        ContactRepository bd = ContactRepository.getInstance();
        Contact contacto = bd.getContact(id);
        request.setAttribute("contact", contacto);

        request.getRequestDispatcher("/contactEditView.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");

        ContactRepository bd = ContactRepository.getInstance();
        Contact contacto = bd.getContact(id);
        contacto.setName(name);
        contacto.setTelephone(phone);
        bd.updateContact(contacto);
        request.setAttribute("message", "Contacto modificado");
        request.getRequestDispatcher("/").forward(request, response);
    }

}
