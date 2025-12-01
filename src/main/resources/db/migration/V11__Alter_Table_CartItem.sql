ALTER TABLE cart_item
    DROP COLUMN price;

ALTER TABLE cart_item
    ADD price DECIMAL NOT NULL;