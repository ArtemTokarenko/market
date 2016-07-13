package com.cusbee.salers.service.impl;

import com.cusbee.salers.beans.SalerBean;
import com.cusbee.salers.entity.Saler;
import com.cusbee.salers.repository.SalerRepository;
import com.cusbee.salers.service.interfaces.SalerService;
import com.cusbee.salers.sites.ResponseContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalerServiceImpl implements SalerService {

    @Autowired
    private SalerRepository salerRepository;

    @Override
    public List<SalerBean> getAll() {
        List<SalerBean> salerBeanList = new ArrayList();
        List<Saler> salerList = salerRepository.findAll();
        salerList.forEach(s -> salerBeanList.add(SalerBean.toBean(s)));
        return salerBeanList;
    }

    @Override
    public SalerBean getByLogin(String login) {
        Saler saler = salerRepository.getByLogin(login);
        SalerBean salerBean = SalerBean.toBean(saler);
        return salerBean;
    }

    @Override
    public SalerBean getByEmail(String email) {
        Saler saler = salerRepository.getByEmail(email);
        SalerBean salerBean = SalerBean.toBean(saler);
        return salerBean;
    }

    @Override
    public ResponseContainer add(String login, String password) {
        ResponseContainer responseContainer = new ResponseContainer<>();
        if ((salerRepository.checkForThePresenceLogin(login)) != null) {
            responseContainer.setMessage("This login is occupied");
            responseContainer.setCode(406);
        } else {
            Saler saler = new Saler();
            saler.setLogin(login);
            saler.setPassword(password);
            saler.setFirstname(null);
            saler.setLastname(null);
            saler.setEmail(null);
            saler.setPhonenumber(null);
            salerRepository.save(saler);
            responseContainer.setMessage("Success");
            responseContainer.setCode(200);

        }
        return responseContainer;
    }

    @Override
    public void update(SalerBean salerBean) {
        Saler saler;
        saler = salerRepository.findOne(salerBean.getId());
        saler.setFirstname(salerBean.getFirstname());
        saler.setLastname(saler.getLastname());
        saler.setEmail(salerBean.getEmail());
        saler.setPassword(salerBean.getPassword());
        saler.setPhonenumber(salerBean.getPhonenumber());
        salerRepository.save(saler);
    }

    @Override
    public void delete(Integer id) {
        salerRepository.delete(id);
    }
}
