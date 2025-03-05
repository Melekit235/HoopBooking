BEGIN;


CREATE TABLE IF NOT EXISTS public.courts
(
    court_id serial NOT NULL,
    city_id integer NOT NULL,
    court_type integer NOT NULL,
    court_adress "char" NOT NULL,
    PRIMARY KEY (c_id)
);

CREATE TABLE IF NOT EXISTS public.cities
(
    city_id serial NOT NULL,
    city_name "char" NOT NULL,
    PRIMARY KEY (city_id)
);

CREATE TABLE IF NOT EXISTS public.players
(
    player_id serial NOT NULL,
    first_name "char" NOT NULL,
    last_name "char" NOT NULL,
    email "char" NOT NULL,
    password_hash "char" NOT NULL,
    PRIMARY KEY (player_id)
);

CREATE TABLE IF NOT EXISTS public.court_types
(
    type_id serial NOT NULL,
    type "char" NOT NULL,
    PRIMARY KEY (type_id)
);

CREATE TABLE IF NOT EXISTS public.player_arrivals
(
    player_id integer NOT NULL,
    court_id integer NOT NULL,
    arrival_date date NOT NULL,
    start_time time without time zone[] NOT NULL,
    end_time time without time zone
);

CREATE TABLE IF NOT EXISTS public.favorites
(
    player_id integer NOT NULL,
    court_id integer NOT NULL
);

CREATE TABLE IF NOT EXISTS public.player_friends
(
    player_id integer NOT NULL,
    firend_id integer NOT NULL,
    friendship_date date NOT NULL
);

CREATE TABLE IF NOT EXISTS public.court_reviews
(
    review_id serial NOT NULL,
    cort_id integer NOT NULL,
    player_id integer NOT NULL,
    rating integer NOT NULL CHECK (rating BETWEEN 1 AND 5),
    review_text text,
    rewiew_date date,
    PRIMARY KEY (review_id)
);

ALTER TABLE IF EXISTS public.courts
    ADD FOREIGN KEY (city_id)
    REFERENCES public.cities (city_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.courts
    ADD FOREIGN KEY (court_type)
    REFERENCES public.court_types (type_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.player_arrivals
    ADD FOREIGN KEY (player_id)
    REFERENCES public.players (player_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.player_arrivals
    ADD FOREIGN KEY (court_id)
    REFERENCES public.courts (court_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.favorites
    ADD FOREIGN KEY (player_id)
    REFERENCES public.players (player_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.favorites
    ADD FOREIGN KEY (court_id)
    REFERENCES public.courts (court_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.player_friends
    ADD FOREIGN KEY (player_id)
    REFERENCES public.players (player_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.player_friends
    ADD FOREIGN KEY (firend_id)
    REFERENCES public.players (player_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.court_reviews
    ADD FOREIGN KEY (cort_id)
    REFERENCES public.courts (court_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;


ALTER TABLE IF EXISTS public.court_reviews
    ADD FOREIGN KEY (player_id)
    REFERENCES public.players (player_id) MATCH SIMPLE
    ON UPDATE NO ACTION
    ON DELETE NO ACTION
    NOT VALID;

END;