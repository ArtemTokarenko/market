package com.cusbee.salers.service.interfaces;

import com.cusbee.salers.beans.UpworkBidBean;
import com.cusbee.salers.entity.UpworkBid;

import java.util.List;

public interface UpworkBidService {

    void add(UpworkBid upworkBid);

    void update(UpworkBid upworkBid);

    void delete(Long id);

    List<UpworkBidBean> getAll();

    List<UpworkBidBean> getBySaler(Long salerId);

    List<UpworkBidBean> getByComment(String comment);

    List<UpworkBidBean> getAllActive ();

    List<UpworkBidBean> getAllInactive ();

    UpworkBidBean getByUrl(String url);

    void changeActivity(Long id);

    List<UpworkBidBean> getBySalerAndDateBetween(Long salerId, String dateFrom, String dateTo);

    List<UpworkBidBean> getBySalerAndUpdatedDateBetween(Long salerId, String dateFrom, String dateTo);

    List<UpworkBidBean> getAllBetweenDate(String dateFrom, String dateTo);

}
