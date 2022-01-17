package service;

import beans.Place;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tahiri
 */
public class PlaceService implements IDao<Place>{

    @Override
    public boolean create(Place p) {
        String sql = "insert into place values (null, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setBoolean(2, p.getEtat());
            ps.setString(3, p.getSection());
            ps.setInt(4, p.getEtage());
            ps.setInt(5, p.getParking());
            
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Place p) {
        String sql = "delete from place where id  = ?";
        
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
    public boolean update(Place p) {
        String sql = "update place set nom  = ? ,etat = ? ,section = ? ,etage = ? ,parking = ?  where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setBoolean(2, p.getEtat());
            ps.setString(3, p.getSection());
            ps.setInt(4, p.getEtage());
            ps.setInt(5, p.getParking());
            ps.setInt(6, p.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("update : erreur sql : " + ex.getMessage());

        }
        return false;
    }

    @Override
    public Place findById(int id) {
        String sql = "select * from place where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Place(rs.getInt("id"), rs.getString("nom"), rs.getBoolean("etat")
                    , rs.getString("section"),rs.getInt("etage") , rs.getInt("parking")) ;
            }
        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Place> findAll() {
        List<Place> places = new ArrayList<Place>();

        String sql = "select * from place";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                places.add(new Place(rs.getInt("id"), rs.getString("nom"), rs.getBoolean("etat")
                    , rs.getString("section"),rs.getInt("etage") , rs.getInt("parking")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return places;
    }

    public List<Place> findAllBySection(String section , int etage , int parking) {
        List<Place> places = new ArrayList<Place>();

        String sql = "select * from place where section = ? and etage = ? and parking = ? and etat = 0";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setString(1, section);
            ps.setInt(2, etage);
            ps.setInt(3, parking);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                places.add(new Place(rs.getInt("id"), rs.getString("nom"), rs.getBoolean("etat")
                    , rs.getString("section"),rs.getInt("etage") , rs.getInt("parking")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return places;
    }
}
