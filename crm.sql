#drop database ssh_crm;
create database ssh_crm;
use ssh_crm;
#课程类型表
create table crm_lessonType(
  lessonTypeID varchar(50) not null primary key,  #主键ID
  lessonCost double null , #课程费用
  total int null, #总课时
  lessonName varchar(500) ,#课程名称
  remark varchar(5000) null # 课程介绍
);

#班级表
create table crm_class(
  classID varchar(50) not null primary key , #主键ID
  name varchar(50)  ,#班级名称
  beginTime datetime  , #开班时间
  endTime datetime  ,#毕业时间
  state varchar(20) ,#状态(未开课、已开课、已结束)
  totalCount int, #学生总数
  goCount int , #升学数
  leaveCount int, #留班数
  remark varchar(500),  # 备注
  lessonTypeID varchar(50), #所属课程ID (课程的外键),
  uploadFileName varchar(100),	#上传课表名称
  uploadPath varchar(200)	#上传课表位置
);

### 班级表与课程类型表(多对一) 主外键约束 
alter table crm_class add constraint foreign key(lessonTypeID) references crm_lessonType(lessonTypeID);


#部门表
create table crm_department(
 depID varchar(50) not null primary key, #主键
 depName varchar(50) # 部门名称
);

#职务表
create table crm_post(
  postID varchar(50) not null primary key , # 主键id
  name varchar(100) , # 职务名称
  depID varchar(50) #部门id
);

### 职务表与部门表 (多对一) 主外键约束
alter table crm_post add constraint foreign key (depID) references crm_department(depID);

#员工表
create table crm_staff(
  staffID varchar(50) not null primary key,
  staffCode varchar(50) , #员工编号
  loginName varchar(100) , #登录名
  loginPwd varchar(100),  #密码
  staffName varchar(100) , #员工名称
  gender varchar(20) , # 性别
  birthday datetime ,#出生日期
  onDutyDate datetime , #入职时间
  postID varchar(50) #职务ID ，外键
);

### 员工表 与 职务表 (多对一) 主外键关系
alter table crm_staff add constraint foreign key(postID) references crm_post(postID);


insert into crm_department(depID,depName) values('1','Java教研部');
insert into crm_department(depID,depName) values('2','PHP教研部');
insert into crm_department(depID,depName) values('3','财务部');
insert into crm_department(depID,depName) values('4','学工部');
insert into crm_department(depID,depName) values('5','咨询部');


insert into crm_post(postID,name,depID) values('1','教学总监','1');
insert into crm_post(postID,name,depID) values('2','讲师','1');



insert into crm_staff(staffID,loginName,loginPwd) values('1','jack',md5('1234'));
## 81dc9bdb52d04dc20036dbd8313ed055

 















