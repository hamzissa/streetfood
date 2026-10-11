# Street Food Directory

A Spring Boot web application for browsing and managing street food vendors, built for the CO2123 module at the University of Leicester.

## Features

- Create, edit and delete vendors, dishes, reviews, photos and awards
- Vendor profiles with bio, social media handle and website
- Dishes with price, spice level and tags (e.g. "Vegetarian", "Hidden Gem", "Spicy Challenge")
- Search vendors by name or by dish (case-insensitive)
- Server-side validation, including a check for duplicate vendor names
- Sample data loaded on startup so the app is ready to explore

## Tech Stack

- Java 21
- Spring Boot 3 (Spring MVC, Spring Data JPA, Validation)
- MySQL
- JSP / JSTL views
- Gradle

## Data Model

| Entity | Relationships |
|---|---|
| `Vendor` | one-to-one `VendorProfile`, one-to-many `Dish`, `Photo`, `Award` |
| `Dish` | many-to-one `Vendor`, one-to-many `Review`, many-to-many `Tag` |
| `Review` | many-to-one `Dish` |

## Running Locally

1. Start a local MySQL server and create the database:
   ```sql
   CREATE DATABASE co2123db;
   ```
2. Check the connection settings in `src/main/resources/application.properties` (defaults: user `root`, password `root`, port `3306`).
3. Run the app:
   ```bash
   ./gradlew bootRun
   ```
4. Open http://localhost:8080

The schema is created on startup and dropped on shutdown (`ddl-auto=create-drop`), so the sample data is reset every run.

## Project Structure

```
src/main/java/co2123/streetfood/
├── controller/   # Request handling, forms, search, validation
├── model/        # JPA entities
└── repository/   # Spring Data repositories
src/main/webapp/WEB-INF/views/   # JSP pages and forms
```
