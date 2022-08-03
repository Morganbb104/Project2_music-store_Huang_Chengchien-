use music_store_catalog;

insert into artist(`name`, instagram, twitter)values
    ('Cheng', '@cheng', '@cheng'),
    ('Andrew', '@andrew', '@andrew'),
	('Stone', '@stone', '@stone');

insert into label(`name`, website) values
    ('Cheng label','www.cheng.com.tw'),
    ('Andrew label','www.andrew.com'),
    ('Stone label','www.stone.com');

insert into album(title, artist_id, release_date, label_id, list_price)values
    ('Fairy tale', 1, '2022-08-02', 2, 19.99),
    ('Stone rack', 2, '2022-08-01', 3, 29.99),
    ('Andrew star',3, '2022-08-03', 1, 39.99);

insert into track(album_id, title, run_time) values
    (1, 'Mountain Monster', 120),
    (2, 'Freaking drinks', 130),
    (3, 'Wonder island', 150),
    (1, 'Endless ego', 140),
    (2, 'Best scenario', 100),
    (3, 'Long meditation', 120);