CREATE TABLE advert(
    advert_id INT PRIMARY KEY AUTO INCREMENT,
    advert_type VARCHAR(max) NOT NULL,
    title VARCHAR(max) NOT NULL,
    description VARCHAR(max) NOT NULL,
    owner_id INT NOT NULL FOREIGN KEY REFERENCES user(user_id) ON DELETE CASCADE,
    creation_date DATE NOT NULL,
    place_id INT NOT NULL
)