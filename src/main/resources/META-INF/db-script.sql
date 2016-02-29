create database location character set utf8 COLLATE utf8_general_ci ;
USE location ;

CREATE  TABLE IF NOT EXISTS location.loc (
  loc_id INT NOT NULL AUTO_INCREMENT,
  loc_latitude NUMERIC,
  loc_longitude NUMERIC,
  loc_horizontalAccuracy NUMERIC,
  loc_speed NUMERIC,
  loc_course NUMERIC,
  loc_altitude NUMERIC,
  loc_verticalAccuracy NUMERIC,
  loc_actuality VARCHAR(45),
  loc_timestamp BIGINT,
  PRIMARY KEY (loc_id) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;