package com.java.controller;

import com.java.dao.DoctorDao;
import com.java.dao.EspecialidadDao;
import com.java.pojos.Doctor;
import com.java.pojos.Especialidad;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {

    private String forward = "";
    private static String READ_ESPECIALIDAD = "/views/listEspecialidad.jsp";
    private HttpSession sesion;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        switch (action) {
            case "createEspecialidad":
                createEspecialidad(request, response);
                break;
            case "readEspecialidad":
                readEspecialidad(request, response);
                break;
            case "updateEspecialidad":
                updateEspecialidad(request, response);
                break;
            case "deleteEspecialidad":
                deleteEspecialidad(request, response);
                break;
            case "createDoctor":
                createDoctor(request, response);
                break;
            case "readDoctor":
                readDoctor(request, response);
                break;
            case "updateDoctor":
                updateDoctor(request, response);
                break;
            case "deleteDoctor":
                deleteDoctor(request, response);
                break;
            case "createPaciente":
                createPaciente(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void createEspecialidad(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        EspecialidadDao dao = new EspecialidadDao();
        Especialidad especialidad = new Especialidad();
        especialidad.setId(Integer.parseInt(request.getParameter("txtId")));
        especialidad.setNombre(request.getParameter("txtNombre"));
        dao.create(especialidad);
        readEspecialidad(request, response);
    }

    private void readEspecialidad(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        forward = "/views/listEspecialidad.jsp";
        EspecialidadDao dao = new EspecialidadDao();
        request.setAttribute("especialidades", dao.list());
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    private void updateEspecialidad(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        EspecialidadDao dao = new EspecialidadDao();
        Especialidad especialidad = new Especialidad();
        especialidad.setId(Integer.parseInt(request.getParameter("txtId")));
        especialidad.setNombre(request.getParameter("txtNombre"));
        dao.update(especialidad);
        readEspecialidad(request, response);
    }

    private void deleteEspecialidad(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        new EspecialidadDao().delete(Integer.parseInt(request.getParameter("id")));
        readEspecialidad(request, response);
    }

    private void createDoctor(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, Exception {
        DoctorDao dao = new DoctorDao();
        Doctor doctor = new Doctor();
        doctor.setId(Integer.parseInt(request.getParameter("txtId")));
        doctor.setNombre(request.getParameter("txtNombre"));
        doctor.setAp_paterno(request.getParameter("txtApPaterno"));
        doctor.setAp_materno(request.getParameter("txtApMaterno"));
        doctor.setEspecialidad(new Especialidad());
        doctor.getEspecialidad().setId(Integer.parseInt(request.getParameter("cboEspecialidad")));
        dao.create(doctor);
        readDoctor(request, response);
    }

    private void readDoctor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        forward = "/views/listDoctor.jsp";
        DoctorDao dao = new DoctorDao();
        request.setAttribute("doctores", dao.list());
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    private void updateDoctor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        DoctorDao dao = new DoctorDao();
        Doctor doctor = new Doctor();
        doctor.setId(Integer.parseInt(request.getParameter("txtId")));
        doctor.setNombre(request.getParameter("txtNombre"));
        doctor.setAp_paterno(request.getParameter("txtApPaterno"));
        doctor.setAp_materno(request.getParameter("txtApMaterno"));
        doctor.setEspecialidad(new Especialidad());
        doctor.getEspecialidad().setId(Integer.parseInt(request.getParameter("cboEspecialidad")));
        dao.update(doctor);
        readDoctor(request, response);
    }

    private void deleteDoctor(HttpServletRequest request, HttpServletResponse response) throws Exception {
        new DoctorDao().delete(Integer.parseInt(request.getParameter("id")));
        readDoctor(request, response);
    }

    private void createPaciente(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        forward = "/views/clasesInstanciadas.jsp";
//        PacienteDao dao = new PacienteDao();
//        Paciente paciente = new Paciente();
//        paciente.setIdpaciente(request.getParameter("txtIdPaciente"));
//        paciente.setNombre(request.getParameter("txtNombre"));
//        paciente.setApPaterno(request.getParameter("txtApPaterno"));
//        paciente.setApMaterno(request.getParameter("txtApMaterno"));
//        paciente.setTipodocid(request.getParameter("txtTipodocid"));
//        paciente.setNumerodedocid(Integer.parseInt(request.getParameter("txtNumerodedocid")));
//        paciente.setEdad(Integer.parseInt(request.getParameter("txtEdad")));
//        paciente.setDireccion(request.getParameter("txtDireccion"));
//        paciente.setTelefono(request.getParameter("txtTelefono"));
//        dao.createPaciente(paciente);
//        request.setAttribute("objeto", paciente);
//        RequestDispatcher view = request.getRequestDispatcher(forward);
//        view.forward(request, response);
    }

}
