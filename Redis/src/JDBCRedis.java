import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCRedis {
    private static Connection conn = null;  
    private static Statement stm = null;  
    private static ResultSet rs = null; 
    
	 /* 
     * 初始化 
     */  
    private static void init() {  
          
        try {  
            // 加载redis jdbc驱动  
            Class.forName("br.com.svvs.jdbc.redis.RedisDriver");  
            // 连接  
            conn = DriverManager.getConnection("jdbc:redis://222.222.221.137");  
            stm = conn.createStatement();  
        } catch (ClassNotFoundException e) {  
            System.out.println(e.toString());  
        } catch (SQLException e) {  
            System.out.println(e.toString());  
        }  
    } 
    
    /* 
     * 关闭rs,stm,conn,
     */  
    private static void close() {  
        try {  
        	if (rs!=null) {
                rs.close();
			}
        	if (stm!=null) {
                stm.close();
			}
        	if (conn!=null) {
                conn.close();
			} 
        } catch (SQLException e) {  
            System.out.println(e.toString());  
        }  
    }  
    
    /* 
     * 存储string数据类型
     */  
    private static void saveString(String key,String value){
        try {
			String sql = "set "+key+" "+value;  
			boolean result = stm.execute(sql);  
			System.out.println("存储结果string数据类型{"+key+":"+value+"}结果为"+result);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    private static void getString(String key) {  
    	try {
			stm.execute("get "+key);
	        rs = stm.getResultSet();  
	        System.out.println("获取"+key+":");  
	        while (rs.next()) {
	            System.out.println(rs.getString(0)); 
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
	public static void main(String[] args) {
		init();
		saveString("jdbckey1","jdbcvalue111");
		getString("jdbckey1");    //返回字符串长度,待解决.
		close();
	}
	
}
