/**
 * 
 */
package com.example.resources.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.resources.model.Candidate;
import com.example.resources.service.CandidateService;

/**
 * @author sawai
 *
 */

@RestController
@RequestMapping(value = "/candidate")
public class CandidateController {

	@Autowired
	private CandidateService candidateService;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Candidate candidate(@RequestBody Candidate candidate) {
		return candidateService.create(candidate);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Candidate getById(@PathVariable("id") String id) {
		return candidateService.getById(id);
	}
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Candidate> getAll() {
		return candidateService.getAll();
	}
}
