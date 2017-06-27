/*
Navicat PGSQL Data Transfer

Source Server         : myprogress
Source Server Version : 90309
Source Host           : localhost:5432
Source Database       : STUDENT_DB
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90309
File Encoding         : 65001

Date: 2017-06-27 08:33:12
*/


-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS "public"."users";
CREATE TABLE "public"."users" (
"id" int4 DEFAULT nextval('users_id_seq'::regclass) NOT NULL,
"username" varchar(100) COLLATE "default",
"email" varchar(100) COLLATE "default",
"gender" varchar(1) COLLATE "default",
"phonenumber" varchar(100) COLLATE "default",
"status" varchar(1) COLLATE "default",
"user_hash" varchar(100) COLLATE "default",
"created_date" timestamp(6)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO "public"."users" VALUES ('1', 'Pheng', 'chanpheng123@gmail.com', 'M', '069659998', '1', 'sahkfhkfkashflh-dsgsd-gssd', '2017-06-23 00:00:00');
INSERT INTO "public"."users" VALUES ('2', 'Sokheang', 'kheang@gmail.com', 'M', '022121332', '0', 'sdggsdgsdgs-dssggsgs-sfgsg', '2017-06-23 00:00:00');
INSERT INTO "public"."users" VALUES ('3', 'Mouy Kea', 'Kea@gmail.com', 'F', '023435255', '1', 'saafsfafafsaf-egehehggf-esfsgf', '2017-06-23 00:00:00');
INSERT INTO "public"."users" VALUES ('9', 'sss', 'sss', 'F', '4', '0', 'dsdfsfdsgsg', '2017-06-23 16:32:19.669');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table users
-- ----------------------------
ALTER TABLE "public"."users" ADD PRIMARY KEY ("id");
