package com.cusbee.salers.service.impl;

import com.cusbee.salers.beans.UpworkBidBean;
import com.cusbee.salers.entity.Saler;
import com.cusbee.salers.entity.UpworkBid;
import com.cusbee.salers.repository.SalerRepository;
import com.cusbee.salers.repository.UpworkBidRepository;
import com.cusbee.salers.service.interfaces.UpworkBidService;
import com.cusbee.salers.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UpworkBidServiceImpl implements UpworkBidService {

    @Autowired
    private UpworkBidRepository upworkBidRepository;

    @Autowired
    private SalerRepository salerRepository;

    @Override
    public void add(UpworkBid upworkBid) {
        upworkBid.setDate(DateTimeUtil.setCurrentDateTime());
        upworkBidRepository.save(upworkBid);
    }

    @Override
    public void update(UpworkBid upworkBid) {
        upworkBid.setUpdatedDate(DateTimeUtil.setCurrentDateTime());
        upworkBidRepository.save(upworkBid);
    }

    @Override
    public void delete(Long id) {
        upworkBidRepository.delete(id);
    }

    @Override
    public void changeActivity(Long id) {
        UpworkBid bid = upworkBidRepository.getById(id);
        bid.setActive(bid.isActive() ? false : true);
        bid.setUpdatedDate(DateTimeUtil.setCurrentDateTime());
        upworkBidRepository.save(bid);
    }

    @Override
    @Transactional
    public List<UpworkBidBean> getAll() {
        List<UpworkBidBean> upworkBidBeanList = new ArrayList<>();
        List<UpworkBid> upworkBidList = upworkBidRepository.findAll();
        upworkBidList.forEach(u -> upworkBidBeanList.add(UpworkBidBean.toBean(u)));
        return upworkBidBeanList;
    }

    @Override
    @Transactional
    public List<UpworkBidBean> getBySaler(Long salerId) {
        Saler saler = salerRepository.getById(salerId);
        List<UpworkBidBean> upworkBidBeanList = new ArrayList<>();
        List<UpworkBid> upworkBidList = upworkBidRepository.getBySaler(saler);
        upworkBidList.forEach(u -> upworkBidBeanList.add(UpworkBidBean.toBean(u)));
        return upworkBidBeanList;
    }

    @Override
    @Transactional
    public List<UpworkBidBean> getByComment(String comment) {
        List<UpworkBidBean> upworkBidBeanList = new ArrayList<>();
        List<UpworkBid> upworkBidList = upworkBidRepository.getByCommentLike(comment);
        upworkBidList.forEach(u -> upworkBidBeanList.add(UpworkBidBean.toBean(u)));
        return upworkBidBeanList;
    }

    @Override
    @Transactional
    public List<UpworkBidBean> getAllActive() {
        List<UpworkBidBean> upworkBidBeanList = new ArrayList<>();
        List<UpworkBid> upworkBidList = upworkBidRepository.getByActiveTrue();
        upworkBidList.forEach(u -> upworkBidBeanList.add(UpworkBidBean.toBean(u)));
        return upworkBidBeanList;
    }

    @Override
    @Transactional
    public List<UpworkBidBean> getAllInactive() {
        List<UpworkBidBean> upworkBidBeanList = new ArrayList<>();
        List<UpworkBid> upworkBidList = upworkBidRepository.getByActiveFalse();
        upworkBidList.forEach(u -> upworkBidBeanList.add(UpworkBidBean.toBean(u)));
        return upworkBidBeanList;
    }

    @Override
    @Transactional
    public UpworkBidBean getByUrl(String url) {
        UpworkBidBean upworkBidBean = UpworkBidBean.toBean(upworkBidRepository.getByUrlLike(url));
        return upworkBidBean;
    }

    @Override
    @Transactional
    public List<UpworkBidBean> getBySalerAndDateBetween(Long salerId, String dateFrom, String dateTo) {
        List<UpworkBidBean> upworkBidBeanList = new ArrayList<>();
        List<UpworkBid> upworkBidList = upworkBidRepository
                .getBySalerAndDateBetween(salerId, dateFrom, dateTo);
        upworkBidList.forEach(u -> upworkBidBeanList.add(UpworkBidBean.toBean(u)));
        return upworkBidBeanList;
    }

    @Override
    @Transactional
    public List<UpworkBidBean> getBySalerAndUpdatedDateBetween(Long salerId, String dateFrom, String dateTo) {
        List<UpworkBidBean> upworkBidBeanList = new ArrayList<>();
        List<UpworkBid> upworkBidList = upworkBidRepository.getBySalerAndUpdatedDateBetween(salerId, dateFrom, dateTo);
        upworkBidList.forEach(u -> upworkBidBeanList.add(UpworkBidBean.toBean(u)));
        return upworkBidBeanList;
    }

    @Override
    @Transactional
    public List<UpworkBidBean> getAllBetweenDate(String dateFrom, String dateTo) {
        List<UpworkBidBean> upworkBidBeanList = new ArrayList<>();
        List<UpworkBid> upworkBidList = upworkBidRepository.getAllBetweenDate(dateFrom, dateTo);
        upworkBidList.forEach(u -> upworkBidBeanList.add(UpworkBidBean.toBean(u)));
        return upworkBidBeanList;
    }


}
