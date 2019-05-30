package com.ujs.isi.dao;

import com.ujs.isi.bean.TbCo2Data;
import com.ujs.isi.bean.TbPm10Data;
import com.ujs.isi.bean.TbPm25Data;
import com.ujs.isi.bean.TbVocData;
import com.ujs.isi.commons.ISIException;
import com.ujs.isi.utils.DBUtils;
import com.ujs.isi.utils.DownDateFormat;
import com.ujs.isi.utils.QueryUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hyp
 * Project name is isi
 * Include in com.ujs.isi.dao
 * hyp create at 2019/5/24
 **/
public class CommonsDao implements ICommonsDao<java.math.BigDecimal> {
    private static Logger log = LoggerFactory.getLogger(CommonsDao.class);
    ScalarHandler<Integer> scalarHandler = new ScalarHandler<Integer>() {
        @Override
        public Integer handle(ResultSet rs) throws SQLException {
            int c = 0;
            if (rs.next()) {
                c = rs.getInt(1);
            }
            return c;
        }
    };
    ResultSetHandler<Integer> re = new ResultSetHandler<Integer>() {
        @Override
        public Integer handle(ResultSet resultSet) throws SQLException {
            int i = 0;
            if (resultSet.next()) {
                i = resultSet.getInt(1);
            }
            return i;
        }
    };

    private List<Map<String, Object>> get(String sql, ResultSetHandler<Map<String, Object>> rsh, Object... params) throws ISIException {
        Connection con = null;
        QueryRunner q = new QueryRunner();
        List<Map<String, Object>> l = new ArrayList<>();
        try {
            con = DBUtils.getConnection();
            l = q.execute(con, sql, rsh, params);

        } catch (Exception e) {
            throw new ISIException(e);
        } finally {
            try {
                DbUtils.close(con);
            } catch (SQLException e) {
                throw new ISIException(e);
            }
        }
        return l;
    }

    private int count(String sql, ResultSetHandler<Integer> rsh, Object... params) throws ISIException {
        Connection con = null;
        QueryRunner q = new QueryRunner();

        int count = 0;
        try {
            con = DBUtils.getConnection();
            count = q.query(con, sql, rsh, params);
        } catch (Exception e) {
            throw new ISIException(e);
        } finally {
            try {
                DbUtils.close(con);
            } catch (SQLException e) {
                throw new ISIException(e);
            }
        }

        return count;
    }

    /**
     * 获取不同天气用水用电
     *
     * @return List<Map ` < String, Use>>`
     */
    @Override
    public List getUseWeather() throws ISIException {

        return get(QueryUtils.instance.get("weather.use"),
                new MapHandler() {
                    @Override
                    public Map<String, Object> handle(ResultSet rs) throws SQLException {
                        Map<String, Object> map = new HashMap<>();
                        if (rs.next()) {
                            map.put("weather", rs.getString("tweather"));
                            map.put("water", rs.getBigDecimal("tcwater"));
                            map.put("electricity", rs.getBigDecimal("tcelectricity"));

                        }
                        return map;
                    }
                });
    }

    /**
     * 获取不同天气环境参数
     *
     * @return List<Map ` < String, BeforeData>>`
     */
    @Override
    public List getDataWeather() throws ISIException {

        return get(QueryUtils.instance.get("weather.data"),
                new MapHandler() {
                    @Override
                    public Map<String, Object> handle(ResultSet rs) throws SQLException {
                        Map<String, Object> map = new HashMap<>();
                        if (rs.next()) {
                            map.put("weather", rs.getString("tweather"));
                            map.put("co2", rs.getBigDecimal("tco2"));
                            map.put("voc", rs.getBigDecimal("tvoc"));
                            map.put("pm25", rs.getBigDecimal("tpm25"));
                            map.put("pm10", rs.getBigDecimal("tpm10"));

                        }
                        return map;
                    }
                });
    }

    /**
     * 获取不同天气出差频率
     *
     * @return List<Map ` < String, Int>>`
     */
    @Override
    public List getTravelWeather() throws ISIException {

        return get(QueryUtils.instance.get("weather.travel"),
                new MapHandler() {
                    @Override
                    public Map<String, Object> handle(ResultSet rs) throws SQLException {
                        Map<String, Object> map = new HashMap<>();
                        if (rs.next()) {
                            map.put("weather", rs.getString("tweather"));
                            map.put("count", rs.getBigDecimal("tcount"));

                        }
                        return map;
                    }
                });
    }

