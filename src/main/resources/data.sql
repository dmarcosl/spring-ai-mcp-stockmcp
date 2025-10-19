INSERT INTO product (name, color, price) VALUES
('trousers', 'blue', 29.99),
('trousers', 'black', 34.99),
('trousers', 'pink', 24.50),
('skirt', 'blue', 29.99),
('skirt','black', 34.99),
('skirt', 'pink', 24.50);

INSERT INTO stock (product_id, quantity, location) VALUES
(1, 10, 'Warehouse A'),
(1, 3, 'Warehouse B'),
(1, 7, 'Warehouse C'),

(2, 8, 'Warehouse A'),
(2, 5, 'Warehouse B'),
(2, 12, 'Warehouse C'),

(3, 15, 'Warehouse A'),
(3, 2, 'Warehouse B'),
(3, 6, 'Warehouse C'),

(4, 9, 'Warehouse A'),
(4, 4, 'Warehouse B'),
(4, 11, 'Warehouse C'),

(5, 13, 'Warehouse A'),
(5, 1, 'Warehouse B'),
(5, 5, 'Warehouse C'),

(6, 6, 'Warehouse A'),
(6, 14, 'Warehouse B'),
(6, 3, 'Warehouse C');
