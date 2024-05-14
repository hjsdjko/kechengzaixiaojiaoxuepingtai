package com.entity.vo;

import com.entity.JiaoxueziyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 教学资源
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaoxueziyuan")
public class JiaoxueziyuanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 老师
     */

    @TableField(value = "laoshi_id")
    private Integer laoshiId;


    /**
     * 教学资源编号
     */

    @TableField(value = "jiaoxueziyuan_uuid_number")
    private String jiaoxueziyuanUuidNumber;


    /**
     * 教学资源名称
     */

    @TableField(value = "jiaoxueziyuan_name")
    private String jiaoxueziyuanName;


    /**
     * 教学资源照片
     */

    @TableField(value = "jiaoxueziyuan_photo")
    private String jiaoxueziyuanPhoto;


    /**
     * 教学视频
     */

    @TableField(value = "jiaoxueziyuan_video")
    private String jiaoxueziyuanVideo;


    /**
     * 教学课件
     */

    @TableField(value = "jiaoxueziyuan_file")
    private String jiaoxueziyuanFile;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 教学资源类型
     */

    @TableField(value = "jiaoxueziyuan_types")
    private Integer jiaoxueziyuanTypes;


    /**
     * 点击次数
     */

    @TableField(value = "jiaoxueziyuan_clicknum")
    private Integer jiaoxueziyuanClicknum;


    /**
     * 教学资源介绍
     */

    @TableField(value = "jiaoxueziyuan_content")
    private String jiaoxueziyuanContent;


    /**
     * 是否上架
     */

    @TableField(value = "shangxia_types")
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "jiaoxueziyuan_delete")
    private Integer jiaoxueziyuanDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 获取：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 设置：教学资源编号
	 */
    public String getJiaoxueziyuanUuidNumber() {
        return jiaoxueziyuanUuidNumber;
    }


    /**
	 * 获取：教学资源编号
	 */

    public void setJiaoxueziyuanUuidNumber(String jiaoxueziyuanUuidNumber) {
        this.jiaoxueziyuanUuidNumber = jiaoxueziyuanUuidNumber;
    }
    /**
	 * 设置：教学资源名称
	 */
    public String getJiaoxueziyuanName() {
        return jiaoxueziyuanName;
    }


    /**
	 * 获取：教学资源名称
	 */

    public void setJiaoxueziyuanName(String jiaoxueziyuanName) {
        this.jiaoxueziyuanName = jiaoxueziyuanName;
    }
    /**
	 * 设置：教学资源照片
	 */
    public String getJiaoxueziyuanPhoto() {
        return jiaoxueziyuanPhoto;
    }


    /**
	 * 获取：教学资源照片
	 */

    public void setJiaoxueziyuanPhoto(String jiaoxueziyuanPhoto) {
        this.jiaoxueziyuanPhoto = jiaoxueziyuanPhoto;
    }
    /**
	 * 设置：教学视频
	 */
    public String getJiaoxueziyuanVideo() {
        return jiaoxueziyuanVideo;
    }


    /**
	 * 获取：教学视频
	 */

    public void setJiaoxueziyuanVideo(String jiaoxueziyuanVideo) {
        this.jiaoxueziyuanVideo = jiaoxueziyuanVideo;
    }
    /**
	 * 设置：教学课件
	 */
    public String getJiaoxueziyuanFile() {
        return jiaoxueziyuanFile;
    }


    /**
	 * 获取：教学课件
	 */

    public void setJiaoxueziyuanFile(String jiaoxueziyuanFile) {
        this.jiaoxueziyuanFile = jiaoxueziyuanFile;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：教学资源类型
	 */
    public Integer getJiaoxueziyuanTypes() {
        return jiaoxueziyuanTypes;
    }


    /**
	 * 获取：教学资源类型
	 */

    public void setJiaoxueziyuanTypes(Integer jiaoxueziyuanTypes) {
        this.jiaoxueziyuanTypes = jiaoxueziyuanTypes;
    }
    /**
	 * 设置：点击次数
	 */
    public Integer getJiaoxueziyuanClicknum() {
        return jiaoxueziyuanClicknum;
    }


    /**
	 * 获取：点击次数
	 */

    public void setJiaoxueziyuanClicknum(Integer jiaoxueziyuanClicknum) {
        this.jiaoxueziyuanClicknum = jiaoxueziyuanClicknum;
    }
    /**
	 * 设置：教学资源介绍
	 */
    public String getJiaoxueziyuanContent() {
        return jiaoxueziyuanContent;
    }


    /**
	 * 获取：教学资源介绍
	 */

    public void setJiaoxueziyuanContent(String jiaoxueziyuanContent) {
        this.jiaoxueziyuanContent = jiaoxueziyuanContent;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJiaoxueziyuanDelete() {
        return jiaoxueziyuanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJiaoxueziyuanDelete(Integer jiaoxueziyuanDelete) {
        this.jiaoxueziyuanDelete = jiaoxueziyuanDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
