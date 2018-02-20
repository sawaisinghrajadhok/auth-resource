/**
 * 
 */
package com.example.resources.service;

import java.util.List;
import com.example.resources.model.Candidate;

/**
 * @author sawai
 *
 */

public interface CandidateService {
	
	public Candidate create(Candidate candidate);
	
	public Candidate getById(String id);
	
	public List<Candidate> getAll();
}
