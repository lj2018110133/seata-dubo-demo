package com.example.accountservice.contorller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.example.democommon.StorageDubboService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

@Controller
@RequestMapping(value = "/seata")
public class AccountContorller {

    @Reference(version = "1.0.1")
    private StorageDubboService storageDubboService;

    //index
    // index12

    @RequestMapping(value = "/index")
    @ResponseBody
    public boolean get(int money,String uid) throws SQLException {


//        return service.decreaseAccount(money,uid);
        return storageDubboService.decreaseStorage(money,uid);
    }
}
