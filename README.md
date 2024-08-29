# JavaEE Transaction Course

This project aims to illustrate the different uses of transactions within JavaEE.

## Installation

### Docker
Run the Postgres and WebLogic containers

```
docker compose up -d
```

### WebLogic
Then create a new XA datasource for PostgreSQL:
- Go to the URL http://localhost.finbel.intra:7272/console
- In the `domain structure` tree on your left, select `services/datasources`
- Create a new generic datasource
- Enter `sandbox.transactionDatasource` both as name and JNDI name
- Select PostgreSQL as type
- There should be only one driver, the `Type 4` one. Select it.
- Check global transaction and then select `validation (commit) in one phase`
- Then you have to input the data for JDBC:
    - Database name: sandbox
    - Host name: db
    - Port: 5432
    - Username: javaee
    - Password: javaee
- Finally, test the connection to see if everything's ok

### The database
Using your favorite DB editor, create the table

```sql
create table tasks (
	id serial primary key,
	name varchar(255) not null,
	status varchar(255) not null
);
alter sequence tasks_id_seq increment by 5;
```

### Deploy the application
Launch:
```
mvn install -Pdeploy-local-docker
```
Be sure to launch it with powershell otherwise it will be painfully slow.