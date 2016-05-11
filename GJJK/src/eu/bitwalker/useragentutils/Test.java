package eu.bitwalker.useragentutils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yunsu on 2016/5/10.
 */
public class Test {
    public static void main(String[] args){
//        UserAgent userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36");
        //Mozilla/5.0 (Linux; Android 4.4.2; H60-L01 Build/HDH60-L01) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/37.0.0.0 Mobile MQQBrowser/6.2 TBS/036215 Safari/537.36 MicroMessenger/6.3.13.49_r4080b63.740 NetType/WIFI Language/zh_CN
//        Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Version/9.0 Mobile/13B143 Safari/601.1 wechatdevtools/0.6.0 MicroMessenger/6.3.9 Language/zh_CN webview/0
//        Meizu MX2 M040 	Android 4.1 	ÁÔ±ª 2.8 	Mozilla/5.0 (Linux; Android 4.1.1; M040 Build/JRO03H) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/28.0.1500.64 Mobile Safari/537.36
//        Mozilla/5.0 (Linux; Android 4.4.2; GT-I9507V Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36
//        Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36
//        Mozilla/5.0 (iPhone; CPU iPhone OS 9_3_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13E238 AliApp(TB/5.4.3)  WindVane/8.0.0 750x1334
//        Mozilla/5.0 (Linux; Android 4.4.2; H60-L02 Build/HDH60-L02) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/37.0.0.0 Mobile MQQBrowser/6.2 TBS/036215 Safari/537.36 MicroMessenger/6.3.16.49_r03ae324.780 NetType/WIFI Language/zh_CN
        UserAgent userAgent=UserAgent.parseUserAgentString("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.111 Safari/537.36");
        System.out.println(userAgent.toString());
        System.out.println(userAgent.getOperatingSystem());
        System.out.println("os: "+userAgent.getOperatingSystem().getName());
        System.out.println("os_manufacturer: "+userAgent.getOperatingSystem().getManufacturer());
        System.out.println("browser_name: "+userAgent.getBrowser().getName());
        System.out.println("browser_type: "+userAgent.getBrowser().getBrowserType());
        System.out.println(userAgent.getBrowserVersion());
        System.out.println(userAgent.getBrowser().getRenderingEngine());

        Pattern pattern=Pattern.compile("Mobile(/\\w+)?\\s\\w+");
        Matcher matcher=pattern.matcher("Mozilla/5.0 (iPhone; CPU iPhone OS 9_3_1 like Mac OS X) AppleWebKit/601.1.46 (KHTML, like Gecko) Mobile/13E238 AliApp(TB/5.4.3)  WindVane/8.0.0 750x1334");
        if (matcher.find()){
            String app=matcher.group();
            System.out.println("app: "+app);
        }

        Pattern netPattern=Pattern.compile("NetType/\\w+(\\+)?");
        Matcher netMatcher=netPattern.matcher("Mozilla/5.0 (Linux; Android 4.4.2; H60-L02 Build/HDH60-L02) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/37.0.0.0 Mobile MQQBrowser/6.2 TBS/036215 Safari/537.36 MicroMessenger/6.3.16.49_r03ae324.780 NetType/wifi+ Language/zh_CN");
        if (netMatcher.find()){
            String netType=netMatcher.group();
            System.out.println("netType: "+netType);
        }
    }
}
