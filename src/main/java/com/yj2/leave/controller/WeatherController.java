package com.yj2.leave.controller;

import com.yj2.leave.util.PureNetUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@Api(value = "WeatherController|天气预报信息管理")
public class WeatherController {
    //接口地址,因为只需要传入一个固定的key为参数,所以设为常量
    private static final String URL= "http://v.juhe.cn/weather/uni?key=d1b821b79431d3c684c36d07d79195ea";

    /**
     * 调用获取城市列表接口,返回所有数据
     * @return 返回接口数据
     */
    @GetMapping("/cityList")
    @ApiOperation("获取所有城市列表")
    public String excute(){
        //PureNetUtil是一个封装了get和post方法获取网络请求数据的工具类
        return PureNetUtil.get(URL);//使用get方法
    }

    /**
     * 调用接口返回数据后,解析数据,根据输入城市名得到对应ID
     * @param cityName 城市名称
     * @return 返回对应ID
     */
    @GetMapping("/idBycityName")
    @ApiOperation("根据城市名获取对应ID")
    public String getIDBycityName(String cityName) {
        String result=excute();//返回接口结果,得到json格式数据
        if(result!=null){
            JSONObject obj=JSONObject.fromObject(result);
            result=obj.getString("resultcode");//得到返回状态码
            if(result!=null&&result.equals("200")){//200表示成功返回数据
                result=obj.getString("result");//得到城市列表的json格式字符串数组
                JSONArray arr=JSONArray.fromObject(result);
                for(Object o:arr){//对arr进行遍历
                    //将数组中的一个json个数字符串进行解析
                    obj=JSONObject.fromObject(o.toString());
                    /*此时obj如 {"id":"2","province":"北京","city":"北京","district":"海淀"}*/
                    //以city这个key为线索判断所需要寻找的这条记录
                    result=obj.getString("district");
                    //防止输入城市名不全,如苏州市输入为苏州,类似与模糊查询
                    if(result.equals(cityName)||result.contains(cityName)){
                        result=obj.getString("id");//得到ID
                        return result;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 利用遍历数组的方式获取
     * @return 天气名称
     */
    @GetMapping("/weatherByWid")
    @ApiOperation("根据Wid获取天气信息")
    public String getWeatherByWid(String wid) {
        String result=excute();//获取接口数据
        if(result!=null){
            JSONObject obj=JSONObject.fromObject(result);
            result=obj.getString("resultcode");
            /*获取返回状态码*/
            if(result!=null&&result.equals("200")){
                /*获取数组数据*/
                result=obj.getString("result");
                JSONArray arr=JSONArray.fromObject(result);
                for(Object o:arr){//遍历数组
                    obj=JSONObject.fromObject(o.toString());
                    //如果遍历到需要的数据后直接返回结果,根据key(wid)得到value判断是否等于传入参数
                    if(obj.getString("wid").equals(wid)){
                        result=obj.getString("weather");
                        return result;
                    }
                }
            }
        }
        return result;
    }

    /**
     * 根据城市名获取
     * @param cityName
     * @return
     */
    @GetMapping("/cityByCityName")
    @ApiOperation("根据城市名称获取城市信息")
    public String excute1(String cityName){
        String url=//此处以返回json格式数据示例,所以format=2,以根据城市名称为例,cityName传入中文
                "http://v.juhe.cn/weather/index?cityname="+cityName+"&key=d1b821b79431d3c684c36d07d79195ea";
        return PureNetUtil.get(url);//通过工具类获取返回数据
    }
    /**
     * 获取返回数据中的一个属性示例,此处以获取今日温度为例
     * "temperature": "8℃~20℃"     今日温度
     * @return
     */
    @GetMapping("/todayTemperatureByCity")
    @ApiOperation("获取城市今日温度")
    public String GetTodayTemperatureByCity(String city) {
        String result=excute1(city);
        if(result!=null){
            JSONObject obj=JSONObject.fromObject(result);
            /*获取返回状态码*/
            result=obj.getString("resultcode");
            /*如果状态码是200说明返回数据成功*/
            if(result!=null&&result.equals("200")){
                result=obj.getString("result");
                //此时result中数据有多个key,可以对其key进行遍历,得到对个属性
                obj=JSONObject.fromObject(result);
                //今日温度对应的key是today
                result=obj.getString("today");
                obj=JSONObject.fromObject(result);
                //今日温度对应当key是temperature
                result=obj.getString("temperature");
                return result;
            }
        }
        return result;
    }
}
