package pt05.com.sg.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt05.com.sg.data.dto.NoteDto;
import pt05.com.sg.data.dto.RuleCodeDto;
import pt05.com.sg.data.dto.RuleCodeValueDto;
import pt05.com.sg.data.entity.Note;
import pt05.com.sg.data.entity.RuleCode;
import pt05.com.sg.data.entity.RuleCodeValue;
import pt05.com.sg.data.repository.RuleCodeRepository;
import pt05.com.sg.data.repository.RuleCodeValueRepository;
import pt05.com.sg.service.RuleCodeService;
import pt05.com.sg.util.NoteHelper;

@Service
public class RuleCodeServiceImpl implements RuleCodeService {
	private static final Logger log = LoggerFactory.getLogger(RuleCodeServiceImpl.class);

	@Autowired
	private RuleCodeRepository ruleCodeRepository;

	@Autowired
	private RuleCodeValueRepository ruleCodeValueRepository;

	public List<RuleCodeDto> getList() {
		// return (List<RuleCode>) this.ruleCodeRepository.findAll();

		List<RuleCode> list = (List<RuleCode>) this.ruleCodeRepository.findAll();
		List<RuleCodeDto> ruleCodeDtolist = null;
		try {
			if (list != null) {
				ruleCodeDtolist = new ArrayList<>();
				for (RuleCode rc : list) {
					RuleCodeDto dto = new RuleCodeDto();
					dto.setRuleCodeId(rc.getRuleCodeId());
					dto.setCode(rc.getCode());
					dto.setCodeDesc(rc.getCodeDesc());
					dto.setRemarks(rc.getRemarks());

					ruleCodeDtolist.add(dto);
				}
			} else {
				ruleCodeDtolist = null;
			}

		} catch (Exception e) {
			log.info("System Exception");
		}
		return ruleCodeDtolist;

	}

	public RuleCodeDto getRuleByCodeId(Long ruleCodeId) {
		log.info("Get Rulee Code: " + ruleCodeId);
		Optional<RuleCode> ruleCode = this.ruleCodeRepository.findByRuleCodeId(ruleCodeId);
		RuleCodeDto ruleCodeDto = null;
		try {

			if (ruleCode.isPresent() && ruleCode.get() != null) {
				// noteDto=NoteHelper.mapNoteDto(note.get());
				log.info("Rule Code DTO Setting: " + ruleCodeId);
				RuleCode ruleCodeDb = ruleCode.get();

				ruleCodeDto = new RuleCodeDto();
				ruleCodeDto.setRuleCodeId(ruleCodeDb.getRuleCodeId());
				ruleCodeDto.setCode(ruleCodeDb.getCode());
				ruleCodeDto.setCodeDesc(ruleCodeDb.getCodeDesc());
				ruleCodeDto.setRemarks(ruleCodeDb.getRemarks());

				log.info("Rule Code DTO Setting: " + ruleCodeDb.getCode());

				List<RuleCodeValue> listCv = ruleCodeDb.getRuleCodeValue();
				List<RuleCodeValueDto> cvdtoList = new ArrayList<>();

				for (RuleCodeValue cv : listCv) {
					RuleCodeValueDto cvdto = new RuleCodeValueDto();

					cvdto.setRuleCodeValueId(cv.getRuleCodeValueId());
					cvdto.setCode(cv.getCode());
					cvdto.setCodeDesc(cv.getCodeDesc());
					cvdto.setCodeValue(cv.getCodeValue());
					cvdto.setRemarks(cv.getRemarks());

					cvdtoList.add(cvdto);
				}

				ruleCodeDto.setRuleCodeValueList(cvdtoList);

			} else {
				log.info("Rule Code not exist in the System!!!!");
				ruleCodeDto = null;
			}

		} catch (Exception e) {
			log.info("System Exception");
		}

		return ruleCodeDto;

	}

	public RuleCode addOrUpdate(RuleCode ruleCode) {
		return this.ruleCodeRepository.save(ruleCode);
	}

}
