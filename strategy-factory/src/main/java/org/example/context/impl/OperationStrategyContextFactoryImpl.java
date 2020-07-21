package org.example.context.impl;

import org.example.context.OperationStrategyContextFactory;
import org.example.enums.OperationEnum;
import org.example.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class OperationStrategyContextFactoryImpl implements OperationStrategyContextFactory {

    @Autowired
    private Map<String, OperationService> operationServices = new HashMap<>();

    @Override
    public OperationService get(OperationEnum e) {
        return operationServices.get(e.operationServiceName);
    }

    @Override
    public OperationService get(String operation) {
        return operationServices.get(OperationEnum.get(operation).operationServiceName);
    }
}
