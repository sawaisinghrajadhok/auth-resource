/**
 * 
 */
package com.example.resources.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author sawai
 *
 */

@Entity
@Table(name = "CANDIDATE")
//@TableGenerator(name = "CANDIDATE_GENERATOR", initialValue = 0, allocationSize = 1)
//@PrimaryKeyJoinColumn(name = "id")
public class Candidate implements Serializable { //extends User {

	private static final long serialVersionUID = -4312063000076942163L;

	@Id
	private String id;
	
	private String address;
	
	private String qualification;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "Candidate [address=" + address + ", qualification="
				+ qualification + "]";
	}
}
