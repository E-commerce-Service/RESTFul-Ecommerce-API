ALTER TABLE order_item
    DROP COLUMN price;

ALTER TABLE order_item
    ADD price DECIMAL;