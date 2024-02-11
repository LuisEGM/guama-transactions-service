# Guama Transactions Service

### Description
It is a REST API that allows the management of test transactions for guama platform.

### Utilities
- Create a transaction
- List all transactions
- Update a transaction
- Delete a transaction

### Resources
Website to generate sample data: [https://www.mockaroo.com/1aea1f10](https://www.mockaroo.com/1aea1f10)

### Error Handling
| Title | Description | Code |
| --- | --- | --- |
| InvalidDateFormatException | The date %s does not have the format ISO 8601 | GUAMA-TS-001 |
| InvalidDateFormatException | The page number can't be less than zero | GUAMA-TS-002 |
| PageSizeCanNotBeLessThanZeroException | The page size can't be less than zero | GUAMA-TS-003 |
| SortDirectionIsInvalidException | The sort direction %s isn't valid direction, use asc or desc | GUAMA-TS-004 |
| TransactionNameCanNotBeNullOrEmptyException | The transaction name can not be null or empty exception | GUAMA-TS-005 |
| TransactionStatusCanNotBeNullOrEmptyAndShouldValidException | The transaction status cannot be null or empty and must be PAID, PENDING or DECLINED | GUAMA-TS-006 |
| TransactionAmountCanNotBeNullOrLessThanZeroException | The transaction amount can't be null or less than zero | GUAMA-TS-007 |
| TransactionDateCanNotBeNullOrEmptyException | The transaction date can not be null or empty exception | GUAMA-TS-008 |
| TransactionNotFound | The transaction with id <%d> was not found | GUAMA-TS-009 |

### Initial dataset
```sql
insert into transactions (id, name, amount, status, date) values (1, 'rutrum at lorem integer', 518627.8, 'REJECTED', '2023-04-04 08:36:11');
insert into transactions (id, name, amount, status, date) values (2, 'vestibulum ac est lacinia', 294122.6, 'PAID', '2023-01-21 02:06:49');
insert into transactions (id, name, amount, status, date) values (3, 'lacinia erat', 140456.61, 'PAID', '2023-07-26 18:29:14');
insert into transactions (id, name, amount, status, date) values (4, 'mauris sit amet eros', 502787.67, 'PENDING', '2023-10-15 21:19:15');
insert into transactions (id, name, amount, status, date) values (5, 'suscipit nulla elit ac', 636293.28, 'PAID', '2023-10-06 07:05:31');
insert into transactions (id, name, amount, status, date) values (6, 'maecenas ut', 811974.89, 'REJECTED', '2023-08-14 16:51:41');
insert into transactions (id, name, amount, status, date) values (7, 'nonummy maecenas tincidunt lacus', 870643.75, 'PAID', '2023-01-29 14:05:43');
insert into transactions (id, name, amount, status, date) values (8, 'urna pretium', 740861.96, 'PAID', '2023-01-09 02:14:41');
insert into transactions (id, name, amount, status, date) values (9, 'luctus cum sociis', 789569.88, 'PAID', '2023-01-20 11:25:21');
insert into transactions (id, name, amount, status, date) values (10, 'posuere metus', 676985.68, 'PAID', '2023-05-16 19:09:43');
insert into transactions (id, name, amount, status, date) values (11, 'duis bibendum', 600573.77, 'PAID', '2023-06-29 05:13:57');
insert into transactions (id, name, amount, status, date) values (12, 'ut erat', 381184.59, 'PAID', '2023-08-18 05:49:46');
insert into transactions (id, name, amount, status, date) values (13, 'lorem vitae mattis', 424356.77, 'PENDING', '2023-02-22 02:56:04');
insert into transactions (id, name, amount, status, date) values (14, 'lectus aliquam sit', 389144.16, 'REJECTED', '2023-11-15 03:06:58');
insert into transactions (id, name, amount, status, date) values (15, 'porttitor lorem id', 332663.89, 'REJECTED', '2023-07-17 18:58:32');
insert into transactions (id, name, amount, status, date) values (16, 'justo nec condimentum neque', 623394.57, 'PAID', '2023-05-22 15:33:46');
insert into transactions (id, name, amount, status, date) values (17, 'mattis egestas metus aenean', 545136.63, 'PAID', '2023-09-25 07:21:41');
insert into transactions (id, name, amount, status, date) values (18, 'dui vel sem', 516636.78, 'PENDING', '2023-08-21 04:48:45');
insert into transactions (id, name, amount, status, date) values (19, 'in lectus pellentesque at', 427786.32, 'REJECTED', '2023-07-06 22:53:41');
insert into transactions (id, name, amount, status, date) values (20, 'vestibulum rutrum rutrum', 668264.5, 'PENDING', '2023-07-06 05:11:12');
insert into transactions (id, name, amount, status, date) values (21, 'eu orci mauris', 601490.62, 'REJECTED', '2023-03-28 11:25:50');
insert into transactions (id, name, amount, status, date) values (22, 'ligula nec', 536568.14, 'PENDING', '2023-08-14 09:09:32');
insert into transactions (id, name, amount, status, date) values (23, 'faucibus cursus urna ut', 857942.83, 'PAID', '2023-03-18 05:57:00');
insert into transactions (id, name, amount, status, date) values (24, 'leo pellentesque ultrices mattis', 747332.0, 'PAID', '2023-05-13 06:25:02');
insert into transactions (id, name, amount, status, date) values (25, 'elementum pellentesque quisque', 119810.04, 'PAID', '2023-09-20 03:53:15');
insert into transactions (id, name, amount, status, date) values (26, 'quis tortor id', 715172.08, 'PAID', '2023-06-20 03:01:34');
insert into transactions (id, name, amount, status, date) values (27, 'condimentum curabitur in', 717127.91, 'PENDING', '2023-01-05 04:09:02');
insert into transactions (id, name, amount, status, date) values (28, 'consectetuer adipiscing elit proin', 607049.67, 'PAID', '2023-03-10 01:18:20');
insert into transactions (id, name, amount, status, date) values (29, 'ac nulla', 484687.04, 'PENDING', '2023-06-20 10:04:30');
insert into transactions (id, name, amount, status, date) values (30, 'volutpat quam pede', 936382.3, 'PENDING', '2023-11-20 17:22:37');
insert into transactions (id, name, amount, status, date) values (31, 'et magnis', 120217.22, 'REJECTED', '2023-12-04 12:53:11');
insert into transactions (id, name, amount, status, date) values (32, 'sit amet justo', 836310.94, 'REJECTED', '2023-02-18 23:19:05');
insert into transactions (id, name, amount, status, date) values (33, 'platea dictumst aliquam augue', 921164.5, 'PENDING', '2023-09-22 12:08:26');
insert into transactions (id, name, amount, status, date) values (34, 'maecenas leo odio condimentum', 485532.07, 'PAID', '2023-03-27 05:53:54');
insert into transactions (id, name, amount, status, date) values (35, 'turpis enim', 476313.11, 'PENDING', '2023-07-16 04:42:51');
insert into transactions (id, name, amount, status, date) values (36, 'sed vestibulum sit amet', 517389.18, 'PAID', '2023-09-15 06:53:09');
insert into transactions (id, name, amount, status, date) values (37, 'diam nam tristique tortor', 914354.29, 'PAID', '2023-10-31 19:16:42');
insert into transactions (id, name, amount, status, date) values (38, 'nulla elit ac nulla', 147093.87, 'PENDING', '2023-12-13 20:23:52');
insert into transactions (id, name, amount, status, date) values (39, 'dignissim vestibulum vestibulum', 109190.2, 'PENDING', '2023-07-30 18:34:20');
insert into transactions (id, name, amount, status, date) values (40, 'felis eu', 360217.18, 'PAID', '2023-03-01 10:17:21');
insert into transactions (id, name, amount, status, date) values (41, 'at feugiat non', 289593.9, 'REJECTED', '2023-04-21 14:51:37');
insert into transactions (id, name, amount, status, date) values (42, 'in blandit ultrices', 770638.56, 'REJECTED', '2023-12-12 06:54:00');
insert into transactions (id, name, amount, status, date) values (43, 'mauris laoreet ut rhoncus', 462960.88, 'REJECTED', '2023-04-06 10:51:55');
insert into transactions (id, name, amount, status, date) values (44, 'platea dictumst aliquam', 351265.43, 'PAID', '2023-05-01 21:54:17');
insert into transactions (id, name, amount, status, date) values (45, 'donec vitae nisi', 423955.46, 'PAID', '2023-04-15 21:26:51');
insert into transactions (id, name, amount, status, date) values (46, 'rutrum ac lobortis vel', 571103.19, 'PENDING', '2023-01-18 09:44:41');
insert into transactions (id, name, amount, status, date) values (47, 'faucibus orci luctus', 808627.33, 'REJECTED', '2023-01-07 15:10:57');
insert into transactions (id, name, amount, status, date) values (48, 'lectus suspendisse potenti in', 940889.86, 'PENDING', '2023-05-07 20:10:29');
insert into transactions (id, name, amount, status, date) values (49, 'tincidunt lacus at velit', 985012.28, 'PAID', '2023-04-02 18:23:08');
insert into transactions (id, name, amount, status, date) values (50, 'velit id pretium iaculis', 479356.58, 'REJECTED', '2023-09-02 00:05:26');
```
