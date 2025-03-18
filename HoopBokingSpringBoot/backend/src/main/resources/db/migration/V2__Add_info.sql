INSERT INTO public.cities (city_id, city_name)
SELECT * FROM (VALUES (1, 'New York'), (2, 'Los Angeles'), (3, 'Chicago')) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM public.cities);

INSERT INTO public.court_types (type_id, type)
SELECT * FROM (VALUES (1, 'Indoor'), (2, 'Outdoor'), (3, 'Street')) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM public.court_types);

INSERT INTO public.players (player_id, first_name, last_name, email, password_hash)
SELECT * FROM (VALUES 
    (1, 'John', 'Doe', 'john@example.com', 'hash1'),
    (2, 'Jane', 'Smith', 'jane@example.com', 'hash2'),
    (3, 'Mike', 'Brown', 'mike@example.com', 'hash3')
) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM public.players);

INSERT INTO public.courts (court_id, city_id, court_type, court_address)
SELECT * FROM (VALUES 
    (1, 1, 1, '123 Main St'),
    (2, 2, 2, '456 Park Ave'),
    (3, 3, 3, '789 Sunset Blvd')
) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM public.courts);

INSERT INTO public.court_reviews (court_id, player_id, review_text, review_date)
SELECT * FROM (VALUES 
    (1, 1, 'Great court!', '2025-03-01'::DATE),
    (2, 2, 'Needs maintenance', '2025-03-02'::DATE),
    (3, 3, 'Perfect for games', '2025-03-03'::DATE)
) AS tmp(court_id, player_id, review_text, review_date)
WHERE NOT EXISTS (SELECT 1 FROM public.court_reviews);

INSERT INTO public.favorites (player_id, court_id)
SELECT * FROM (VALUES (1, 1), (2, 2), (3, 3)) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM public.favorites);

INSERT INTO public.player_arrivals (player_id, court_id, arrival_date, start_time, end_time)
SELECT * FROM (VALUES 
    (1, 1, '2025-03-01'::DATE, '10:00:00'::TIME, '12:00:00'::TIME),
    (2, 2, '2025-03-02'::DATE, '14:00:00'::TIME, '16:00:00'::TIME),
    (3, 3, '2025-03-03'::DATE, '18:00:00'::TIME, '20:00:00'::TIME)
) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM public.player_arrivals);

INSERT INTO public.player_friends (player_id, friend_id, friendship_date)
SELECT * FROM (VALUES 
    (1, 2, '2025-03-01'::DATE),
    (2, 3, '2025-03-02'::DATE),
    (3, 1, '2025-03-03'::DATE)
) AS tmp
WHERE NOT EXISTS (SELECT 1 FROM public.player_friends);