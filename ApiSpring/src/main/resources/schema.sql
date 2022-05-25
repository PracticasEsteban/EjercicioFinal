

-- Table: Friend
CREATE TABLE friend (
    id bigint auto_increment,
    user_send_id bigint NOT NULL,
    user_recive_id bigint NOT NULL,
    accept bool NOT NULL,
    date date NOT NULL,
    CONSTRAINT friend_pk PRIMARY KEY (id)
);

-- Table: Historieta
CREATE TABLE historieta (
    id bigint auto_increment,
    user_id bigint NOT NULL,
    text text NOT NULL,
    date date NOT NULL,
    CONSTRAINT historieta_pk PRIMARY KEY (id)
);

-- Table: Historieta_Estado
CREATE TABLE historieta_estado (
    id bigint auto_increment,
    historieta_id bigint NOT NULL,
    estado varchar(10) NOT NULL,
    user_id bigint NOT NULL,
    date date NULL,
    CONSTRAINT historieta_estado_pk PRIMARY KEY (id)
);

-- Table: User
CREATE TABLE user (
    id bigint auto_increment,
    name varchar(50) NOT NULL,
    surnames varchar(100) NOT NULL,
    email varchar(50) DEFAULT NULL,
    description varchar(300) NOT NULL,
    image varchar(100) NOT NULL,
    date date NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: Evento
CREATE TABLE evento (
    id bigint auto_increment,
    name varchar(50) NOT NULL,
    description varchar(300) NOT NULL,
    image blob NOT NULL,
    date date NOT NULL,
    CONSTRAINT evento_pk PRIMARY KEY (id)
);

-- Table: Evento User
CREATE TABLE evento_user (
    id bigint auto_increment,
    evento_id bigint NOT NULL,
    user_id bigint NOT NULL,
    date date NULL,
    CONSTRAINT evento_user_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Historieta_Historieta_Estado (table: Historieta_Estado)
ALTER TABLE historieta_estado ADD CONSTRAINT pk_historieta_estado FOREIGN KEY (historieta_id)
    REFERENCES historieta (id);

-- Reference: Historieta_User (table: Historieta)
ALTER TABLE historieta ADD CONSTRAINT historieta_user FOREIGN KEY (user_id)
    REFERENCES user (id);

-- Reference: User_Friend (table: Friend)
ALTER TABLE friend ADD CONSTRAINT user_friend FOREIGN KEY (user_recive_id)
    REFERENCES user (id);

-- Reference: User_Friend_Send (table: Friend)
ALTER TABLE friend ADD CONSTRAINT user_friend_send FOREIGN KEY (user_send_id)
    REFERENCES user (id);

-- Reference: User_Historieta_Estado (table: Historieta_Estado)
ALTER TABLE historieta_estado ADD CONSTRAINT user_historieta_estado FOREIGN KEY (user_id)
    REFERENCES user (id);

-- Reference: Evento_evento_user (table: Evento_User)
ALTER TABLE evento_user ADD CONSTRAINT evento_evento_user FOREIGN KEY (evento_id)
    REFERENCES evento (id);

-- Reference: User_evento_user (table: Evento_User)
ALTER TABLE evento_user ADD CONSTRAINT user_evento_user FOREIGN KEY (user_id)
    REFERENCES user (id);

-- End of file.

