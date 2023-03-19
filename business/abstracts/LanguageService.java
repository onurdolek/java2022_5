package kodlama.io.programming.business.abstracts;

import java.util.List;

import kodlama.io.programming.business.requests.CreateLanguageRequest;
import kodlama.io.programming.business.responses.GetAllLanguageResponse;
import kodlama.io.programming.entities.concretes.Language;

public interface LanguageService {
	void add(CreateLanguageRequest createLanguageRequest);

	List<GetAllLanguageResponse> getAll();

	void delete(int id);

	Language getLanguageById(int id);

	void update(int id, CreateLanguageRequest createLanguageRequest);

}
