package com.entity.model;

import com.entity.JiaoxueziyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教学资源
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaoxueziyuanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 教学资源编号
     */
    private String jiaoxueziyuanUuidNumber;


    /**
     * 教学资源名称
     */
    private String jiaoxueziyuanName;


    /**
     * 教学资源照片
     */
    private String jiaoxueziyuanPhoto;


    /**
     * 教学视频
     */
    private String jiaoxueziyuanVideo;


    /**
     * 教学课件
     */
    private String jiaoxueziyuanFile;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 教学资源类型
     */
    private Integer jiaoxueziyuanTypes;


    /**
     * 点击次数
     */
    private Integer jiaoxueziyuanClicknum;


    /**
     * 教学资源介绍
     */
    private String jiaoxueziyuanContent;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer jiaoxueziyuanDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 设置：老师
	 */
    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：教学资源编号
	 */
    public String getJiaoxueziyuanUuidNumber() {
        return jiaoxueziyuanUuidNumber;
    }


    /**
	 * 设置：教学资源编号
	 */
    public void setJiaoxueziyuanUuidNumber(String jiaoxueziyuanUuidNumber) {
        this.jiaoxueziyuanUuidNumber = jiaoxueziyuanUuidNumber;
    }
    /**
	 * 获取：教学资源名称
	 */
    public String getJiaoxueziyuanName() {
        return jiaoxueziyuanName;
    }


    /**
	 * 设置：教学资源名称
	 */
    public void setJiaoxueziyuanName(String jiaoxueziyuanName) {
        this.jiaoxueziyuanName = jiaoxueziyuanName;
    }
    /**
	 * 获取：教学资源照片
	 */
    public String getJiaoxueziyuanPhoto() {
        return jiaoxueziyuanPhoto;
    }


    /**
	 * 设置：教学资源照片
	 */
    public void setJiaoxueziyuanPhoto(String jiaoxueziyuanPhoto) {
        this.jiaoxueziyuanPhoto = jiaoxueziyuanPhoto;
    }
    /**
	 * 获取：教学视频
	 */
    public String getJiaoxueziyuanVideo() {
        return jiaoxueziyuanVideo;
    }


    /**
	 * 设置：教学视频
	 */
    public void setJiaoxueziyuanVideo(String jiaoxueziyuanVideo) {
        this.jiaoxueziyuanVideo = jiaoxueziyuanVideo;
    }
    /**
	 * 获取：教学课件
	 */
    public String getJiaoxueziyuanFile() {
        return jiaoxueziyuanFile;
    }


    /**
	 * 设置：教学课件
	 */
    public void setJiaoxueziyuanFile(String jiaoxueziyuanFile) {
        this.jiaoxueziyuanFile = jiaoxueziyuanFile;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 设置：赞
	 */
    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 设置：踩
	 */
    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：教学资源类型
	 */
    public Integer getJiaoxueziyuanTypes() {
        return jiaoxueziyuanTypes;
    }


    /**
	 * 设置：教学资源类型
	 */
    public void setJiaoxueziyuanTypes(Integer jiaoxueziyuanTypes) {
        this.jiaoxueziyuanTypes = jiaoxueziyuanTypes;
    }
    /**
	 * 获取：点击次数
	 */
    public Integer getJiaoxueziyuanClicknum() {
        return jiaoxueziyuanClicknum;
    }


    /**
	 * 设置：点击次数
	 */
    public void setJiaoxueziyuanClicknum(Integer jiaoxueziyuanClicknum) {
        this.jiaoxueziyuanClicknum = jiaoxueziyuanClicknum;
    }
    /**
	 * 获取：教学资源介绍
	 */
    public String getJiaoxueziyuanContent() {
        return jiaoxueziyuanContent;
    }


    /**
	 * 设置：教学资源介绍
	 */
    public void setJiaoxueziyuanContent(String jiaoxueziyuanContent) {
        this.jiaoxueziyuanContent = jiaoxueziyuanContent;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getJiaoxueziyuanDelete() {
        return jiaoxueziyuanDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setJiaoxueziyuanDelete(Integer jiaoxueziyuanDelete) {
        this.jiaoxueziyuanDelete = jiaoxueziyuanDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
