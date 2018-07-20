package com.mwp.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PartyMemberExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public PartyMemberExample() {
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

        public Criteria andCertidIsNull() {
            addCriterion("certid is null");
            return (Criteria) this;
        }

        public Criteria andCertidIsNotNull() {
            addCriterion("certid is not null");
            return (Criteria) this;
        }

        public Criteria andCertidEqualTo(String value) {
            addCriterion("certid =", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotEqualTo(String value) {
            addCriterion("certid <>", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidGreaterThan(String value) {
            addCriterion("certid >", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidGreaterThanOrEqualTo(String value) {
            addCriterion("certid >=", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLessThan(String value) {
            addCriterion("certid <", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLessThanOrEqualTo(String value) {
            addCriterion("certid <=", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidLike(String value) {
            addCriterion("certid like", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotLike(String value) {
            addCriterion("certid not like", value, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidIn(List<String> values) {
            addCriterion("certid in", values, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotIn(List<String> values) {
            addCriterion("certid not in", values, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidBetween(String value1, String value2) {
            addCriterion("certid between", value1, value2, "certid");
            return (Criteria) this;
        }

        public Criteria andCertidNotBetween(String value1, String value2) {
            addCriterion("certid not between", value1, value2, "certid");
            return (Criteria) this;
        }

        public Criteria andPartynameIsNull() {
            addCriterion("partyName is null");
            return (Criteria) this;
        }

        public Criteria andPartynameIsNotNull() {
            addCriterion("partyName is not null");
            return (Criteria) this;
        }

        public Criteria andPartynameEqualTo(String value) {
            addCriterion("partyName =", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameNotEqualTo(String value) {
            addCriterion("partyName <>", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameGreaterThan(String value) {
            addCriterion("partyName >", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameGreaterThanOrEqualTo(String value) {
            addCriterion("partyName >=", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameLessThan(String value) {
            addCriterion("partyName <", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameLessThanOrEqualTo(String value) {
            addCriterion("partyName <=", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameLike(String value) {
            addCriterion("partyName like", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameNotLike(String value) {
            addCriterion("partyName not like", value, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameIn(List<String> values) {
            addCriterion("partyName in", values, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameNotIn(List<String> values) {
            addCriterion("partyName not in", values, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameBetween(String value1, String value2) {
            addCriterion("partyName between", value1, value2, "partyname");
            return (Criteria) this;
        }

        public Criteria andPartynameNotBetween(String value1, String value2) {
            addCriterion("partyName not between", value1, value2, "partyname");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIsNull() {
            addCriterion("nativeplace is null");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIsNotNull() {
            addCriterion("nativeplace is not null");
            return (Criteria) this;
        }

        public Criteria andNativeplaceEqualTo(String value) {
            addCriterion("nativeplace =", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotEqualTo(String value) {
            addCriterion("nativeplace <>", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceGreaterThan(String value) {
            addCriterion("nativeplace >", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceGreaterThanOrEqualTo(String value) {
            addCriterion("nativeplace >=", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLessThan(String value) {
            addCriterion("nativeplace <", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLessThanOrEqualTo(String value) {
            addCriterion("nativeplace <=", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceLike(String value) {
            addCriterion("nativeplace like", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotLike(String value) {
            addCriterion("nativeplace not like", value, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceIn(List<String> values) {
            addCriterion("nativeplace in", values, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotIn(List<String> values) {
            addCriterion("nativeplace not in", values, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceBetween(String value1, String value2) {
            addCriterion("nativeplace between", value1, value2, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andNativeplaceNotBetween(String value1, String value2) {
            addCriterion("nativeplace not between", value1, value2, "nativeplace");
            return (Criteria) this;
        }

        public Criteria andIstaiwanIsNull() {
            addCriterion("isTaiwan is null");
            return (Criteria) this;
        }

        public Criteria andIstaiwanIsNotNull() {
            addCriterion("isTaiwan is not null");
            return (Criteria) this;
        }

        public Criteria andIstaiwanEqualTo(String value) {
            addCriterion("isTaiwan =", value, "istaiwan");
            return (Criteria) this;
        }

        public Criteria andIstaiwanNotEqualTo(String value) {
            addCriterion("isTaiwan <>", value, "istaiwan");
            return (Criteria) this;
        }

        public Criteria andIstaiwanGreaterThan(String value) {
            addCriterion("isTaiwan >", value, "istaiwan");
            return (Criteria) this;
        }

        public Criteria andIstaiwanGreaterThanOrEqualTo(String value) {
            addCriterion("isTaiwan >=", value, "istaiwan");
            return (Criteria) this;
        }

        public Criteria andIstaiwanLessThan(String value) {
            addCriterion("isTaiwan <", value, "istaiwan");
            return (Criteria) this;
        }

        public Criteria andIstaiwanLessThanOrEqualTo(String value) {
            addCriterion("isTaiwan <=", value, "istaiwan");
            return (Criteria) this;
        }

        public Criteria andIstaiwanLike(String value) {
            addCriterion("isTaiwan like", value, "istaiwan");
            return (Criteria) this;
        }

        public Criteria andIstaiwanNotLike(String value) {
            addCriterion("isTaiwan not like", value, "istaiwan");
            return (Criteria) this;
        }

        public Criteria andIstaiwanIn(List<String> values) {
            addCriterion("isTaiwan in", values, "istaiwan");
            return (Criteria) this;
        }

        public Criteria andIstaiwanNotIn(List<String> values) {
            addCriterion("isTaiwan not in", values, "istaiwan");
            return (Criteria) this;
        }

        public Criteria andIstaiwanBetween(String value1, String value2) {
            addCriterion("isTaiwan between", value1, value2, "istaiwan");
            return (Criteria) this;
        }

        public Criteria andIstaiwanNotBetween(String value1, String value2) {
            addCriterion("isTaiwan not between", value1, value2, "istaiwan");
            return (Criteria) this;
        }

        public Criteria andBrithdayIsNull() {
            addCriterion("brithday is null");
            return (Criteria) this;
        }

        public Criteria andBrithdayIsNotNull() {
            addCriterion("brithday is not null");
            return (Criteria) this;
        }

        public Criteria andBrithdayEqualTo(String value) {
            addCriterion("brithday =", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayNotEqualTo(String value) {
            addCriterion("brithday <>", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayGreaterThan(String value) {
            addCriterion("brithday >", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayGreaterThanOrEqualTo(String value) {
            addCriterion("brithday >=", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayLessThan(String value) {
            addCriterion("brithday <", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayLessThanOrEqualTo(String value) {
            addCriterion("brithday <=", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayLike(String value) {
            addCriterion("brithday like", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayNotLike(String value) {
            addCriterion("brithday not like", value, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayIn(List<String> values) {
            addCriterion("brithday in", values, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayNotIn(List<String> values) {
            addCriterion("brithday not in", values, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayBetween(String value1, String value2) {
            addCriterion("brithday between", value1, value2, "brithday");
            return (Criteria) this;
        }

        public Criteria andBrithdayNotBetween(String value1, String value2) {
            addCriterion("brithday not between", value1, value2, "brithday");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(String value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(String value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(String value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(String value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(String value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(String value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLike(String value) {
            addCriterion("age like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotLike(String value) {
            addCriterion("age not like", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<String> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<String> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(String value1, String value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(String value1, String value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andPartygroupIsNull() {
            addCriterion("partygroup is null");
            return (Criteria) this;
        }

        public Criteria andPartygroupIsNotNull() {
            addCriterion("partygroup is not null");
            return (Criteria) this;
        }

        public Criteria andPartygroupEqualTo(String value) {
            addCriterion("partygroup =", value, "partygroup");
            return (Criteria) this;
        }

        public Criteria andPartygroupNotEqualTo(String value) {
            addCriterion("partygroup <>", value, "partygroup");
            return (Criteria) this;
        }

        public Criteria andPartygroupGreaterThan(String value) {
            addCriterion("partygroup >", value, "partygroup");
            return (Criteria) this;
        }

        public Criteria andPartygroupGreaterThanOrEqualTo(String value) {
            addCriterion("partygroup >=", value, "partygroup");
            return (Criteria) this;
        }

        public Criteria andPartygroupLessThan(String value) {
            addCriterion("partygroup <", value, "partygroup");
            return (Criteria) this;
        }

        public Criteria andPartygroupLessThanOrEqualTo(String value) {
            addCriterion("partygroup <=", value, "partygroup");
            return (Criteria) this;
        }

        public Criteria andPartygroupLike(String value) {
            addCriterion("partygroup like", value, "partygroup");
            return (Criteria) this;
        }

        public Criteria andPartygroupNotLike(String value) {
            addCriterion("partygroup not like", value, "partygroup");
            return (Criteria) this;
        }

        public Criteria andPartygroupIn(List<String> values) {
            addCriterion("partygroup in", values, "partygroup");
            return (Criteria) this;
        }

        public Criteria andPartygroupNotIn(List<String> values) {
            addCriterion("partygroup not in", values, "partygroup");
            return (Criteria) this;
        }

        public Criteria andPartygroupBetween(String value1, String value2) {
            addCriterion("partygroup between", value1, value2, "partygroup");
            return (Criteria) this;
        }

        public Criteria andPartygroupNotBetween(String value1, String value2) {
            addCriterion("partygroup not between", value1, value2, "partygroup");
            return (Criteria) this;
        }

        public Criteria andPartytimeIsNull() {
            addCriterion("partytime is null");
            return (Criteria) this;
        }

        public Criteria andPartytimeIsNotNull() {
            addCriterion("partytime is not null");
            return (Criteria) this;
        }

        public Criteria andPartytimeEqualTo(String value) {
            addCriterion("partytime =", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeNotEqualTo(String value) {
            addCriterion("partytime <>", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeGreaterThan(String value) {
            addCriterion("partytime >", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeGreaterThanOrEqualTo(String value) {
            addCriterion("partytime >=", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeLessThan(String value) {
            addCriterion("partytime <", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeLessThanOrEqualTo(String value) {
            addCriterion("partytime <=", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeLike(String value) {
            addCriterion("partytime like", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeNotLike(String value) {
            addCriterion("partytime not like", value, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeIn(List<String> values) {
            addCriterion("partytime in", values, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeNotIn(List<String> values) {
            addCriterion("partytime not in", values, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeBetween(String value1, String value2) {
            addCriterion("partytime between", value1, value2, "partytime");
            return (Criteria) this;
        }

        public Criteria andPartytimeNotBetween(String value1, String value2) {
            addCriterion("partytime not between", value1, value2, "partytime");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeIsNull() {
            addCriterion("fullpartytime is null");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeIsNotNull() {
            addCriterion("fullpartytime is not null");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeEqualTo(String value) {
            addCriterion("fullpartytime =", value, "fullpartytime");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeNotEqualTo(String value) {
            addCriterion("fullpartytime <>", value, "fullpartytime");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeGreaterThan(String value) {
            addCriterion("fullpartytime >", value, "fullpartytime");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeGreaterThanOrEqualTo(String value) {
            addCriterion("fullpartytime >=", value, "fullpartytime");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeLessThan(String value) {
            addCriterion("fullpartytime <", value, "fullpartytime");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeLessThanOrEqualTo(String value) {
            addCriterion("fullpartytime <=", value, "fullpartytime");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeLike(String value) {
            addCriterion("fullpartytime like", value, "fullpartytime");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeNotLike(String value) {
            addCriterion("fullpartytime not like", value, "fullpartytime");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeIn(List<String> values) {
            addCriterion("fullpartytime in", values, "fullpartytime");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeNotIn(List<String> values) {
            addCriterion("fullpartytime not in", values, "fullpartytime");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeBetween(String value1, String value2) {
            addCriterion("fullpartytime between", value1, value2, "fullpartytime");
            return (Criteria) this;
        }

        public Criteria andFullpartytimeNotBetween(String value1, String value2) {
            addCriterion("fullpartytime not between", value1, value2, "fullpartytime");
            return (Criteria) this;
        }

        public Criteria andJobIsNull() {
            addCriterion("job is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("job is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("job =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("job <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("job >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("job >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("job <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("job <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("job like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("job not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("job in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("job not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("job between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("job not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andTimetoworkIsNull() {
            addCriterion("timetowork is null");
            return (Criteria) this;
        }

        public Criteria andTimetoworkIsNotNull() {
            addCriterion("timetowork is not null");
            return (Criteria) this;
        }

        public Criteria andTimetoworkEqualTo(String value) {
            addCriterion("timetowork =", value, "timetowork");
            return (Criteria) this;
        }

        public Criteria andTimetoworkNotEqualTo(String value) {
            addCriterion("timetowork <>", value, "timetowork");
            return (Criteria) this;
        }

        public Criteria andTimetoworkGreaterThan(String value) {
            addCriterion("timetowork >", value, "timetowork");
            return (Criteria) this;
        }

        public Criteria andTimetoworkGreaterThanOrEqualTo(String value) {
            addCriterion("timetowork >=", value, "timetowork");
            return (Criteria) this;
        }

        public Criteria andTimetoworkLessThan(String value) {
            addCriterion("timetowork <", value, "timetowork");
            return (Criteria) this;
        }

        public Criteria andTimetoworkLessThanOrEqualTo(String value) {
            addCriterion("timetowork <=", value, "timetowork");
            return (Criteria) this;
        }

        public Criteria andTimetoworkLike(String value) {
            addCriterion("timetowork like", value, "timetowork");
            return (Criteria) this;
        }

        public Criteria andTimetoworkNotLike(String value) {
            addCriterion("timetowork not like", value, "timetowork");
            return (Criteria) this;
        }

        public Criteria andTimetoworkIn(List<String> values) {
            addCriterion("timetowork in", values, "timetowork");
            return (Criteria) this;
        }

        public Criteria andTimetoworkNotIn(List<String> values) {
            addCriterion("timetowork not in", values, "timetowork");
            return (Criteria) this;
        }

        public Criteria andTimetoworkBetween(String value1, String value2) {
            addCriterion("timetowork between", value1, value2, "timetowork");
            return (Criteria) this;
        }

        public Criteria andTimetoworkNotBetween(String value1, String value2) {
            addCriterion("timetowork not between", value1, value2, "timetowork");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIsNull() {
            addCriterion("mobilephone is null");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIsNotNull() {
            addCriterion("mobilephone is not null");
            return (Criteria) this;
        }

        public Criteria andMobilephoneEqualTo(String value) {
            addCriterion("mobilephone =", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotEqualTo(String value) {
            addCriterion("mobilephone <>", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneGreaterThan(String value) {
            addCriterion("mobilephone >", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneGreaterThanOrEqualTo(String value) {
            addCriterion("mobilephone >=", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLessThan(String value) {
            addCriterion("mobilephone <", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLessThanOrEqualTo(String value) {
            addCriterion("mobilephone <=", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneLike(String value) {
            addCriterion("mobilephone like", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotLike(String value) {
            addCriterion("mobilephone not like", value, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneIn(List<String> values) {
            addCriterion("mobilephone in", values, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotIn(List<String> values) {
            addCriterion("mobilephone not in", values, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneBetween(String value1, String value2) {
            addCriterion("mobilephone between", value1, value2, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andMobilephoneNotBetween(String value1, String value2) {
            addCriterion("mobilephone not between", value1, value2, "mobilephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("telephone is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("telephone is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("telephone =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("telephone <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("telephone >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("telephone >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("telephone <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("telephone <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("telephone like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("telephone not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("telephone in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("telephone not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("telephone between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("telephone not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNull() {
            addCriterion("marriage is null");
            return (Criteria) this;
        }

        public Criteria andMarriageIsNotNull() {
            addCriterion("marriage is not null");
            return (Criteria) this;
        }

        public Criteria andMarriageEqualTo(String value) {
            addCriterion("marriage =", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotEqualTo(String value) {
            addCriterion("marriage <>", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThan(String value) {
            addCriterion("marriage >", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageGreaterThanOrEqualTo(String value) {
            addCriterion("marriage >=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThan(String value) {
            addCriterion("marriage <", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLessThanOrEqualTo(String value) {
            addCriterion("marriage <=", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageLike(String value) {
            addCriterion("marriage like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotLike(String value) {
            addCriterion("marriage not like", value, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageIn(List<String> values) {
            addCriterion("marriage in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotIn(List<String> values) {
            addCriterion("marriage not in", values, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageBetween(String value1, String value2) {
            addCriterion("marriage between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andMarriageNotBetween(String value1, String value2) {
            addCriterion("marriage not between", value1, value2, "marriage");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceIsNull() {
            addCriterion("archiveplace is null");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceIsNotNull() {
            addCriterion("archiveplace is not null");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceEqualTo(String value) {
            addCriterion("archiveplace =", value, "archiveplace");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceNotEqualTo(String value) {
            addCriterion("archiveplace <>", value, "archiveplace");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceGreaterThan(String value) {
            addCriterion("archiveplace >", value, "archiveplace");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceGreaterThanOrEqualTo(String value) {
            addCriterion("archiveplace >=", value, "archiveplace");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceLessThan(String value) {
            addCriterion("archiveplace <", value, "archiveplace");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceLessThanOrEqualTo(String value) {
            addCriterion("archiveplace <=", value, "archiveplace");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceLike(String value) {
            addCriterion("archiveplace like", value, "archiveplace");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceNotLike(String value) {
            addCriterion("archiveplace not like", value, "archiveplace");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceIn(List<String> values) {
            addCriterion("archiveplace in", values, "archiveplace");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceNotIn(List<String> values) {
            addCriterion("archiveplace not in", values, "archiveplace");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceBetween(String value1, String value2) {
            addCriterion("archiveplace between", value1, value2, "archiveplace");
            return (Criteria) this;
        }

        public Criteria andArchiveplaceNotBetween(String value1, String value2) {
            addCriterion("archiveplace not between", value1, value2, "archiveplace");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleIsNull() {
            addCriterion("technicaltitle is null");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleIsNotNull() {
            addCriterion("technicaltitle is not null");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleEqualTo(String value) {
            addCriterion("technicaltitle =", value, "technicaltitle");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleNotEqualTo(String value) {
            addCriterion("technicaltitle <>", value, "technicaltitle");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleGreaterThan(String value) {
            addCriterion("technicaltitle >", value, "technicaltitle");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleGreaterThanOrEqualTo(String value) {
            addCriterion("technicaltitle >=", value, "technicaltitle");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleLessThan(String value) {
            addCriterion("technicaltitle <", value, "technicaltitle");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleLessThanOrEqualTo(String value) {
            addCriterion("technicaltitle <=", value, "technicaltitle");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleLike(String value) {
            addCriterion("technicaltitle like", value, "technicaltitle");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleNotLike(String value) {
            addCriterion("technicaltitle not like", value, "technicaltitle");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleIn(List<String> values) {
            addCriterion("technicaltitle in", values, "technicaltitle");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleNotIn(List<String> values) {
            addCriterion("technicaltitle not in", values, "technicaltitle");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleBetween(String value1, String value2) {
            addCriterion("technicaltitle between", value1, value2, "technicaltitle");
            return (Criteria) this;
        }

        public Criteria andTechnicaltitleNotBetween(String value1, String value2) {
            addCriterion("technicaltitle not between", value1, value2, "technicaltitle");
            return (Criteria) this;
        }

        public Criteria andSociallevelIsNull() {
            addCriterion("sociallevel is null");
            return (Criteria) this;
        }

        public Criteria andSociallevelIsNotNull() {
            addCriterion("sociallevel is not null");
            return (Criteria) this;
        }

        public Criteria andSociallevelEqualTo(String value) {
            addCriterion("sociallevel =", value, "sociallevel");
            return (Criteria) this;
        }

        public Criteria andSociallevelNotEqualTo(String value) {
            addCriterion("sociallevel <>", value, "sociallevel");
            return (Criteria) this;
        }

        public Criteria andSociallevelGreaterThan(String value) {
            addCriterion("sociallevel >", value, "sociallevel");
            return (Criteria) this;
        }

        public Criteria andSociallevelGreaterThanOrEqualTo(String value) {
            addCriterion("sociallevel >=", value, "sociallevel");
            return (Criteria) this;
        }

        public Criteria andSociallevelLessThan(String value) {
            addCriterion("sociallevel <", value, "sociallevel");
            return (Criteria) this;
        }

        public Criteria andSociallevelLessThanOrEqualTo(String value) {
            addCriterion("sociallevel <=", value, "sociallevel");
            return (Criteria) this;
        }

        public Criteria andSociallevelLike(String value) {
            addCriterion("sociallevel like", value, "sociallevel");
            return (Criteria) this;
        }

        public Criteria andSociallevelNotLike(String value) {
            addCriterion("sociallevel not like", value, "sociallevel");
            return (Criteria) this;
        }

        public Criteria andSociallevelIn(List<String> values) {
            addCriterion("sociallevel in", values, "sociallevel");
            return (Criteria) this;
        }

        public Criteria andSociallevelNotIn(List<String> values) {
            addCriterion("sociallevel not in", values, "sociallevel");
            return (Criteria) this;
        }

        public Criteria andSociallevelBetween(String value1, String value2) {
            addCriterion("sociallevel between", value1, value2, "sociallevel");
            return (Criteria) this;
        }

        public Criteria andSociallevelNotBetween(String value1, String value2) {
            addCriterion("sociallevel not between", value1, value2, "sociallevel");
            return (Criteria) this;
        }

        public Criteria andSituationIsNull() {
            addCriterion("situation is null");
            return (Criteria) this;
        }

        public Criteria andSituationIsNotNull() {
            addCriterion("situation is not null");
            return (Criteria) this;
        }

        public Criteria andSituationEqualTo(String value) {
            addCriterion("situation =", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotEqualTo(String value) {
            addCriterion("situation <>", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationGreaterThan(String value) {
            addCriterion("situation >", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationGreaterThanOrEqualTo(String value) {
            addCriterion("situation >=", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationLessThan(String value) {
            addCriterion("situation <", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationLessThanOrEqualTo(String value) {
            addCriterion("situation <=", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationLike(String value) {
            addCriterion("situation like", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotLike(String value) {
            addCriterion("situation not like", value, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationIn(List<String> values) {
            addCriterion("situation in", values, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotIn(List<String> values) {
            addCriterion("situation not in", values, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationBetween(String value1, String value2) {
            addCriterion("situation between", value1, value2, "situation");
            return (Criteria) this;
        }

        public Criteria andSituationNotBetween(String value1, String value2) {
            addCriterion("situation not between", value1, value2, "situation");
            return (Criteria) this;
        }

        public Criteria andTrainingIsNull() {
            addCriterion("training is null");
            return (Criteria) this;
        }

        public Criteria andTrainingIsNotNull() {
            addCriterion("training is not null");
            return (Criteria) this;
        }

        public Criteria andTrainingEqualTo(String value) {
            addCriterion("training =", value, "training");
            return (Criteria) this;
        }

        public Criteria andTrainingNotEqualTo(String value) {
            addCriterion("training <>", value, "training");
            return (Criteria) this;
        }

        public Criteria andTrainingGreaterThan(String value) {
            addCriterion("training >", value, "training");
            return (Criteria) this;
        }

        public Criteria andTrainingGreaterThanOrEqualTo(String value) {
            addCriterion("training >=", value, "training");
            return (Criteria) this;
        }

        public Criteria andTrainingLessThan(String value) {
            addCriterion("training <", value, "training");
            return (Criteria) this;
        }

        public Criteria andTrainingLessThanOrEqualTo(String value) {
            addCriterion("training <=", value, "training");
            return (Criteria) this;
        }

        public Criteria andTrainingLike(String value) {
            addCriterion("training like", value, "training");
            return (Criteria) this;
        }

        public Criteria andTrainingNotLike(String value) {
            addCriterion("training not like", value, "training");
            return (Criteria) this;
        }

        public Criteria andTrainingIn(List<String> values) {
            addCriterion("training in", values, "training");
            return (Criteria) this;
        }

        public Criteria andTrainingNotIn(List<String> values) {
            addCriterion("training not in", values, "training");
            return (Criteria) this;
        }

        public Criteria andTrainingBetween(String value1, String value2) {
            addCriterion("training between", value1, value2, "training");
            return (Criteria) this;
        }

        public Criteria andTrainingNotBetween(String value1, String value2) {
            addCriterion("training not between", value1, value2, "training");
            return (Criteria) this;
        }

        public Criteria andIsworkerIsNull() {
            addCriterion("isworker is null");
            return (Criteria) this;
        }

        public Criteria andIsworkerIsNotNull() {
            addCriterion("isworker is not null");
            return (Criteria) this;
        }

        public Criteria andIsworkerEqualTo(String value) {
            addCriterion("isworker =", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerNotEqualTo(String value) {
            addCriterion("isworker <>", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerGreaterThan(String value) {
            addCriterion("isworker >", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerGreaterThanOrEqualTo(String value) {
            addCriterion("isworker >=", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerLessThan(String value) {
            addCriterion("isworker <", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerLessThanOrEqualTo(String value) {
            addCriterion("isworker <=", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerLike(String value) {
            addCriterion("isworker like", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerNotLike(String value) {
            addCriterion("isworker not like", value, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerIn(List<String> values) {
            addCriterion("isworker in", values, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerNotIn(List<String> values) {
            addCriterion("isworker not in", values, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerBetween(String value1, String value2) {
            addCriterion("isworker between", value1, value2, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsworkerNotBetween(String value1, String value2) {
            addCriterion("isworker not between", value1, value2, "isworker");
            return (Criteria) this;
        }

        public Criteria andIsofflineIsNull() {
            addCriterion("isoffline is null");
            return (Criteria) this;
        }

        public Criteria andIsofflineIsNotNull() {
            addCriterion("isoffline is not null");
            return (Criteria) this;
        }

        public Criteria andIsofflineEqualTo(String value) {
            addCriterion("isoffline =", value, "isoffline");
            return (Criteria) this;
        }

        public Criteria andIsofflineNotEqualTo(String value) {
            addCriterion("isoffline <>", value, "isoffline");
            return (Criteria) this;
        }

        public Criteria andIsofflineGreaterThan(String value) {
            addCriterion("isoffline >", value, "isoffline");
            return (Criteria) this;
        }

        public Criteria andIsofflineGreaterThanOrEqualTo(String value) {
            addCriterion("isoffline >=", value, "isoffline");
            return (Criteria) this;
        }

        public Criteria andIsofflineLessThan(String value) {
            addCriterion("isoffline <", value, "isoffline");
            return (Criteria) this;
        }

        public Criteria andIsofflineLessThanOrEqualTo(String value) {
            addCriterion("isoffline <=", value, "isoffline");
            return (Criteria) this;
        }

        public Criteria andIsofflineLike(String value) {
            addCriterion("isoffline like", value, "isoffline");
            return (Criteria) this;
        }

        public Criteria andIsofflineNotLike(String value) {
            addCriterion("isoffline not like", value, "isoffline");
            return (Criteria) this;
        }

        public Criteria andIsofflineIn(List<String> values) {
            addCriterion("isoffline in", values, "isoffline");
            return (Criteria) this;
        }

        public Criteria andIsofflineNotIn(List<String> values) {
            addCriterion("isoffline not in", values, "isoffline");
            return (Criteria) this;
        }

        public Criteria andIsofflineBetween(String value1, String value2) {
            addCriterion("isoffline between", value1, value2, "isoffline");
            return (Criteria) this;
        }

        public Criteria andIsofflineNotBetween(String value1, String value2) {
            addCriterion("isoffline not between", value1, value2, "isoffline");
            return (Criteria) this;
        }

        public Criteria andOffdateIsNull() {
            addCriterion("offdate is null");
            return (Criteria) this;
        }

        public Criteria andOffdateIsNotNull() {
            addCriterion("offdate is not null");
            return (Criteria) this;
        }

        public Criteria andOffdateEqualTo(String value) {
            addCriterion("offdate =", value, "offdate");
            return (Criteria) this;
        }

        public Criteria andOffdateNotEqualTo(String value) {
            addCriterion("offdate <>", value, "offdate");
            return (Criteria) this;
        }

        public Criteria andOffdateGreaterThan(String value) {
            addCriterion("offdate >", value, "offdate");
            return (Criteria) this;
        }

        public Criteria andOffdateGreaterThanOrEqualTo(String value) {
            addCriterion("offdate >=", value, "offdate");
            return (Criteria) this;
        }

        public Criteria andOffdateLessThan(String value) {
            addCriterion("offdate <", value, "offdate");
            return (Criteria) this;
        }

        public Criteria andOffdateLessThanOrEqualTo(String value) {
            addCriterion("offdate <=", value, "offdate");
            return (Criteria) this;
        }

        public Criteria andOffdateLike(String value) {
            addCriterion("offdate like", value, "offdate");
            return (Criteria) this;
        }

        public Criteria andOffdateNotLike(String value) {
            addCriterion("offdate not like", value, "offdate");
            return (Criteria) this;
        }

        public Criteria andOffdateIn(List<String> values) {
            addCriterion("offdate in", values, "offdate");
            return (Criteria) this;
        }

        public Criteria andOffdateNotIn(List<String> values) {
            addCriterion("offdate not in", values, "offdate");
            return (Criteria) this;
        }

        public Criteria andOffdateBetween(String value1, String value2) {
            addCriterion("offdate between", value1, value2, "offdate");
            return (Criteria) this;
        }

        public Criteria andOffdateNotBetween(String value1, String value2) {
            addCriterion("offdate not between", value1, value2, "offdate");
            return (Criteria) this;
        }

        public Criteria andIsfloatIsNull() {
            addCriterion("isfloat is null");
            return (Criteria) this;
        }

        public Criteria andIsfloatIsNotNull() {
            addCriterion("isfloat is not null");
            return (Criteria) this;
        }

        public Criteria andIsfloatEqualTo(String value) {
            addCriterion("isfloat =", value, "isfloat");
            return (Criteria) this;
        }

        public Criteria andIsfloatNotEqualTo(String value) {
            addCriterion("isfloat <>", value, "isfloat");
            return (Criteria) this;
        }

        public Criteria andIsfloatGreaterThan(String value) {
            addCriterion("isfloat >", value, "isfloat");
            return (Criteria) this;
        }

        public Criteria andIsfloatGreaterThanOrEqualTo(String value) {
            addCriterion("isfloat >=", value, "isfloat");
            return (Criteria) this;
        }

        public Criteria andIsfloatLessThan(String value) {
            addCriterion("isfloat <", value, "isfloat");
            return (Criteria) this;
        }

        public Criteria andIsfloatLessThanOrEqualTo(String value) {
            addCriterion("isfloat <=", value, "isfloat");
            return (Criteria) this;
        }

        public Criteria andIsfloatLike(String value) {
            addCriterion("isfloat like", value, "isfloat");
            return (Criteria) this;
        }

        public Criteria andIsfloatNotLike(String value) {
            addCriterion("isfloat not like", value, "isfloat");
            return (Criteria) this;
        }

        public Criteria andIsfloatIn(List<String> values) {
            addCriterion("isfloat in", values, "isfloat");
            return (Criteria) this;
        }

        public Criteria andIsfloatNotIn(List<String> values) {
            addCriterion("isfloat not in", values, "isfloat");
            return (Criteria) this;
        }

        public Criteria andIsfloatBetween(String value1, String value2) {
            addCriterion("isfloat between", value1, value2, "isfloat");
            return (Criteria) this;
        }

        public Criteria andIsfloatNotBetween(String value1, String value2) {
            addCriterion("isfloat not between", value1, value2, "isfloat");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionIsNull() {
            addCriterion("floatdirection is null");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionIsNotNull() {
            addCriterion("floatdirection is not null");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionEqualTo(String value) {
            addCriterion("floatdirection =", value, "floatdirection");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionNotEqualTo(String value) {
            addCriterion("floatdirection <>", value, "floatdirection");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionGreaterThan(String value) {
            addCriterion("floatdirection >", value, "floatdirection");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionGreaterThanOrEqualTo(String value) {
            addCriterion("floatdirection >=", value, "floatdirection");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionLessThan(String value) {
            addCriterion("floatdirection <", value, "floatdirection");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionLessThanOrEqualTo(String value) {
            addCriterion("floatdirection <=", value, "floatdirection");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionLike(String value) {
            addCriterion("floatdirection like", value, "floatdirection");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionNotLike(String value) {
            addCriterion("floatdirection not like", value, "floatdirection");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionIn(List<String> values) {
            addCriterion("floatdirection in", values, "floatdirection");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionNotIn(List<String> values) {
            addCriterion("floatdirection not in", values, "floatdirection");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionBetween(String value1, String value2) {
            addCriterion("floatdirection between", value1, value2, "floatdirection");
            return (Criteria) this;
        }

        public Criteria andFloatdirectionNotBetween(String value1, String value2) {
            addCriterion("floatdirection not between", value1, value2, "floatdirection");
            return (Criteria) this;
        }

        public Criteria andInfoprecentIsNull() {
            addCriterion("infoprecent is null");
            return (Criteria) this;
        }

        public Criteria andInfoprecentIsNotNull() {
            addCriterion("infoprecent is not null");
            return (Criteria) this;
        }

        public Criteria andInfoprecentEqualTo(String value) {
            addCriterion("infoprecent =", value, "infoprecent");
            return (Criteria) this;
        }

        public Criteria andInfoprecentNotEqualTo(String value) {
            addCriterion("infoprecent <>", value, "infoprecent");
            return (Criteria) this;
        }

        public Criteria andInfoprecentGreaterThan(String value) {
            addCriterion("infoprecent >", value, "infoprecent");
            return (Criteria) this;
        }

        public Criteria andInfoprecentGreaterThanOrEqualTo(String value) {
            addCriterion("infoprecent >=", value, "infoprecent");
            return (Criteria) this;
        }

        public Criteria andInfoprecentLessThan(String value) {
            addCriterion("infoprecent <", value, "infoprecent");
            return (Criteria) this;
        }

        public Criteria andInfoprecentLessThanOrEqualTo(String value) {
            addCriterion("infoprecent <=", value, "infoprecent");
            return (Criteria) this;
        }

        public Criteria andInfoprecentLike(String value) {
            addCriterion("infoprecent like", value, "infoprecent");
            return (Criteria) this;
        }

        public Criteria andInfoprecentNotLike(String value) {
            addCriterion("infoprecent not like", value, "infoprecent");
            return (Criteria) this;
        }

        public Criteria andInfoprecentIn(List<String> values) {
            addCriterion("infoprecent in", values, "infoprecent");
            return (Criteria) this;
        }

        public Criteria andInfoprecentNotIn(List<String> values) {
            addCriterion("infoprecent not in", values, "infoprecent");
            return (Criteria) this;
        }

        public Criteria andInfoprecentBetween(String value1, String value2) {
            addCriterion("infoprecent between", value1, value2, "infoprecent");
            return (Criteria) this;
        }

        public Criteria andInfoprecentNotBetween(String value1, String value2) {
            addCriterion("infoprecent not between", value1, value2, "infoprecent");
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

        public Criteria andIsoutIsNull() {
            addCriterion("isout is null");
            return (Criteria) this;
        }

        public Criteria andIsoutIsNotNull() {
            addCriterion("isout is not null");
            return (Criteria) this;
        }

        public Criteria andIsoutEqualTo(String value) {
            addCriterion("isout =", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutNotEqualTo(String value) {
            addCriterion("isout <>", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutGreaterThan(String value) {
            addCriterion("isout >", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutGreaterThanOrEqualTo(String value) {
            addCriterion("isout >=", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutLessThan(String value) {
            addCriterion("isout <", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutLessThanOrEqualTo(String value) {
            addCriterion("isout <=", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutLike(String value) {
            addCriterion("isout like", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutNotLike(String value) {
            addCriterion("isout not like", value, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutIn(List<String> values) {
            addCriterion("isout in", values, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutNotIn(List<String> values) {
            addCriterion("isout not in", values, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutBetween(String value1, String value2) {
            addCriterion("isout between", value1, value2, "isout");
            return (Criteria) this;
        }

        public Criteria andIsoutNotBetween(String value1, String value2) {
            addCriterion("isout not between", value1, value2, "isout");
            return (Criteria) this;
        }

        public Criteria andOuttimeIsNull() {
            addCriterion("outtime is null");
            return (Criteria) this;
        }

        public Criteria andOuttimeIsNotNull() {
            addCriterion("outtime is not null");
            return (Criteria) this;
        }

        public Criteria andOuttimeEqualTo(String value) {
            addCriterion("outtime =", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotEqualTo(String value) {
            addCriterion("outtime <>", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThan(String value) {
            addCriterion("outtime >", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeGreaterThanOrEqualTo(String value) {
            addCriterion("outtime >=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThan(String value) {
            addCriterion("outtime <", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLessThanOrEqualTo(String value) {
            addCriterion("outtime <=", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeLike(String value) {
            addCriterion("outtime like", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotLike(String value) {
            addCriterion("outtime not like", value, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeIn(List<String> values) {
            addCriterion("outtime in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotIn(List<String> values) {
            addCriterion("outtime not in", values, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeBetween(String value1, String value2) {
            addCriterion("outtime between", value1, value2, "outtime");
            return (Criteria) this;
        }

        public Criteria andOuttimeNotBetween(String value1, String value2) {
            addCriterion("outtime not between", value1, value2, "outtime");
            return (Criteria) this;
        }

        public Criteria andFileprecentIsNull() {
            addCriterion("fileprecent is null");
            return (Criteria) this;
        }

        public Criteria andFileprecentIsNotNull() {
            addCriterion("fileprecent is not null");
            return (Criteria) this;
        }

        public Criteria andFileprecentEqualTo(String value) {
            addCriterion("fileprecent =", value, "fileprecent");
            return (Criteria) this;
        }

        public Criteria andFileprecentNotEqualTo(String value) {
            addCriterion("fileprecent <>", value, "fileprecent");
            return (Criteria) this;
        }

        public Criteria andFileprecentGreaterThan(String value) {
            addCriterion("fileprecent >", value, "fileprecent");
            return (Criteria) this;
        }

        public Criteria andFileprecentGreaterThanOrEqualTo(String value) {
            addCriterion("fileprecent >=", value, "fileprecent");
            return (Criteria) this;
        }

        public Criteria andFileprecentLessThan(String value) {
            addCriterion("fileprecent <", value, "fileprecent");
            return (Criteria) this;
        }

        public Criteria andFileprecentLessThanOrEqualTo(String value) {
            addCriterion("fileprecent <=", value, "fileprecent");
            return (Criteria) this;
        }

        public Criteria andFileprecentLike(String value) {
            addCriterion("fileprecent like", value, "fileprecent");
            return (Criteria) this;
        }

        public Criteria andFileprecentNotLike(String value) {
            addCriterion("fileprecent not like", value, "fileprecent");
            return (Criteria) this;
        }

        public Criteria andFileprecentIn(List<String> values) {
            addCriterion("fileprecent in", values, "fileprecent");
            return (Criteria) this;
        }

        public Criteria andFileprecentNotIn(List<String> values) {
            addCriterion("fileprecent not in", values, "fileprecent");
            return (Criteria) this;
        }

        public Criteria andFileprecentBetween(String value1, String value2) {
            addCriterion("fileprecent between", value1, value2, "fileprecent");
            return (Criteria) this;
        }

        public Criteria andFileprecentNotBetween(String value1, String value2) {
            addCriterion("fileprecent not between", value1, value2, "fileprecent");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentIsNull() {
            addCriterion("mainfileprecent is null");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentIsNotNull() {
            addCriterion("mainfileprecent is not null");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentEqualTo(String value) {
            addCriterion("mainfileprecent =", value, "mainfileprecent");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentNotEqualTo(String value) {
            addCriterion("mainfileprecent <>", value, "mainfileprecent");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentGreaterThan(String value) {
            addCriterion("mainfileprecent >", value, "mainfileprecent");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentGreaterThanOrEqualTo(String value) {
            addCriterion("mainfileprecent >=", value, "mainfileprecent");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentLessThan(String value) {
            addCriterion("mainfileprecent <", value, "mainfileprecent");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentLessThanOrEqualTo(String value) {
            addCriterion("mainfileprecent <=", value, "mainfileprecent");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentLike(String value) {
            addCriterion("mainfileprecent like", value, "mainfileprecent");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentNotLike(String value) {
            addCriterion("mainfileprecent not like", value, "mainfileprecent");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentIn(List<String> values) {
            addCriterion("mainfileprecent in", values, "mainfileprecent");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentNotIn(List<String> values) {
            addCriterion("mainfileprecent not in", values, "mainfileprecent");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentBetween(String value1, String value2) {
            addCriterion("mainfileprecent between", value1, value2, "mainfileprecent");
            return (Criteria) this;
        }

        public Criteria andMainfileprecentNotBetween(String value1, String value2) {
            addCriterion("mainfileprecent not between", value1, value2, "mainfileprecent");
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