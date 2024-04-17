
## 1数据库设计
### 1.1用户（user）

- id（userId int 11）
- username（varchar 10）
- phoneNum（char 11）
- password（varchar 20）

### 1.2课程对应人物（课程/班级）(course)

- id（courseId int 11）
- name（课程名字 varchar 255
- 课程对应图片url（varchar 255）
- phoneNum
- role （1创建者， 0学生，int）
### 学习记录表(learn_record)

- id（learnRecordId int 11）
- 课程id（courseId int 11）
- type #未归范（1题，0视频，int)
- 用户名称（phoneNum varchar 10）
- isOver  （1完成， 0未完成， int) detail：对应课时完成情况
### 1.3课时列表（每一门课对应的课时）（course_list）

- id（courseListId int 11）
- title（varchar 255）
- courseID //课程id

### 1.4某个课程（1.3对应）某个章节对应题（课时题）（question	）
#### 选择题

- id（questionId int 11）
- title（题目 varchar 255
- 课时列表对应id （courseListId int 11）
- A （optionA varchar 255）
- B（optionB varchar 255）
- C（optionC varchar 255）
- D（optionD varchar 255）
- answer(答案 char 1）
- kind （判断选择还是判断 int类型 1 选择 0判断
#### 判断

- id
- title（题目
- 课时列表对应id
- 对（right int 1）
- 错（error int 1）
- answer
- kind （判断选择还是判断 int类型 1 选择 0判断
### 用户答题记录（answer_record）

- id（answerRecordId int 11）
- userID（userId int 11）
- 课时题id （对应1.4 questionId int 11）
- answer（用户选择答案 char 1）
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
# 2接口

## 2.1个人信息

### 2.1.1登录

- api
（/login， post， {phoneNum:  Str, password: Str }，
- return 
   - Result(code:  msg: data: Map<String, Object> map) 
      - map :key
      - Jwt: token
      - url:  //图片
      - username:  //用户名字

### 2.1.2注册

- api
（/register, post, {phoneNum： str, username : str, ps : str},
- return 
   - Result(code 200:  msg:“success” data: null)

### 2.1.3 修改密码

- api
（/modifyPasword, post, {phoneNum： str, ps : str},
- return 
   - Result(code 200:  msg:“success” data: null)

## 2.3课程

### 2.3.1

- api

(/joinClass, get, /key="")

- return 
   - Result(code 200:  msg:“success” data: null)

## 2.3.2

- api
(/getClass, get, /phone=""/role="(0 1, int)")
- return 
   - Result(code 200:  msg:“success” data: List)

# 学习记录

## 查询

- api
(/getLearnRecord, Get, /phoneNum=""/type="(0 1, int)/course")
- return 
   - Result(code 200:  msg:“success” data: List)


