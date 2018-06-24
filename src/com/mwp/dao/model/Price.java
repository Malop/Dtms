package com.mwp.dao.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Price implements Serializable {
    /**
     * 主键
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 总值
     *
     * @mbg.generated
     */
    private BigDecimal total;

    /**
     * 消费前
     *
     * @mbg.generated
     */
    private BigDecimal front;

    /**
     * 消费后
     *
     * @mbg.generated
     */
    private BigDecimal end;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getFront() {
        return front;
    }

    public void setFront(BigDecimal front) {
        this.front = front;
    }

    public BigDecimal getEnd() {
        return end;
    }

    public void setEnd(BigDecimal end) {
        this.end = end;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", total=").append(total);
        sb.append(", front=").append(front);
        sb.append(", end=").append(end);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Price other = (Price) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTotal() == null ? other.getTotal() == null : this.getTotal().equals(other.getTotal()))
            && (this.getFront() == null ? other.getFront() == null : this.getFront().equals(other.getFront()))
            && (this.getEnd() == null ? other.getEnd() == null : this.getEnd().equals(other.getEnd()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTotal() == null) ? 0 : getTotal().hashCode());
        result = prime * result + ((getFront() == null) ? 0 : getFront().hashCode());
        result = prime * result + ((getEnd() == null) ? 0 : getEnd().hashCode());
        return result;
    }
}