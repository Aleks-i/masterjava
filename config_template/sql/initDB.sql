DROP TABLE IF EXISTS user_group;
DROP TABLE IF EXISTS groups;
DROP TABLE IF EXISTS projects;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS cities;
DROP SEQUENCE IF EXISTS user_seq;
DROP SEQUENCE IF EXISTS common_seq;
DROP TYPE IF EXISTS user_flag;
DROP TYPE IF EXISTS group_type;

CREATE TYPE user_flag AS ENUM ('active', 'deleted', 'superuser');
CREATE TYPE group_type AS ENUM ('REGISTERING', 'CURRENT', 'FINISHED');

CREATE SEQUENCE user_seq START 100000;
CREATE SEQUENCE common_seq START 100000;

CREATE TABLE cities (
                        id      TEXT PRIMARY KEY,
                        name    TEXT NOT NULL
);

CREATE TABLE users (
                       id        INTEGER PRIMARY KEY DEFAULT nextval('user_seq'),
                       full_name TEXT NOT NULL,
                       email     TEXT NOT NULL,
                       flag      user_flag NOT NULL,
                       city_id   TEXT NOT NULL,
                       FOREIGN KEY (city_id) REFERENCES cities (id)
);

CREATE UNIQUE INDEX email_idx ON users (email);

CREATE TABLE projects (
                          id          INTEGER PRIMARY KEY DEFAULT nextval('common_seq'),
                          name        TEXT UNIQUE NOT NULL,
                          description TEXT NOT NULL
);

CREATE TABLE groups (
                        id              INTEGER PRIMARY KEY DEFAULT nextval('common_seq'),
                        name            TEXT NOT NULL ,
                        type            group_type NOT NULL,
                        project_id      INTEGER NOT NULL,
                        FOREIGN KEY (project_id) REFERENCES projects (id)
);

CREATE TABLE user_group (
                            user_id     INTEGER NOT NULL,
                            group_id    INTEGER NOT NULL,
                            FOREIGN KEY (user_id) REFERENCES users (id),
                            FOREIGN KEY (group_id) REFERENCES groups (id)
);