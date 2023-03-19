package kodlama.io.programming.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.programming.business.abstracts.LanguageService;
import kodlama.io.programming.business.requests.CreateLanguageRequest;
import kodlama.io.programming.business.responses.GetAllLanguageResponse;
import kodlama.io.programming.dataAccess.LanguageRepository;
import kodlama.io.programming.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {

	private LanguageRepository languageRepository;

	@Autowired
	public LanguageManager(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public void add(CreateLanguageRequest createLanguageRequest) {
		Language language = new Language();
		language.setName(createLanguageRequest.getName());
		language.setTechnology(createLanguageRequest.getTechnology());
		this.languageRepository.save(language);
	}

	@Override
	public List<GetAllLanguageResponse> getAll() {
		List<Language> languages = languageRepository.findAll();
		List<GetAllLanguageResponse> brandResponse = new ArrayList<GetAllLanguageResponse>();
		for (Language language : languages) {
			GetAllLanguageResponse responseItem = new GetAllLanguageResponse();
			responseItem.setId(language.getId());
			responseItem.setName(language.getName());
			responseItem.setTechnology(language.getTechnology());
			brandResponse.add(responseItem);
		}
		return brandResponse;
	}

	@Override
	public void delete(int id) {
		languageRepository.deleteById(id);

	}

	@Override
	public Language getLanguageById(int id) {
		return languageRepository.findById(id).get();

	}

	@Override
	public void update(int id, CreateLanguageRequest createLanguageRequest) {

		Optional<Language> updatelanguage = languageRepository.findById(id);
		updatelanguage.get().setName(createLanguageRequest.getName());
		updatelanguage.get().setTechnology(createLanguageRequest.getTechnology());
		this.languageRepository.save(updatelanguage.get());

	}
	
	// Different update and business logic approach if name and technology NOT
	// Repeat:
	//@Transactional
	//public void updateLanguage(Long languageId,String name,String technology){
	//Language language = languageRepository.findById(languageId)
	// .orElseThrow(()-> new IllegalStateException("language with id " + languageId + " does not exist")
	// if ( name != null && name.length()>0 && !Objects.equals(language.getName(),name)
	// {language.setName(name);}
	// if ( technology != null && technoogy.length()>0 && !Objects.equals(language.getTechnology(),technology)
	// { Optional<Language>languageOptional=languageRepository.findlanguageByTechnology(technology);
	// if (LanguageOptional.isPresent()){
	// throw new IllegalStateException("technology taken");}
	// language.SetTechnology(technology); }
}
