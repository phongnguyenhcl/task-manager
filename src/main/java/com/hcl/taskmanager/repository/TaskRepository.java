package com.hcl.taskmanager.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.taskmanager.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	@Modifying
	@Query("UPDATE Task t set taskName = :taskName, "
			+ "t.startDate = :startDate, "
			+ "t.endDate = :endDate, "
			+ "t.description = :description, "
			+ "t.email = :email, "
			+ "t.severity = :severity, "
			+ "t.owner = :owner "
			+ "where t.id = :id")

	void updateTask(@Param(value = "id") long id, 
					@Param(value = "taskName") String taskName,
					@Param(value = "startDate") Date startDate, 
					@Param(value = "endDate") Date endDate,
					@Param(value = "description") String description,
					@Param(value = "email") String email,
					@Param(value = "severity") String severity,
					@Param(value = "owner") String owner);

}
