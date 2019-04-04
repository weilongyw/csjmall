package com.csj.framework.utils;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class ElParser {

    private static ExpressionParser expressionParser = new SpelExpressionParser();


    public static String getKey(String key, String[] paramNames, Object[] args) {
        Expression expression = expressionParser.parseExpression(key);
        StandardEvaluationContext context = new StandardEvaluationContext();
        if (args.length <= 0) {
            return null;
        }
        for (int i = 0; i < args.length; i++) {
            context.setVariable(paramNames[i], args[i]);
        }
        return expression.getValue(context, String.class);

    }

}
