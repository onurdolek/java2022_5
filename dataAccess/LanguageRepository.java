package kodlama.io.programming.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.programming.entities.concretes.Language;

public interface LanguageRepository extends JpaRepository<Language, Integer> {

}
