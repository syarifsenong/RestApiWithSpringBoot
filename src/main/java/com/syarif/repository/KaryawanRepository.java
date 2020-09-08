package com.syarif.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.syarif.entity.Karyawan;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Integer>{

}
