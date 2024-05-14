package com.entity.view;

import com.entity.JiaoxueziyuanCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 教学资源收藏
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("jiaoxueziyuan_collection")
public class JiaoxueziyuanCollectionView extends JiaoxueziyuanCollectionEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 类型的值
		*/
		private String jiaoxueziyuanCollectionValue;



		//级联表 jiaoxueziyuan
			/**
			* 教学资源 的 老师
			*/
			private Integer jiaoxueziyuanLaoshiId;
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
				* 教学资源类型的值
				*/
				private String jiaoxueziyuanValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer jiaoxueziyuanDelete;

		//级联表 xuesheng
			/**
			* 学号
			*/
			private String xueshengUuidNumber;
			/**
			* 学生姓名
			*/
			private String xueshengName;
			/**
			* 学生手机号
			*/
			private String xueshengPhone;
			/**
			* 学生身份证号
			*/
			private String xueshengIdNumber;
			/**
			* 学生头像
			*/
			private String xueshengPhoto;
			/**
			* 电子邮箱
			*/
			private String xueshengEmail;

	public JiaoxueziyuanCollectionView() {

	}

	public JiaoxueziyuanCollectionView(JiaoxueziyuanCollectionEntity jiaoxueziyuanCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, jiaoxueziyuanCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 类型的值
			*/
			public String getJiaoxueziyuanCollectionValue() {
				return jiaoxueziyuanCollectionValue;
			}
			/**
			* 设置： 类型的值
			*/
			public void setJiaoxueziyuanCollectionValue(String jiaoxueziyuanCollectionValue) {
				this.jiaoxueziyuanCollectionValue = jiaoxueziyuanCollectionValue;
			}













				//级联表的get和set jiaoxueziyuan

					/**
					* 获取：教学资源 的 老师
					*/
					public Integer getJiaoxueziyuanLaoshiId() {
						return jiaoxueziyuanLaoshiId;
					}
					/**
					* 设置：教学资源 的 老师
					*/
					public void setJiaoxueziyuanLaoshiId(Integer jiaoxueziyuanLaoshiId) {
						this.jiaoxueziyuanLaoshiId = jiaoxueziyuanLaoshiId;
					}


					/**
					* 获取： 教学资源编号
					*/
					public String getJiaoxueziyuanUuidNumber() {
						return jiaoxueziyuanUuidNumber;
					}
					/**
					* 设置： 教学资源编号
					*/
					public void setJiaoxueziyuanUuidNumber(String jiaoxueziyuanUuidNumber) {
						this.jiaoxueziyuanUuidNumber = jiaoxueziyuanUuidNumber;
					}

					/**
					* 获取： 教学资源名称
					*/
					public String getJiaoxueziyuanName() {
						return jiaoxueziyuanName;
					}
					/**
					* 设置： 教学资源名称
					*/
					public void setJiaoxueziyuanName(String jiaoxueziyuanName) {
						this.jiaoxueziyuanName = jiaoxueziyuanName;
					}

					/**
					* 获取： 教学资源照片
					*/
					public String getJiaoxueziyuanPhoto() {
						return jiaoxueziyuanPhoto;
					}
					/**
					* 设置： 教学资源照片
					*/
					public void setJiaoxueziyuanPhoto(String jiaoxueziyuanPhoto) {
						this.jiaoxueziyuanPhoto = jiaoxueziyuanPhoto;
					}

					/**
					* 获取： 教学视频
					*/
					public String getJiaoxueziyuanVideo() {
						return jiaoxueziyuanVideo;
					}
					/**
					* 设置： 教学视频
					*/
					public void setJiaoxueziyuanVideo(String jiaoxueziyuanVideo) {
						this.jiaoxueziyuanVideo = jiaoxueziyuanVideo;
					}

					/**
					* 获取： 教学课件
					*/
					public String getJiaoxueziyuanFile() {
						return jiaoxueziyuanFile;
					}
					/**
					* 设置： 教学课件
					*/
					public void setJiaoxueziyuanFile(String jiaoxueziyuanFile) {
						this.jiaoxueziyuanFile = jiaoxueziyuanFile;
					}

					/**
					* 获取： 赞
					*/
					public Integer getZanNumber() {
						return zanNumber;
					}
					/**
					* 设置： 赞
					*/
					public void setZanNumber(Integer zanNumber) {
						this.zanNumber = zanNumber;
					}

					/**
					* 获取： 踩
					*/
					public Integer getCaiNumber() {
						return caiNumber;
					}
					/**
					* 设置： 踩
					*/
					public void setCaiNumber(Integer caiNumber) {
						this.caiNumber = caiNumber;
					}

					/**
					* 获取： 教学资源类型
					*/
					public Integer getJiaoxueziyuanTypes() {
						return jiaoxueziyuanTypes;
					}
					/**
					* 设置： 教学资源类型
					*/
					public void setJiaoxueziyuanTypes(Integer jiaoxueziyuanTypes) {
						this.jiaoxueziyuanTypes = jiaoxueziyuanTypes;
					}


						/**
						* 获取： 教学资源类型的值
						*/
						public String getJiaoxueziyuanValue() {
							return jiaoxueziyuanValue;
						}
						/**
						* 设置： 教学资源类型的值
						*/
						public void setJiaoxueziyuanValue(String jiaoxueziyuanValue) {
							this.jiaoxueziyuanValue = jiaoxueziyuanValue;
						}

					/**
					* 获取： 点击次数
					*/
					public Integer getJiaoxueziyuanClicknum() {
						return jiaoxueziyuanClicknum;
					}
					/**
					* 设置： 点击次数
					*/
					public void setJiaoxueziyuanClicknum(Integer jiaoxueziyuanClicknum) {
						this.jiaoxueziyuanClicknum = jiaoxueziyuanClicknum;
					}

					/**
					* 获取： 教学资源介绍
					*/
					public String getJiaoxueziyuanContent() {
						return jiaoxueziyuanContent;
					}
					/**
					* 设置： 教学资源介绍
					*/
					public void setJiaoxueziyuanContent(String jiaoxueziyuanContent) {
						this.jiaoxueziyuanContent = jiaoxueziyuanContent;
					}

					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}

					/**
					* 获取： 逻辑删除
					*/
					public Integer getJiaoxueziyuanDelete() {
						return jiaoxueziyuanDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setJiaoxueziyuanDelete(Integer jiaoxueziyuanDelete) {
						this.jiaoxueziyuanDelete = jiaoxueziyuanDelete;
					}













				//级联表的get和set xuesheng

					/**
					* 获取： 学号
					*/
					public String getXueshengUuidNumber() {
						return xueshengUuidNumber;
					}
					/**
					* 设置： 学号
					*/
					public void setXueshengUuidNumber(String xueshengUuidNumber) {
						this.xueshengUuidNumber = xueshengUuidNumber;
					}

					/**
					* 获取： 学生姓名
					*/
					public String getXueshengName() {
						return xueshengName;
					}
					/**
					* 设置： 学生姓名
					*/
					public void setXueshengName(String xueshengName) {
						this.xueshengName = xueshengName;
					}

					/**
					* 获取： 学生手机号
					*/
					public String getXueshengPhone() {
						return xueshengPhone;
					}
					/**
					* 设置： 学生手机号
					*/
					public void setXueshengPhone(String xueshengPhone) {
						this.xueshengPhone = xueshengPhone;
					}

					/**
					* 获取： 学生身份证号
					*/
					public String getXueshengIdNumber() {
						return xueshengIdNumber;
					}
					/**
					* 设置： 学生身份证号
					*/
					public void setXueshengIdNumber(String xueshengIdNumber) {
						this.xueshengIdNumber = xueshengIdNumber;
					}

					/**
					* 获取： 学生头像
					*/
					public String getXueshengPhoto() {
						return xueshengPhoto;
					}
					/**
					* 设置： 学生头像
					*/
					public void setXueshengPhoto(String xueshengPhoto) {
						this.xueshengPhoto = xueshengPhoto;
					}

					/**
					* 获取： 电子邮箱
					*/
					public String getXueshengEmail() {
						return xueshengEmail;
					}
					/**
					* 设置： 电子邮箱
					*/
					public void setXueshengEmail(String xueshengEmail) {
						this.xueshengEmail = xueshengEmail;
					}









}
