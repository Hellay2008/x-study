package com.example.demo.convertor;


import com.example.demo.domain.metrics.MetricItem;
import com.example.demo.gatewayimpl.database.dataobject.MetricDO;

/**
 * @author frankzhang
 */
public class MetricConvertor{

    public static MetricDO toDataObject(MetricItem metricItem){
        MetricDO metricDO = new MetricDO();
        metricDO.setUserId(metricItem.getMetricOwner().getUserId());
        metricDO.setMainMetric(metricItem.getSubMetric().getParent().getCode());
        metricDO.setSubMetric(metricItem.getSubMetric().getCode());
        metricDO.setMetricItem(metricItem.toJsonString());
        return metricDO;
    }

}
