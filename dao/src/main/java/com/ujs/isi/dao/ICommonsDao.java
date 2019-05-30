package com.ujs.isi.dao;

import com.ujs.isi.bean.TbCo2Data;
import com.ujs.isi.bean.TbPm10Data;
import com.ujs.isi.bean.TbPm25Data;
import com.ujs.isi.bean.TbVocData;
import com.ujs.isi.commons.ISIException;

import java.util.List;

/**
 * @author hyp
 * Project name is isi
 * Include in com.ujs.isi.dao
 * hyp create at 2019/5/24
 **/
public interface ICommonsDao<T> {

    /**
     * 获取不同天气用水用电
     *
     * @return Map`<String,Use>`
     */
    public List getUseWeather() throws ISIException;

    /**
     * 获取不同天气环境参数
     *
     * @return Map`<String,BeforeData>`
     */
    public List getDataWeather() throws ISIException;

    /**
     * 获取不同天气出差频率
     *
     * @return Map`<String,Int>`
     */
    public List getTravelWeather() throws ISIException;

    /**
     * 返回出差目的地数量
     *
     * @return
     */
    public int countTravel() throws ISIException;

    /**
     * 获取出差最多目的地
     * 输入从第f开始后的t条记录
     * 返回Map<String,Int>
     *
     * @param f
     * @param t
     * @return Map<String, Int>
     */
    public List getMaxDestination(int f, int t) throws ISIException;


    /**
     * 返回员工数量
     *
     * @return int
     */
    public int countStaff() throws ISIException;

    /**
     * 获取出差最多的人
     * 输入从第f开始后的t条记录
     *
     * @return Map<String, Int>
     */
    public List getMaxStaff(int f, int t) throws ISIException;


    /**
     * @return 返回设备数量
     */
    public int countDevice() throws ISIException;

    /**
     * 获取设备
     * 输入从第f开始后的t条记录
     *
     * @param f
     * @param t
     * @return List<Devices>
     */
    public List getDevices(int f, int t) throws ISIException;


    /**
     * 返回设备数据CO2数量
     * 输入设备id
     *
     * @return
     */
    public int countDeviceDataCo2(T did) throws ISIException;

    /**
     * 获取设备数据Co2
     * 输入从第f开始后的t条记录
     *
     * @param f
     * @param t
     * @return List<DevicesData>
     */
    public List getDevicesDataCo2(T did, int f, int t) throws ISIException;


    /**
     * 新增数据Co2
     *
     * @param data
     * @return 返回影响行数
     */
    public int addDeviceDataCo2(TbCo2Data data) throws ISIException;

    /**
     * 返回设备数据数量Voc
     * 输入设备id
     *
     * @return
     */
    public int countDeviceDataVoc(T did) throws ISIException;

    /**
     * 获取设备数据Voc
     * 输入从第f开始后的t条记录
     *
     * @param f
     * @param t
     * @return List<DevicesData>
     */
    public List getDevicesDataVoc(T did, int f, int t) throws ISIException;


    /**
     * 新增数据Voc
     *
     * @param data
     * @return 返回影响行数
     */
    public int addDeviceDataVoc(TbVocData data) throws ISIException;

    /**
     * 返回设备数据数量PM25
     * 输入设备id
     *
     * @return
     */
    public int countDeviceDataPM25(T did) throws ISIException;

    /**
     * 获取设备数据PM25
     * 输入从第f开始后的t条记录
     *
     * @param f
     * @param t
     * @return List<DevicesData>
     */
    public List getDevicesDataPM25(T did, int f, int t) throws ISIException;


    /**
     * 新增数据PM25
     *
     * @param data
     * @return 返回影响行数
     */
    public int addDeviceDataPM25(TbPm25Data data) throws ISIException;

    /**
     * 返回设备数据数量PM10
     * 输入设备id
     *
     * @return
     */
    public int countDeviceDataPM10(T did) throws ISIException;

    /**
     * 获取设备数据PM10
     * 输入从第f开始后的t条记录
     *
     * @param f
     * @param t
     * @return List<DevicesData>
     */
    public List getDevicesDataPM10(T did, int f, int t) throws ISIException;


    /**
     * 新增数据PM10
     *
     * @param data
     * @return 返回影响行数
     */
    public int addDeviceDataPM10(TbPm10Data data) throws ISIException;
}
