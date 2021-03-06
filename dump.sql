SET DB_CLOSE_DELAY -1;         
;              
CREATE USER IF NOT EXISTS "SA" SALT '57deabbb2ce9a3dc' HASH '6ccd55dcfe640f31ec9d0e4a620ff6cae3ac7e2b9c641b910304131fd3af4df3' ADMIN;          
CREATE SEQUENCE "PUBLIC"."HIBERNATE_SEQUENCE" START WITH 1;    
CREATE MEMORY TABLE "PUBLIC"."flyway_schema_history"(
    "installed_rank" INT NOT NULL,
    "version" VARCHAR(50),
    "description" VARCHAR(200) NOT NULL,
    "type" VARCHAR(20) NOT NULL,
    "script" VARCHAR(1000) NOT NULL,
    "checksum" INT,
    "installed_by" VARCHAR(100) NOT NULL,
    "installed_on" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    "execution_time" INT NOT NULL,
    "success" BOOLEAN NOT NULL
);         
ALTER TABLE "PUBLIC"."flyway_schema_history" ADD CONSTRAINT "PUBLIC"."flyway_schema_history_pk" PRIMARY KEY("installed_rank"); 
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.flyway_schema_history;    
INSERT INTO "PUBLIC"."flyway_schema_history" VALUES
(-1, NULL, '<< Flyway Schema History table created >>', 'TABLE', '', NULL, 'SA', TIMESTAMP '2021-03-23 22:12:23.627903', 0, TRUE);         
CREATE INDEX "PUBLIC"."flyway_schema_history_s_idx" ON "PUBLIC"."flyway_schema_history"("success");            
CREATE MEMORY TABLE "PUBLIC"."DATABASECHANGELOGLOCK"(
    "ID" INT NOT NULL,
    "LOCKED" BOOLEAN NOT NULL,
    "LOCKGRANTED" TIMESTAMP,
    "LOCKEDBY" VARCHAR(255)
);        
ALTER TABLE "PUBLIC"."DATABASECHANGELOGLOCK" ADD CONSTRAINT "PUBLIC"."PK_DATABASECHANGELOGLOCK" PRIMARY KEY("ID");             
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.DATABASECHANGELOGLOCK;    
INSERT INTO "PUBLIC"."DATABASECHANGELOGLOCK" VALUES
(1, FALSE, NULL, NULL);    
CREATE MEMORY TABLE "PUBLIC"."DATABASECHANGELOG"(
    "ID" VARCHAR(255) NOT NULL,
    "AUTHOR" VARCHAR(255) NOT NULL,
    "FILENAME" VARCHAR(255) NOT NULL,
    "DATEEXECUTED" TIMESTAMP NOT NULL,
    "ORDEREXECUTED" INT NOT NULL,
    "EXECTYPE" VARCHAR(10) NOT NULL,
    "MD5SUM" VARCHAR(35),
    "DESCRIPTION" VARCHAR(255),
    "COMMENTS" VARCHAR(255),
    "TAG" VARCHAR(255),
    "LIQUIBASE" VARCHAR(20),
    "CONTEXTS" VARCHAR(255),
    "LABELS" VARCHAR(255),
    "DEPLOYMENT_ID" VARCHAR(10)
);               
-- 1 +/- SELECT COUNT(*) FROM PUBLIC.DATABASECHANGELOG;        
INSERT INTO "PUBLIC"."DATABASECHANGELOG" VALUES
('raw', 'includeAll', 'db/changelog/changes/schema.sql', TIMESTAMP '2021-03-23 22:12:25.028845', 1, 'EXECUTED', '8:d0391b3bdd0ad38468e918baf3fd2e10', 'sql', '', NULL, '3.10.3', NULL, NULL, '6530344959');    
CREATE MEMORY TABLE "PUBLIC"."user"(
    "ID" VARCHAR(255) NOT NULL,
    "NAME" VARCHAR(50) NOT NULL
);        
ALTER TABLE "PUBLIC"."user" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_3" PRIMARY KEY("ID");          
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.user;     
CREATE MEMORY TABLE "PUBLIC"."CUSTOMER"(
    "CUST_ID" BIGINT NOT NULL,
    "FIRST_NAME" VARCHAR(50),
    "LAST_NAME" VARCHAR(50) NOT NULL,
    "STREET" VARCHAR(255)
);       
ALTER TABLE "PUBLIC"."CUSTOMER" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_5" PRIMARY KEY("CUST_ID"); 
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.CUSTOMER; 
CREATE MEMORY TABLE "PUBLIC"."DATASET"(
    "ID" INTEGER NOT NULL,
    "SET" VARCHAR(255)
);   
ALTER TABLE "PUBLIC"."DATASET" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8" PRIMARY KEY("ID");       
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.DATASET;  
CREATE MEMORY TABLE "PUBLIC"."INVOICE"(
    "INVOICE_ID" BIGINT NOT NULL,
    "AMOUNT_DUE" DOUBLE,
    "ORDER_CANCELLED_DT" TIMESTAMP,
    "ORDER_RAISED_DT" TIMESTAMP,
    "ORDER_SETTLED_DT" TIMESTAMP,
    "UPDATED_TIME" TIMESTAMP,
    "ORDER_ORDER_ID" BIGINT NOT NULL
);
ALTER TABLE "PUBLIC"."INVOICE" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_9" PRIMARY KEY("INVOICE_ID");               
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.INVOICE;  
CREATE MEMORY TABLE "PUBLIC"."ORDERS"(
    "ORDER_ID" BIGINT NOT NULL,
    "TOT_PRICE" DOUBLE,
    "CUSTOMER_CUST_ID" BIGINT NOT NULL
);       
ALTER TABLE "PUBLIC"."ORDERS" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_8B" PRIMARY KEY("ORDER_ID"); 
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.ORDERS;   
CREATE MEMORY TABLE "PUBLIC"."ORDERS_PRODUCT_LIST"(
    "ORDER_LIST_ORDER_ID" BIGINT NOT NULL,
    "PRODUCT_LIST_PROD_ID" BIGINT NOT NULL
);   
-- 0 +/- SELECT COUNT(*) FROM PUBLIC.ORDERS_PRODUCT_LIST;      
CREATE MEMORY TABLE "PUBLIC"."PRODUCT"(
    "PROD_ID" BIGINT NOT NULL,
    "PRICE" VARCHAR(255),
    "PROD_DESCRIPTION" VARCHAR(200),
    "PROD_NAME" VARCHAR(50) NOT NULL,
    "UPDATED_TIME" TIMESTAMP
);    
ALTER TABLE "PUBLIC"."PRODUCT" ADD CONSTRAINT "PUBLIC"."CONSTRAINT_1" PRIMARY KEY("PROD_ID");  
-- 2 +/- SELECT COUNT(*) FROM PUBLIC.PRODUCT;  
INSERT INTO "PUBLIC"."PRODUCT" VALUES
(1, '10000', 'car', 'vw', TIMESTAMP '2021-03-23 00:00:00'),
(2, '10000', 'car', 'opel', TIMESTAMP '2021-03-23 00:00:00');
ALTER TABLE "PUBLIC"."INVOICE" ADD CONSTRAINT "PUBLIC"."UK_H4TK8HSURO0XX6O9CX9SP33X9" UNIQUE("ORDER_ORDER_ID");
ALTER TABLE "PUBLIC"."ORDERS_PRODUCT_LIST" ADD CONSTRAINT "PUBLIC"."FK9M8G4G3AK9KRWDLRJ5UL4SQJ2" FOREIGN KEY("PRODUCT_LIST_PROD_ID") REFERENCES "PUBLIC"."PRODUCT"("PROD_ID") NOCHECK;         
ALTER TABLE "PUBLIC"."INVOICE" ADD CONSTRAINT "PUBLIC"."FKMAE3V19CV44X3V6E4UMFYFHS0" FOREIGN KEY("ORDER_ORDER_ID") REFERENCES "PUBLIC"."ORDERS"("ORDER_ID") NOCHECK;           
ALTER TABLE "PUBLIC"."ORDERS_PRODUCT_LIST" ADD CONSTRAINT "PUBLIC"."FK84X21B9JHRX703AFY0UD9MYD7" FOREIGN KEY("ORDER_LIST_ORDER_ID") REFERENCES "PUBLIC"."ORDERS"("ORDER_ID") NOCHECK;          
ALTER TABLE "PUBLIC"."ORDERS" ADD CONSTRAINT "PUBLIC"."FKA01L1VSYM35WKE0PXYK432LNA" FOREIGN KEY("CUSTOMER_CUST_ID") REFERENCES "PUBLIC"."CUSTOMER"("CUST_ID") NOCHECK;         
