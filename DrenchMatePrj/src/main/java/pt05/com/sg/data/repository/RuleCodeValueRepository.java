package pt05.com.sg.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import pt05.com.sg.data.entity.RuleCodeValue;
@Repository
public interface RuleCodeValueRepository extends CrudRepository<RuleCodeValue, Long>{
	
	 @Query("SELECT ruleCodeValue FROM RuleCodeValue ruleCodeValue WHERE ruleCodeValue.ruleCode.ruleCodeId = ?1")
	 Optional<List<RuleCodeValue>> findByCodeValueId(long ruleCodeid);
	 
	 @Query("SELECT ruleCodeValue FROM RuleCodeValue ruleCodeValue WHERE ruleCodeValue.ruleCode.code=?1")
	 Optional<List<RuleCodeValue>> findCodeValueByCode(String ruleCode);
	  
	 Optional<RuleCodeValue> findByRuleCodeValueId(Long ruleCodeValueId);
	 

}
