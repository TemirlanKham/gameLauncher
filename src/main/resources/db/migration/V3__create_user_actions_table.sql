
CREATE TABLE user_actions (
                              id BIGSERIAL  PRIMARY KEY,
                              user_id BIGSERIAL ,
                              game_id BIGSERIAL,
                              action_type VARCHAR(255) NOT NULL,
                              FOREIGN KEY (user_id) REFERENCES users(id),
                              FOREIGN KEY (game_id) REFERENCES game(id)
);