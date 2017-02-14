package org.seckill.dao.redis;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.seckill.entity.Seckill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class RedisDao {

    private final static Logger LOG = LoggerFactory.getLogger(RedisDao.class);
    private final static String SECKILL_KEY_PREFIX="seckill:";
    private final JedisPool jedisPool;

    private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);

    public RedisDao(String ip, int port) {
        jedisPool = new JedisPool(ip,port);
    }

    public Seckill getSeckill(long seckillId){
        try{
            Jedis jedis = jedisPool.getResource();
            try{
                String key =SECKILL_KEY_PREFIX + seckillId;
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null){
                    //空对象
                    Seckill seckill = schema.newMessage();
                    ProtobufIOUtil.mergeFrom(bytes,seckill,schema);
                    //Seckill 被反序列化
                    return seckill;
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
        }
        return null;
    }

    public String putSeckill(Seckill seckill){
        // set Object(Seckill) -> 序列号 -> byte[]
        try{
                Jedis jedis = jedisPool.getResource();
            try{
                String key = SECKILL_KEY_PREFIX+seckill.getSeckillId();

                byte[] bytes = ProtobufIOUtil.toByteArray(seckill,schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));

                //超时缓存
                int timeout = 60 * 60;//1小时
                String result = jedis.setex(key.getBytes(),timeout,bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            LOG.error(e.getMessage(),e);
        }
        return null;
    }
}
