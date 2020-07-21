package org.example.context;


import org.example.enums.OperationEnum;
import org.example.service.OperationService;

public interface OperationStrategyContextFactory {
    OperationService get(OperationEnum e);
    OperationService get(String operation);
}
