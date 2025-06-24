# Deep Understanding Of Repositories
Repository
   ↑
CrudRepository
   ↑
PagingAndSortingRepository
   ↑
JpaRepository

# 🧬 JPA Entity Lifecycle — Deep Dive Project

This project explains and demonstrates the **lifecycle of JPA/Hibernate entities** from creation to deletion. It shows how entities transition through different states such as `NEW`, `MANAGED`, `DETACHED`, and `REMOVED`, with real code examples and console logs.

---

## 📌 Key Concepts Covered

| Lifecycle State | Description |
|-----------------|-------------|
| `NEW`           | Entity is created with `new` but not yet saved |
| `MANAGED`       | Entity is tracked by the persistence context |
| `DETACHED`      | Entity is disconnected from the persistence context |
| `REMOVED`       | Entity is marked for deletion |
| `MERGED`        | A detached entity is reattached to the context |

---
# 🔗 Spring Boot Entity Relationship Demo

This project demonstrates all major **JPA/Hibernate entity relationships** with real-world use cases, such as:

- 🧍‍♂️ One-to-One
- 🧑‍🏫 One-to-Many & Many-to-One
- 👨‍🎓 Many-to-Many
- 🔁 Bidirectional vs Unidirectional
- ⚙️ `mappedBy`, `@JoinColumn`, `cascade`, and more

---

## 📌 Relationship Types Covered

| Relationship     | Annotation(s)                                 | Example              |
|------------------|-----------------------------------------------|----------------------|
| One-to-One       | `@OneToOne`, `@JoinColumn`                    | User → Profile       |
| One-to-Many      | `@OneToMany(mappedBy = "...")`                | Author → Books       |
| Many-to-One      | `@ManyToOne`, `@JoinColumn`                   | Book → Author        |
| Many-to-Many     | `@ManyToMany`, `@JoinTable`, `mappedBy`       | Student ↔ Course     |
| Bidirectional    | Entity A ↔ Entity B with `mappedBy`           | Full navigation      |
| Unidirectional   | One side references the other only            | Simplified navigation|

---
# 🧬 JPA Inheritance Mapping Demo

This Spring Boot project demonstrates how to implement **JPA inheritance** using all three strategies supported by Hibernate:

- 🗃️ `SINGLE_TABLE`
- 🧩 `JOINED`
- 📄 `TABLE_PER_CLASS`

It includes annotated examples with `@Inheritance`, `@DiscriminatorColumn`, and real-life entity structures like `User`, `Admin`, and `Customer`.

---

## 📌 Key Concepts

| Strategy           | Description                                     | When to Use                      |
|--------------------|-------------------------------------------------|----------------------------------|
| `SINGLE_TABLE`      | All classes stored in one table with null columns | High performance, simple schema |
| `JOINED`            | Normalized structure with foreign key joins    | Clean DB design, less nulls     |
| `TABLE_PER_CLASS`   | Each class has its own table                   | Small class trees, no joins     |

---


