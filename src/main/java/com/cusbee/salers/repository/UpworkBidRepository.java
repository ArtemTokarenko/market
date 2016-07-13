package com.cusbee.salers.repository;

import com.cusbee.salers.entity.Saler;
import com.cusbee.salers.entity.UpworkBid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UpworkBidRepository extends JpaRepository<UpworkBid, Long> {

    //simple queries
    List<UpworkBid> getBySaler(Saler saler);

    UpworkBid getById(Long id);

    List<UpworkBid> getByCommentLike(String comment);

    UpworkBid getByUrlLike(String url);

    List<UpworkBid> getByActiveTrue();

    List<UpworkBid> getByActiveFalse();

    @Query(value = "SELECT * FROM UPWORKBID WHERE SALER_ID = :salerId AND DATE BETWEEN :dateFrom AND :dateTo", nativeQuery = true)
    List<UpworkBid> getBySalerAndDateBetween(@Param("salerId") Long salerId,
            @Param("dateFrom") String dateFrom,
            @Param("dateTo") String dateTo
    );

    @Query(value = "SELECT * FROM UPWORKBID WHERE SALER_ID = :salerId AND UPDATED_DATE BETWEEN :dateFrom AND :dateTo", nativeQuery = true)
    List<UpworkBid> getBySalerAndUpdatedDateBetween(@Param("salerId") Long salerId,
            @Param("dateFrom") String dateFrom,
            @Param("dateTo") String dateTo
    );

    @Query(value = "SELECT * FROM UPWORKBID WHERE DATE BETWEEN :dateFrom AND :dateTo", nativeQuery = true)
    List<UpworkBid> getAllBetweenDate(@Param("dateFrom") String dateFrom,
            @Param("dateTo") String dateTo
    );

}
