CREATE TABLE IF NOT EXISTS orders (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(120) NOT NULL,
    quantity INT NOT NULL,
    id_transaction VARCHAR(36)  NULL,
    pod_name VARCHAR(30) NOT NULL
);