package com.flare.rap.common.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Aspect
@Configuration
@EnableAspectJAutoProxy
public class TransactionConfig {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice() {

        TransactionInterceptor txAdvice = new TransactionInterceptor();
        Properties txAttributes = new Properties();

        List<RollbackRuleAttribute> rollbackRules = new ArrayList<RollbackRuleAttribute>();
        rollbackRules.add(new RollbackRuleAttribute(Exception.class));

        DefaultTransactionAttribute readOnlyAttribute = new DefaultTransactionAttribute(
                TransactionDefinition.ISOLATION_READ_COMMITTED
        );
        readOnlyAttribute.setReadOnly(true);
        readOnlyAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        RuleBasedTransactionAttribute writeAttribute = new RuleBasedTransactionAttribute(
                TransactionDefinition.ISOLATION_READ_COMMITTED, rollbackRules
        );
        writeAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        String readOnlyTransactionAttributesDefinition = readOnlyAttribute.toString();
        String writeTransactionAttributesDefinition = writeAttribute.toString();

        txAttributes.setProperty("retrieve*", readOnlyTransactionAttributesDefinition);
        txAttributes.setProperty("save*", writeTransactionAttributesDefinition);
        txAttributes.setProperty("insert*", writeTransactionAttributesDefinition);
        txAttributes.setProperty("update*", writeTransactionAttributesDefinition);
        txAttributes.setProperty("delete*", writeTransactionAttributesDefinition);
        txAttributes.setProperty("process*", writeTransactionAttributesDefinition);

        txAdvice.setTransactionAttributes(txAttributes);
        txAdvice.setTransactionManager(transactionManager);

        return txAdvice;
    }

    @Bean
    public DefaultPointcutAdvisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* *..*ServiceImpl.*(..))");

        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}
