package mx.edu.utng.turistas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.edu.utng.turistas.model.Turista;
import mx.edu.utng.turistas.util.UtilDB;

/**
 *
 * @author Omar Uriel Rodriguez Castañeda
 */
public class TuristaDAOImp implements TuristaDAO{
    
    private Connection connection;
    
    public TuristaDAOImp(){
        connection = UtilDB.getConnection();
    }

    @Override
    public void agregarTurista(Turista turista) {
        try {
          String query = "INSERT INTO turistas(nombre, telefono, pais, email) VALUES(?,?,?,?)";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, turista.getNombre());
            ps.setString(2, turista.getTelefono());
            ps.setString(3, turista.getPais());
            ps.setString(4, turista.getEmail());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void borrarTurista(int idTurista) {
        try {
             String query = "DELETE FROM turistas WHERE id_turista = ?";
             PreparedStatement ps = connection.prepareCall(query);
             ps.setInt(1, idTurista);
             ps.executeUpdate();
             ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void cambiarTurista(Turista turista) {
        try {
          String query = "UPDATE turistas SET nombre = ?, telefono = ?, pais = ?, email = ? WHERE "
                  + " id_turista = ?";
            PreparedStatement ps = connection.prepareCall(query);
            ps.setString(1, turista.getNombre());
            ps.setString(2, turista.getTelefono());
            ps.setString(3, turista.getPais());
            ps.setString(4, turista.getEmail());
            ps.setInt(5, turista.getIdTurista());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Turista> desplegarTuristas() {
        List<Turista> turistas = new ArrayList<Turista>();
        try{
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                "SELECT * FROM turistas");
            while (resultSet.next()) {
              Turista turista = new Turista(
              resultSet.getInt("id_turista"),
              resultSet.getString("nombre"),
              resultSet.getString("telefono"),
              resultSet.getString("pais"),
              resultSet.getString("email"));
              turistas.add(turista);
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return turistas;
    }

    @Override
    public Turista elegirTurista(int idTurista) {
        Turista turista = new Turista();
        try{
        PreparedStatement statement = 
                connection.prepareStatement(
                        "SELECT * FROM turistas");
        statement.setInt(1, idTurista);
        ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
              turista.setIdTurista(
                      resultSet.getInt("id_turista"));
              turista.setNombre(
                      resultSet.getString("nombre"));
              turista.setTelefono(
                      resultSet.getString("telefono"));
              turista.setPais(
                      resultSet.getString("pais"));
              turista.setEmail(
                      resultSet.getString("email"));
            }
            resultSet.close();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return turista;
    }
    
}
