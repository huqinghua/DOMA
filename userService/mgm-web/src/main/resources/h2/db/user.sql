CREATE TABLE user(
  id            BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
  name      VARCHAR(100) NOT NULL DEFAULT '' COMMENT 'name',
  pwd      VARCHAR(100) NOT NULL DEFAULT '' COMMENT 'password',
  PRIMARY KEY (id)
) COMMENT ='user';