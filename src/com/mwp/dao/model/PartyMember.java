package com.mwp.dao.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class PartyMember implements Serializable {
    private String certid;

    private String partyname;

    /**
     * male男 female女
     *
     * @mbg.generated
     */
    private String sex;

    /**
     * 民族
     *
     * @mbg.generated
     */
    private String nation;

    /**
     * 籍贯
     *
     * @mbg.generated
     */
    private String nativeplace;

    /**
     * 01是 02否
     *
     * @mbg.generated
     */
    private String istaiwan;

    /**
     * 生日
     *
     * @mbg.generated
     */
    private String brithday;

    /**
     * 年龄
     *
     * @mbg.generated
     */
    private String age;

    /**
     * 学历
     *
     * @mbg.generated
     */
    private String education;

    /**
     * 人员类别
     *
     * @mbg.generated
     */
    private String category;

    /**
     * 党组织
     *
     * @mbg.generated
     */
    private String partygroup;

    /**
     * 入党时间
     *
     * @mbg.generated
     */
    private String partytime;

    /**
     * 转正时间
     *
     * @mbg.generated
     */
    private String fullpartytime;

    /**
     * 工作岗位
     *
     * @mbg.generated
     */
    private String job;

    /**
     * 参加工作时间
     *
     * @mbg.generated
     */
    private String timetowork;

    /**
     * 地址
     *
     * @mbg.generated
     */
    private String address;

    /**
     * 手机号码
     *
     * @mbg.generated
     */
    private String mobilephone;

    /**
     * 固定电话
     *
     * @mbg.generated
     */
    private String telephone;

    /**
     * 婚姻状况
     *
     * @mbg.generated
     */
    private String marriage;

    /**
     * 档案所在地
     *
     * @mbg.generated
     */
    private String archiveplace;

    /**
     * 技术职称
     *
     * @mbg.generated
     */
    private String technicaltitle;

    /**
     * 社会阶层类型
     *
     * @mbg.generated
     */
    private String sociallevel;

    /**
     * 一线情况
     *
     * @mbg.generated
     */
    private String situation;

    /**
     * 培训情况
     *
     * @mbg.generated
     */
    private String training;

    /**
     * 是否农民工
     *
     * @mbg.generated
     */
    private String isworker;

    /**
     * 是否失联党员
     *
     * @mbg.generated
     */
    private String isoffline;

    /**
     * 失联时间
     *
     * @mbg.generated
     */
    private String offdate;

    /**
     * 是否流动党员
     *
     * @mbg.generated
     */
    private String isfloat;

    /**
     * 外出流向
     *
     * @mbg.generated
     */
    private String floatdirection;

    /**
     * 信息完整度
     *
     * @mbg.generated
     */
    private String infoprecent;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date cttime;

    /**
     * 是否转出
     *
     * @mbg.generated
     */
    private String isout;

    /**
     * 转出时间
     *
     * @mbg.generated
     */
    private String outtime;

    /**
     * 档案资料完整度
     *
     * @mbg.generated
     */
    private String fileprecent;

    /**
     * 主要档案资料完整度
     *
     * @mbg.generated
     */
    private String mainfileprecent;
    public PartyMember(){}
    public PartyMember(List<String> list){
		this.partyname = list.get(0);
		this.certid = list.get(1);
		this.sex = list.get(2);
		this.nation = list.get(3);
		this.nativeplace = list.get(4);
		this.istaiwan = list.get(5);
		this.brithday = list.get(6);
		this.education = list.get(7);
		this.category = list.get(8);
		this.partygroup = list.get(9);
		this.partytime = list.get(10);
		this.fullpartytime = list.get(11);
		this.job = list.get(12);
		this.timetowork =list.get(13);
		this.address = list.get(14);
		this.mobilephone = list.get(15);
		this.telephone = list.get(16);
		this.marriage = list.get(17);
		this.archiveplace = list.get(18);
		this.technicaltitle = list.get(19);
		this.sociallevel = list.get(20);
		this.situation = list.get(21);
		this.training = list.get(22);
		this.isworker = list.get(23);
		this.isoffline = list.get(24);
		this.offdate = list.get(25);
		this.isfloat = list.get(26);
		this.floatdirection = list.get(27);
		this.infoprecent = list.get(28);
		this.isout="0";
	}

    private static final long serialVersionUID = 1L;

    public String getCertid() {
        return certid;
    }

    public void setCertid(String certid) {
        this.certid = certid;
    }

    public String getPartyname() {
        return partyname;
    }

    public void setPartyname(String partyname) {
        this.partyname = partyname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getIstaiwan() {
        return istaiwan;
    }

    public void setIstaiwan(String istaiwan) {
        this.istaiwan = istaiwan;
    }

    public String getBrithday() {
        return brithday;
    }

    public void setBrithday(String brithday) {
        this.brithday = brithday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPartygroup() {
        return partygroup;
    }

    public void setPartygroup(String partygroup) {
        this.partygroup = partygroup;
    }

    public String getPartytime() {
        return partytime;
    }

    public void setPartytime(String partytime) {
        this.partytime = partytime;
    }

    public String getFullpartytime() {
        return fullpartytime;
    }

    public void setFullpartytime(String fullpartytime) {
        this.fullpartytime = fullpartytime;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getTimetowork() {
        return timetowork;
    }

    public void setTimetowork(String timetowork) {
        this.timetowork = timetowork;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getArchiveplace() {
        return archiveplace;
    }

    public void setArchiveplace(String archiveplace) {
        this.archiveplace = archiveplace;
    }

    public String getTechnicaltitle() {
        return technicaltitle;
    }

    public void setTechnicaltitle(String technicaltitle) {
        this.technicaltitle = technicaltitle;
    }

    public String getSociallevel() {
        return sociallevel;
    }

    public void setSociallevel(String sociallevel) {
        this.sociallevel = sociallevel;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getIsworker() {
        return isworker;
    }

    public void setIsworker(String isworker) {
        this.isworker = isworker;
    }

    public String getIsoffline() {
        return isoffline;
    }

    public void setIsoffline(String isoffline) {
        this.isoffline = isoffline;
    }

    public String getOffdate() {
        return offdate;
    }

    public void setOffdate(String offdate) {
        this.offdate = offdate;
    }

    public String getIsfloat() {
        return isfloat;
    }

    public void setIsfloat(String isfloat) {
        this.isfloat = isfloat;
    }

    public String getFloatdirection() {
        return floatdirection;
    }

    public void setFloatdirection(String floatdirection) {
        this.floatdirection = floatdirection;
    }

    public String getInfoprecent() {
        return infoprecent;
    }

    public void setInfoprecent(String infoprecent) {
        this.infoprecent = infoprecent;
    }

    public Date getCttime() {
        return cttime;
    }

    public void setCttime(Date cttime) {
        this.cttime = cttime;
    }

    public String getIsout() {
        return isout;
    }

    public void setIsout(String isout) {
        this.isout = isout;
    }

    public String getOuttime() {
        return outtime;
    }

    public void setOuttime(String outtime) {
        this.outtime = outtime;
    }

    public String getFileprecent() {
        return fileprecent;
    }

    public void setFileprecent(String fileprecent) {
        this.fileprecent = fileprecent;
    }

    public String getMainfileprecent() {
        return mainfileprecent;
    }

    public void setMainfileprecent(String mainfileprecent) {
        this.mainfileprecent = mainfileprecent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", certid=").append(certid);
        sb.append(", partyname=").append(partyname);
        sb.append(", sex=").append(sex);
        sb.append(", nation=").append(nation);
        sb.append(", nativeplace=").append(nativeplace);
        sb.append(", istaiwan=").append(istaiwan);
        sb.append(", brithday=").append(brithday);
        sb.append(", age=").append(age);
        sb.append(", education=").append(education);
        sb.append(", category=").append(category);
        sb.append(", partygroup=").append(partygroup);
        sb.append(", partytime=").append(partytime);
        sb.append(", fullpartytime=").append(fullpartytime);
        sb.append(", job=").append(job);
        sb.append(", timetowork=").append(timetowork);
        sb.append(", address=").append(address);
        sb.append(", mobilephone=").append(mobilephone);
        sb.append(", telephone=").append(telephone);
        sb.append(", marriage=").append(marriage);
        sb.append(", archiveplace=").append(archiveplace);
        sb.append(", technicaltitle=").append(technicaltitle);
        sb.append(", sociallevel=").append(sociallevel);
        sb.append(", situation=").append(situation);
        sb.append(", training=").append(training);
        sb.append(", isworker=").append(isworker);
        sb.append(", isoffline=").append(isoffline);
        sb.append(", offdate=").append(offdate);
        sb.append(", isfloat=").append(isfloat);
        sb.append(", floatdirection=").append(floatdirection);
        sb.append(", infoprecent=").append(infoprecent);
        sb.append(", cttime=").append(cttime);
        sb.append(", isout=").append(isout);
        sb.append(", outtime=").append(outtime);
        sb.append(", fileprecent=").append(fileprecent);
        sb.append(", mainfileprecent=").append(mainfileprecent);
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
        PartyMember other = (PartyMember) that;
        return (this.getCertid() == null ? other.getCertid() == null : this.getCertid().equals(other.getCertid()))
            && (this.getPartyname() == null ? other.getPartyname() == null : this.getPartyname().equals(other.getPartyname()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getNativeplace() == null ? other.getNativeplace() == null : this.getNativeplace().equals(other.getNativeplace()))
            && (this.getIstaiwan() == null ? other.getIstaiwan() == null : this.getIstaiwan().equals(other.getIstaiwan()))
            && (this.getBrithday() == null ? other.getBrithday() == null : this.getBrithday().equals(other.getBrithday()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getCategory() == null ? other.getCategory() == null : this.getCategory().equals(other.getCategory()))
            && (this.getPartygroup() == null ? other.getPartygroup() == null : this.getPartygroup().equals(other.getPartygroup()))
            && (this.getPartytime() == null ? other.getPartytime() == null : this.getPartytime().equals(other.getPartytime()))
            && (this.getFullpartytime() == null ? other.getFullpartytime() == null : this.getFullpartytime().equals(other.getFullpartytime()))
            && (this.getJob() == null ? other.getJob() == null : this.getJob().equals(other.getJob()))
            && (this.getTimetowork() == null ? other.getTimetowork() == null : this.getTimetowork().equals(other.getTimetowork()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getMobilephone() == null ? other.getMobilephone() == null : this.getMobilephone().equals(other.getMobilephone()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getMarriage() == null ? other.getMarriage() == null : this.getMarriage().equals(other.getMarriage()))
            && (this.getArchiveplace() == null ? other.getArchiveplace() == null : this.getArchiveplace().equals(other.getArchiveplace()))
            && (this.getTechnicaltitle() == null ? other.getTechnicaltitle() == null : this.getTechnicaltitle().equals(other.getTechnicaltitle()))
            && (this.getSociallevel() == null ? other.getSociallevel() == null : this.getSociallevel().equals(other.getSociallevel()))
            && (this.getSituation() == null ? other.getSituation() == null : this.getSituation().equals(other.getSituation()))
            && (this.getTraining() == null ? other.getTraining() == null : this.getTraining().equals(other.getTraining()))
            && (this.getIsworker() == null ? other.getIsworker() == null : this.getIsworker().equals(other.getIsworker()))
            && (this.getIsoffline() == null ? other.getIsoffline() == null : this.getIsoffline().equals(other.getIsoffline()))
            && (this.getOffdate() == null ? other.getOffdate() == null : this.getOffdate().equals(other.getOffdate()))
            && (this.getIsfloat() == null ? other.getIsfloat() == null : this.getIsfloat().equals(other.getIsfloat()))
            && (this.getFloatdirection() == null ? other.getFloatdirection() == null : this.getFloatdirection().equals(other.getFloatdirection()))
            && (this.getInfoprecent() == null ? other.getInfoprecent() == null : this.getInfoprecent().equals(other.getInfoprecent()))
            && (this.getCttime() == null ? other.getCttime() == null : this.getCttime().equals(other.getCttime()))
            && (this.getIsout() == null ? other.getIsout() == null : this.getIsout().equals(other.getIsout()))
            && (this.getOuttime() == null ? other.getOuttime() == null : this.getOuttime().equals(other.getOuttime()))
            && (this.getFileprecent() == null ? other.getFileprecent() == null : this.getFileprecent().equals(other.getFileprecent()))
            && (this.getMainfileprecent() == null ? other.getMainfileprecent() == null : this.getMainfileprecent().equals(other.getMainfileprecent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCertid() == null) ? 0 : getCertid().hashCode());
        result = prime * result + ((getPartyname() == null) ? 0 : getPartyname().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getNativeplace() == null) ? 0 : getNativeplace().hashCode());
        result = prime * result + ((getIstaiwan() == null) ? 0 : getIstaiwan().hashCode());
        result = prime * result + ((getBrithday() == null) ? 0 : getBrithday().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getCategory() == null) ? 0 : getCategory().hashCode());
        result = prime * result + ((getPartygroup() == null) ? 0 : getPartygroup().hashCode());
        result = prime * result + ((getPartytime() == null) ? 0 : getPartytime().hashCode());
        result = prime * result + ((getFullpartytime() == null) ? 0 : getFullpartytime().hashCode());
        result = prime * result + ((getJob() == null) ? 0 : getJob().hashCode());
        result = prime * result + ((getTimetowork() == null) ? 0 : getTimetowork().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getMobilephone() == null) ? 0 : getMobilephone().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getMarriage() == null) ? 0 : getMarriage().hashCode());
        result = prime * result + ((getArchiveplace() == null) ? 0 : getArchiveplace().hashCode());
        result = prime * result + ((getTechnicaltitle() == null) ? 0 : getTechnicaltitle().hashCode());
        result = prime * result + ((getSociallevel() == null) ? 0 : getSociallevel().hashCode());
        result = prime * result + ((getSituation() == null) ? 0 : getSituation().hashCode());
        result = prime * result + ((getTraining() == null) ? 0 : getTraining().hashCode());
        result = prime * result + ((getIsworker() == null) ? 0 : getIsworker().hashCode());
        result = prime * result + ((getIsoffline() == null) ? 0 : getIsoffline().hashCode());
        result = prime * result + ((getOffdate() == null) ? 0 : getOffdate().hashCode());
        result = prime * result + ((getIsfloat() == null) ? 0 : getIsfloat().hashCode());
        result = prime * result + ((getFloatdirection() == null) ? 0 : getFloatdirection().hashCode());
        result = prime * result + ((getInfoprecent() == null) ? 0 : getInfoprecent().hashCode());
        result = prime * result + ((getCttime() == null) ? 0 : getCttime().hashCode());
        result = prime * result + ((getIsout() == null) ? 0 : getIsout().hashCode());
        result = prime * result + ((getOuttime() == null) ? 0 : getOuttime().hashCode());
        result = prime * result + ((getFileprecent() == null) ? 0 : getFileprecent().hashCode());
        result = prime * result + ((getMainfileprecent() == null) ? 0 : getMainfileprecent().hashCode());
        return result;
    }
}