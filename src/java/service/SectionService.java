package service;

import beans.Section;
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
public class SectionService implements IDao<Section>{

    @Override
    public boolean create(Section s) {
        String sql = "insert into section values (null, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, s.getNom());
            ps.setInt(2, 10);
            ps.setInt(3, s.getIdEtage());
            ps.setInt(4, s.getIdParking());
                    
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Section s) {
        String sql = "delete from section where id  = ?";
        
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, s.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("delete : erreur sql : " + ex.getMessage());

        }
        return false;
    }
    
    @Override
    public boolean update(Section o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Section findById(int id) {
        String sql = "select * from section where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Section(rs.getInt("id"), rs.getString("nom"), rs.getInt("nbrPlace")
                    ,rs.getInt("id_etage") , rs.getInt("id_parking"));
            }
        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Section> findAll() {
        List<Section> sections = new ArrayList<Section>();

        String sql = "select * from section order by id_etage";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sections.add(new Section(rs.getInt("id"), rs.getString("nom"), rs.getInt("nbrPlace")
                    ,rs.getInt("id_etage") , rs.getInt("id_parking")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return sections;
    }
    
    
    public List<Section> findAllByNumeroEtage(int num) {
        List<Section> sections = new ArrayList<Section>();

        String sql = "select * from section Where id_etage = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);;
            ps.setInt(1, num);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sections.add(new Section(rs.getInt("id"), rs.getString("nom"), rs.getInt("nbrPlace")
                    ,rs.getInt("id_etage") , rs.getInt("id_parking")));
            }

        } catch (SQLException e) {
            System.out.println("findAll " + e.getMessage());
        }
        return sections;
    }
    
    public boolean SectionisEmpty(Section s) {
        String sql = "select * from place where etat = ? and section = ? and parking = ?";
        
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, 0);
            ps.setString(2, s.getNom());
            ps.setInt(3, s.getIdParking());
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
