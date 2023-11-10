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
    productID INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (productID ) REFERENCES product(id)
);

