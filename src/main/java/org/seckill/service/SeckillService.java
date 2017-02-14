package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：站在"使用者"角度设计接口
 * 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 * Created by joshul on 2017/2/8.
 */
public interface SeckillService {
    /**
     * 查询所有秒杀记录
     * @return List<Seckill>
     */
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     * @param seckillId
     * @return Seckill
     */
    Seckill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址,
     * 否则输出系统时间个秒杀时间
     * @param seckillId
     * @return Exposer
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return SeckillExecution
     */
    SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException,RepeatKillException,SeckillCloseException;

    /**
     * 存储过程执行秒杀
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * SeckillExecution
     *
     */
    SeckillExecution executeSeckillProcedure(long seckillId,long userPhone,String md5);
}
