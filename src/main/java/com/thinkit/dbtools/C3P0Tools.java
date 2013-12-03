package com.thinkit.dbtools;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Statement;
import com.thinkit.vo.SpeechVo;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Good Luck! Man! -- C3P0Tools
 *
 * @author shaohailong
 */
public class C3P0Tools {

    private static C3P0Tools dbPool;
    private ComboPooledDataSource dataSource;
    private static Logger log = Logger.getLogger(C3P0Tools.class);

    static {
        dbPool = new C3P0Tools();
    }

    public C3P0Tools() {
        Properties props = new Properties();
        try {
            props.load(this.getClass().getResourceAsStream("/config.properties"));
        } catch (IOException ex) {
            log.error("配置文件信息获取失败", ex);
        }

        try {
            dataSource = new ComboPooledDataSource();
            dataSource.setUser(props.getProperty("db.username"));
            dataSource.setPassword(props.getProperty("db.password"));
            dataSource.setJdbcUrl(props.getProperty("db.url"));
            dataSource.setDriverClass(props.getProperty("db.driver"));
            dataSource.setInitialPoolSize(4);
            dataSource.setMinPoolSize(5);
            dataSource.setMaxPoolSize(20);
            dataSource.setMaxStatements(150);
            dataSource.setMaxIdleTime(1800);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    public static C3P0Tools getInstance() {
        return dbPool;
    }

    public final Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
        	System.out.println("无法获取连接");
            throw new RuntimeException("无法从数据源获取连接 ", e);
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection con = null;
        try {
            con = C3P0Tools.getInstance().getConnection();
        } catch (Exception e) {
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}