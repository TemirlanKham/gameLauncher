
CREATE TABLE users (
                       id BIGSERIAL  PRIMARY KEY,
                       name VARCHAR(20000),
                       username VARCHAR(20000) UNIQUE NOT NULL,
                       password VARCHAR(20000) NOT NULL,
                       email VARCHAR(20000) UNIQUE NOT NULL
);

CREATE TABLE users_roles (
                             user_id BIGSERIAL ,
                             role VARCHAR(20000) ,
                             FOREIGN KEY (user_id) REFERENCES users(id)
);
