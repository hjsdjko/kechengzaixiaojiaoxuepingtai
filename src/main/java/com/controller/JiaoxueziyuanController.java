
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 教学资源
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaoxueziyuan")
public class JiaoxueziyuanController {
    private static final Logger logger = LoggerFactory.getLogger(JiaoxueziyuanController.class);

    @Autowired
    private JiaoxueziyuanService jiaoxueziyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private LaoshiService laoshiService;

    @Autowired
    private XueshengService xueshengService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("xueshengId",request.getSession().getAttribute("userId"));
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        params.put("jiaoxueziyuanDeleteStart",1);params.put("jiaoxueziyuanDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jiaoxueziyuanService.queryPage(params);

        //字典表数据转换
        List<JiaoxueziyuanView> list =(List<JiaoxueziyuanView>)page.getList();
        for(JiaoxueziyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaoxueziyuanEntity jiaoxueziyuan = jiaoxueziyuanService.selectById(id);
        if(jiaoxueziyuan !=null){
            //entity转view
            JiaoxueziyuanView view = new JiaoxueziyuanView();
            BeanUtils.copyProperties( jiaoxueziyuan , view );//把实体数据重构到view中

                //级联表
                LaoshiEntity laoshi = laoshiService.selectById(jiaoxueziyuan.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoxueziyuanEntity jiaoxueziyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaoxueziyuan:{}",this.getClass().getName(),jiaoxueziyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老师".equals(role))
            jiaoxueziyuan.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JiaoxueziyuanEntity> queryWrapper = new EntityWrapper<JiaoxueziyuanEntity>()
            .eq("laoshi_id", jiaoxueziyuan.getLaoshiId())
            .eq("jiaoxueziyuan_uuid_number", jiaoxueziyuan.getJiaoxueziyuanUuidNumber())
            .eq("jiaoxueziyuan_name", jiaoxueziyuan.getJiaoxueziyuanName())
            .eq("jiaoxueziyuan_video", jiaoxueziyuan.getJiaoxueziyuanVideo())
            .eq("zan_number", jiaoxueziyuan.getZanNumber())
            .eq("cai_number", jiaoxueziyuan.getCaiNumber())
            .eq("jiaoxueziyuan_types", jiaoxueziyuan.getJiaoxueziyuanTypes())
            .eq("jiaoxueziyuan_clicknum", jiaoxueziyuan.getJiaoxueziyuanClicknum())
            .eq("shangxia_types", jiaoxueziyuan.getShangxiaTypes())
            .eq("jiaoxueziyuan_delete", jiaoxueziyuan.getJiaoxueziyuanDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoxueziyuanEntity jiaoxueziyuanEntity = jiaoxueziyuanService.selectOne(queryWrapper);
        if(jiaoxueziyuanEntity==null){
            jiaoxueziyuan.setJiaoxueziyuanClicknum(1);
            jiaoxueziyuan.setShangxiaTypes(1);
            jiaoxueziyuan.setJiaoxueziyuanDelete(1);
            jiaoxueziyuan.setCreateTime(new Date());
            jiaoxueziyuanService.insert(jiaoxueziyuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaoxueziyuanEntity jiaoxueziyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiaoxueziyuan:{}",this.getClass().getName(),jiaoxueziyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老师".equals(role))
//            jiaoxueziyuan.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<JiaoxueziyuanEntity> queryWrapper = new EntityWrapper<JiaoxueziyuanEntity>()
            .notIn("id",jiaoxueziyuan.getId())
            .andNew()
            .eq("laoshi_id", jiaoxueziyuan.getLaoshiId())
            .eq("jiaoxueziyuan_uuid_number", jiaoxueziyuan.getJiaoxueziyuanUuidNumber())
            .eq("jiaoxueziyuan_name", jiaoxueziyuan.getJiaoxueziyuanName())
            .eq("jiaoxueziyuan_video", jiaoxueziyuan.getJiaoxueziyuanVideo())
            .eq("zan_number", jiaoxueziyuan.getZanNumber())
            .eq("cai_number", jiaoxueziyuan.getCaiNumber())
            .eq("jiaoxueziyuan_types", jiaoxueziyuan.getJiaoxueziyuanTypes())
            .eq("jiaoxueziyuan_clicknum", jiaoxueziyuan.getJiaoxueziyuanClicknum())
            .eq("shangxia_types", jiaoxueziyuan.getShangxiaTypes())
            .eq("jiaoxueziyuan_delete", jiaoxueziyuan.getJiaoxueziyuanDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoxueziyuanEntity jiaoxueziyuanEntity = jiaoxueziyuanService.selectOne(queryWrapper);
        if("".equals(jiaoxueziyuan.getJiaoxueziyuanPhoto()) || "null".equals(jiaoxueziyuan.getJiaoxueziyuanPhoto())){
                jiaoxueziyuan.setJiaoxueziyuanPhoto(null);
        }
        if("".equals(jiaoxueziyuan.getJiaoxueziyuanVideo()) || "null".equals(jiaoxueziyuan.getJiaoxueziyuanVideo())){
                jiaoxueziyuan.setJiaoxueziyuanVideo(null);
        }
        if("".equals(jiaoxueziyuan.getJiaoxueziyuanFile()) || "null".equals(jiaoxueziyuan.getJiaoxueziyuanFile())){
                jiaoxueziyuan.setJiaoxueziyuanFile(null);
        }
        if(jiaoxueziyuanEntity==null){
            jiaoxueziyuanService.updateById(jiaoxueziyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<JiaoxueziyuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiaoxueziyuanEntity jiaoxueziyuanEntity = new JiaoxueziyuanEntity();
            jiaoxueziyuanEntity.setId(id);
            jiaoxueziyuanEntity.setJiaoxueziyuanDelete(2);
            list.add(jiaoxueziyuanEntity);
        }
        if(list != null && list.size() >0){
            jiaoxueziyuanService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<JiaoxueziyuanEntity> jiaoxueziyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiaoxueziyuanEntity jiaoxueziyuanEntity = new JiaoxueziyuanEntity();
//                            jiaoxueziyuanEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            jiaoxueziyuanEntity.setJiaoxueziyuanUuidNumber(data.get(0));                    //教学资源编号 要改的
//                            jiaoxueziyuanEntity.setJiaoxueziyuanName(data.get(0));                    //教学资源名称 要改的
//                            jiaoxueziyuanEntity.setJiaoxueziyuanPhoto("");//详情和图片
//                            jiaoxueziyuanEntity.setJiaoxueziyuanVideo(data.get(0));                    //教学视频 要改的
//                            jiaoxueziyuanEntity.setJiaoxueziyuanFile(data.get(0));                    //教学课件 要改的
//                            jiaoxueziyuanEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            jiaoxueziyuanEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            jiaoxueziyuanEntity.setJiaoxueziyuanTypes(Integer.valueOf(data.get(0)));   //教学资源类型 要改的
//                            jiaoxueziyuanEntity.setJiaoxueziyuanClicknum(Integer.valueOf(data.get(0)));   //点击次数 要改的
//                            jiaoxueziyuanEntity.setJiaoxueziyuanContent("");//详情和图片
//                            jiaoxueziyuanEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            jiaoxueziyuanEntity.setJiaoxueziyuanDelete(1);//逻辑删除字段
//                            jiaoxueziyuanEntity.setCreateTime(date);//时间
                            jiaoxueziyuanList.add(jiaoxueziyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //教学资源编号
                                if(seachFields.containsKey("jiaoxueziyuanUuidNumber")){
                                    List<String> jiaoxueziyuanUuidNumber = seachFields.get("jiaoxueziyuanUuidNumber");
                                    jiaoxueziyuanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiaoxueziyuanUuidNumber = new ArrayList<>();
                                    jiaoxueziyuanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiaoxueziyuanUuidNumber",jiaoxueziyuanUuidNumber);
                                }
                        }

                        //查询是否重复
                         //教学资源编号
                        List<JiaoxueziyuanEntity> jiaoxueziyuanEntities_jiaoxueziyuanUuidNumber = jiaoxueziyuanService.selectList(new EntityWrapper<JiaoxueziyuanEntity>().in("jiaoxueziyuan_uuid_number", seachFields.get("jiaoxueziyuanUuidNumber")).eq("jiaoxueziyuan_delete", 1));
                        if(jiaoxueziyuanEntities_jiaoxueziyuanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiaoxueziyuanEntity s:jiaoxueziyuanEntities_jiaoxueziyuanUuidNumber){
                                repeatFields.add(s.getJiaoxueziyuanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [教学资源编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiaoxueziyuanService.insertBatch(jiaoxueziyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = jiaoxueziyuanService.queryPage(params);

        //字典表数据转换
        List<JiaoxueziyuanView> list =(List<JiaoxueziyuanView>)page.getList();
        for(JiaoxueziyuanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaoxueziyuanEntity jiaoxueziyuan = jiaoxueziyuanService.selectById(id);
            if(jiaoxueziyuan !=null){

                //点击数量加1
                jiaoxueziyuan.setJiaoxueziyuanClicknum(jiaoxueziyuan.getJiaoxueziyuanClicknum()+1);
                jiaoxueziyuanService.updateById(jiaoxueziyuan);

                //entity转view
                JiaoxueziyuanView view = new JiaoxueziyuanView();
                BeanUtils.copyProperties( jiaoxueziyuan , view );//把实体数据重构到view中

                //级联表
                    LaoshiEntity laoshi = laoshiService.selectById(jiaoxueziyuan.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JiaoxueziyuanEntity jiaoxueziyuan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jiaoxueziyuan:{}",this.getClass().getName(),jiaoxueziyuan.toString());
        Wrapper<JiaoxueziyuanEntity> queryWrapper = new EntityWrapper<JiaoxueziyuanEntity>()
            .eq("laoshi_id", jiaoxueziyuan.getLaoshiId())
            .eq("jiaoxueziyuan_uuid_number", jiaoxueziyuan.getJiaoxueziyuanUuidNumber())
            .eq("jiaoxueziyuan_name", jiaoxueziyuan.getJiaoxueziyuanName())
            .eq("jiaoxueziyuan_video", jiaoxueziyuan.getJiaoxueziyuanVideo())
            .eq("zan_number", jiaoxueziyuan.getZanNumber())
            .eq("cai_number", jiaoxueziyuan.getCaiNumber())
            .eq("jiaoxueziyuan_types", jiaoxueziyuan.getJiaoxueziyuanTypes())
            .eq("jiaoxueziyuan_clicknum", jiaoxueziyuan.getJiaoxueziyuanClicknum())
            .eq("shangxia_types", jiaoxueziyuan.getShangxiaTypes())
            .eq("jiaoxueziyuan_delete", jiaoxueziyuan.getJiaoxueziyuanDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoxueziyuanEntity jiaoxueziyuanEntity = jiaoxueziyuanService.selectOne(queryWrapper);
        if(jiaoxueziyuanEntity==null){
            jiaoxueziyuan.setJiaoxueziyuanDelete(1);
            jiaoxueziyuan.setCreateTime(new Date());
        jiaoxueziyuanService.insert(jiaoxueziyuan);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
