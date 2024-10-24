package com.ht22.QLDiemSinhVien.DAO;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DaoInterface<T> {
    List<T> getAll();
    List<T> getAllByKhoaID(String id);
    Optional<T> get(int id);
    int insert(T t) throws SQLException;
    Boolean update(T t);
    Boolean delete(String maLop);
}
