package service;

import beans.Admin;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author TAHIRI
 */
public class AdminService implements IDao<Admin>{

    @Override
    public boolean create(Admin a) {
        String sql = "insert into admin values (null, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, a.getEmail());
            ps.setString(2, a.getUsername());
            ps.setString(3, a.getPassword());
            ps.setString(4, a.getParking());
                    
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Admin a) {
        String sql = "delete from admin where id  = ?";
        
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, a.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("delete : erreur sql : " + ex.getMessage());

        }
        return false;
    }

    @Override
    public boolean update(Admin a) {
        String sql = "update admin set email  = ? ,username = ? ,password = ? ,parking = ?  where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, a.getEmail());
            ps.setString(2, a.getUsername());
            ps.setString(3, a.getPassword());
            ps.setString(4, a.getParking());
            ps.setInt(5, a.getId());
            if (ps.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("update : erreur sql : " + ex.getMessage());

        }
        return false;
    }

    @Override
    public Admin findById(int id) {
        String sql = "select * from admin where id  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Admin(rs.getInt("id"), rs.getString("email"), rs.getString("username")
                                , rs.getString("password"), rs.getString("parking"));
            }
        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }
    
    public Admin findByEmail(String email) {
        String sql = "select * from admin where email  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Admin(rs.getInt("id"), rs.getString("email"), rs.getString("username")
                                , rs.getString("password"), rs.getString("parking"));
            }
        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }
    
    public Admin findByUsername(String username) {
        String sql = "select * from admin where username  = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Admin(rs.getInt("id"), rs.getString("email"), rs.getString("username")
                                , rs.getString("password"), rs.getString("parking"));
            }
        } catch (SQLException e) {
            System.out.println("findById " + e.getMessage());
        }
        return null;
    }
    
    public Admin Login(String username , String password){
        String sql = "select * from admin where username = ? and password = ?";
        try {
            PreparedStatement ps = Connexion.getInstane().getConnection().prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Admin(rs.getInt("id"), rs.getString("email"), rs.getString("username")
                                , rs.getString("password"), rs.getString("parking"));
            }
        } catch (SQLException e) {
            System.out.println("Login admin :: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Admin> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
