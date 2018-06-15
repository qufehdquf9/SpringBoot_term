package kr.ac.springboot.term;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import kr.ac.springboot.term.experience.Experience;
import kr.ac.springboot.term.experience.ExperienceRepository;
import kr.ac.springboot.term.resume.Resume;
import kr.ac.springboot.term.resume.ResumeRepository;

@Component
public class DataLoader implements ApplicationRunner {
	
	@Autowired
	private ResumeRepository repo;
	
	@Autowired
	private ExperienceRepository expeRepo;
	
    @Override
    public void run(ApplicationArguments args) {
    Resume resume = new Resume("최영진","term","2012551117","cyjin9.yc@gmail.com","경성대학교");
       repo.save(resume);
       expeRepo.save(new Experience("software engineer", "최영진", "qufehdquf9@github.com", "2018.06.15", resume));
    }
}