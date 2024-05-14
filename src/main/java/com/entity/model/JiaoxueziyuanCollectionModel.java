package com.entity.model;

import com.entity.JiaoxueziyuanCollectionEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 教学资源收藏
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaoxueziyuanCollectionModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 教学资源
     */
    private Integer jiaoxueziyuanId;


    /**
     * 学生
     */
    private Integer xueshengId;


    /**
     * 类型
     */
    private Integer jiaoxueziyuanCollectionTypes;


    /**
     * 收藏时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 photoShow
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
	 * 获取：教学资源
	 */
    public Integer getJiaoxueziyuanId() {
        return jiaoxueziyuanId;
    }


    /**
	 * 设置：教学资源
	 */
    public void setJiaoxueziyuanId(Integer jiaoxueziyuanId) {
        this.jiaoxueziyuanId = jiaoxueziyuanId;
    }
    /**
	 * 获取：学生
	 */
    public Integer getXueshengId() {
        return xueshengId;
    }


    /**
	 * 设置：学生
	 */
    public void setXueshengId(Integer xueshengId) {
        this.xueshengId = xueshengId;
    }
    /**
	 * 获取：类型
	 */
    public Integer getJiaoxueziyuanCollectionTypes() {
        return jiaoxueziyuanCollectionTypes;
    }


    /**
	 * 设置：类型
	 */
    public void setJiaoxueziyuanCollectionTypes(Integer jiaoxueziyuanCollectionTypes) {
        this.jiaoxueziyuanCollectionTypes = jiaoxueziyuanCollectionTypes;
    }
    /**
	 * 获取：收藏时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：收藏时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
