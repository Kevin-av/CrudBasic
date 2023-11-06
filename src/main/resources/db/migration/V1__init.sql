CREATE TABLE IF NOT EXISTS product (
    id SERIAL,
    description VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS ventas (
    id SERIAL,
    description VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    product_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id ) REFERENCES product(id)
);

