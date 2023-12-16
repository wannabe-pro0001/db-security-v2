package com.db.security.config;

import lombok.RequiredArgsConstructor;
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

    public DatasourceRoutingConfig(DataSourceContextHolder dataSourceContextHolder, PrimaryDatasourceConfig primaryDatasourceConfig, XacThucDatasourceConfig xacThucDatasourceConfig) {
        this.dataSourceContextHolder = dataSourceContextHolder;
        this.primaryDatasourceConfig = primaryDatasourceConfig;
        this.xacThucDatasourceConfig = xacThucDatasourceConfig;
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put(DatasourceType.PRIMARY, primaryDatasourceConfig());
        dataSourceMap.put(DatasourceType.XAC_THUC, xacThucDatasourceConfig());

        this.setTargetDataSources(dataSourceMap);
        this.setDefaultTargetDataSource(xacThucDatasourceConfig());
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
