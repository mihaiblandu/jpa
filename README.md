# jpa
| JPA         | Hibernate|
|-------------|----------|
|It is just a specification. | It is one of the most frequently used JPA implementation.|
|The EntityManagerFactory interface is used to interact with the entity manager factory for the persistence unit. Thus, it provides an entity manager.|It uses SessionFactory interface to create Session instances.|
| It uses Java Persistence Query Language (JPQL)| It uses Hibernate Query Language (HQL) |



Eager Loading When you are sure that want to get multiple entities at a time, for example you have to show user, and user details at the same page, then you should go with eager loading. Eager loading makes single hit on database and load the related entities.

Lazy loading When you have to show users only at the page, and by clicking on users you need to show user details then you need to go with lazy loading. Lazy loading make multiple hits, to get load the related entities when you bind/iterate related entities.
        
        import lombok.Data;

        import javax.persistence.*;
        import java.util.List;

        @Entity
        @Data
        public class EntityA {
            @Id
            @GeneratedValue
            private int myIdA;
            private String strA;
            //@JoinTable is compose name of the table, joinColumns and inverseJoinColumns
            //@JoinColumn is composed by name, referencedColumnName and insertable = false, updatable = false,;
            @OneToMany
            @JoinTable(name = "MY_JOIN_TABLE",
                joinColumns = {@JoinColumn(name = "MY_ENTITY_A_FK", referencedColumnName = "myIdA")},
                inverseJoinColumns = {@JoinColumn(name = "MY_ENTITY_B_FK", referencedColumnName = "myIdB")}
            )
            private List<EntityB> entityBList;
        }


        @Entity
        @Data
        public class EntityB {
            @Id
            @GeneratedValue
            private int myIdB;
            private String strB;
            @ManyToOne            
            //@JoinTable is compose name of the table, joinColumns and inverseJoinColumns
            //@JoinColumn is composed by name and referencedColumnName;
            @JoinTable(name = "MY_JOIN_TABLE",
                joinColumns = {@JoinColumn(name = "MY_ENTITY_B_FK", insertable = false,
                updatable = false, referencedColumnName = "myIdB")},
                inverseJoinColumns = {@JoinColumn(name = "MY_ENTITY_A_FK", insertable = false,
                updatable = false, referencedColumnName = "myIdA")}
            )
            private EntityA refEntityA;
        }
