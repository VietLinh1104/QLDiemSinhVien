package com.ht22.QLDiemSinhVien.DAO;

import com.ht22.QLDiemSinhVien.entity.Subject;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SubjectDao implements DaoInterface<Subject>{
    @Override
    public List<Subject> getAll() {
        return List.of();
    }

    @Override
    public List<Subject> getAllByKhoaID(String id) {
        return List.of();
    }

    @Override
    public Optional<Subject> get(int id) {
        return Optional.empty();
    }

    @Override
    public int insert(Subject subject) throws SQLException {
        return 0;
    }

    @Override
    public Boolean update(Subject subject) {
        return null;
    }

    @Override
    public Boolean delete(String maLop) {
        return null;
    }
}
