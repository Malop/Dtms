package com.mwp.dao.model;

import java.io.Serializable;
import java.util.Date;

public class MFile implements Serializable {
    /**
     * 图片id
     *
     * @mbg.generated
     */
    private String mfileid;

    /**
     * 图片名称
     *
     * @mbg.generated
     */
    private String mfilename;

    /**
     * 所属人员号
     *
     * @mbg.generated
     */
    private String userid;

    /**
     * 图片类型
     *
     * @mbg.generated
     */
    private String mfiletype;

    /**
     * 存储路径
     *
     * @mbg.generated
     */
    private String mfileurl;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date cttime;

    private static final long serialVersionUID = 1L;

    public String getMfileid() {
        return mfileid;
    }

    public void setMfileid(String mfileid) {
        this.mfileid = mfileid;
    }

    public String getMfilename() {
        return mfilename;
    }

    public void setMfilename(String mfilename) {
        this.mfilename = mfilename;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMfiletype() {
        return mfiletype;
    }

    public void setMfiletype(String mfiletype) {
        this.mfiletype = mfiletype;
    }

    public String getMfileurl() {
        return mfileurl;
    }

    public void setMfileurl(String mfileurl) {
        this.mfileurl = mfileurl;
    }

    public Date getCttime() {
        return cttime;
    }

    public void setCttime(Date cttime) {
        this.cttime = cttime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", mfileid=").append(mfileid);
        sb.append(", mfilename=").append(mfilename);
        sb.append(", userid=").append(userid);
        sb.append(", mfiletype=").append(mfiletype);
        sb.append(", mfileurl=").append(mfileurl);
        sb.append(", cttime=").append(cttime);
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
        MFile other = (MFile) that;
        return (this.getMfileid() == null ? other.getMfileid() == null : this.getMfileid().equals(other.getMfileid()))
            && (this.getMfilename() == null ? other.getMfilename() == null : this.getMfilename().equals(other.getMfilename()))
            && (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getMfiletype() == null ? other.getMfiletype() == null : this.getMfiletype().equals(other.getMfiletype()))
            && (this.getMfileurl() == null ? other.getMfileurl() == null : this.getMfileurl().equals(other.getMfileurl()))
            && (this.getCttime() == null ? other.getCttime() == null : this.getCttime().equals(other.getCttime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getMfileid() == null) ? 0 : getMfileid().hashCode());
        result = prime * result + ((getMfilename() == null) ? 0 : getMfilename().hashCode());
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getMfiletype() == null) ? 0 : getMfiletype().hashCode());
        result = prime * result + ((getMfileurl() == null) ? 0 : getMfileurl().hashCode());
        result = prime * result + ((getCttime() == null) ? 0 : getCttime().hashCode());
        return result;
    }
}