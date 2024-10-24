package com.ht22.QLDiemSinhVien.DAO;

import com.ht22.QLDiemSinhVien.database.ConnectDB;
import com.ht22.QLDiemSinhVien.entity.Khoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//package com.ht22.QLDiemSinhVien.DAO;
//
//import com.ht22.QLDiemSinhVien.entity.Khoa;
//
//public class DAOKhoa implements DaoInterface<Khoa>{
//
//}
public class DAOKhoa implements DaoInterface<Khoa>{
    @Override
    public List<Khoa> getAll() {
        List<Khoa> khoas = new ArrayList<>();
        String query = "SELECT * FROM khoa ;";
        try(Connection conn = ConnectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery() ){
            while(rs.next()){
                Khoa khoa = new Khoa(rs.getString("tenKhoa"), rs.getString("maKhoa"));
                khoas.add(khoa);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return khoas;
    }


    @Override
    public List<Khoa> getAllByKhoaID(String id) {
        return List.of();
    }

    public Khoa getByID(){
        Khoa khoa = new Khoa();
        String query = "SELECT * FROM khoa ;";
        try(Connection conn = ConnectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery() ){

                khoa = new Khoa(rs.getString("tenKhoa"), rs.getString("maKhoa"));


        }catch (SQLException e){
            e.printStackTrace();
        }
        return khoa;

    }

    @Override
    public Optional<Khoa> get(int id) {
        return Optional.empty();
    }

    @Override
    public int insert(Khoa khoa) throws SQLException {
        String query = "INSERT INTO khoa (tenKhoa, maKhoa) VALUES (?, ?)";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, khoa.getTenKhoa());
            stmt.setString(2, khoa.getMaKhoa());

            stmt.executeUpdate();
        } catch (SQLException e) {
            // Thay vì chỉ in stack trace, ném ngoại lệ ra ngoài để nơi gọi có thể bắt
            throw e;
        }
        return 0;
    }

    @Override
    public Boolean update(Khoa khoa) {
        return null;
    }

    @Override
    public Boolean delete(String maKhoa) {
        String query = "DELETE FROM khoa WHERE maKhoa = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maKhoa); // Giả sử lop có phương thức getMaLop()
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Thay vì chỉ in stack trace, ném ngoại lệ ra ngoài để nơi gọi có thể bắt
            e.printStackTrace();
        }
        return true;
    }
}