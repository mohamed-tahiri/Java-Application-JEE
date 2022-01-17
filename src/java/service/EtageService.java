package service;

import beans.Etage;
import connexion.Connexion;
import dao.IDao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tahiri
 */
public class EtageService implements IDao<Etage>{

    @Override
    public boolean create(Etage e) {
        String sql = "insert into etage values (null, ?, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, e.getNumero());
            ps.setInt(2, e.getNbr_section());
            ps.setInt(3, e.getId_parking());
                    
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Etage e) {
        String sql = "delete from etage where id  = ?";
        
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, e.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("delete : erreur sql : " + ex.getMessage());

        }
        return false;
    }

    @Override
    public boolean update(Etage e) {
        String sql = "update etage set numero  = ? ,nbr_section = ? ,id_parking = ?  where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, e.getNumero());
            ps.setInt(2, e.getNbr_section());
            ps.setInt(3, e.getId_parking());
            ps.setInt(4, e.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("update : erreur sql : " + ex.getMessage());

        }
        return false;
    }

    @Override
    public Etage findById(int id) {
        String sql = "select * from etage where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Etage(rs.getInt("id"), rs.getInt("numero"), rs.getInt("nbr_section"), rs.getInt("id_parking"));
            }
        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }
    
    public Etage findByNumero(int numero) {
        String sql = "select * from etage where numero  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Etage(rs.getInt("id"), rs.getInt("numero"), rs.getInt("nbr_section"), rs.getInt("id_parking"));
            }
        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Etage> findAll() {
        List<Etage> etages = new ArrayList<Etage>();

        String sql = "select * from etage order by id ;";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                etages.add(new Etage(rs.getInt("id"), rs.getInt("numero"), rs.getInt("nbr_section"), rs.getInt("id_parking")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return etages;
    }
    
    public List<Etage> findAllByParking(int id_parking) {
        List<Etage> etages = new ArrayList<Etage>();

        String sql = "select * from etage where id_parking = ? order by numero ;";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setInt(1, id_parking);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                etages.add(new Etage(rs.getInt("id"), rs.getInt("numero"), rs.getInt("nbr_section"), rs.getInt("id_parking")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return etages;
    }
    
    public boolean EtageisEmpty(Etage e) {
        String sql = "select * from place where etat = ? and etage = ? and parking = ?";
        
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setInt(2, e.getNumero());
            ps.setInt(3, e.getId_parking());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("isEmpty : erreur sql : " + ex.getMessage());

        }
        return false;
    }
    
}
