CREATE OR REPLACE TABLE product(
    id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    p_description VARCHAR(200) NOT NULL,
    number_of_searches BIGINT UNSIGNED NOT NULL DEFAULT 0,
    images VARCHAR(512) NOT NULL,
    PRIMARY KEY(id)
);

CREATE OR REPLACE TABLE category(
    id VARCHAR(40) NOT NULL,
    PRIMARY KEY(id)
);

CREATE OR REPLACE TABLE productxcategory(
    product_id BIGINT UNSIGNED NOT NULL,
    category_id VARCHAR(40) NOT NULL,
    PRIMARY KEY (product_id, category_id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

CREATE OR REPLACE TABLE country(
    id VARCHAR(100) NOT NULL,
    maximum_discount_percentage FLOAT NOT NULL,
    currency_abbreviation VARCHAR(20) NOT NULL,
    currency_symbol VARCHAR(5) NOT NULL,
    PRIMARY KEY(id)
);

CREATE OR REPLACE TABLE productxcountry(
    product_id BIGINT UNSIGNED NOT NULL,
    country_id VARCHAR(100) NOT NULL,
    price FLOAT UNSIGNED NOT NULL,
    discount_percentage FLOAT UNSIGNED NOT NULL,
    price_after_discount FLOAT UNSIGNED NOT NULL,
    PRIMARY KEY (product_id, country_id),
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (country_id) REFERENCES country(id)
);