import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 名   称：CreateEntity.java
 * 描   述：
 * 作   者：邱  宇
 * 时   间：2017年12月5日
 * --------------------------------------------------
 * 修改历史
 * 序号    日期    修改人     修改原因 
 * 1                                                        
 * **************************************************
 */
public class CreateEntity {
    private String packagePath = "com.qy.entity";    //指定实体生成所在包的路径
    //表名以","分隔;若为"*"则生成所有表的entity文件
    private String tableNames = "*";    
    
    private String authorName = "邱宇";    //作者名字
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/protocol";
	private static final String NAME = "qy";
	private static final String PASS = "199526";
	
	private boolean f_util = false;  // 是否需要导入包java.util.*
	private boolean f_sql = false;  // 是否需要导入包java.sql.*
    
	public static void main(String[] args) {
		new CreateEntity();
	}

	public CreateEntity(){
		
		String[] tables = null;
		if (this.tableNames=="*") {
			tables = getAllTables();
		}else {
			tables = this.tableNames.split(",");
		}
		for (int i = 0; i < tables.length; i++) {
			new CreateEntity(tables[i]);
			f_util = false;
			f_sql = false;
		}
	}
	
	public CreateEntity(String tableName){
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		DatabaseMetaData dbmd = null;
		//ResultSetMetaData rsmd= null;
		List<FieldMeta> fmls = new ArrayList<FieldMeta>();
		String sql= "select * from "+tableName;
		try {
			con=getJdbcCon();
			dbmd = con.getMetaData();
			rs = dbmd.getColumns(con.getCatalog(), null, tableName, null);
			while (rs.next()) {
				FieldMeta fm = new FieldMeta();
				fm.setFieldName(rs.getString("COLUMN_NAME"));
				if (rs.getString("TYPE_NAME").equalsIgnoreCase("datetime")
						|| rs.getString("TYPE_NAME").equalsIgnoreCase("date")) {
					f_util = true;
				}
				if (rs.getString("TYPE_NAME").equalsIgnoreCase("image")
						|| rs.getString("TYPE_NAME").equalsIgnoreCase("text")) {
					f_sql = true;
				}
				fm.setFieldDataType(rs.getString("TYPE_NAME"));
				fm.setFieldLength(Integer.parseInt(rs.getString("COLUMN_SIZE")));
				fm.setFieldComment(rs.getString("REMARKS").replace("\r\n", "  "));   //注释中的换行改为空格
				fmls.add(fm);
			}
			/* 从resultSet读取的ResultSetMetaData没有注释等详细信息
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			rsmd = rs.getMetaData();
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				FieldMeta fm = new FieldMeta();
				fm.setFieldName(rsmd.getColumnName(i+1));
				if (rsmd.getColumnTypeName(i+1).equalsIgnoreCase("datetime")) {
					f_util = true;
				}
				if (rsmd.getColumnTypeName(i+1).equalsIgnoreCase("image")
						|| rsmd.getColumnTypeName(i+1).equalsIgnoreCase("text")) {
					f_sql = true;
				}
				fm.setFieldDataType(rsmd.getColumnTypeName(i+1));
				fm.setFieldLength(rsmd.getColumnDisplaySize(i+1));
				//fm.setFieldComment(fieldComment);
				fmls.add(fm);
			}*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			if (con!=null) {
				closeAll(rs, ps, con, null);
			}
		}
		//生成内容
		String content = genFrame(fmls,tableName);
		//System.out.println(content);
		//写入到文件
		wirteToFile(content,this.packagePath,tableName);
	}
	
	/**
	 * 生成类主题框架
	 */
	public String genFrame(List<FieldMeta> fmls,String tableName){
		StringBuilder sb = new StringBuilder();
		//package空间
		sb.append("package "+this.packagePath+";\r\n\r\n");
		// 判断是否导入工具包
		if (f_util) {
			sb.append("import java.util.Date;\r\n");
		}
		if (f_sql) {
			sb.append("import java.sql.*;\r\n");
		}
		// 注释部分
		sb.append("/**\r\n");
		sb.append(" * 名   称：" + tableName + "\r\n");
		sb.append(" * 描   述：\r\n");
		sb.append(" * 作   者：" + this.authorName + "\r\n");
		sb.append(" * 时   间：" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) + "\r\n");
		sb.append(" * --------------------------------------------------" + "\r\n");
		sb.append(" * 修改历史" + "\r\n");
		sb.append(" * 序号    日期    修改人     修改原因 "+ "\r\n");
		sb.append(" * 1" + "\r\n");
		sb.append(" * **************************************************" + "\r\n");
		sb.append(" */\r\n");
		// 实体部分
		sb.append("public class " + upFirstChar(tableName) + "{\r\n");
		//字段部分
		genAttrs(sb, fmls);
		//方法部分
		genMethods(sb, fmls);
		sb.append("}\r\n");
		return new String(sb);
	}
	/**
	 * 功能：生成所有属性
	 */
	private void genAttrs(StringBuilder sb,List<FieldMeta> fmls) {
		for (int i = 0; i < fmls.size(); i++) {
			sb.append("\t");
			sb.append("private " + fmls.get(i).getFieldDataType() + " "
					+ fmls.get(i).getFieldName() + ";");
			sb.append("\t/*"+fmls.get(i).getFieldComment()+"\tlen: "+fmls.get(i).getFieldLength()+"*/\r\n");
		}
		sb.append("\r\n");
	}
	/**
	 * 功能：生成所有方法
	 */
	private void genMethods(StringBuilder sb,List<FieldMeta> fmls){
		for (int i = 0; i < fmls.size(); i++) {
			sb.append("\tpublic void set"+upFirstChar(fmls.get(i).getFieldName())+"("+fmls.get(i).getFieldDataType()+" "+fmls.get(i).getFieldName()+"){\r\n");
			sb.append("\t\tthis."+fmls.get(i).getFieldName()+"="+fmls.get(i).getFieldName()+";\r\n");
			sb.append("\t}\r\n");
			sb.append("\tpublic "+fmls.get(i).getFieldDataType()+" get"+upFirstChar(fmls.get(i).getFieldName())+"(){\r\n");
			sb.append("\t\treturn "+fmls.get(i).getFieldName()+";\r\n");
			sb.append("\t}\r\n");
			sb.append("\r\n");
		}
		sb.append("");
	}
	/**
	 * 写入文件 
	 */
	private void wirteToFile(String content,String packagePath,String tableName){
		PrintWriter pw = null;
		BufferedWriter bw = null;
		File dir = new File("");    //根据空文件获取项目路径
		//entity文件父文件夹全路径
		String dirpath = dir.getAbsolutePath() + "\\src\\"+packagePath.replace(".", "\\");
		File parentDir = new File(dirpath);
		if (!parentDir.exists()) {    //判断是否存在该路径
			parentDir.mkdirs();     //不存在则创建
		}
		String filePath = dirpath+"\\"+upFirstChar(tableName)+".java";    //java文件路径
		File file = new File(filePath);
		try {
			if (!file.exists()) {    //判断是否存在java文件
				file.createNewFile();    //不存在则创建
			}else {
				System.out.print("表     "+tableName+"   的entity实体已存在于:");
			}
			pw = new PrintWriter(file);
			bw = new BufferedWriter(pw);
			bw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				if (bw!=null) {
					bw.close();
				}
				if (pw!=null) {
					pw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(filePath);
	}
	
	//获取所有表名
	private String[] getAllTables(){
		List<String> stringList = new ArrayList<String>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =null;
		con = getJdbcCon();
		String sql = "show tables";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				stringList.add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			closeAll(rs, ps, con, null);
		}
		return stringList.toArray(new String[stringList.size()]);
	}
	/** 
     * 功能：将输入字符串的首字母改成大写 
     * @param str 
     * @return 
     */  
    private String upFirstChar(String str) {
        if (str!=null&&str.length()>0) {
            char[] ch = str.toCharArray();  
            if(ch[0] >= 'a' && ch[0] <= 'z'){
                ch[0] = (char)(ch[0] - 32);  
            }
            return new String(ch);  
		}
        return null;
    }
    
    /**
     * 获取jdbc连接 
     */
    private Connection getJdbcCon(){
    	try {
        	Class.forName(DRIVER);
			return DriverManager.getConnection(URL,NAME,PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
    }
    /**  
     * 关闭所有资源  
     */    
    private void closeAll(ResultSet resultSet,PreparedStatement preparedStatement,Connection connnection,CallableStatement callableStatement) {    
        // 关闭结果集对象    
        if (resultSet != null) {    
            try {    
                resultSet.close();    
            } catch (SQLException e) {    
                System.out.println(e.getMessage());    
            }    
        }    
        // 关闭PreparedStatement对象    
        if (preparedStatement != null) {    
            try {    
                preparedStatement.close();    
            } catch (SQLException e) {    
                System.out.println(e.getMessage());    
            }    
        }    
        // 关闭CallableStatement 对象    
        if (callableStatement != null) {    
            try {    
                callableStatement.close();    
            } catch (SQLException e) {    
                System.out.println(e.getMessage());    
            }    
        }    
        // 关闭Connection 对象    
        if (connnection != null) {    
            try {    
                connnection.close();    
            } catch (SQLException e) {    
                System.out.println(e.getMessage());    
            }    
        }  
    }
}

/**
 * 字段信息表
 */
class FieldMeta {
	private String fieldName;    //字段名
	private String fieldDataType;   //字段列类型
	private int fieldLength;    //字段长度
	private String fieldComment;    //字段备注

	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldDataType() {
		if(fieldDataType.equalsIgnoreCase("bit")){  
            return "boolean";  
        }else if(fieldDataType.equalsIgnoreCase("tinyint")){  
            return "byte";  
        }else if(fieldDataType.equalsIgnoreCase("smallint")){  
            return "short";  
        }else if(fieldDataType.equalsIgnoreCase("int")){  
            return "int";  
        }else if(fieldDataType.equalsIgnoreCase("bigint")){  
            return "long";  
        }else if(fieldDataType.equalsIgnoreCase("float")){  
            return "float";  
        }else if(fieldDataType.equalsIgnoreCase("decimal") || fieldDataType.equalsIgnoreCase("numeric")   
                || fieldDataType.equalsIgnoreCase("real") || fieldDataType.equalsIgnoreCase("money")   
                || fieldDataType.equalsIgnoreCase("smallmoney")){  
            return "double";  
        }else if(fieldDataType.equalsIgnoreCase("varchar") || fieldDataType.equalsIgnoreCase("char")   
                || fieldDataType.equalsIgnoreCase("nvarchar") || fieldDataType.equalsIgnoreCase("nchar")   
                || fieldDataType.equalsIgnoreCase("text") || fieldDataType.equalsIgnoreCase("LONGTEXT")){  
            return "String";  
        }else if(fieldDataType.equalsIgnoreCase("datetime")){  
            return "Date";  
        }else if(fieldDataType.equalsIgnoreCase("image")){  
            return "Blod";  
        }  
		return fieldDataType;
	}
	public void setFieldDataType(String fieldDataType) {
		if(fieldDataType.equalsIgnoreCase("bit")){  
			this.fieldDataType = "boolean";  
        }else if(fieldDataType.equalsIgnoreCase("tinyint")){  
        	this.fieldDataType = "byte";  
        }else if(fieldDataType.equalsIgnoreCase("smallint")){  
        	this.fieldDataType = "short";  
        }else if(fieldDataType.equalsIgnoreCase("int")){  
        	this.fieldDataType = "int";  
        }else if(fieldDataType.equalsIgnoreCase("bigint")){  
        	this.fieldDataType = "long";  
        }else if(fieldDataType.equalsIgnoreCase("float")){  
        	this.fieldDataType = "float";  
        }else if(fieldDataType.equalsIgnoreCase("decimal") || fieldDataType.equalsIgnoreCase("numeric")   
                || fieldDataType.equalsIgnoreCase("real") || fieldDataType.equalsIgnoreCase("money")   
                || fieldDataType.equalsIgnoreCase("smallmoney")){  
        	this.fieldDataType = "double";  
        }else if(fieldDataType.equalsIgnoreCase("varchar") || fieldDataType.equalsIgnoreCase("char")   
                || fieldDataType.equalsIgnoreCase("nvarchar") || fieldDataType.equalsIgnoreCase("nchar")   
                || fieldDataType.equalsIgnoreCase("text") || fieldDataType.equalsIgnoreCase("LONGTEXT") 
                || fieldDataType.equalsIgnoreCase("TIMESTAMP")){  
        	this.fieldDataType = "String";  
        }else if(fieldDataType.equalsIgnoreCase("datetime") || fieldDataType.equalsIgnoreCase("date")){  
        	this.fieldDataType = "Date";  
        }else if(fieldDataType.equalsIgnoreCase("image")){  
        	this.fieldDataType = "Blod";  
        }else {
    		this.fieldDataType = fieldDataType;
		}
	}
	
	public int getFieldLength() {
		return fieldLength;
	}
	public void setFieldLength(int fieldLength) {
		this.fieldLength = fieldLength;
	}

	public String getFieldComment() {
		return fieldComment;
	}
	public void setFieldComment(String fieldComment) {
		this.fieldComment = fieldComment;
	}
	
}