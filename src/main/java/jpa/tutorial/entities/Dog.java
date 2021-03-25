package jpa.tutorial.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="DOG")
@SecondaryTables({
        @SecondaryTable(name="DOG_SECONDARY_A", pkJoinColumns={@PrimaryKeyJoinColumn(name="ID")}),
        @SecondaryTable(name="DOG_SECONDARY_B", pkJoinColumns={@PrimaryKeyJoinColumn(name="ID")})})
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private int age;
    private double weight;
}