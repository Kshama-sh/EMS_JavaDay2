package com.webknot.d2_assign2.service;

import com.webknot.d2_assign2.dto.SkillDto;
import com.webknot.d2_assign2.entity.Skill;
import com.webknot.d2_assign2.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    @Autowired
    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill addSkill(SkillDto ski) {
        Skill skill=Skill.builder()
                .skillName(ski.getSkillName())
                .build();
        return skillRepository.save(skill);
    }
}
