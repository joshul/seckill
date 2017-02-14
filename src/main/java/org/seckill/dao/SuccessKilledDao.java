package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

/**
 * Created by joshul on 2017/1/20.
 */
public interface SuccessKilledDao {
    /**
     *插入购买明显，可重复过滤
     * @param seckillId
     * @param userPhone
     * @return 插入的行数
     */
    int insertSuccessKilled(@Param("seckillId")long seckillId, @Param("userPhone")long userPhone);

    /**
     * 根据id查询SuccessKilled并携带秒杀产品对象实例
     * @param seckillId
     * @param userPhone
     * @return SuccessKilled
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);
}
