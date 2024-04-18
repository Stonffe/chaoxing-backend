package com.example.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname: SelectedCourses
 * @Author: Stonffe
 * @Date: 2024/4/18 16:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("selected_courses")
public class SelectedCourses {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer courseId;
    private String phoneNum;
}
