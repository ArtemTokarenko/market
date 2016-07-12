package com.cusbee.salers.service.impl;

import com.cusbee.salers.beans.UpworkBidBean;
import com.cusbee.salers.entity.Saler;
import com.cusbee.salers.entity.UpworkBid;
import com.cusbee.salers.repository.SalerRepository;
import com.cusbee.salers.repository.UpworkBidRepository;
import com.cusbee.salers.service.interfaces.UpworkBidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        upworkBid.setDate(setCurrentDateTime());
        upworkBidRepository.save(upworkBid);
    }

    @Override
    public void update(UpworkBid upworkBid) {
        upworkBid.setUpdatedDate(setCurrentDateTime());
        upworkBidRepository.save(upworkBid);
    }

    @Override
    public void delete(Integer id) {
        upworkBidRepository.delete(id);
    }

    @Override
    public void changeActivity(Integer id) {
        UpworkBid bid = upworkBidRepository.getById(id);
        bid.setActive(bid.isActive() ? false : true);
        bid.setUpdatedDate(setCurrentDateTime());
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
    public List<UpworkBidBean> getBySaler(Integer salerId) {
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
        List<UpworkBid> upworkBidList = upworkBidRepository.getByComment(comment);
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
        UpworkBidBean upworkBidBean = UpworkBidBean.toBean(upworkBidRepository.getByUrl(url));
        return upworkBidBean;
    }

    @Override
    @Transactional
    public List<UpworkBidBean> getBySalerAndDateBetween(Integer salerId, Date dateFrom, Date dateTo) {
        Saler saler = salerRepository.getById(salerId);
        List<UpworkBidBean> upworkBidBeanList = new ArrayList<>();
        List<UpworkBid> upworkBidList = upworkBidRepository.getBySalerAndDateBetween(saler, dateFrom, dateTo);
        upworkBidList.forEach(u -> upworkBidBeanList.add(UpworkBidBean.toBean(u)));
        return upworkBidBeanList;
    }

    @Override
    @Transactional
    public List<UpworkBidBean> getBySalerAndUpdatedDateBetween(Integer salerId, Date dateFrom, Date dateTo) {
        Saler saler = salerRepository.getById(salerId);
        List<UpworkBidBean> upworkBidBeanList = new ArrayList<>();
        List<UpworkBid> upworkBidList = upworkBidRepository.getBySalerAndUpdatedDateBetween(saler, dateFrom, dateTo);
        upworkBidList.forEach(u -> upworkBidBeanList.add(UpworkBidBean.toBean(u)));
        return upworkBidBeanList;
    }

    @Override
    @Transactional
    public List<UpworkBidBean> getAllBetweenDate(Date dateFrom, Date dateTo) {
        List<UpworkBidBean> upworkBidBeanList = new ArrayList<>();
        List<UpworkBid> upworkBidList = upworkBidRepository.getAllBetweenDate(dateFrom, dateTo);
        upworkBidList.forEach(u -> upworkBidBeanList.add(UpworkBidBean.toBean(u)));
        return upworkBidBeanList;
    }

    private Date setCurrentDateTime() {
        Date date = new Date();
        return date;
    }
}
