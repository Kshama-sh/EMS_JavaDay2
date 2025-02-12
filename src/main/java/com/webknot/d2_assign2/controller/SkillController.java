package com.webknot.d2_assign2.controller;

import com.webknot.d2_assign2.dto.SkillDto;
import com.webknot.d2_assign2.entity.Skill;
import com.webknot.d2_assign2.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/skills")
public class SkillController {
    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity<Skill> createSkill(@RequestBody SkillDto skill) {
        return ResponseEntity.ok(skillService.addSkill(skill));
    }
}