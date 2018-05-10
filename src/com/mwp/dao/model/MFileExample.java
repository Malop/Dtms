package com.mwp.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MFileExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public MFileExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andMfileidIsNull() {
            addCriterion("mfileid is null");
            return (Criteria) this;
        }

        public Criteria andMfileidIsNotNull() {
            addCriterion("mfileid is not null");
            return (Criteria) this;
        }

        public Criteria andMfileidEqualTo(String value) {
            addCriterion("mfileid =", value, "mfileid");
            return (Criteria) this;
        }

        public Criteria andMfileidNotEqualTo(String value) {
            addCriterion("mfileid <>", value, "mfileid");
            return (Criteria) this;
        }

        public Criteria andMfileidGreaterThan(String value) {
            addCriterion("mfileid >", value, "mfileid");
            return (Criteria) this;
        }

        public Criteria andMfileidGreaterThanOrEqualTo(String value) {
            addCriterion("mfileid >=", value, "mfileid");
            return (Criteria) this;
        }

        public Criteria andMfileidLessThan(String value) {
            addCriterion("mfileid <", value, "mfileid");
            return (Criteria) this;
        }

        public Criteria andMfileidLessThanOrEqualTo(String value) {
            addCriterion("mfileid <=", value, "mfileid");
            return (Criteria) this;
        }

        public Criteria andMfileidLike(String value) {
            addCriterion("mfileid like", value, "mfileid");
            return (Criteria) this;
        }

        public Criteria andMfileidNotLike(String value) {
            addCriterion("mfileid not like", value, "mfileid");
            return (Criteria) this;
        }

        public Criteria andMfileidIn(List<String> values) {
            addCriterion("mfileid in", values, "mfileid");
            return (Criteria) this;
        }

        public Criteria andMfileidNotIn(List<String> values) {
            addCriterion("mfileid not in", values, "mfileid");
            return (Criteria) this;
        }

        public Criteria andMfileidBetween(String value1, String value2) {
            addCriterion("mfileid between", value1, value2, "mfileid");
            return (Criteria) this;
        }

        public Criteria andMfileidNotBetween(String value1, String value2) {
            addCriterion("mfileid not between", value1, value2, "mfileid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andMfiletypeIsNull() {
            addCriterion("mfiletype is null");
            return (Criteria) this;
        }

        public Criteria andMfiletypeIsNotNull() {
            addCriterion("mfiletype is not null");
            return (Criteria) this;
        }

        public Criteria andMfiletypeEqualTo(String value) {
            addCriterion("mfiletype =", value, "mfiletype");
            return (Criteria) this;
        }

        public Criteria andMfiletypeNotEqualTo(String value) {
            addCriterion("mfiletype <>", value, "mfiletype");
            return (Criteria) this;
        }

        public Criteria andMfiletypeGreaterThan(String value) {
            addCriterion("mfiletype >", value, "mfiletype");
            return (Criteria) this;
        }

        public Criteria andMfiletypeGreaterThanOrEqualTo(String value) {
            addCriterion("mfiletype >=", value, "mfiletype");
            return (Criteria) this;
        }

        public Criteria andMfiletypeLessThan(String value) {
            addCriterion("mfiletype <", value, "mfiletype");
            return (Criteria) this;
        }

        public Criteria andMfiletypeLessThanOrEqualTo(String value) {
            addCriterion("mfiletype <=", value, "mfiletype");
            return (Criteria) this;
        }

        public Criteria andMfiletypeLike(String value) {
            addCriterion("mfiletype like", value, "mfiletype");
            return (Criteria) this;
        }

        public Criteria andMfiletypeNotLike(String value) {
            addCriterion("mfiletype not like", value, "mfiletype");
            return (Criteria) this;
        }

        public Criteria andMfiletypeIn(List<String> values) {
            addCriterion("mfiletype in", values, "mfiletype");
            return (Criteria) this;
        }

        public Criteria andMfiletypeNotIn(List<String> values) {
            addCriterion("mfiletype not in", values, "mfiletype");
            return (Criteria) this;
        }

        public Criteria andMfiletypeBetween(String value1, String value2) {
            addCriterion("mfiletype between", value1, value2, "mfiletype");
            return (Criteria) this;
        }

        public Criteria andMfiletypeNotBetween(String value1, String value2) {
            addCriterion("mfiletype not between", value1, value2, "mfiletype");
            return (Criteria) this;
        }

        public Criteria andMfileurlIsNull() {
            addCriterion("mfileurl is null");
            return (Criteria) this;
        }

        public Criteria andMfileurlIsNotNull() {
            addCriterion("mfileurl is not null");
            return (Criteria) this;
        }

        public Criteria andMfileurlEqualTo(String value) {
            addCriterion("mfileurl =", value, "mfileurl");
            return (Criteria) this;
        }

        public Criteria andMfileurlNotEqualTo(String value) {
            addCriterion("mfileurl <>", value, "mfileurl");
            return (Criteria) this;
        }

        public Criteria andMfileurlGreaterThan(String value) {
            addCriterion("mfileurl >", value, "mfileurl");
            return (Criteria) this;
        }

        public Criteria andMfileurlGreaterThanOrEqualTo(String value) {
            addCriterion("mfileurl >=", value, "mfileurl");
            return (Criteria) this;
        }

        public Criteria andMfileurlLessThan(String value) {
            addCriterion("mfileurl <", value, "mfileurl");
            return (Criteria) this;
        }

        public Criteria andMfileurlLessThanOrEqualTo(String value) {
            addCriterion("mfileurl <=", value, "mfileurl");
            return (Criteria) this;
        }

        public Criteria andMfileurlLike(String value) {
            addCriterion("mfileurl like", value, "mfileurl");
            return (Criteria) this;
        }

        public Criteria andMfileurlNotLike(String value) {
            addCriterion("mfileurl not like", value, "mfileurl");
            return (Criteria) this;
        }

        public Criteria andMfileurlIn(List<String> values) {
            addCriterion("mfileurl in", values, "mfileurl");
            return (Criteria) this;
        }

        public Criteria andMfileurlNotIn(List<String> values) {
            addCriterion("mfileurl not in", values, "mfileurl");
            return (Criteria) this;
        }

        public Criteria andMfileurlBetween(String value1, String value2) {
            addCriterion("mfileurl between", value1, value2, "mfileurl");
            return (Criteria) this;
        }

        public Criteria andMfileurlNotBetween(String value1, String value2) {
            addCriterion("mfileurl not between", value1, value2, "mfileurl");
            return (Criteria) this;
        }

        public Criteria andCttimeIsNull() {
            addCriterion("cttime is null");
            return (Criteria) this;
        }

        public Criteria andCttimeIsNotNull() {
            addCriterion("cttime is not null");
            return (Criteria) this;
        }

        public Criteria andCttimeEqualTo(Date value) {
            addCriterion("cttime =", value, "cttime");
            return (Criteria) this;
        }

        public Criteria andCttimeNotEqualTo(Date value) {
            addCriterion("cttime <>", value, "cttime");
            return (Criteria) this;
        }

        public Criteria andCttimeGreaterThan(Date value) {
            addCriterion("cttime >", value, "cttime");
            return (Criteria) this;
        }

        public Criteria andCttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cttime >=", value, "cttime");
            return (Criteria) this;
        }

        public Criteria andCttimeLessThan(Date value) {
            addCriterion("cttime <", value, "cttime");
            return (Criteria) this;
        }

        public Criteria andCttimeLessThanOrEqualTo(Date value) {
            addCriterion("cttime <=", value, "cttime");
            return (Criteria) this;
        }

        public Criteria andCttimeIn(List<Date> values) {
            addCriterion("cttime in", values, "cttime");
            return (Criteria) this;
        }

        public Criteria andCttimeNotIn(List<Date> values) {
            addCriterion("cttime not in", values, "cttime");
            return (Criteria) this;
        }

        public Criteria andCttimeBetween(Date value1, Date value2) {
            addCriterion("cttime between", value1, value2, "cttime");
            return (Criteria) this;
        }

        public Criteria andCttimeNotBetween(Date value1, Date value2) {
            addCriterion("cttime not between", value1, value2, "cttime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}