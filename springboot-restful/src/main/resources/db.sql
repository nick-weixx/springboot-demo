CREATE DATABASE /*!32312 IF NOT EXISTS*/ `blog` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `blog`;
-- Dumping structure for table concretepage.articles
CREATE TABLE `articles` (
  `article_id` int(5) NOT NULL AUTO_INCREMENT COMMENT '自增的文章编号',
  `title` varchar(200) NOT NULL DEFAULT '' COMMENT '标题',
  `category` varchar(100) NOT NULL DEFAULT '' COMMENT '类别',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
-- Dumping data for table concretepage.articles: ~3 rows (approximately)
INSERT INTO `articles` (`article_id`, `title`, `category`) VALUES
	(1, 'Java Concurrency', 'Java'),
	(2, 'Hibernate HQL ', 'Hibernate'),
	(3, 'Spring MVC with Hibernate', 'Spring'); 