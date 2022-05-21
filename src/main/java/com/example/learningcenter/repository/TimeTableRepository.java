package com.example.learningcenter.repository;

import com.example.learningcenter.entity.TimeTable;
import com.example.learningcenter.repository.base.BaseRepository;
import com.example.learningcenter.utill.enums.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface TimeTableRepository extends JpaRepository<TimeTable, Long>, BaseRepository {

    @Transactional
    @Query(nativeQuery = true, value = "select count(*) " +
            "from time_table " +
            "where room_id =:roomId " +
            "and day =:day " +
            "and ((start_time >=:startTime and end_time <=:endTime) or " +
            "(start_time <=:startTime and end_time >=:endTime))")
    Integer checkAllPossibleCases(Long roomId,
                                  String day,
                                  LocalDateTime startTime,
                                  LocalDateTime endTime);

    @Transactional
    @Query(nativeQuery = true, value = "select count(*) " +
            "from time_table " +
            "where id=:id and room_id =:roomId " +
            "and day =:day " +
            "and ((start_time >:startTime and end_time <:endTime) or " +
            "(start_time <:startTime and end_time >:endTime))")
    Integer checkAllPossibleCasesButIdNot(Long id,
                                          Long roomId,
                                          String day,
                                          LocalDateTime startTime,
                                          LocalDateTime endTime);

}
