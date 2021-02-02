package com.example.demo.command;

import com.alibaba.cola.dto.Response;
import com.example.demo.domain.metrics.techinfluence.ATAMetric;
import com.example.demo.domain.metrics.techinfluence.ATAMetricItem;
import com.example.demo.domain.metrics.techinfluence.InfluenceMetric;
import com.example.demo.domain.user.UserProfile;
import com.example.demo.dto.ATAMetricAddCmd;
import com.example.demo.domain.gateway.MetricGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ATAMetricAddCmdExe
 *
 * @author Frank Zhang
 * @date 2019-03-01 11:42 AM
 */
@Component
public class ATAMetricAddCmdExe{

    @Autowired
    private MetricGateway metricGateway;

    public Response execute(ATAMetricAddCmd cmd) {
        ATAMetricItem ataMetricItem = new ATAMetricItem();
        BeanUtils.copyProperties(cmd.getAtaMetricCO(), ataMetricItem);
        ataMetricItem.setSubMetric(new ATAMetric(new InfluenceMetric(new UserProfile(cmd.getAtaMetricCO().getOwnerId()))));
        metricGateway.save(ataMetricItem);
        return Response.buildSuccess();
    }
}
