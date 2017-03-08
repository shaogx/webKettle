package org.sxdata.jingwei.util.CommonUtil;

import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cRAZY on 2017/2/22.
 *
 */
public class Util {
    //为json-lib日期返回正常的中的指定格式
    public static JsonConfig configJson(String datePattern){
        JsonConfig  config=new JsonConfig();
        config.setExcludes(new String[]{""});
        config.setIgnoreDefaultExcludes(false);
        config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        config.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor(datePattern));
        return config;
    }

    //判断字符串不是空
    public static boolean isEmpty(String source){
        if (source==null || source.trim().equals("")){
            return true;
        }
        return false;
    }

    //字符串按照指定格式转换为日期
    public static Date stringToDate(String source,String pattern) throws Exception{
        SimpleDateFormat simple=new SimpleDateFormat(pattern);
        return simple.parse(source);
    }

    //日期按照指定格式转换为字符串
    public static String dateToString(String source,String pattern) throws Exception{
        SimpleDateFormat simple=new SimpleDateFormat(pattern);
        return simple.format(source);
    }

    //获取request对象中所有参数，并设置到map中
    public static Map getMapByRequest(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<String, Object>();
        Enumeration enu = request.getParameterNames();
        while(enu.hasMoreElements()) {
            String paraName = (String)enu.nextElement();
            String paraValue = request.getParameter(paraName);
            if(paraValue!=null && !"".equals(paraValue)){
                map.put(paraName, paraValue.trim());
            }
        }
        return map;
    }

    public static Integer getdayInt(String dayByMonth){
        String result="";
        dayByMonth=dayByMonth.trim();
        int index=dayByMonth.indexOf("号");
        result=dayByMonth.substring(0,index);
        return Integer.parseInt(result);
    }

    public static Integer getIntWeek(String week){
        Integer result=0;
        week=week.trim();
        if(week.endsWith("一")){
            result=2;
        }else if(week.endsWith("二")){
            result=3;
        }else if(week.endsWith("三")){
            result=4;
        }else if(week.endsWith("四")){
            result=5;
        }else if(week.endsWith("五")){
            result=6;
        }else if(week.endsWith("六")){
            result=7;
        }else if(week.endsWith("日")){
            result=1;
        }
        return result;
    }
}
