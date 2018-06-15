package kr.ac.springboot.term.experience;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.springboot.term.resume.ResumeRepository;



@Controller
@RequestMapping("/experience/")//알아보기

public class ExperienceController {
	
	@Autowired
	ExperienceRepository repo;
	
	@Autowired
	ResumeRepository reRepo;
	
	@GetMapping("/")
	public String list(Model model) {
		model.addAttribute("result",repo.findAllByOrderByRegdateDesc());
		
		return "experience";
	}
	@GetMapping("/register")
	public void registerGET(@ModelAttribute("vo") Experience vo) {
		
	}
	@PostMapping("/register")
	public String registerPost(@ModelAttribute("vo") Experience vo) {
		vo.setResume(reRepo.findById(1L).get());
		repo.save(vo);
		return "redirect:/experience/";
	}
    @GetMapping("/{rno}")
    public String view(@PathVariable("rno") long rno, Model model) {
        if (repo.findById(rno).isPresent()) {
            model.addAttribute("result", repo.findById(rno).get());
        } else {
            return "errors/404";
        }
        return "experience/view";
    }
    @GetMapping("/{rno}/delete")
    public String delete(@PathVariable("rno") long rno) {
        if (repo.findById(rno).isPresent()) {
            repo.deleteById(rno);
        } else {
            return "errors/404";
        }
        return "redirect:/experience/";
    }
    @GetMapping("/{rno}/update")
    public String editGet(@PathVariable("rno") long rno, @ModelAttribute("vo") Experience vo, Model model) {
        if (repo.findById(rno).isPresent()) {
            model.addAttribute("vo", repo.findById(rno).get());
        } else {
            return "errors/404";
        }
        return "experience/update";
    }

    @PostMapping("/update")
    public String editPost(@ModelAttribute("vo") Experience vo) {
        Optional<Experience> experience = repo.findById(vo.getRno());
        if (experience.isPresent()) {
        		experience.get().setMyPosition(vo.getMyPosition());
        		experience.get().setProjectContent(vo.getProjectContent());
        		experience.get().setTerm(vo.getTerm());
        		experience.get().setProjectName(vo.getProjectName());
             
        		repo.save(experience.get());
        } else {
            repo.save(vo);
        }
        return "redirect:/experience/";
    }
}
