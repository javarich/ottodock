package com.ottodock.db;

import com.ottodock.core.DockMetric;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.time.Instant;
import java.util.List;

@RegisterBeanMapper(DockMetric.class)

public interface DockMetricDao {


    @SqlQuery("SELECT * FROM dock_metric where dock_id = ?")
    List<DockMetric> listDockMetricsFor(int dockId);

    @SqlUpdate("insert into dock_metric (dock_id, north, east, down, temperature, wind_speed, measurementTS) " +
            "values (:dockId, :north, :east, :down, :temperature, :windSpeed, :metricTs)")
    void insert(@BindBean DockMetric dockMetric);
//    dock_metric (
//            dock_id       INTEGER NOT NULL,
//            north         FLOAT NOT NULL,
//            east          FLOAT NOT NULL,
//            down          FLOAT NOT NULL,
//            temperature    FLOAT NOT NULL,
//            wind_speed    FLOAT NOT NULL,
//            measurementTS TIMESTAMP,

}
