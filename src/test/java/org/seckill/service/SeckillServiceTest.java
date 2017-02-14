package org.seckill.service;

import org.junit.Test;
import org.seckill.BaseTest;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by joshul on 2017/2/8.
 */
public class SeckillServiceTest extends BaseTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SeckillService seckillService;

    @Test
    public void getSeckillList() throws Exception {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000L;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}",seckill);
    }

    //测试代码完整逻辑，注意可重复执行.
    @Test
    public void exportSeckillLogic() throws Exception {
        long id = 1003L;
        Exposer exposer = seckillService.exportSeckillUrl(id);
        logger.info("exposer={}",exposer);
        if (exposer.isExposed()){
            long phone = 1877511732L;
            String md5 = exposer.getMd5();
            try {
                SeckillExecution execution =seckillService.executeSeckill(id,phone,md5);
                logger.info("execution={}",execution);
            }catch (RepeatKillException e){
                logger.info(e.getMessage());
            }catch (SeckillCloseException e){
                logger.info(e.getMessage());
            }
        }else {
            //秒杀未开启
            logger.warn("秒杀未开始：{}",exposer.toString());
        }
    }

    @Test
    public void executeSeckillProcedure() {
        long seckillId = 1003L;
        long phone = 12311111111L;
        Exposer exposer = seckillService.exportSeckillUrl(seckillId);
        if (exposer.isExposed()) {
            String md5 = exposer.getMd5();
            SeckillExecution seckillExecution = seckillService
                    .executeSeckillProcedure(seckillId, phone, md5);
            logger.info(seckillExecution.getStateInfo());
        }
    }
}