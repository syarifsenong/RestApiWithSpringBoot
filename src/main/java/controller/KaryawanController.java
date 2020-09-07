package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import repository.KaryawanRepository;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {

	//memanggil repo
	private KaryawanRepository karyawanRepository;

	public KaryawanController(KaryawanRepository karyawanRepository) {
		this.karyawanRepository = karyawanRepository;
	}
	
	//menampilkan seluruh data karyawan
	@GetMapping
	public ResponseEntity<?> getKaryawan(){
		return new ResponseEntity<>(karyawanRepository.findAll(), HttpStatus.OK);
	}
	
}
