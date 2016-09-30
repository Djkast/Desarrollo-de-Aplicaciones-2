package mx.edu.utng.turistas.controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.edu.utng.turistas.dao.TuristaDAOImp;
import mx.edu.utng.turistas.model.Turista;
import mx.edu.utng.turistas.dao.TuristaDAO;

/**
 *
 * @author Omar Uriel Rodriguez Castañeda
 */
@WebServlet("/TuristaController")
public class TuristaController extends HttpServlet {
    
    private static final String LISTA_TURISTAS =
            "/lista_turistas.jsp";
    private static final String AGREGAR_O_CAMBIAR = 
            "turista.jsp";
    private TuristaDAO dao;
    
    public TuristaController(){
        dao = new TuristaDAOImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");
        if(action.equalsIgnoreCase("borrar")){
            forward = LISTA_TURISTAS;
            int idTurista = Integer.parseInt(
                request.getParameter("id_turista"));
            dao.borrarTurista(idTurista);
            request.setAttribute("turistas",
                    dao.desplegarTuristas());
         }else if(action.equalsIgnoreCase("cambiar")){
             forward = AGREGAR_O_CAMBIAR;
             int idTurista = Integer.parseInt(
                request.getParameter("id_turista"));
             Turista turista = 
                     dao.elegirTurista(idTurista);
             request.setAttribute("turista", turista);
         } else if(action.equalsIgnoreCase("agregar")){
             forward = AGREGAR_O_CAMBIAR;
         } else{
             forward = LISTA_TURISTAS;
             request.setAttribute("turistas", 
                     dao.desplegarTuristas());
         }
        
        RequestDispatcher view = 
                request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Turista turista = new Turista();
        turista.setNombre(request.getParameter("nombre"));
        turista.setTelefono(request.getParameter("telefono"));
        turista.setPais(request.getParameter("pais"));
        turista.setEmail(request.getParameter("email"));
        String idTurista = request.getParameter("id_turista");
        
        if(idTurista==null|| idTurista.isEmpty()||idTurista.trim().equals("")){
            dao.agregarTurista(turista);
        }else{
            turista.setIdTurista(
                    Integer.parseInt(idTurista));
            dao.cambiarTurista(turista);
        }
        RequestDispatcher view = 
                request.getRequestDispatcher(LISTA_TURISTAS);
        request.setAttribute("turistas", 
                dao.desplegarTuristas());
        view.forward(request, response);
    }
}