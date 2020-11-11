-- 创建部门表
CREATE TABLE dep(
depid INT PRIMARY KEY AUTO_INCREMENT,
depname VARCHAR(50) NOT	NULL
);
-- 创建福利表
CREATE TABLE welfare(
wid INT PRIMARY KEY AUTO_INCREMENT,
wname VARCHAR(50) NOT NULL
);
-- 创建员工表
CREATE TABLE emp(
eid INT PRIMARY KEY AUTO_INCREMENT,
ename VARCHAR(50) NOT NULL,
sex VARCHAR(4) DEFAULT '男',
address VARCHAR(100),
birthday DATE,
photo VARCHAR(50),
depid INT NOT NULL,
CONSTRAINT fk_depid FOREIGN KEY(depid) REFERENCES dep(depid)
);
-- 创建薪资表（一对一关系）
CREATE TABLE salary(
sid INT PRIMARY KEY AUTO_INCREMENT,
eid INT NOT NULL UNIQUE,
emoney FLOAT,
CONSTRAINT fk_sa_eid FOREIGN KEY(eid) REFERENCES emp(eid)
);
-- 创建员工福利表
CREATE TABLE empwelfare(
ewid INT PRIMARY KEY AUTO_INCREMENT,
eid INT NOT NULL,
wid INT NOT NULL,
CONSTRAINT fk_ewf_eid FOREIGN KEY(eid) REFERENCES emp(eid),
CONSTRAINT fk_ewf_wid FOREIGN KEY(wid) REFERENCES welfare(wid)
);
-- 插入如初始化数据
INSERT INTO dep(depname) VALUES('技术部');
INSERT INTO dep(depname) VALUES('市场部');
INSERT INTO dep(depname) VALUES('行政部');
INSERT INTO dep(depname) VALUES('人事部');
INSERT INTO dep(depname) VALUES('研发部');
INSERT INTO dep(depname) VALUES('后勤部');

INSERT INTO welfare(wname) VALUES('住房补贴');
INSERT INTO welfare(wname) VALUES('交通费');
INSERT INTO welfare(wname) VALUES('差旅费');
INSERT INTO welfare(wname) VALUES('误餐费');
INSERT INTO welfare(wname) VALUES('加班费');
INSERT INTO welfare(wname) VALUES('降温费');
INSERT INTO welfare(wname) VALUES('取暖费');
INSERT INTO welfare(wname) VALUES('通讯费');

SELECT * FROM dep;
SELECT * FROM welfare;
-- 项目表之间的关系：部门表，员工表，员工福利表，薪水表，福利表