ALTER TABLE order_shopping
    ADD transaction_code UUID;

ALTER TABLE order_shopping
    ALTER COLUMN transaction_code SET NOT NULL;

ALTER TABLE order_shopping
    ADD CONSTRAINT uc_ordershopping_transactioncode UNIQUE (transaction_code);

ALTER TABLE order_shopping
    DROP COLUMN status;

ALTER TABLE order_shopping
    ADD status VARCHAR(255);