package com.example.democommon;

import java.sql.SQLException;

public interface StorageDubboService {

    boolean decreaseStorage(int count,String id) throws SQLException;

}
