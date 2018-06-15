package kr.ac.springboot.term.resume_reply;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.springboot.term.resume.Resume;

@RestController
@RequestMapping("/replies/")
public class ReplyController {

	@Autowired
	private ReplyRepository replyRepo;
	
	@Transactional
	@PostMapping("/{rno}")
	public ResponseEntity<Void> addReply(
			@PathVariable("rno")Long rno,
			@RequestBody Reply reply){
			
			Resume resume = new Resume();
			resume.setBno(rno);
			
			reply.setResume(resume);
			replyRepo.save(reply);
			
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	   @Transactional
	    @DeleteMapping("/{bno}/{rno}")
	    public ResponseEntity<List<Reply>> remove(
	            @PathVariable("bno") Long bno,
	            @PathVariable("rno") Long rno) {

	        replyRepo.deleteById(rno);

	        Resume resume = new Resume();
	        resume.setBno(bno);

	        return new ResponseEntity<>(getListByResume(resume), HttpStatus.OK);

	    }
	private List<Reply> getListByResume(Resume resume)throws RuntimeException{
		// TODO Auto-generated method stub
//		return replyRepo.getRepliesOfResume(resume);
		return null;
	}

}
