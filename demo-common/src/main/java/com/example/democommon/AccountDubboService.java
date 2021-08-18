package com.example.democommon;

import java.sql.SQLException;

public interface AccountDubboService {

    /**
     * 账户扣钱
     * @param money
     */
    boolean decreaseAccount(int money,String uid) throws SQLException;

}
