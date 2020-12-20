CREATE TABLE points(
  id            BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
  user_id      BIGINT(20) NOT NULL DEFAULT '' COMMENT 'userId',
  point      INTEGER NOT NULL DEFAULT 0 COMMENT 'point',
  PRIMARY KEY (id)
) COMMENT ='points';