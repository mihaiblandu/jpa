select COUNT(*) from (SELECT A.MY_IDA,A.STRA FROM ENTITYA as A INNER JOIN
                                                  MY_JOIN_TABLE as JOIN_Table on A.MY_IDA = JOIN_Table.MY_ENTITY_A_FK
                                                               inner join ENTITYB as B on B.MY_IDB = JOIN_Table.MY_ENTITY_B_FK
                      where A.STRA like 'B%' order by A.STRA ) as T;