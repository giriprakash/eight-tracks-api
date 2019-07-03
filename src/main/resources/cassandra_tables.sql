create key_space eight_tracks_key_space

create table tracks_metadata(
track_id String,
track_description String,
track_title String,
artists list<string>,
genre list<string>,
mood list<string>,
tags list<string>,
likes bigint,
no_of_plays bigint,
created_time timestamp,
created_by timestamp,
laste_update_time timestamp,
last_update_by string
PRIMARY((track_id),last_updated_time))
);

create table tracks_by_artist(
artist string,
track_id String,
track_title String,
likes bigint,
no_of_plays bigint,
last_update_time timestamp
PRIMARY KEY((artist),no_ok_plays,likes)
);

create table tracks_by_genre(
genre string,
track_id String,
track_title String,
likes bigint,
no_of_plays bigint,
last_update_time timestamp
PRIMARY KEY((genre),no_ok_plays,likes)
);

create table tracks_by_mood(
mood string,
track_id String,
track_title String,
likes bigint,
no_of_plays bigint,
last_update_time timestamp
PRIMARY KEY((mood),no_ok_plays,likes)
);

create table tracks_by_tag(
tag string,
track_id String,
track_title String,
likes bigint,
no_of_plays bigint,
last_update_time timestamp
PRIMARY KEY((tag),no_ok_plays,likes)
);

create table populr_tracks(
date Date,
track_id String,
track_description String,
track_title String,
artists list<string>,
genre list<string>,
mood list<string>,
tags list<string>,
likes bigint,
no_of_plays bigint,
created_time timestamp,
created_by timestamp,
laste_update_time timestamp,
last_update_by string
PRIMARY KEY((date),likes,no_of_plays))
);