INSERT INTO users (username, password, enabled)
    values ('user',
    'pass',
    true);
INSERT INTO users (username, password, enabled)
    values ('admin',
    'pass',
    true);

INSERT INTO authorities (username, authority)
    values ('user', 'ROLE_USER');
INSERT INTO authorities (username, authority)
    values ('admin', 'ROLE_ADMIN');

INSERT INTO coupon (code) VALUES ('ABC123');
INSERT INTO coupon (code) VALUES ('XYZ789');