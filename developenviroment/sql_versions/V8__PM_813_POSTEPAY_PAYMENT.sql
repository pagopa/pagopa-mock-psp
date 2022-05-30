INSERT INTO config(property_key, property_value)
VALUES ('POSTEPAY_PAYMENT_OUTCOME', 'OK');

INSERT INTO config(property_key, property_value)
VALUES ('POSTEPAY_PAYMENT_TIMEOUT_MS', '1');

INSERT INTO config(property_key, property_value)
VALUES ('POSTEPAY_REDIRECT_URL', 'http://localhost:8080');

CREATE TABLE payment_postepay(
	id SERIAL PRIMARY KEY,
	outcome varchar(5) not null,
	shop_transaction_id varchar(128) not null,
	payment_id varchar(128) not null
);

GRANT all privileges
ON payment_postepay
TO azureuser, mock_psp_user;

GRANT all privileges ON SEQUENCE payment_postepay_id_seq TO azureuser, mock_psp_user;