package org.example.service.impl;

import org.example.service.OperationService;
import org.springframework.stereotype.Service;

@Service("addOperationService")
public class AddOperationServiceImpl implements OperationService {
    @Override
    public Double operate(Double a, Double b) {
        return a+b;
    }
}
