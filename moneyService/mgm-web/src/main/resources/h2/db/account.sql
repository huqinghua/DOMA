CREATE TABLE account (
  id            BIGINT(20)   NOT NULL AUTO_INCREMENT COMMENT '主键',
  user_id      BIGINT(20)  NOT NULL DEFAULT '' COMMENT 'userId',
  currency DECIMAL(18, 2) NOT NULL DEFAULT '' COMMENT 'currency',
  PRIMARY KEY (id)
) COMMENT ='account';