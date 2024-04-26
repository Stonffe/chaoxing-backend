package com.example.exam.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname: CourseList
 * @Author: Stonffe
 * @Date: 2024/4/17 16:04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("course_list")
public class CourseList {
    @TableId(type = IdType.AUTO)
    private Integer courseListId;
    private String title;
    private Integer courseId;
    private String url;
}
