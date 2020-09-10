package com.work;

import org.apache.cxf.jaxrs.client.WebClient;

import javax.xml.ws.Response;


/**
 * @ClassName WebClient_Test
 * @Description
 * @Author ymy
 * @Date 2020-08-21 08:56
 * @Version 1.0
 */
public class WebClient_Test {
    public static void main(String[] args) {
        WebClient client=WebClient.create("http://10.18.10.134:7003/ecips-open");
        String url="/web/code/auth2/token?appid=1";
        String query=url.substring(url.indexOf("?")+1);

        System.out.println("query="+query);
        System.out.println(client.path(url).replaceQuery(query).getCurrentURI().toString());

    }
}
