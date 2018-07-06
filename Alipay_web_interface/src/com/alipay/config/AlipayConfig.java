package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016080500172104";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "L+IRt2rkrlLjm0X8G6IGqJ/8WUusb3qQgKMq4pacz6FbUjoPHhfKKbBgD28wrnUhvYrAGMZdxrXF73tg3l7glFF/pR/Mjlb0YRgc1aVawhtg6jZ7A4G9sAzv6TnYP8Qa2dAF6ekEyyxqaNTSBMtGLlCuldh+9RR4ZamoRa83vGOzKhAqYFwyAE06hvJ64xeG4QiD8F6dH6z+LtevK3Oaxx8FOTKBVCj01M/d40zXCrpF66czBTAq67j7JbjCHPilgAfZzXiALjMrqWfGdxhhzzITw54lJZFkkD5/JldNZaw28aKDPF7UU/Ao/4AgmaLtrfU5Ingvqap0T+fKqwDTAgMBAAECggEAIW0yWXXkRFSTGf0T69vXMHeN/PZFKwmeJ8CGG3vfaogJZ/2htpIdh6JbW4nlWu14jfEQYG6ym7MuYpUVTUWZynQz4K1CF4XS/WqiD41ObVK6uwL0weCmLKDpubD7r1H2WVWhaPJ/nGfjTjTM637DBwG2aATEO7yEDnXf97ZCJfjiye/bRW0QR49pF2lQ4fm0PatD3P2WOgpnEeZ6cKKrYH/DwQ/S9w4TmrouZJfWc0U6qet6VVAVY4CcqnHDFDQx3oTWXjswl5hdgW55oCG9nN6SrmAakKo1Sb7nmq2y/TdkOzb58PVG8ac825W/xaqanu+XCMXojRHCqpzIDDq5kQKBgQDTwHh6zIbpWGksLwVDotS86CqE5zV35Yl1P96z4q7T19Rj0HxTqLIjntbbRxbrcg6XxWC78x6P1fJcopkR/sMLqOuCgXFuAR4NbSO40m3Pi1zq8ytOHMncTpnCLiVRk/+RW35aPCnHUvZGG1JKTLu5wMdP/1VYUDuzgUw3ulbdCwKBgQCr5haSK/JPkG+fWEPRQCC6POMeZqebTdmPUgTDymhzxtE6xMEOpuaqneRqN1ptq/kYXS6MIKO8ZybaIHKBi1FzUE/qgEtx2a+9ogKAIuuHoqbbly+Iw05/oin45GXei6YvSNywxo/tNf5UrywdscxTlz0dWic6CwY4Rsiwy3F4WQKBgB9Cm8atKQGLzsL6EhHhGPzmXViPdYJEvZ00l6EAxwR5KV6u6ZvEHMBLc7adcRHDHcpkFhrJEmrzj7sDOgvBC3RONK5og6FUwuYChbKERjfMgCQjT/JRJ6/BXsue2l2HtsPzuNyDYzuM0NSatfRIDbKndgUmUage+CFQ5jqX5LjvAoGADme1tIIiSDCeaggHht2M4I6BqeaIXSdk9/GznIS1xB4BIp+iXgv2gI3CunPxDAfBVB1a7Ts+/WbXhqf5cImwRa2RROGDcQMBCy8sbnh+rFshCH3e6eMUDPYV9lmNf9zMDGJavCWnogVITuhvFf30VXzzDiaj6uVJnCWyY75ov+ECgYBd+IuSd8tQHlBJIytDrCKNOtZmAzgfrrNegum/QF9gN+F6JYDevDvzRuii4wVqXfp+wlUygn7eJCojO+qHSk2pUIBvJWbDAN2vtHGqUlOD5yKqaxvcPvAGdWd9pNX93QMrS2ikOwHWXseSOacdBJOkPtBq8tB89FCBU1CstZPREQ==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "c/wSP3kosfHiNn4T1SVpXgVT+wCynGtZ8OfZr50hadW7u4wNjo5ANWNV9wRXlMHjIazkGSQSl1AUdnV4C0Z0E+DLEE3gL1X6FzgI33gJvTqzn6Cuj1dP8e9qgH5j/zeTGKDeSpjul01oT6URWcwYv+7+FgVT7QyURRl17lMVLTVRr+7rYfbs5aoFDfRBWyOd/HsY0XbS/vtPZWOXOdMs83imiX9CsgSXoOJ/hh+3MiB62N+aqhPSaXll49R8aKtj0LhIUO5KKDK9Kgo+/2phAqc+4UeJtFwNO07bGDwPQyxLkEGjgnBaeu2fctT7R2LejaGwdBMx7advYswIDAQAB";
    
	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//可以写其他项目的接受接口public static String notify_url = "http://localhost/Alipay/notify_url.jsp";
    public static String notify_url = "http://localhost/Alipay_web_interface/autumn/Notify";
	
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost/Alipay_web_interface/autumn/Return";
	
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "\\alipay\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

