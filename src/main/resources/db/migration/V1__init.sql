CREATE TABLE IF NOT EXISTS client (
    id SERIAL,
    fullname VARCHAR(100) NOT NULL,
    address VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS product (
    id SERIAL,
    description VARCHAR(100) NOT NULL,
    brand VARCHAR(100) NOT NULL,
    price VARCHAR(100) NOT NULL,
    stock VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS invoice (
    id SERIAL,
    code VARCHAR(100) NOT NULL,
    create_at TIMESTAMP NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    clientID INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (clientID) REFERENCES client(id)
);


CREATE TABLE IF NOT EXISTS detail (
    id SERIAL,
    quantity VARCHAR(100) NOT NULL,
    price VARCHAR(100) NOT NULL,
    invoiceID INT NOT NULL,
    productID INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (invoiceID) REFERENCES invoice(id),
    FOREIGN KEY (productID) REFERENCES product(id)
);