package com.github.hqh.mgm.common.transaction;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @Description:
 * @author huqinghua
 */
public class TransactionHelper {
	static public void processAroundTransaction(PlatformTransactionManager transactionManager, Procedure procedure) {
		
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
        	procedure.process();
            transactionManager.commit(status);
        } catch (Throwable throwable) {
        	transactionManager.rollback(status);
            throw throwable;
        }
	}
}
