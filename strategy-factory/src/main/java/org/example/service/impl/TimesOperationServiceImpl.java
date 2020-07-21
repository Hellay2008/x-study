package org.example.service.impl;

import org.example.service.OperationService;
import org.springframework.stereotype.Service;

@Service("timesOperationService")
public class TimesOperationServiceImpl implements OperationService {
    @Override
    public Double operate(Double a, Double b) {
        return a * b;
    }
}
