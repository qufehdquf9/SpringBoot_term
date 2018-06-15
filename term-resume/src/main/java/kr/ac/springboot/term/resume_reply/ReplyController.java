package kr.ac.springboot.term.resume_reply;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import kr.ac.springboot.term.resume.Resume;

@RestController
@RequestMapping("/replies/*")
public class ReplyController {

	@Autowired
	private ReplyRepository replyRepo;
	
    @GetMapping("/{bno}")
    public ResponseEntity<List<Reply>> getReplies(@PathVariable("bno") Long bno) {

        Resume resume = new Resume();
        resume.setBno(bno);
        return new ResponseEntity<>(getListByResume(resume), HttpStatus.OK);
    }

	@Transactional
	@PostMapping("/{bno}")
	public ResponseEntity<List<Reply>> addReply(
			@PathVariable("bno")Long bno,
			@RequestBody Reply reply){
			
			Resume resume = new Resume();
			resume.setBno(bno);
			System.out.println("------------------------------------------");

			System.out.println(bno);
			reply.setResume(resume);
			replyRepo.save(reply);
			
		return new ResponseEntity<>(getListByResume(resume), HttpStatus.CREATED);
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
		return replyRepo.getRepliesOfResume(resume);
//		return null;
	}
	
	  @Transactional
	    @PutMapping("/{bno}")
	    public ResponseEntity<List<Reply>> modify(@PathVariable("bno") Long bno, @RequestBody Reply reply) {

	        replyRepo.findById(reply.getRno()).ifPresent(origin -> {
	            origin.setReplyText(reply.getReplyText());
	            origin.setReplyer(reply.getReplyer());
	            replyRepo.save(origin);
	        });

	        Resume resume = new Resume();
	        resume.setBno(bno);

	        return new ResponseEntity<>(getListByResume(resume), HttpStatus.OK);
	    }

}
