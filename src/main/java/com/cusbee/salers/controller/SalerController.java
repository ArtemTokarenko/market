package com.cusbee.salers.controller;


import com.cusbee.salers.beans.SalerBean;
import com.cusbee.salers.service.impl.SalerServiceImpl;
import com.cusbee.salers.sites.ResponseContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/saler")



public class SalerController {

    @Autowired
    private SalerServiceImpl salerServiceImpl;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseContainer<List<SalerBean>> all(){
        ResponseContainer dataContainer = new ResponseContainer<>();
        dataContainer.setData(salerServiceImpl.getAll());
        dataContainer.setCode(200);
        return dataContainer;
    }
    @RequestMapping(value = "/getByLogin", method = RequestMethod.GET)
    @ResponseBody
    public ResponseContainer<List<SalerBean>> getByLogin(@RequestParam(value = "login", required = true) String login){
        ResponseContainer dataContainer = new ResponseContainer<>();
        dataContainer.setData(salerServiceImpl.getByLogin(login));
        dataContainer.setCode(200);
        return dataContainer;
    }
    @RequestMapping(value = "/getByEmail", method = RequestMethod.GET)
    @ResponseBody
    public ResponseContainer<List<SalerBean>> getByEmail(@RequestParam(value = "email", required = true) String email){
        ResponseContainer dataContainer = new ResponseContainer<>();
        dataContainer.setData(salerServiceImpl.getByEmail(email));
        dataContainer.setCode(200);
        return dataContainer;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseContainer add(@RequestParam(value = "login", required = true) String login,
                                 @RequestParam(value = "password", required = true) String password){
        return  salerServiceImpl.add(login, password);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseContainer update(@RequestBody SalerBean salerBean){
        ResponseContainer dataContainer = new ResponseContainer<>();
        salerServiceImpl.update(salerBean);
        dataContainer.setCode(200);
        return dataContainer;
    }


    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseContainer delete(@RequestParam(value = "id", required = true) Integer id){
        ResponseContainer dataContainer = new ResponseContainer<>();
        salerServiceImpl.delete(id);
        dataContainer.setCode(200);
        return dataContainer;
    }


}
