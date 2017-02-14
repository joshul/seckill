package org.seckill.dao;

import org.junit.Test;
import org.seckill.BaseTest;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.xml.crypto.Data;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by joshul on 2017/2/8.
 */
public class SeckillDaoTest extends BaseTest {

    //注入Dao实现类
    @Resource
    private SeckillDao seckillDao;

    @Test
    public void reduceNumber() throws Exception {
        long id = 1000L;
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(id,killTime);
        System.out.println("updateCount: " + updateCount);
    }

    @Test
    public void queryById() throws Exception {
        long id = 1000L;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill);
    }

    @Test
    public void queryAll() throws Exception {
        List<Seckill> seckills = seckillDao.queryAll(0,100);
        for (Seckill seckill:seckills) {
            System.out.println(seckill);
        }
    }

}