package com.syarif.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syarif.entity.Karyawan;
import com.syarif.repository.KaryawanRepository;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {

	//memanggil repo
	@Autowired
	public KaryawanRepository karyawanRepository;

	public KaryawanController(KaryawanRepository karyawanRepository) {
		this.karyawanRepository = karyawanRepository;
	}
	
	//menampilkan seluruh data karyawan
	@GetMapping
	public ResponseEntity<?> getKaryawan(){
		return new ResponseEntity<>(karyawanRepository.findAll(), HttpStatus.OK);
	}
	
	
	
}
