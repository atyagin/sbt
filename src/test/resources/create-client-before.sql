
insert into client (id, name, security_social_number)
    values (1, 'client1-tst', '75849367-d2ad-4c2d-8f77-b70921bf08c2'),
    (2, 'client2-tst', 'b3eb9af2-cf38-48b4-a673-0ae574446787'),
    (3, 'client3-tst', '73565f9d-ec9c-49d1-adf9-1db7d29bb260');

insert into order_table (id, description, responsible, client_id)
    values (1, 'desc1-tst', 'something', 1), (2, 'desc2-tst', 'some', 1), (3, 'desc3-tst', 'sm', 2);