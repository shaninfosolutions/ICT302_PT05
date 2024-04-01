package pt05.com.sg.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pt05.com.sg.data.entity.EmailTemplate;

@Repository
public interface EmailTemplateRepository extends CrudRepository<EmailTemplate, Long>{

	//@Query("SELECT t FROM EmailTemplate t WHERE t.templateNumber = ?1")
	Optional<EmailTemplate> findByTemplateNumber(Long templateNumber);
	
	Optional<EmailTemplate> findByEmailTemplateId(Long emailTemplateId);
	
	Optional<EmailTemplate> findByTemplateName(String templateName);
}
