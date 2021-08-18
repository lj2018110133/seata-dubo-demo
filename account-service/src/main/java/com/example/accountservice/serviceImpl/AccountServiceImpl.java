package com.example.accountservice.serviceImpl;


import com.alibaba.dubbo.config.annotation.Service;
import com.example.democommon.AccountDubboService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@Service(version = "1.0.1",protocol = "${dubbo.protocol.id}",application = "${dubbo.application.id}",
        registry = "${dubbo.registry.id}",timeout = 3000)
public class AccountServiceImpl implements AccountDubboService {

    @Autowired
    @Qualifier("seataDataSource1")
    private DataSource seataDataSource;

    @Override
    public boolean decreaseAccount(int money,String uid) throws SQLException {
        System.out.println("===============  storage xid ==================");
        System.out.println(RootContext.getXID());
        Connection conn = null;
        PreparedStatement pps = null;
        String sql = "update account set money = money - 1 where user_id = '"+uid+"'";
        boolean isTrue = false;
        try{
            conn = seataDataSource.getConnection();
            pps = conn.prepareStatement(sql);
            pps.execute();
            isTrue = true;
        } catch (SQLException throwables) {
            throw  throwables;
        }finally {
            conn.close();
            pps.close();
        }
        return isTrue;
    }
}
