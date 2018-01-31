package com.ottodock.resources;

import com.codahale.metrics.annotation.Timed;
import com.ottodock.core.DockMetric;
import com.ottodock.core.User;
import com.ottodock.db.DockMetricDao;
import com.sun.org.apache.xpath.internal.operations.Minus;
import org.slf4j.LoggerFactory;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Optional;

@Path("/docks/metrics")

public class DockMetricsResource {
    private final org.slf4j.Logger log = LoggerFactory.getLogger(this.getClass());

    private DockMetricDao dao;
    public DockMetricsResource(DockMetricDao dao) {
        this.dao = dao;
    }

    @GET
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public List<DockMetric> getDockMetrics(@QueryParam("dockId") int dockId) {
        log.info("Getting metrics for dockId = {}", dockId);
        return dao.listDockMetricsFor(dockId);
    }

    @POST
    @Timed
    @Produces(MediaType.APPLICATION_JSON)
    public int insertMetric() {
        return 0;
    }

}
