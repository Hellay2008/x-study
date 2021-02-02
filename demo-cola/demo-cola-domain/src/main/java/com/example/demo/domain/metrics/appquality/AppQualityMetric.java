package com.example.demo.domain.metrics.appquality;

import com.example.demo.domain.metrics.MainMetric;
import com.example.demo.domain.metrics.MainMetricType;
import com.example.demo.domain.metrics.devquality.BugMetric;
import com.example.demo.domain.user.UserProfile;

public class AppQualityMetric extends MainMetric {

    private AppMetric appMetric;

    public AppQualityMetric(UserProfile metricOwner){
        this.metricOwner = metricOwner;
        metricOwner.setAppQualityMetric(this);
        this.metricMainType = MainMetricType.APP_QUALITY;
    }

    @Override
    public double getWeight() {
        return metricOwner.getWeight().getAppQualityWeight();
    }
}
