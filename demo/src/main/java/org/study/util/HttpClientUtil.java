package org.study.util;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLException;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.study.common.Constant;
import org.study.common.ResultInfo;

/**
 * @description: HttpClient工具类，提供了post、get请求
 * @author liuzhibo
 * @date 2015年6月11日 上午11:54:36 
 */
public class HttpClientUtil {
    private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);    //日志记录
 
    /**
     * httpPost
     * @param url  路径
     * @param jsonParam 参数
     * @return
     */
    public static ResultInfo httpPost(String url, JSONObject jsonParam){
        return httpPost(url, jsonParam, false);
    }
 
    /**
     * post请求
     * 5、6行分别设置了Socket最大等待时间、连接最大等待时间（单位都是毫秒）。socket等待时间是指从站点下载页面和数据时，两个数据包之间的最大时间间隔，超过这个时间间隔，httpclient就认为连接出了故障。连接最大等待时间则是指和站点建立连接时的最大等待时间，超过这个时间站点不给回应，则认为站点无法连接。第7行设置httpclient不使用NoDelay策略。如果启用了NoDelay策略，httpclient和站点之间传输数据时将会尽可能及时地将发送缓冲区中的数据发送出去、而不考虑网络带宽的利用率，这个策略适合对实时性要求高的场景。而禁用了这个策略之后，数据传输会采用Nagle's algorithm发送数据，该算法会充分顾及带宽的利用率，而不是数据传输的实时性。第8行设置socket缓冲区的大小（单位为字节），默认是8KB。
     * @param url         url地址
     * @param jsonParam     参数
     * @param noNeedResponse    不需要返回结果
     * @return
     */
    public static ResultInfo httpPost(String url,JSONObject jsonParam, boolean noNeedResponse){
    	ResultInfo resultInfo = new ResultInfo();
        //post请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        Integer socketTimeout = 10000;  
        Integer connectionTimeout = 10000;  
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, socketTimeout);  
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connectionTimeout);  
        httpClient.getParams().setParameter(CoreConnectionPNames.TCP_NODELAY, false);  
        httpClient.getParams().setParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, 1024 * 1024);
        httpClient.setHttpRequestRetryHandler(new HttpRequestRetryService());  
        JSONObject jsonResult = null;
        HttpPost method = new HttpPost(url);
        try {
            if (null != jsonParam) {
                //解决中文乱码问题
                StringEntity entity = new StringEntity(jsonParam.toString(), "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/json");
                method.setEntity(entity);
            }
            HttpResponse result = httpClient.execute(method);
//            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                /**读取服务器返回过来的json字符串数据**/
                str = EntityUtils.toString(result.getEntity());
                if (noNeedResponse) {
                    return null;
                }
                /**把json字符串转换成json对象**/
                jsonResult = JSONObject.parseObject(str);
        		resultInfo.setCode(Constant.Success);
        		resultInfo.setContent(jsonResult);
        		return resultInfo;
            }else{
        		resultInfo.setCode(Constant.Fail);
        		return resultInfo;
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
    		resultInfo.setCode(Constant.Fail);
    		return resultInfo;
        } finally{
        	httpClient.getConnectionManager().shutdown();
        }
    }
    
    /**
     * httpGet
     * @param url  路径
     * @return
     */
    public static ResultInfo httpGet(String url){
        return httpGet(url, false);
    }    
 
    /**
     * get请求
     * 5、6行分别设置了Socket最大等待时间、连接最大等待时间（单位都是毫秒）。socket等待时间是指从站点下载页面和数据时，两个数据包之间的最大时间间隔，超过这个时间间隔，httpclient就认为连接出了故障。连接最大等待时间则是指和站点建立连接时的最大等待时间，超过这个时间站点不给回应，则认为站点无法连接。第7行设置httpclient不使用NoDelay策略。如果启用了NoDelay策略，httpclient和站点之间传输数据时将会尽可能及时地将发送缓冲区中的数据发送出去、而不考虑网络带宽的利用率，这个策略适合对实时性要求高的场景。而禁用了这个策略之后，数据传输会采用Nagle's algorithm发送数据，该算法会充分顾及带宽的利用率，而不是数据传输的实时性。第8行设置socket缓冲区的大小（单位为字节），默认是8KB。
     * @param url         url地址
     * @param noNeedResponse    不需要返回结果
     * @return
     */
	public static ResultInfo httpGet(String url, boolean noNeedResponse){
		ResultInfo resultInfo = new ResultInfo();
        //get请求返回结果
        DefaultHttpClient httpClient = new DefaultHttpClient();
        Integer socketTimeout = 10000;  
        Integer connectionTimeout = 10000;  
        httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, socketTimeout);  
        httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, connectionTimeout);  
        httpClient.getParams().setParameter(CoreConnectionPNames.TCP_NODELAY, false);  
        httpClient.getParams().setParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, 1024 * 1024);
        httpClient.setHttpRequestRetryHandler(new HttpRequestRetryService());
        JSONObject jsonResult = null;
        HttpGet method = new HttpGet(url);
        try {
            HttpResponse result = httpClient.execute(method);
//            url = URLDecoder.decode(url, "UTF-8");
            /**请求发送成功，并得到响应**/
            if (result.getStatusLine().getStatusCode() == 200) {
                String str = "";
                /**读取服务器返回过来的json字符串数据**/
//                str = EntityUtils.toString(result.getEntity());
                if (noNeedResponse) {
                    return null;
                }
                /**把json字符串转换成json对象**/
                jsonResult = JSONObject.parseObject(str);
        		resultInfo.setCode(Constant.Success);
        		resultInfo.setContent(jsonResult);
        		return resultInfo;
            }else{
        		resultInfo.setCode(Constant.Fail);
        		return resultInfo;
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
    		resultInfo.setCode(Constant.Fail);
    		return resultInfo;
        } finally{
        	httpClient.getConnectionManager().shutdown();
        }
    }
 
}

class HttpRequestRetryService implements HttpRequestRetryHandler{
	final int retryTime = 3;  
    @Override  
    public boolean retryRequest(IOException exception, int executionCount, HttpContext context)  
    {  
        if (executionCount >= retryTime)  
        {  
            // Do not retry if over max retry count  
            return false;  
        }  
        if (exception instanceof InterruptedIOException)  
        {  
            // Timeout  
            return false;  
        }  
        if (exception instanceof UnknownHostException)  
        {  
            // Unknown host  
            return false;  
        }  
        if (exception instanceof ConnectException)  
        {  
            // Connection refused  
            return false;  
        }  
        if (exception instanceof SSLException)  
        {  
            // SSL handshake exception  
            return false;  
        }  
        HttpRequest request = (HttpRequest) context.getAttribute(ExecutionContext.HTTP_REQUEST);  
        boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);  
        if (idempotent)  
        {  
            // Retry if the request is considered idempotent  
            return true;  
        }  
        return false;  
    }
  
}