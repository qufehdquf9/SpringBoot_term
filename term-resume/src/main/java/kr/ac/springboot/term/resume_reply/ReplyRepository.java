package kr.ac.springboot.term.resume_reply;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import kr.ac.springboot.term.resume.Resume;

public interface ReplyRepository extends CrudRepository<Reply, Long>{
//	@Query("SELECT r FROM Reply r WHERE r.resume = ?1"+"AND r.rno > 0 ORDER BY r.rno ASC")
//	public List<Reply> getRepliesOfResume(Resume resume);

    List<Reply> findAllByResumeOrderByUpdatedateDesc(Resume resume);


}
