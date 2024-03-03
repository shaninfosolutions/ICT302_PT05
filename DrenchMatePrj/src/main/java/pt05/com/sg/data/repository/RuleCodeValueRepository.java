package pt05.com.sg.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pt05.com.sg.data.entity.RuleCodeValue;
@Repository
public interface RuleCodeValueRepository extends CrudRepository<RuleCodeValue, Long>{

}
