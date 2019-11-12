package com.company.df.model;


import java.util.List;
import java.util.Optional;
 
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IrregularVerbRepository extends JpaRepository<Lecture, Long> {
 
	@Query(value="select * from tb_lecture  where type = :type", nativeQuery = true)
//    List<Lecture> findByType(String type);
	
//	@Query(value = "select a from tb_lecture a where a.type = :type")
	List<Lecture> findByType(@Param("type") String type);

}
