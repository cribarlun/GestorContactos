package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
public class ContactListMovilController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(ContactListMovilController.class.getName());

    public ContactListMovilController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Load contacts
        ContactRepository repository = ContactRepository.getInstance();

        // Send contacts to index.jsp
        request.setAttribute("contacts", repository.getContactsMovil());

        request.getRequestDispatcher("/contactListView.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
