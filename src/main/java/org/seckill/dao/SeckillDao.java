package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Seckill;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by joshul on 2017/1/20.
 */
public interface SeckillDao {

/*Java没有保存形参的记录:QueryAll(int offset,int limit)->QueryAll(arg0,arg1);
因为java形参的问题,多个基本类型参数的时候需要用@Param("seckillId")注解区分开来*/
    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return 如果影响行数大于等于1，表示更新记录行数
     */
    int reduceNumber(@Param("seckillId")long seckillId, @Param("killTime")Date killTime);

    /**
     * 根据id查询秒杀商品
     * @param seckillId
     * @return Seckill
     */
    Seckill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return List<Seckill>
     */
    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 使用存储过程执行秒杀
     *
     * @param paramMap
     */
    void killByProcedure(Map<String, Object> paramMap);
}
