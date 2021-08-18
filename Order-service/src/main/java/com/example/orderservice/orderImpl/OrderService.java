package com.example.orderservice.orderImpl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.democommon.AccountDubboService;
import com.example.democommon.StorageDubboService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class OrderService {


    @Reference(version = "1.0.1")
    private AccountDubboService accountDubboService;

    @Reference(version = "1.0.1")
    private StorageDubboService storageDubboService;

    @GlobalTransactional(timeoutMills = 10000,name = "dubbo-order-service")
    public boolean creataOrder(int count,String id) throws SQLException {
        System.out.println("===============  storage xid ==================");
        System.out.println(RootContext.getXID());
        return accountDubboService.decreaseAccount(count,id) && storageDubboService.decreaseStorage(count,id);
    }

}
