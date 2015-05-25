package com.gmo.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import com.gmo.model.user.UserTrace;

public class BeanToMapUtil {
  
    /**
     * 将一个 Map 对象转化为一个 JavaBean
     * @param type 要转化的类型
     * @param map 包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     * @throws IntrospectionException
     *             如果分析类属性失败
     * @throws IllegalAccessException
     *             如果实例化 JavaBean 失败
     * @throws InstantiationException
     *             如果实例化 JavaBean 失败
     * @throws InvocationTargetException
     *             如果调用属性的 setter 方法失败
     */
    public static Object convertMap(Class type, Map map)
            throws IntrospectionException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
        Object obj = type.newInstance(); // 创建 JavaBean 对象

        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();

            if (map.containsKey(propertyName)) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                Object value = map.get(propertyName);

                Object[] args = new Object[1];
                args[0] = value;

                descriptor.getWriteMethod().invoke(obj, args);
            }
        }
        return obj;
    }

    /**
     * 将一个 JavaBean 对象转化为一个  Map
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static Map convertBean(Object bean)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Class type = bean.getClass();
        Map returnMap = new HashMap();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }
    
    /**
     * 将一个 JavaBean 对象转化为一个  Map
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static LinkedHashMap convertBean1(Object bean)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Class type = bean.getClass();
        LinkedHashMap returnMap = new LinkedHashMap();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
        for (int i = 0; i< propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!propertyName.equals("class")) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, "");
                }
            }
        }
        return returnMap;
    }
    
    /**
     * 将一个 JavaBean 对象转化为一个  Map
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     * @throws IntrospectionException 如果分析类属性失败
     * @throws IllegalAccessException 如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static LinkedHashMap<String, String> convertBean2(UserTrace userTrace)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        LinkedHashMap<String, String> returnMap = new LinkedHashMap<String, String>();
        returnMap.put("ID", userTrace.getId()== null?"":userTrace.getId());
        returnMap.put("B040021", userTrace.getAuthType()== null?"":userTrace.getAuthType());
        returnMap.put("B040022", userTrace.getAuthId1()== null?"":userTrace.getAuthId1());
        returnMap.put("220040B", userTrace.getAuthId2()== null?"":userTrace.getAuthId2());
        returnMap.put("B040005", userTrace.getPassWord()== null?"":userTrace.getPassWord());
        returnMap.put("B050004", userTrace.getCallingNum()== null?"":userTrace.getCallingNum());
        returnMap.put("B050009", userTrace.getCalledNum()== null?"":userTrace.getCalledNum());
        returnMap.put("F020001", userTrace.getAllotIp()== null?"":userTrace.getAllotIp());
        returnMap.put("H010003", userTrace.getActionType()== null?"":userTrace.getActionType());
        returnMap.put("B020007", userTrace.getSsid()== null?"":userTrace.getSsid());
        returnMap.put("C050001", userTrace.getImei()== null?"":userTrace.getImei());
        returnMap.put("F030002", userTrace.getBsNum()== null?"":userTrace.getBsNum());
        returnMap.put("F030008", userTrace.getLocalAgent()== null?"":userTrace.getLocalAgent());
        returnMap.put("F030009", userTrace.getProxyGateway()== null?"":userTrace.getProxyGateway());
        returnMap.put("H010014", userTrace.getCaptureTime()== null?"":userTrace.getCaptureTime());
        returnMap.put("E020007", userTrace.getCallingLocation()== null?"":userTrace.getCallingLocation());
        returnMap.put("C040002", userTrace.getTerMac()== null?"":userTrace.getTerMac());
        returnMap.put("G020013", userTrace.getMakerOrgCode()== null?"":userTrace.getMakerOrgCode());
        returnMap.put("G020014", userTrace.getMakerOrgName()== null?"":userTrace.getMakerOrgName());
        returnMap.put("B020001", userTrace.getOperatorFlag()== null?"":userTrace.getOperatorFlag());
        returnMap.put("F030013", userTrace.getUplinkTunnelNo()== null?"":userTrace.getUplinkTunnelNo());
        returnMap.put("F030014", userTrace.getDownlinkTunnelNo()== null?"":userTrace.getDownlinkTunnelNo());
        returnMap.put("F010008", userTrace.getCollectSite()== null?"":userTrace.getCollectSite());
        returnMap.put("B050012", userTrace.getFirstCollectTime()== null?"":userTrace.getFirstCollectTime());
        returnMap.put("B050014", userTrace.getLatelyCollectTime()== null?"":userTrace.getLatelyCollectTime());
        returnMap.put("B050016", userTrace.getDataSourceName()== null?"":userTrace.getDataSourceName());
        returnMap.put("H010034", userTrace.getSensitivityLevel()== null?"":userTrace.getSensitivityLevel());
        returnMap.put("B050018", userTrace.getOldDiscoverDays()== null?"":userTrace.getOldDiscoverDays());
        returnMap.put("B050020", userTrace.getNewDiscoverDays()== null?"":userTrace.getNewDiscoverDays());
        return returnMap;
    }
} 