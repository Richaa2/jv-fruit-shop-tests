package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperationStrategyImplTest {
    private OperationStrategy operationStrategy;
    private Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap;

    @BeforeEach
    void setUp() {
        operationOperationHandlerMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceStrategyOperationImpl(),
                FruitTransaction.Operation.SUPPLY, new SupplyStrategyOperationImpl(),
                FruitTransaction.Operation.PURCHASE, new PurchaseStrategyOperationImpl(),
                FruitTransaction.Operation.RETURN, new ReturnStrategyOperationImpl()
        );
        operationStrategy = new OperationStrategyImpl(operationOperationHandlerMap);
    }

    @Test
    void get_purchase_Ok() {
        OperationHandler expected
                = operationOperationHandlerMap.get(FruitTransaction.Operation.PURCHASE);
        OperationHandler actual = operationStrategy.get(FruitTransaction.Operation.PURCHASE);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void get_supply_Ok() {
        OperationHandler expected
                = operationOperationHandlerMap.get(FruitTransaction.Operation.SUPPLY);
        OperationHandler actual = operationStrategy.get(FruitTransaction.Operation.SUPPLY);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void get_return_Ok() {
        OperationHandler expected
                = operationOperationHandlerMap.get(FruitTransaction.Operation.RETURN);
        OperationHandler actual = operationStrategy.get(FruitTransaction.Operation.RETURN);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void get_balance_Ok() {
        OperationHandler expected
                = operationOperationHandlerMap.get(FruitTransaction.Operation.BALANCE);
        OperationHandler actual = operationStrategy.get(FruitTransaction.Operation.BALANCE);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void get_null_notOk() {
        Assertions.assertThrows(RuntimeException.class, () -> operationStrategy.get(null));
    }
}
