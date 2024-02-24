-- spring_app_dev.`user` definition

create table if not exists `user` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_time` datetime NOT NULL,
  `email` varchar(45) NOT NULL,
  `fname` varchar(45) NOT NULL,
  `gender` varchar(255) NOT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `is_enabled` bit(1) DEFAULT NULL,
  `lname` varchar(45) NOT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `user_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_589idila9li6a4arw1t8ht1gx` (`phone`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- spring_app_dev.`role` definition

create table if not exists `role` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- spring_app_dev.user_role definition

create table if not exists `user_role` (
  `role_id` bigint DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- spring_app_dev.user_seq_gen definition

create table if not exists `user_seq_gen` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- spring_app_dev.address definition

create table if not exists `address` (
  `id` bigint NOT NULL,
  `area` varchar(100) NOT NULL,
  `city` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `created_time` datetime NOT NULL,
  `pincode` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- spring_app_dev.address_seq_gen definition

create table if not exists `address_seq_gen` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- spring_app_dev.corporate definition

create table if not exists `corporate` (
  `id` bigint NOT NULL,
  `client_spoc_email` varchar(100) NOT NULL,
  `client_spoc_name` varchar(255) NOT NULL,
  `client_spoc_phone` varchar(15) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_time` datetime NOT NULL,
  `gst` varchar(100) NOT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_hcv8ag5wvc1yd8f1j3jlr7ouc` (`client_spoc_email`),
  UNIQUE KEY `UK_3b3idai0e1uyf26e4hqhhxq4m` (`client_spoc_phone`),
  UNIQUE KEY `UK_lc0dw1vn4e0fjmd3rs5gcdg76` (`gst`),
  UNIQUE KEY `UK_6oc60mpjoxotb9j5wqop3mpey` (`name`),
  KEY `FKohbawqx667tq1qkxi1nwvk6ou` (`address_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- spring_app_dev.corporate_domain definition

create table if not exists `corporate_domain` (
  `id` bigint NOT NULL,
  `name` varchar(50) NOT NULL,
  `corporate_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2461sng9ry2k5nljqplltj3vx` (`corporate_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- spring_app_dev.corporate_domain_seq_gen definition

create table if not exists `corporate_domain_seq_gen` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- spring_app_dev.corporate_employee definition

create table if not exists `corporate_employee` (
  `corporate_id` bigint DEFAULT NULL,
  `employee_id` bigint NOT NULL,
  PRIMARY KEY (`employee_id`),
  KEY `FKbhcw47pa1igwywmhdmjc7jfgk` (`corporate_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- spring_app_dev.badge definition

create table if not exists `badge` (
  `id` bigint NOT NULL,
  `image` mediumblob NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- spring_app_dev.checkpoint_reviewer definition

create table if not exists `checkpoint_reviewer` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_time` datetime NOT NULL,
  `email` varchar(255) NOT NULL,
  `frequency` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `reviewer_role` varchar(255) NOT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `engagement_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9wku2pi94ynjs1e1qgan5i5fb` (`engagement_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- spring_app_dev.checkpoint_reviewer_seq_gen definition

create table if not exists `checkpoint_reviewer_seq_gen` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- spring_app_dev.allot_group_badge definition

create table if not exists `allot_group_badge` (
  `team_id` bigint NOT NULL,
  `badge_id` bigint NOT NULL,
  PRIMARY KEY (`team_id`,`badge_id`),
  UNIQUE KEY `UK_1l7goyu1fng5omw3c3gpft6i0` (`badge_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- spring_app_dev.allot_individual_badge definition

create table if not exists `allot_individual_badge` (
  `user_id` bigint NOT NULL,
  `badge_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`badge_id`),
  UNIQUE KEY `UK_57mhsu9d35naegy1w1m10ccfi` (`badge_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- spring_app_dev.engagement definition

create table if not exists `engagement` (
  `id` bigint NOT NULL,
  `client_spoc_email` varchar(100) NOT NULL,
  `client_spoc_name` varchar(255) NOT NULL,
  `client_spoc_phone` varchar(15) NOT NULL,
  `contract_amount` double NOT NULL,
  `is_deleted` bit(1) DEFAULT NULL,
  `service_offering` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `corporate_id` bigint DEFAULT NULL,
  `engagement_manager_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKpur0c0id4spriax7b4ujl5cgr` (`corporate_id`),
  KEY `FKltpvc6noiq7csfpdpfj2gvmnl` (`engagement_manager_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- spring_app_dev.module definition

create table if not exists `module` (
  `id` bigint NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- spring_app_dev.engagement_module definition

create table if not exists `engagement_module` (
  `engagement_id` bigint NOT NULL,
  `module_id` bigint NOT NULL,
  KEY `FKig2b08kchp6e93vvh0iirpcjv` (`module_id`),
  KEY `FK2708qd6qc5trbyjlvayrpbokb` (`engagement_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- spring_app_dev.engagement_status definition

create table if not exists `engagement_status` (
  `id` bigint NOT NULL,
  `actual_end_date` datetime DEFAULT NULL,
  `actual_start_date` datetime DEFAULT NULL,
  `completion_status` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `planned_end_date` datetime NOT NULL,
  `planned_start_date` datetime NOT NULL,
  `sign_off_status` varchar(255) DEFAULT NULL,
  `stage_id` tinyint NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `engagement_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK639rflq5nqawu4rqirhotyxs8` (`engagement_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



-- spring_app_dev.engagement_status_seq_gen definition

create table if not exists `engagement_status_seq_gen` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- spring_app_dev.engagement_seq_gen definition

create table if not exists `engagement_seq_gen` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- spring_app_dev.team definition

create table if not exists `team` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_time` datetime NOT NULL,
  `is_deleted` bit(1) NOT NULL,
  `name` varchar(45) NOT NULL,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_g2l9qqsoeuynt4r5ofdt1x2td` (`name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- spring_app_dev.team_seq_gen definition

create table if not exists `team_seq_gen` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- spring_app_dev.team_idea_selection definition

create table if not exists `team_idea_selection` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) NOT NULL,
  `created_time` datetime NOT NULL,
  `ideate` bit(1) NOT NULL,
  `project_identification` bit(1) NOT NULL,
  `prototype_phase` bit(1) NOT NULL,
  `test_phase` bit(1) NOT NULL,
  `updated_by` varchar(255) NOT NULL,
  `updated_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- spring_app_dev.team_idea_selection_seq_gen definition

create table if not exists `team_idea_selection_seq_gen` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- spring_app_dev.team_virtual_wall_ideas definition

create table if not exists `team_virtual_wall_ideas` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- spring_app_dev.team_ideas definition

create table if not exists `team_ideas` (
  `id` bigint NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `created_time` datetime NOT NULL,
  `ideate` varchar(255) NOT NULL,
  `prototype_phase` text,
  `test_phase` text,
  `updated_by` varchar(255) DEFAULT NULL,
  `updated_time` datetime DEFAULT NULL,
  `team_id` bigint DEFAULT NULL,
  `team_idea_selection_id` bigint DEFAULT NULL,
  `team_virtual_wall_ideas_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKohm0edfui4s5ttsb1qgvmuf38` (`team_id`),
  KEY `FKicf92v2wkb8huvqukceedyw5u` (`team_idea_selection_id`),
  KEY `FK5lh790klop8uyqd9wpqijjm8h` (`team_virtual_wall_ideas_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- spring_app_dev.team_member definition

create table if not exists `team_member` (
  `team_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`team_id`,`user_id`),
  UNIQUE KEY `UK_5cxwd5p05k1umbxdo1t50xhfy` (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
