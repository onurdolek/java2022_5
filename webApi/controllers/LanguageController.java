package kodlama.io.programming.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.programming.business.abstracts.LanguageService;
import kodlama.io.programming.business.requests.CreateLanguageRequest;
import kodlama.io.programming.business.responses.GetAllLanguageResponse;
import kodlama.io.programming.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageController {
	LanguageService languageService;

	@Autowired
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@PostMapping("/add")
	public void add(CreateLanguageRequest createLanguageRequest) {
		this.languageService.add(createLanguageRequest);
	}

	@GetMapping("/listall")
	public List<GetAllLanguageResponse> listAll() {
		return languageService.getAll();
	}

	@GetMapping("/getlanguagebyid/{languageId}")
	public Language getLanguageById(@PathVariable("languageId") int id) {
		return languageService.getLanguageById(id);
	}

	@DeleteMapping("/delete/{languageId}")
	public void deleteLanguage(@PathVariable("languageId") int id) {
		this.languageService.delete(id);
	}

	@PutMapping("/update/{languageId}")
	public void update(@PathVariable("languageId") int id, CreateLanguageRequest createLanguageRequest) {
		this.languageService.update(id, createLanguageRequest);
	}

	// Different update and business logic approach if name and technology NOT
	// Repeat:
	// @PutMapping(path="/update/{languageId}")
	// public void updateLanguage (
	// @PathVariable("languageId") Long languageId,
	// @RequestParam(required=false) String name,
	// @RequestParam(required=false) String technology) {
	// languageService.updatelanguage (languageId,name,technology); }

}
