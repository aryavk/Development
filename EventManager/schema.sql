CREATE TABLE state
(
    id TINYINT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL DEFAULT "",
    description VARCHAR(128) NOT NULL DEFAULT "",
    PRIMARY KEY (id)
)engine=INNODB charset=UTF8;

INSERT INTO state VALUES (1, 'NSW', 'New South Wales');
INSERT INTO state VALUES (2, 'QLD', 'Queensland');
INSERT INTO state VALUES (3, 'VIC', 'Victoria');
INSERT INTO state VALUES (4, 'TAS', 'Tasmania');
INSERT INTO state VALUES (5, 'SA', 'South Australia');
INSERT INTO state VALUES (6, 'WA', 'Western Australia');
INSERT INTO state VALUES (7, 'NT', 'Northern Territory');
INSERT INTO state VALUES (8, 'ACT', 'Australian Capital Territory');

CREATE TABLE industry
(
    id TINYINT(3) UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL DEFAULT "",
    PRIMARY KEY (id)
)engine=INNODB charset=UTF8;

CREATE TABLE event
(
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    name VARCHAR(128) NOT NULL DEFAULT "",
    industry_id TINYINT(3) UNSIGNED NOT NULL DEFAULT 0,
    location VARCHAR(128) DEFAULT NULL,
    state_id TINYINT(10) UNSIGNED NOT NULL DEFAULT 0,
    venue VARCHAR(128) DEFAULT NULL,
    website VARCHAR(256) DEFAULT NULL,
    from_date TIMESTAMP NULL DEFAULT NULL,
    to_date TIMESTAMP NULL DEFAULT NULL,
    attending BOOLEAN NOT NULL DEFAULT FALSE,
    responsible_people TEXT DEFAULT NULL,
    pros TEXT DEFAULT NULL,
    cons TEXT DEFAULT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_event_industry FOREIGN KEY (industry_id) REFERENCES industry(id),
    CONSTRAINT fk_event_state FOREIGN KEY (state_id) REFERENCES state(id)
)engine=INNODB charset=UTF8;

CREATE TABLE user
(
    id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(64) NOT NULL DEFAULT "",
    password VARCHAR(128) NOT NULL DEFAULT "",
    enabled BOOLEAN NOT NULL DEFAULT FALSE,
    PRIMARY KEY (id),
    UNIQUE (username)
)engine=INNODB charset=UTF8;

CREATE TABLE user_role 
(
  id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  user_id INT(10) UNSIGNED NOT NULL DEFAULT 0,
  user_role VARCHAR(32) NOT NULL DEFAULT '',
  PRIMARY KEY (id),
  UNIQUE KEY (user_id, user_role),
  CONSTRAINT fk_user_role_user FOREIGN KEY (user_id) REFERENCES user (id)
)engine=INNODB charset=UTF8;
 
INSERT INTO user(username, password, enabled) VALUES ('arya', MD5('Aryavali1'),1);
INSERT INTO user(username, password, enabled) VALUES ('joanne', MD5('ILov3YoU'),1);
INSERT INTO user(username, password, enabled) VALUES ('cathy', MD5('Cathy1'),1);
 
INSERT INTO user_role(user_id, user_role) SELECT id, 'ROLE_ADMIN' FROM user;

INSERT INTO industry (name) VALUES
('Automotive and Transportation'),
('Chemical'),
('Dealer, Reseller'),
('E+H Companies'),
('E+H Representatives'),
('Education, Universities, Consultants'),
('Food & Beverage'),
('Life Sciences'),
('Marine Business'),
('Metal'),
('Multi Industry Plant & Machinery Construction'),
('Multi Industry System Integrator'),
('Not assigned'),
('Oil & Gas'),
('Power & Energy'),
('Primaries'),
('Pulp & Paper (incl. Printing)'),
('Renewable Energy'),
('Textile, Leather, Wood'),
('Unknown'),
('Waste Water'),
('Water (Drinking, Surface and Process)');