/**
 * 
 */
package com.example.resources.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.resources.model.Candidate;

/**
 * @author sawai
 *
 */

public interface CandidateRepository extends JpaRepository<Candidate, String> {
	
}
