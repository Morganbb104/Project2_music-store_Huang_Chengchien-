use music_store_recommendations;
insert into label_recommendation(label_id, user_id, liked ) values
    (1,1,true),
    (1,2,false),
    (1,3,false),
    (2,1,true),
    (3,1,true);
insert into artist_recommendation (artist_id, user_id, liked ) values
    (1,1,false),
    (1,2,true),
    (1,3,true),
    (2,1,false),
    (3,1,true);
    insert into album_recommendation (album_id, user_id, liked ) values
    (1,1,true),
    (1,2,true),
    (1,3,true),
    (2,1,false),
    (3,1,true);
    insert into track_recommendation (track_id, user_id, liked ) values
    (1,1,false),
    (1,2,true),
    (1,3,false),
    (2,1,false),
    (3,1,true);