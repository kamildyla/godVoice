DROP DATABASE IF EXISTS god_voice;

CREATE SCHEMA god_voice DEFAULT CHARACTER SET UTF8MB4;

USE god_voice;

DROP TABLE IF EXISTS volume;

CREATE TABLE volume(
   id				bigint		not null AUTO_INCREMENT,
   volume_number	int			not null,
   volume_name		VARCHAR(50)	not null,
   volume_short		VARCHAR(10)	not null,
   chapter_amount	int			not null,
   version			bigint		not null,
   create_date		datetime	not null,
   update_date		datetime	not null,
   PRIMARY KEY (id),
   UNIQUE INDEX uq_volume_volume_number (volume_number ASC)
  )
DEFAULT CHARACTER SET = utf8mb4;

DROP TABLE IF EXISTS chapter;

CREATE TABLE chapter(
   id				bigint		not null AUTO_INCREMENT,
   volume_no		int			not null,
   chapter			int			not null,
   verses			int			not null,
   version			bigint		not null,
   create_date		datetime	not null,
   update_date		datetime	not null,
   PRIMARY KEY (id),
   CONSTRAINT fk_chapter_volume FOREIGN KEY (volume_no) REFERENCES volume (volume_number)
   )
DEFAULT CHARACTER SET = utf8mb4;
