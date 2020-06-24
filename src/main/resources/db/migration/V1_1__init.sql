INSERT INTO cab(driver, cab_number, location, created)
VALUES ('Raju', 'MH-14-CD-1212', 'Pimpri', now()),
	   ('Rajesh', 'MH-12-EF-4212', 'Nigdi', now()),
       ('Rahul', 'MH-14-GH-1213', 'Baner', now()),
       ('Aman', 'MH-14-IK-1332', 'Aundh', now()),
       ('Suresh', 'MH-12-MN-3442', 'Katraj', now())
ON CONFLICT (id) DO NOTHING;