package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Karyawan;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Integer>{

}
