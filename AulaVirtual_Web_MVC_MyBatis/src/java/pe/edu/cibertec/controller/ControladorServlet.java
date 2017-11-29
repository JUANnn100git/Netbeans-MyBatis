package pe.edu.cibertec.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.cibertec.dao.InterfaceCrudDao;
import pe.edu.cibertec.dao.UsuarioDao;
import pe.edu.cibertec.pojos.Estado;
import pe.edu.cibertec.pojos.Rol;
import pe.edu.cibertec.pojos.Usuario;

@WebServlet(name = "ControladorServlet", urlPatterns = {"/ControladorServlet"})
public class ControladorServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "createUsuario":
                createUsuario(request, response);
                break;
            case "updateUsuario":
                updateUsuario(request, response);
                break;
            case "deleteUsuario":
                deleteUsuario(request, response);
                break;
            case "listUsuario":
                listUsuario(request, response);
                break;
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

    private void createUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            InterfaceCrudDao dao = new UsuarioDao();
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(request.getParameter("txtNombreUsuario"));
            usuario.setNombres(request.getParameter("txtNombres"));
            usuario.setApellidos(request.getParameter("txtApellidos"));
            usuario.setContrasenia(request.getParameter("txtContrasenia"));
            usuario.setCorreo(request.getParameter("txtCorreo"));
            usuario.setEstado(new Estado());
            usuario.getEstado().setId(Integer.parseInt(request.getParameter("cboEstado")));
            usuario.setRol(new Rol());
            usuario.getRol().setId(Integer.parseInt(request.getParameter("cboRol")));
            dao.create(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("view/ModuloUsuario.jsp");
    }

    private void updateUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            UsuarioDao dao = new UsuarioDao();
            Usuario usuario = new Usuario();
            usuario.setId(Integer.parseInt(request.getParameter("txtId")));
            usuario.setNombreUsuario(request.getParameter("txtNombreUsuario"));
            usuario.setNombres(request.getParameter("txtNombres"));
            usuario.setApellidos(request.getParameter("txtApellidos"));
            usuario.setContrasenia(request.getParameter("txtContrasenia"));
            usuario.setCorreo(request.getParameter("txtCorreo"));
            usuario.setEstado(new Estado());
            usuario.getEstado().setId(Integer.parseInt(request.getParameter("cboEstado")));
            usuario.setRol(new Rol());
            usuario.getRol().setId(Integer.parseInt(request.getParameter("cboRol")));
            dao.update(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("view/ModuloUsuario.jsp");
    }

    private void deleteUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            UsuarioDao dao = new UsuarioDao();
            dao.delete(Integer.parseInt(request.getParameter("id")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("view/ModuloUsuario.jsp");
    }

    private void listUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("view/ModuloUsuario.jsp");
    }

}
