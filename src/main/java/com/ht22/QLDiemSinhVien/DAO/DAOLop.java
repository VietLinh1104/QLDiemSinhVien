package com.ht22.QLDiemSinhVien.DAO;

import com.ht22.QLDiemSinhVien.database.ConnectDB;
import com.ht22.QLDiemSinhVien.entity.Lop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOLop implements DaoInterface<Lop>{

    @Override
    public List<Lop> getAll() {

        List<Lop> lops = new ArrayList<>();
        String query = "SELECT * FROM lop ;";
        try(Connection conn = ConnectDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery() ){
            while(rs.next()){
                Lop lop = new Lop(rs.getString("tenLop"), rs.getString("maLop"), rs.getString("makhoa"), rs.getInt("soSV"));
                lops.add(lop);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lops;
    }

    @Override
    public List<Lop> getAllByKhoaID(String id) {
        List<Lop> lops = new ArrayList<>();
        String query = "SELECT * FROM lop WHERE maKhoa = ?;";

        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Đặt giá trị cho tham số
            stmt.setString(1, id);

            // Thực thi truy vấn
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Lop lop = new Lop(rs.getString("tenLop"), rs.getString("maLop"), rs.getString("maKhoa"), rs.getInt("soSV"));
                    lops.add(lop);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lops;
    }

    @Override
    public Optional<Lop> get(int id) {
        return Optional.empty();
    }

    @Override
    public int insert(Lop lop) throws SQLException {
        String query = "INSERT INTO lop (tenLop, maLop, maKhoa, soSV) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, lop.getTenLop());
            stmt.setString(2, lop.getMaLop());
            stmt.setString(3, lop.getMaKhoa());
            stmt.setInt(4, lop.getSoSV());
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Thay vì chỉ in stack trace, ném ngoại lệ ra ngoài để nơi gọi có thể bắt
            throw e;
        }
        return 0;
    }


    @Override
    public Boolean update(Lop lop) {
        return null;
    }


    @Override
    public Boolean delete(String maLop) {
        String query = "DELETE FROM lop WHERE maLop = ?";
        try (Connection conn = ConnectDB.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, maLop); // Giả sử lop có phương thức getMaLop()
            stmt.executeUpdate();
        } catch (SQLException e) {
            // Thay vì chỉ in stack trace, ném ngoại lệ ra ngoài để nơi gọi có thể bắt
            e.printStackTrace();
        }
        return true;
    }
}
