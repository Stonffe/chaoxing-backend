## 1数据库设计
### 1.1用户

- id
- username
- phoneNum
- password

### 1.2课程对应人物（课程/班级）

- id
- name（课程名字
- phoneNum
- role （1创建者， 0学生，int）
### 1.3课时列表（每一门课对应的课时

- id
- name
- courseID //课时id

### 1.4某个课程（1.3对应）某个章节对应题（课时题
#### 选择题

- id
- title（题目
- 课时列表对应id
- A
- B
- C
- D
- answer(答案）
- kind （判断选择还是判断 int类型 1 选择 0判断
#### 判断

- id
- title（题目
- 课时列表对应id
- 对
- 错
- answer
- kind （判断选择还是判断 int类型 1 选择 0判断
### 用户答题记录

- id
- userID
- 课时题id （对应1.4
- answer（用户选择答案
- istrue （0err 1true int）
### 
# 基本功能

- 登录
- 创建课程
- 加入课程
- 答题（也是考试
- 用户答题情况
- 管理员/老师创建题
## 视频

- 上传视频
- 记录看视频



