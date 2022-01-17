package service;

import beans.Parking;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TAHIRI
 */
public class ParkingService implements IDao<Parking>{

    @Override
    public boolean create(Parking p) {
        String sql = "insert into parking values (null, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getAddress());
                    
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Parking p) {
        String sql = "delete from parking where id  = ?";
        
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, p.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("delete : erreur sql : " + ex.getMessage());

        }
        return false;
    }

    @Override
    public boolean update(Parking p) {
        String sql = "update parking set name  = ? ,address = ?  where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setString(2, p.getAddress());
            ps.setInt(3, p.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("update : erreur sql : " + ex.getMessage());

        }
        return false;
    }

    @Override
    public Parking findById(int id) {
        String sql = "select * from parking where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Parking(rs.getInt("id"), rs.getString("name"), rs.getString("address") );
            }
        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }
    
    public Parking findByNom(String nom) {
        String sql = "select * from parking where nom = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Parking(rs.getInt("id"), rs.getString("nom"), rs.getString("address") );
            }
        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Parking> findAll() {
        List<Parking> parkings = new ArrayList<Parking>();

        String sql = "select * from parking;";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                parkings.add(new Parking(rs.getInt("id"), rs.getString("nom"), rs.getString("address") ));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return parkings;
    }    
}
