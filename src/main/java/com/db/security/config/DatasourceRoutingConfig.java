package com.db.security.config;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class DatasourceRoutingConfig extends AbstractRoutingDataSource {
    private final DataSourceContextHolder dataSourceContextHolder;
    private final PrimaryDatasourceConfig primaryDatasourceConfig;
    private final XacThucDatasourceConfig xacThucDatasourceConfig;
    private final XacThuc1DataSourceConfig xacThuc1DataSourceConfig;
    private final XacThuc2DataSourceConfig xacThuc2DataSourceConfig;
    private final XacThuc3DataSourceConfig xacThuc3DataSourceConfig;
    private final LuuTruDatasourceConfig luuTruDatasourceConfig;
    private final XetDuyetDatasourceConfig xetDuyetDatasourceConfig;


    public DatasourceRoutingConfig(DataSourceContextHolder dataSourceContextHolder, PrimaryDatasourceConfig primaryDatasourceConfig, XacThucDatasourceConfig xacThucDatasourceConfig,
                                   XacThuc1DataSourceConfig xacThuc1DataSourceConfig, XacThuc2DataSourceConfig xacThuc2DataSourceConfig, XacThuc3DataSourceConfig xacThuc3DataSourceConfig, LuuTruDatasourceConfig luuTruDatasourceConfig, XetDuyetDatasourceConfig xetDuyetDatasourceConfig) {
        this.dataSourceContextHolder = dataSourceContextHolder;
        this.primaryDatasourceConfig = primaryDatasourceConfig;
        this.xacThucDatasourceConfig = xacThucDatasourceConfig;
        this.xacThuc1DataSourceConfig = xacThuc1DataSourceConfig;
        this.xacThuc2DataSourceConfig = xacThuc2DataSourceConfig;
        this.xacThuc3DataSourceConfig = xacThuc3DataSourceConfig;
        this.luuTruDatasourceConfig = luuTruDatasourceConfig;
        this.xetDuyetDatasourceConfig = xetDuyetDatasourceConfig;

        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DatasourceType.PRIMARY, primaryDatasourceConfig());
        dataSourceMap.put(DatasourceType.XAC_THUC, xacThucDatasourceConfig());
        dataSourceMap.put(DatasourceType.XAC_THUC_1, xacThuc1DataSourceConfig());
        dataSourceMap.put(DatasourceType.XAC_THUC_2, xacThuc2DataSourceConfig());
        dataSourceMap.put(DatasourceType.XAC_THUC_3, xacThuc3DataSourceConfig());
        dataSourceMap.put(DatasourceType.XET_DUYET, xetDuyetDatasourceConfig());
        dataSourceMap.put(DatasourceType.LUU_TRU, luuTruDatasourceConfig());

        this.setTargetDataSources(dataSourceMap);
        this.setDefaultTargetDataSource(xacThucDatasourceConfig());
    }

    private DataSource xacThuc1DataSourceConfig() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(xacThuc1DataSourceConfig.getUrl());
        dataSource.setUsername(xacThuc1DataSourceConfig.getUsername());
        dataSource.setPassword(xacThuc1DataSourceConfig.getPassword());
        return dataSource;
    }
    private DataSource xacThuc2DataSourceConfig() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(xacThuc2DataSourceConfig.getUrl());
        dataSource.setUsername(xacThuc2DataSourceConfig.getUsername());
        dataSource.setPassword(xacThuc2DataSourceConfig.getPassword());
        return dataSource;
    }
    private DataSource xetDuyetDatasourceConfig() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(xetDuyetDatasourceConfig.getUrl());
        dataSource.setUsername(xetDuyetDatasourceConfig.getUsername());
        dataSource.setPassword(xetDuyetDatasourceConfig.getPassword());
        return dataSource;
    }
    private DataSource luuTruDatasourceConfig() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(luuTruDatasourceConfig.getUrl());
        dataSource.setUsername(luuTruDatasourceConfig.getUsername());
        dataSource.setPassword(luuTruDatasourceConfig.getPassword());
        return dataSource;
    }
    private DataSource xacThuc3DataSourceConfig() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(xacThuc3DataSourceConfig.getUrl());
        dataSource.setUsername(xacThuc3DataSourceConfig.getUsername());
        dataSource.setPassword(xacThuc3DataSourceConfig.getPassword());
        return dataSource;
    }

    private DataSource primaryDatasourceConfig() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(primaryDatasourceConfig.getUrl());
        dataSource.setUsername(primaryDatasourceConfig.getUsername());
        dataSource.setPassword(primaryDatasourceConfig.getPassword());
        return dataSource;
    }

    private DataSource xacThucDatasourceConfig() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(xacThucDatasourceConfig.getUrl());
        dataSource.setUsername(xacThucDatasourceConfig.getUsername());
        dataSource.setPassword(xacThucDatasourceConfig.getPassword());
        return dataSource;
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceContextHolder.getBranchContext();
    }
}
