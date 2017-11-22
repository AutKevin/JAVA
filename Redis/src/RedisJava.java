import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import redis.clients.jedis.Jedis;


public class RedisJava {
    Jedis jedis = new Jedis("222.222.221.137",6379); //连接本地的 Redis服务
	public static void main(String[] args) {
        RedisJava redisJava = new RedisJava();
        System.out.println("服务正在运行: "+redisJava.jedis.ping());
        redisJava.save("sk1", "-value1");
        redisJava.update("sk1", "sk111");
        redisJava.findByKey("sk111");
        redisJava.del("sk111");
        redisJava.findAll();
        redisJava.list();
        redisJava.map();
        redisJava.set();
        redisJava.jedis.disconnect();
    }
	
	//添加数据(key/value)
    public void save(String key,String value){
        String result = jedis.set(key, value);
        System.out.println("添加{"+key+":"+value+"},结果为"+result);
    }

    //根据Key查询数据
    public String findByKey(String key){
    	String value = jedis.get(key);
    	System.out.println("get到"+key+"的值为"+value);
        return value;
    }
    
    //修改key
    public void update(String oldKey,String newKey){
        System.out.println("检测是否有key:"+oldKey+",结果为:"+jedis.exists(oldKey));
        jedis.rename(oldKey, newKey);
    	System.out.println("将key:"+oldKey+"重置为"+newKey);
    }
    
    //根据Key删除数据
    public void del(String key) {
       Long result = jedis.del(key);
       System.out.println("删除的结果为:"+result);
    }
    
    //查询所有
    public void findAll(){
        // 获取keys数据并输出
        Set<String> keys = jedis.keys("*");
        Iterator<String> it=keys.iterator();
        System.out.println("所有key:");
        while(it.hasNext()){   
            String key = it.next();   
            System.out.println(key);   
            jedis.del(key);    //删除所有key
        }
    }
        
    //操作List
    public void list() {
        //存储数据到列表中,一条一条存
        jedis.lpush("list", "FireFox");
        jedis.lpush("list", "Google");
        jedis.lpush("list", "IE");
        // 从头添加,一次添加多条
        jedis.lpush("list", "flash", "cisco", "catalin", "Google");
        // 从尾添加
        jedis.rpush("list", "walley", "jon");

        // 返回List长度
        System.out.println("list长度为:"+jedis.llen("list"));

        // 取值
        System.out.println("所有list:");
        List<String> list = jedis.lrange("list", 0, -1);
        for (String string : list) {
            System.out.println(string);
        }
    }

    //操作Map
    public void map() {
        jedis.hset("Mcity", "c1", "上海"); //key,map-key,map-value
        System.out.println("取值：" + jedis.hget("Mcity", "c1"));   //根据key,map-key,获取mapvalue
        Map<String, String> map = new HashMap<String, String>();
        map.put("c1", "徐州");   //相同的map-key会被覆盖
        map.put("c2", "扬州");
        map.put("c3", "常州");
        jedis.hmset("Mcity", map);   //一次取多个map值

        List<String> list = jedis.hmget("Mcity", "c1", "c2", "c3");  //一次获取多个map-value
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println("list长度:"+jedis.hlen("Mcity"));
    }
    
    //操作Set
    public void set() {
        jedis.sadd("city", "扬州", "上海", "南京", "苏州", "徐州", "常州","北京");
        System.out.println("取最上面的值:" + jedis.spop("city"));
        System.out.println("随机取值:" + jedis.srandmember("city"));
        jedis.sadd("city1", "北京", "上海", "河北", "辽林", "云南", "黑龙江");
        System.out.println("交集：" + jedis.sinter("city", "city1"));
        System.out.println("并集：" + jedis.sunion("city", "city1"));
        System.out.println("差集：" + jedis.sdiff("city", "city1"));
    }
    
}
