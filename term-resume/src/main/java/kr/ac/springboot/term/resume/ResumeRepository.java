package kr.ac.springboot.term.resume;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ResumeRepository extends CrudRepository<Resume, Long> {
	List<Resume> findAllByOrderByRegdateDesc(); //시간대로 정렬해서 리스트에 넣는
}
