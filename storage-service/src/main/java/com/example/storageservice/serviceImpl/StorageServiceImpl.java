package com.example.storageservice.serviceImpl;


import com.alibaba.dubbo.config.annotation.Service;
import com.example.democommon.StorageDubboService;
import io.seata.core.context.RootContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service(version = "1.0.1",protocol = "${dubbo.protocol.id}",application = "${dubbo.application.id}",registry = "${dubbo.registry.id}",timeout = 3000)
public class StorageServiceImpl implements StorageDubboService {

    @Autowired
    @Qualifier("seataDataSource1")
    private DataSource dataSource;

    @Override
    public boolean decreaseStorage(int count, String id) throws SQLException {

        System.out.println("===============  storage xid ==================");
        System.out.println(RootContext.getXID());

        Connection conn = null;
        PreparedStatement pps = null;
        String sql = "update storage set count = count - " + count + " where commodity_id = '" + id + "'";
        boolean isTrue = false;
        try{
            conn = dataSource.getConnection();
            pps = conn.prepareStatement(sql);
            pps.execute();
            isTrue = true;
        } catch (SQLException throwables) {
            throw throwables;
        } finally {
            pps.close();
            conn.close();
        }
        return isTrue;
    }
}
