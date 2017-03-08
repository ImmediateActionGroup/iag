package com.iag.util.db;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author weixueshan
 *
 */
public class Conditions {
	
	private List<OrderBy> orderByList = new ArrayList<OrderBy>();
	
	//add order by
	public void addOrderBy(String key, boolean isAsc){
		if(key == null || key.trim().length() == 0){
			return ;
		}
		orderByList.add(new OrderBy(key, isAsc));
	}
	
	public String createOrderByString(){
		if(orderByList.size() == 0){
			return "";
		}
		StringBuilder re = new StringBuilder(" order by ");
		for(OrderBy orderBy : orderByList){
			re.append(orderBy.getKey()).append(orderBy.isAsc ? " asc " : " desc ").append(" , ");
		}
		return re.substring(0, re.length() - 3);
	}
	class OrderBy{
		private String key;//key
		private boolean isAsc; //asc or desc
		
		public OrderBy(){
			
		}
		public OrderBy(String key, boolean isAsc){
			super();
			this.key = key;
			this.isAsc = isAsc;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public boolean isAsc() {
			return isAsc;
		}
		public void setAsc(boolean isAsc) {
			this.isAsc = isAsc;
		}
		
	}
	
	class Condition{
		private String key;//key
		private Object value;//value
		private Operator operator;
		
		public Condition(){
			
		}
		
		public Condition(String key, Object value, Operator operator){
			super();
			this.key = key;
			this.value = value;
			this.operator = operator;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public Object getValue() {
			return value;
		}

		public void setValue(Object value) {
			this.value = value;
		}

		public Operator getOperator() {
			return operator;
		}

		public void setOperator(Operator operator) {
			this.operator = operator;
		}
	}
	
	//enum
	public enum Operator{
		EQUAL, LIKE, NOT_EQUAL, GREATER, GREATER_EQUAL, LESS, LESS_EQUAL, IS, NOT_IS
	}
	

	public class WhereAndValues{
		private String where = "";
		private Object[] values;
		
		public Object[] getValues(){
			return values;
		}

		public String getWhere() {
			return where;
		}

		public void setWhere(String where) {
			this.where = where;
		}

		public void setValues(Object[] values) {
			this.values = values;
		}
	}
	
	private List<Condition> conditions = new ArrayList<Condition>();
	
	public void addCondition(String key, Object value, Operator operator){
		
		if(key == null || key.trim().length() == 0){
			return ;
		}
		if(value == null){
			if(operator != Operator.IS && operator != Operator.NOT_IS){
				return;
			}
		}
		
		if(value != null && value instanceof String){
			String v = (String) value;
			if(v.trim().length() == 0){
				return ;
			}
		}
		
		if(operator == null){
			return ;
		}
		conditions.add(new Condition(key, value, operator));
	}
	
	public WhereAndValues createWhereAndValues(){

		WhereAndValues wv = new WhereAndValues();
		StringBuilder where = new StringBuilder(" where ");
		List<Object> values = new ArrayList<Object>();
		
		for(Condition condition : conditions){
			Operator operator = condition.getOperator();
			String key = condition.getKey();
			Object value = condition.getValue();
			
			switch(operator){
			case LIKE:
				where.append(key).append(" like ").append(" ? ");
				values.add("%" + value + "%");
				break;
			case EQUAL:
				where.append(key).append(" = ").append(" ? ");
				values.add(value);
				break;
			case NOT_EQUAL:
				where.append(key).append(" != ").append(" ? ");
				values.add(value);
				break;
			case GREATER:
				where.append(key).append(" > ").append(" ? ");
				values.add(value);
				break;
			case GREATER_EQUAL:
				where.append(key).append(" >= ").append(" ? ");
				values.add(value);
				break;
			case LESS:
				where.append(key).append(" < ").append(" ? ");
				values.add(value);
				break;
			case LESS_EQUAL:
				where.append(key).append(" <= ").append(" ? ");
				values.add(value);
				break;
			case IS:
				where.append(key).append(" is ").append(" ? ");
				values.add(null);
				break;
			case NOT_IS:
				where.append(key).append(" not is ").append(" ? ");
				values.add(null);
				break;
			}
			where.append(" and ");
		}
		String whereString = where.substring(0, where.length() - 6);
		wv.setWhere(whereString);
		wv.setValues(values.toArray());
		return wv;
	}
}
