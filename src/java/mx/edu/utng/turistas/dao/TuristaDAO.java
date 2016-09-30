/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.utng.turistas.dao;

import java.util.List;
import mx.edu.utng.turistas.model.Turista;

/**
 *
 * @author Omar Uriel Rodriguez Castañeda
 */
public interface TuristaDAO {
    void agregarTurista(Turista turista);
    void borrarTurista(int idTurista);
    void cambiarTurista(Turista turista);
    List<Turista> desplegarTuristas();
    Turista elegirTurista(int idTurista);
}
