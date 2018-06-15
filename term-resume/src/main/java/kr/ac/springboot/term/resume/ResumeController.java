package kr.ac.springboot.term.resume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ResumeController {

    // '/' ==> list
    // '/register' ==> create
    // '/{rno} ==> view
    // '/{rno}/update ==> update'
    // '/{rno}/delete ==> delete'
	@Autowired
	ResumeRepository repo;
	
    @GetMapping("/")
    public String resumeIndex(Model model) {
//        Resume resume = new Resume();
//        resume.setName("최영진");
//        model.addAttribute("resume", resume);
    		model.addAttribute("resume",repo.findAllByOrderByRegdateDesc());
        return "resume";
    }



}
