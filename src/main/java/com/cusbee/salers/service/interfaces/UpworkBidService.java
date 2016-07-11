package com.cusbee.salers.service.interfaces;

import com.cusbee.salers.beans.UpworkBidBean;
import com.cusbee.salers.entity.UpworkBid;

import java.util.Date;
import java.util.List;

public interface UpworkBidService {

    void add(UpworkBid upworkBid);

    void update(UpworkBid upworkBid);

    void delete(Integer id);

    List<UpworkBidBean> getAll();

    List<UpworkBidBean> getBySaler(Integer salerId);

    List<UpworkBidBean> getByComment(String comment);

    List<UpworkBidBean> getAllActive ();

    List<UpworkBidBean> getAllInactive ();

    UpworkBidBean getByUrl(String url);

    void changeActivity(Integer id);

    List<UpworkBidBean> getBySalerAndDateBetween(Integer salerId, Date dateFrom, Date dateTo);

    List<UpworkBidBean> getBySalerAndUpdatedDateBetween(Integer salerId, Date dateFrom, Date dateTo);

    List<UpworkBidBean> getAllBetweenDate(Date dateFrom, Date dateTo);

}
