CREATE TABLE freeze_points(
  id            BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
  user_id      BIGINT(20) NOT NULL DEFAULT '' COMMENT 'userId',
  freeze_point      INTEGER NOT NULL DEFAULT 0 COMMENT 'point',
  del          BOOLEAN NOT NULL DEFAULT FALSE COMMENT 'point',
  PRIMARY KEY (id)
) COMMENT ='freeze_points';