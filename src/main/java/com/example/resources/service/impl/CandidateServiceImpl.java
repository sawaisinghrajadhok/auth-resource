/**
 * 
 */
package com.example.resources.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.resources.model.Candidate;
import com.example.resources.model.User;
import com.example.resources.repository.CandidateRepository;
import com.example.resources.service.CandidateService;
import com.example.resources.utils.JWTUtils;

/**
 * @author sawai
 *
 */

@Service
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;
	
	@Override
	public Candidate create(Candidate candidate) {
		System.out.println((com.example.resources.model.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String id = user.getId();
		candidate.setId(id);
		return candidateRepository.save(candidate);
	}

	@Override
	public Candidate getById(String id) {
		return candidateRepository.findOne(id);
	}

	@Override
	public List<Candidate> getAll() {
		return candidateRepository.findAll();
	}
}
