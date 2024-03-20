package pt05.com.sg.data.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import pt05.com.sg.data.entity.RuleCode;

@Repository
public interface RuleCodeRepository extends CrudRepository<RuleCode, Long>{
	
	 @Query("SELECT ruleCode FROM RuleCode ruleCode WHERE ruleCode.ruleCodeId = ?1")
	 Optional<RuleCode> findByRuleCodeId(long ruleCodeid);
	
}