    /**
     * 返回出差目的地数量
     *
     * @return int
     */
    @Override
    public int countTravel() throws ISIException {


        return count(QueryUtils.instance.get("travel.count"),
                scalarHandler);
    }

    /**
     * 获取出差最多目的地
     * 输入从第f开始后的t条记录
     * 返回ListMap<String,Int>
     *
     * @param f
     * @param t
     * @return ListMap<String, Int>
     */
    @Override
    public List getMaxDestination(int f, int t) throws ISIException {


        return get(QueryUtils.instance.get("travel.destination"),
                new MapHandler() {
                    @Override
                    public Map<String, Object> handle(ResultSet rs) throws SQLException {
                        Map<String, Object> map = new HashMap<>();
                        if (rs.next()) {
                            map.put("destination", rs.getString("tdestination"));
                            map.put("count", rs.getBigDecimal("tcount"));

                        }
                        return map;
                    }
                }, f, t);
    }

    /**
     * 返回员工数量
     *
     * @return int
     */
    @Override
    public int countStaff() throws ISIException {


        return count(QueryUtils.instance.get("staff.count"),
                scalarHandler);
    }

    /**
     * 获取出差最多的人
     * 输入从第f开始后的t条记录
     *
     * @param f
     * @param t
     * @return Map<String, Int>
     */
    @Override
    public List getMaxStaff(int f, int t) throws ISIException {
        return get(QueryUtils.instance.get("travel.staff"),
                new MapHandler() {
                    @Override
                    public Map<String, Object> handle(ResultSet rs) throws SQLException {
                        Map<String, Object> map = new HashMap<>();
                        if (rs.next()) {
                            map.put("name", rs.getString("tname"));
                            map.put("count", rs.getBigDecimal("tcount"));

                        }
                        return map;
                    }
                }, f, t);
    }

    /**
     * @return 返回设备数量
     */
    @Override
    public int countDevice() throws ISIException {
        return count(QueryUtils.instance.get("device.count"),
                scalarHandler);
    }

    /**
     * 获取设备
     * 输入从第f开始后的t条记录
     *
     * @param f
     * @param t
     * @return List<Devices>
     */
    @Override
    public List getDevices(int f, int t) throws ISIException {
        return get(QueryUtils.instance.get("device.get"),
                new MapHandler() {
                    @Override
                    public Map<String, Object> handle(ResultSet rs) throws SQLException {
                        Map<String, Object> map = new HashMap<>();
                        if (rs.next()) {
                            map.put("id", rs.getBigDecimal("tid"));
                            map.put("name", rs.getString("tname"));
                            map.put("number", rs.getString("tnumber"));

                        }
                        return map;
                    }
                }, f, t);
    }


    @Override
    public int countDeviceDataCo2(BigDecimal did) throws ISIException {
        return count(QueryUtils.instance.get("device.data.count.co2"),
                scalarHandler, did);
    }

    @Override
    public List getDevicesDataCo2(BigDecimal did, int f, int t) throws ISIException {
        return get(QueryUtils.instance.get("device.data.get.co2"),
                new MapHandler() {
                    @Override
                    public Map<String, Object> handle(ResultSet rs) throws SQLException {
                        Map<String, Object> map = new HashMap<>();
                        if (rs.next()) {
                            map.put("co2", rs.getBigDecimal("tco2"));
                            map.put("date", DownDateFormat.format(rs.getTimestamp("tdate")));

                        }
                        return map;
                    }
                }, did, f, t);
    }

    @Override
    public int addDeviceDataCo2(TbCo2Data data) throws ISIException {
        Connection con = null;
        QueryRunner q = new QueryRunner();
        int l = 0;
        try {
            con = DBUtils.getConnection();
            l = q.query(con, QueryUtils.instance.get("device.data.add.co2"),
                    re
                    , data.getDid(),
                    data.getCo2(),
                    data.getDate()
            );

        } catch (Exception e) {
            throw new ISIException(e);
        } finally {
            try {
                DbUtils.close(con);
            } catch (SQLException e) {
                throw new ISIException(e);
            }
        }

        return l;
    }

