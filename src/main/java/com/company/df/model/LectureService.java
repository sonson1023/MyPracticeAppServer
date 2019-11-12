package com.company.df.model;
 
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LectureService {
	@Autowired
	  private  LectureRepository lectureRespository;

	    public List<Lecture> findAll() {
	        return (List<Lecture>) lectureRespository.findAll();
	    }

	    public Optional<Lecture> findById(Long id) {
	        return lectureRespository.findById(id);
	    }
	    
	    @Transactional
	    public Lecture save(Lecture lecture) {
	        return lectureRespository.save(lecture);
	    }

	    public void deleteById(Long id) {
	    	lectureRespository.deleteById(id);
	    }
	    public List<Lecture> findByTypeAndIsShow(String type, String isShow){
	    	return lectureRespository.findByTypeAndIsShow(type, isShow);
	    }
	    
	    public Lecture update(Lecture lecture) {
	    	Optional<Lecture> opt = lectureRespository.findById(lecture.getId());
	    	Lecture tmp = opt.get();
	    	tmp.setContent(lecture.getContent());
	    	tmp.setIsShow(lecture.getIsShow());
	    	return lectureRespository.save(lecture);
	    }
}