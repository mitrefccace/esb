package org.mitre.fcc.broker;

import java.util.ArrayList;

import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;

public class SplitAggregationStrategy implements AggregationStrategy {
	private static SplitAggregationStrategy instance = null;

	public static SplitAggregationStrategy getInstance () {
		if(instance == null) {
			instance = new SplitAggregationStrategy();
		}
		return instance;
	}

	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		// Assume the new body is a list
		ArrayList<Object> newList = newExchange.getIn().getBody(ArrayList.class);
		ArrayList<Object> list = null;
		if (oldExchange == null) {
			list = new ArrayList<Object>();
			for (Object result: newList) {
				list.add(result);
			}
			newExchange.getIn().setBody(list);
			return newExchange;
		} else {
			list = oldExchange.getIn().getBody(ArrayList.class);
			for (Object result: newList) {
				list.add(result);
			}
			return oldExchange;
		}
	}

}