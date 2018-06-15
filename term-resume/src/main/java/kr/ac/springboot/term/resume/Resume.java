package kr.ac.springboot.term.resume;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.resume_reply.Reply;

@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bno;

    private String name;
    private String content;
    private String studentId;
    private String email;
    private String university;
	@CreationTimestamp
    private Timestamp regdate;
    
    @UpdateTimestamp
    private Timestamp updatedate;

    
    @JsonIgnore
    @OneToMany(mappedBy="resume", fetch=FetchType.LAZY)
    private List<Experience> experience;
    
    @JsonIgnore
    @OneToMany(mappedBy="resume", fetch=FetchType.LAZY)
    private List<Reply> reply;
    
    public Resume() {
    	
    }
    public Resume(String name,String content,String studentId,String email,String university) {
    		this.name = name;
    		this.content = content;
    		this.studentId = studentId;
    		this.email = email;
    		this.university = university;
    		
    }
    
    public List<Experience> getExperience() {
		return experience;
	}
	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
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


    public Long getBno() {
        return bno;
    }

    public void setBno(Long bno) {
        this.bno = bno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Resume [bno=" + bno + ", name=" + name + ", content=" + content + ", studentId=" + studentId
				+ ", email=" + email + ", university=" + university + ", regdate=" + regdate + ", updatedate="
				+ updatedate + "]";
	}
    
}
