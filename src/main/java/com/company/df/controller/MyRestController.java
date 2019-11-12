package com.company.df.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 
import com.company.df.model.Lecture;
import com.company.df.model.LectureService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest")
@Slf4j
@RequiredArgsConstructor
public class MyRestController {

	@Autowired
	private final LectureService lectureSerivce= null;

	   
	@CrossOrigin("*")
//	@RequestMapping(value = "/writelecture", method = RequestMethod.GET)
	@PostMapping("/writelecture")
	@ResponseBody
	public ResponseEntity<Lecture> sendViaResponseEntity(
			@RequestBody Map<String, Object> payload,
			HttpServletRequest request) {
		ResponseEntity<Lecture> entity = null;
		
		Lecture lec = null;
		try {
			System.out.println("-------------recv msg-------------");
			String title = payload.get("title").toString();
			String level = payload.get("level").toString();
			String content = payload.get("content").toString();
			String lectureId = payload.get("lectureId").toString();
			String isShow = payload.get("isShow").toString();
			
			if(Integer.parseInt(lectureId) == -1) {
				lec = new Lecture(level, title, content, isShow); 
				return ResponseEntity.ok(lectureSerivce.save(lec));
			}else
			{
				lec = new Lecture(Long.valueOf(lectureId), level, title, content, isShow);
				System.out.println("update("+lectureId+")"); 
				return ResponseEntity.ok(lectureSerivce.update(lec));
			}
			

			
			 
		}catch(Exception e) {
			System.out.println("error :" + e.getMessage());
//			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE);
			return new ResponseEntity(HttpStatus.SERVICE_UNAVAILABLE);
		} 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@CrossOrigin("*")
	@GetMapping("/lecture/a2")
	@ResponseBody
	public ResponseEntity<List<Lecture>> getLectureList(HttpServletRequest request) {
		ResponseEntity entity = null;
		try {
			System.out.println("-------------recv msg-------------");
			String id = request.getParameter("id");
			List<Lecture> list = lectureSerivce.findByTypeAndIsShow("A2", "y"); 
			if(id == null) {
				
				entity = new ResponseEntity(list, HttpStatus.OK);
		        return entity;
			}
			else { 
				List<Lecture> tmp = new ArrayList<>();
				for(Lecture lec : list) {
					if(lec.getId() == Integer.parseInt(id))
					{
						tmp.add(lec);
						break;
					}
				}
				
				entity = new ResponseEntity(tmp, HttpStatus.OK);
		        return entity;
			} 

		}catch(Exception e) {
			System.out.println(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			return entity;
		}
	}
	
	@GetMapping("/irregularverb")
	@ResponseBody
	public ResponseEntity getirregularverb() {
		ResponseEntity entity = null;
		try {
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			entity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	
}
