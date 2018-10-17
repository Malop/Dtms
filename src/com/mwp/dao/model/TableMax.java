package com.mwp.dao.model;


public class TableMax {

	private String tabname;
	
	private String colname;
	
	private String maxserialno;
	
	private Long version;

	public String getTabname() {
		return tabname;
	}

	public void setTabname(String tabname) {
		this.tabname = tabname;
	}

	public String getColname() {
		return colname;
	}

	public void setColname(String colname) {
		this.colname = colname;
	}

	public String getMaxserialno() {
		return maxserialno;
	}

	public void setMaxserialno(String maxserialno) {
		this.maxserialno = maxserialno;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	 @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append(getClass().getSimpleName());
	        sb.append(" [");
	        sb.append("Hash = ").append(hashCode());
	        sb.append(", tabname=").append(tabname);
	        sb.append(", colname=").append(colname);
	        sb.append(", maxserialno=").append(maxserialno);
	        sb.append(", version=").append(version);
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
	        TableMax other = (TableMax) that;
	        return (this.getTabname() == null ? other.getTabname() == null : this.getTabname().equals(other.getTabname()))
	            && (this.getColname() == null ? other.getColname() == null : this.getColname().equals(other.getColname()))
	            && (this.getMaxserialno() == null ? other.getMaxserialno() == null : this.getMaxserialno().equals(other.getMaxserialno()))
	            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
	    }

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((getTabname() == null) ? 0 : getTabname().hashCode());
	        result = prime * result + ((getColname() == null) ? 0 : getColname().hashCode());
	        result = prime * result + ((getMaxserialno() == null) ? 0 : getMaxserialno().hashCode());
	        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
	        return result;
	    }
}
