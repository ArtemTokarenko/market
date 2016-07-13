package com.cusbee.salers.service.interfaces;

import com.cusbee.salers.beans.SalerBean;
import com.cusbee.salers.sites.ResponseContainer;

import java.util.List;

public interface SalerService {

    List<SalerBean> getAll();

    SalerBean getByLogin(String login);

    SalerBean getByEmail(String email);

    ResponseContainer add(String login, String password);

    void update(SalerBean saler);

    void delete(Long id);

}