    @Override
    public int countDeviceDataVoc(BigDecimal did) throws ISIException {
        return count(QueryUtils.instance.get("device.data.count.voc"),
                scalarHandler, did);
    }

    @Override
    public List getDevicesDataVoc(BigDecimal did, int f, int t) throws ISIException {
        return get(QueryUtils.instance.get("device.data.get.voc"),
                new MapHandler() {
                    @Override
                    public Map<String, Object> handle(ResultSet rs) throws SQLException {
                        Map<String, Object> map = new HashMap<>();
                        if (rs.next()) {
                            map.put("voc", rs.getBigDecimal("tvoc"));
                            map.put("date", DownDateFormat.format(rs.getTimestamp("tdate")));

                        }

                        return map;

                    }
                }, did, f, t);
    }

    @Override
    public int addDeviceDataVoc(TbVocData data) throws ISIException {
        Connection con = null;
        QueryRunner q = new QueryRunner();
        int l = 0;
        try {
            con = DBUtils.getConnection();
            l = q.query(con, QueryUtils.instance.get("device.data.add.voc"),
                    re
                    , data.getDid(),
                    data.getVoc(),
                    data.getDate()
            );

        } catch (Exception e) {
            throw new ISIException(e);
        } finally {
            try {
                DbUtils.close(con);
            } catch (SQLException e) {
                throw new ISIException(e);
            }
        }

        return l;
    }

    @Override
    public int countDeviceDataPM25(BigDecimal did) throws ISIException {
        return count(QueryUtils.instance.get("device.data.count.pm25"),
                scalarHandler, did);
    }

    @Override
    public List getDevicesDataPM25(BigDecimal did, int f, int t) throws ISIException {
        return get(QueryUtils.instance.get("device.data.get.pm25"),
                new MapHandler() {
                    @Override
                    public Map<String, Object> handle(ResultSet rs) throws SQLException {
                        Map<String, Object> map = new HashMap<>();
                        if (rs.next()) {

                            map.put("pm25", rs.getBigDecimal("tpm25"));
                            map.put("date", DownDateFormat.format(rs.getTimestamp("tdate")));

                        }
                        return map;
                    }
                }, did, f, t);
    }

    @Override
    public int addDeviceDataPM25(TbPm25Data data) throws ISIException {
        Connection con = null;
        QueryRunner q = new QueryRunner();
        int l = 0;
        try {
            con = DBUtils.getConnection();
            l = q.query(con, QueryUtils.instance.get("device.data.add.pm25"),
                    re
                    , data.getDid(),
                    data.getPm25(),
                    data.getDate()

            );

        } catch (Exception e) {
            throw new ISIException(e);
        } finally {
            try {
                DbUtils.close(con);
            } catch (SQLException e) {
                throw new ISIException(e);
            }
        }

        return l;
    }

    @Override
    public int countDeviceDataPM10(BigDecimal did) throws ISIException {
        return count(QueryUtils.instance.get("device.data.count.pm10"),
                scalarHandler, did);
    }

    @Override
    public List getDevicesDataPM10(BigDecimal did, int f, int t) throws ISIException {
        return get(QueryUtils.instance.get("device.data.get.pm10"),
                new MapHandler() {
                    @Override
                    public Map<String, Object> handle(ResultSet rs) throws SQLException {
                        Map<String, Object> map = new HashMap<>();
                        if (rs.next()) {
                            map.put("pm10", rs.getBigDecimal("tpm10"));
                            map.put("date", DownDateFormat.format(rs.getTimestamp("tdate")));

                        }
                        return map;
                    }
                }, did, f, t);
    }

    @Override
    public int addDeviceDataPM10(TbPm10Data data) throws ISIException {
        Connection con = null;
        QueryRunner q = new QueryRunner();
        int l = 0;
        try {
            con = DBUtils.getConnection();
            l = q.query(con, QueryUtils.instance.get("device.data.add.pm10"),
                    re
                    , data.getDid(),
                    data.getPm10(),
                    data.getDate()
            );
        } catch (Exception e) {
            throw new ISIException(e);
        } finally {
            try {
                DbUtils.close(con);
            } catch (SQLException e) {
                throw new ISIException(e);
            }
        }

        return l;
    }
}
