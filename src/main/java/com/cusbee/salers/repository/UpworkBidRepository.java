package com.cusbee.salers.repository;

import com.cusbee.salers.entity.Saler;
import com.cusbee.salers.entity.UpworkBid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface UpworkBidRepository extends JpaRepository<UpworkBid, Integer> {

    //simple queries
    List<UpworkBid> getBySaler(Saler saler);

    UpworkBid getById(Integer id);

    List<UpworkBid> getByComment(String comment);

    UpworkBid getByUrl(String url);

    List<UpworkBid> getByActiveTrue();

    List<UpworkBid> getByActiveFalse();

    //complicated queries
    @Query(value = "SELECT u FROM UpworkBid u WHERE u.saler = :saler AND u.date BETWEEN :dateFrom AND :dateTo")
    List<UpworkBid> getBySalerAndDateBetween(@Param("saler") Saler saler, @Param("dateFrom") Date dateFrom,
            @Param("dateTo") Date dateTo);

    @Query(value = "SELECT u FROM UpworkBid u WHERE u.saler = :saler AND u.updatedDate BETWEEN :dateFrom AND :dateTo")
    List<UpworkBid> getBySalerAndUpdatedDateBetween(@Param("saler") Saler saler,
            @Param("dateFrom") Date dateFrom,
            @Param("dateTo") Date dateTo);

    @Query(value = "SELECT u FROM UpworkBid u WHERE u.date BETWEEN :dateFrom AND :dateTo")
    List<UpworkBid> getAllBetweenDate(@Param("dateFrom") Date dateFrom,
            @Param("dateTo") Date dateTo);

}
