Flyway supports the following basic commands to manage database migrations.
    
    Info: Prints current status/version of a database schema. 
    It prints which migrations are pending, which migrations 
    have been applied, what is the status of applied migrations 
    and when they were applied.


    Migrate: Migrates a database schema to the current version. 
    It scans the classpath for available migrations and applies pending migrations.

    Baseline: Baselines an existing database, excluding all migrations, 
    including baselineVersion. Baseline helps to start with Flyway in 
    an existing database. Newer migrations can then be applied normally.

    Validate: Validates current database schema against available migrations.

    Repair: Repairs metadata table.

    Clean: Drops all objects in a configured schema. 
    All database objects are dropped. Of course, you should never 
    use clean on any production database.
