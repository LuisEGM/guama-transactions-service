# Guama Transactions Service

### Description
It is a REST API that allows the management of test transactions for guama platform.

### Image
- Docker images available in: [guama-transaction-service](https://hub.docker.com/r/gamezluisdev/guama-transactions-service)

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
