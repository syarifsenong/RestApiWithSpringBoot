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
	
	//menambah data karyawan
	@PostMapping
	public ResponseEntity<?> saveKaryawan(@RequestBody Karyawan karyawan){
		String hasil = "Data berhasil ditambahkan";
		karyawanRepository.save(karyawan);
		return new ResponseEntity<>(hasil, HttpStatus.CREATED);
	}
	
	//menampilkan berdasarkan id
		@GetMapping("/{id}")
		public ResponseEntity<?> getKaryawanById(@PathVariable int id) {
			Karyawan findKaryawan = karyawanRepository.findById(id).orElse(null);
			String hasil = "";
			if(findKaryawan==null) {
				hasil = "id "+id+" tidak ditemukan";
				return new ResponseEntity<>(hasil, HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(findKaryawan, HttpStatus.OK);
		}
		
		@PutMapping("/{id}")
		public ResponseEntity<?> updateKaryawan(@RequestBody Karyawan karyawan, @PathVariable int id){
			Karyawan findKaryawan = karyawanRepository.findById(id).orElse(null);
			String hasil = "";
			if(findKaryawan==null) {
				hasil = "id "+id+" tidak ditemukan";
				return new ResponseEntity<>(hasil, HttpStatus.NOT_FOUND);
			}
			findKaryawan.setNama(karyawan.getNama());
			findKaryawan.setAlamat(karyawan.getAlamat());
			findKaryawan.setPosisi(karyawan.getPosisi());
			Karyawan updateKaryawan = karyawanRepository.save(findKaryawan);
			return new ResponseEntity<>(updateKaryawan, HttpStatus.OK);
		}
		

		
//		@DeleteMapping("/{id}")
//		public ResponseEntity<?> deleteKaryawan(@PathVariable int id) {
//			Karyawan findKaryawan = repo.findById(id).orElse(null);
//			String hasil = "";
//			if(findKaryawan==null) {
//				hasil = "id "+id+" tidak ditemukan";
//				return new ResponseEntity<>(hasil, HttpStatus.NOT_FOUND);
//			}
//			hasil = "id "+id+" berhasil dihapus";
//			repo.deleteById(id);
//			return new ResponseEntity<>(hasil, HttpStatus.ACCEPTED);
//		}
		@DeleteMapping("/{id}")
		public String deleteKaryawan(@PathVariable int id) {
			Karyawan findKaryawan = karyawanRepository.findById(id).orElse(null);
			String hasil = "";
			if(findKaryawan==null) {
				hasil = "id "+id+" tidak ditemukan";
				return hasil;
			}
			hasil = "id "+id+" berhasil dihapus";
			karyawanRepository.deleteById(id);
			return hasil;
		}
		
}
