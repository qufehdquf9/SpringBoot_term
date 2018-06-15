package kr.ac.springboot.term.experience;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.resume.Resume;

@Entity
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rno;
	
	private String projectName;
	private String myPosition;
	private String projectContent;
	private String term;
	
	@CreationTimestamp
	private Timestamp regdate;
	
	@UpdateTimestamp
	private Timestamp updatedate;
	
    @JsonIgnore
    @ManyToOne(fetch=FetchType.LAZY)
    private Resume resume;
	
	public Experience() {
		
	}


	public Experience(String projectName, String myPosition, String projectContent, String term, Resume resume) {
		this.projectName = projectName;
		this.myPosition = myPosition;
		this.projectContent = projectContent;
		this.term = term;
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "Experience [rno=" + rno + ", projectName=" + projectName + ", myPosition=" + myPosition
				+ ", projectContent=" + projectContent + ", term=" + term + ", regdate=" + regdate + ", updatedate="
				+ updatedate + "]";
	}

	public Resume getResume() {
		return resume;
	}


	public void setResume(Resume resume) {
		this.resume = resume;
	}


	public Long getRno() {
		return rno;
	}

	public void setRno(Long rno) {
		this.rno = rno;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getMyPosition() {
		return myPosition;
	}

	public void setMyPosition(String myPosition) {
		this.myPosition = myPosition;
	}

	public String getProjectContent() {
		return projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public Timestamp getRegdate() {
		return regdate;
	}

	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}

	public Timestamp getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Timestamp updatedate) {
		this.updatedate = updatedate;
	}
	
}
