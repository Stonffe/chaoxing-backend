package com.example.exam.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.exam.entity.Grade;
import com.example.exam.resp.RestResp;
import com.example.exam.vo.GradeVo;

import java.util.List;

/**
 * @Classname: GradeService
 * @Description:
 * @Author: Stonffe
 * @Date: 2024/4/27 23:43
 */
public interface GradeService extends IService<Grade> {
    /**
     * 添加成绩
     *
     * @param phoneNum
     * @return
     */
    RestResp<Void> insertGrade(String phoneNum, Integer courseId);

    /**
     * 查询成绩
     *
     * @param phoneNum
     * @param courseId
     * @return
     */
    RestResp<GradeVo> selectGrade(String phoneNum, Integer courseId);

    /**
     * 查询所有成绩
     *
     * @param courseId
     * @return
     */
    RestResp<List<GradeVo>> selectAllGrade(Integer courseId);
}
