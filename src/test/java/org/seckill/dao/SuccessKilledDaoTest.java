package org.seckill.dao;

import org.junit.Test;
import org.seckill.BaseTest;
import org.seckill.entity.SuccessKilled;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by joshul on 2017/2/8.
 */
public class SuccessKilledDaoTest extends BaseTest {

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Test
    public void insertSuccessKilled() throws Exception {
        long id = 1000L;
        long userPhone = 13877511732L;
        int insertCount = successKilledDao.insertSuccessKilled(id,userPhone);
        System.out.println("insertCount：" + insertCount);
    }

    @Test
    public void queryByIdWithSeckill() throws Exception {
        long id = 1000L;
        long userPhone = 13877511732L;
        SuccessKilled successKilled = successKilledDao.queryByIdWithSeckill(id,userPhone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
    }

}