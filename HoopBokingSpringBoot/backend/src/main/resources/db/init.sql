BEGIN;


CREATE TABLE IF NOT EXISTS public.cities
(
    city_id integer NOT NULL,
    city_name character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT cities_pkey PRIMARY KEY (city_id)
);

CREATE TABLE IF NOT EXISTS public.court_reviews
(
    review_id serial NOT NULL,
    court_id integer NOT NULL,
    player_id integer NOT NULL,
    review_text text COLLATE pg_catalog."default",
    review_date date,
    CONSTRAINT court_reviews_pkey PRIMARY KEY (review_id)
);

CREATE TABLE IF NOT EXISTS public.court_types
(
    type_id integer NOT NULL,
    type character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT court_types_pkey PRIMARY KEY (type_id)
);

CREATE TABLE IF NOT EXISTS public.courts
(
    court_id serial NOT NULL,
    city_id integer NOT NULL,
    court_type integer NOT NULL,
    court_address character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT courts_pkey PRIMARY KEY (court_id)
);

CREATE TABLE IF NOT EXISTS public.favorites
(
    player_id integer NOT NULL,
    court_id integer NOT NULL
);

CREATE TABLE IF NOT EXISTS public.player_arrivals
(
    player_id integer NOT NULL,
    court_id integer NOT NULL,
    arrival_date date NOT NULL,
    start_time time without time zone NOT NULL,
    end_time time without time zone
);

CREATE TABLE IF NOT EXISTS public.player_friends
(
    player_id integer NOT NULL,
    friend_id integer NOT NULL,
    friendship_date date NOT NULL
);

CREATE TABLE IF NOT EXISTS public.players
(
    player_id serial NOT NULL,
    first_name character varying COLLATE pg_catalog."default" NOT NULL,
    last_name character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    password_hash character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT players_pkey PRIMARY KEY (player_id)
);

ALTER TABLE IF EXISTS public.court_reviews
    ADD CONSTRAINT court_reviews_court_id_fkey FOREIGN KEY (court_id)
    REFERENCES public.courts (court_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.court_reviews
    ADD CONSTRAINT court_reviews_player_id_fkey FOREIGN KEY (player_id)
    REFERENCES public.players (player_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.courts
    ADD CONSTRAINT courts_city_id_fkey FOREIGN KEY (city_id)
    REFERENCES public.cities (city_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.courts
    ADD CONSTRAINT courts_court_type_fkey FOREIGN KEY (court_type)
    REFERENCES public.court_types (type_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.favorites
    ADD CONSTRAINT favorites_court_id_fkey FOREIGN KEY (court_id)
    REFERENCES public.courts (court_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.favorites
    ADD CONSTRAINT favorites_player_id_fkey FOREIGN KEY (player_id)
    REFERENCES public.players (player_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.player_arrivals
    ADD CONSTRAINT player_arrivals_court_id_fkey FOREIGN KEY (court_id)
    REFERENCES public.courts (court_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.player_arrivals
    ADD CONSTRAINT player_arrivals_player_id_fkey FOREIGN KEY (player_id)
    REFERENCES public.players (player_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.player_friends
    ADD CONSTRAINT player_friends_friend_id_fkey FOREIGN KEY (friend_id)
    REFERENCES public.players (player_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;


ALTER TABLE IF EXISTS public.player_friends
    ADD CONSTRAINT player_friends_player_id_fkey FOREIGN KEY (player_id)
    REFERENCES public.players (player_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE CASCADE;





INSERT INTO public.cities (city_id, city_name)
SELECT 1, 'New York' WHERE NOT EXISTS (SELECT 1 FROM public.cities WHERE city_name = 'New York')
UNION ALL
SELECT 2, 'Zhodino' WHERE NOT EXISTS (SELECT 1 FROM public.cities WHERE city_name = 'Zhodino')
UNION ALL
SELECT 3, 'Los Angeles' WHERE NOT EXISTS (SELECT 1 FROM public.cities WHERE city_name = 'Los Angeles')
UNION ALL
SELECT 4, 'Chicago' WHERE NOT EXISTS (SELECT 1 FROM public.cities WHERE city_name = 'Chicago')
UNION ALL
SELECT 5, 'Oklahoma' WHERE NOT EXISTS (SELECT 1 FROM public.cities WHERE city_name = 'Oklahoma')
UNION ALL
SELECT 6, 'Phoenix' WHERE NOT EXISTS (SELECT 1 FROM public.cities WHERE city_name = 'Phoenix')
UNION ALL
SELECT 7, 'New Orleans' WHERE NOT EXISTS (SELECT 1 FROM public.cities WHERE city_name = 'New Orleans')
UNION ALL
SELECT 8, 'San Francisco' WHERE NOT EXISTS (SELECT 1 FROM public.cities WHERE city_name = 'San Francisco')
UNION ALL
SELECT 9, 'Detroit' WHERE NOT EXISTS (SELECT 1 FROM public.cities WHERE city_name = 'Detroit')
UNION ALL
SELECT 10, 'Memphis' WHERE NOT EXISTS (SELECT 1 FROM public.cities WHERE city_name = 'Memphis')
UNION ALL
SELECT 11, 'Boston' WHERE NOT EXISTS (SELECT 1 FROM public.cities WHERE city_name = 'Boston')
UNION ALL
SELECT 12, 'Cleveland' WHERE NOT EXISTS (SELECT 1 FROM public.cities WHERE city_name = 'Cleveland');


INSERT INTO public.court_types (type_id, type)
SELECT 1, 'Indoor' WHERE NOT EXISTS (SELECT 1 FROM public.court_types WHERE type = 'Indoor')
UNION ALL
SELECT 2, 'Outdoor' WHERE NOT EXISTS (SELECT 1 FROM public.court_types WHERE type = 'Outdoor')
UNION ALL
SELECT 3, 'Street' WHERE NOT EXISTS (SELECT 1 FROM public.court_types WHERE type = 'Street')