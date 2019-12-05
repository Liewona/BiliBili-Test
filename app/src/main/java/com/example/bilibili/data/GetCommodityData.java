package com.example.bilibili.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.bilibili.contentobj.CommodityBean;
import com.example.bilibili.utils.URLUtils;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class GetCommodityData {

    public static String url = "http://192.168.1.102:8080/CommodityServlet";

    public static List<CommodityBean> getData() {

        List<CommodityBean> list = new ArrayList<>();
        String result = URLUtils.doGet(url);
        JSONArray jsonArray = JSON.parseArray(result);
        if (jsonArray == null || jsonArray.size() == 0) return list;
//        else{
            JSONObject object = null;
            CommodityBean bean = new CommodityBean();
            for(int i = 0; i < jsonArray.size(); i++) {
                object = jsonArray.getJSONObject(i);
                bean.setTitle(object.get("title").toString());
                bean.setBrand(object.get("brand").toString());
                bean.setIntroduce(object.get("introduce").toString());
                bean.setIp(object.get("ip").toString());
                bean.setPic(object.get("pic").toString());
                bean.setPrice(Double.parseDouble(object.get("price").toString()));
                list.add(bean);
                bean = new CommodityBean();
            }
            return list;
//        }

    }
}
