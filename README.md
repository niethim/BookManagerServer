# BookManager

### User story:
- As a library owner, I want to view all the books in my library, including book categories, book titles, authors, and other relevant information.
- As a library owner, I want to be able to fully manage all books in the library (create, update, delete, etc.).
- As a library owner, I want the system to be secure so that unauthorized users cannot access or manipulate the system.
- As a library owner, I want to view the most popular books among customers and see visualized statistics.
- As a customer, I want to access the system, search for books, and add books to my list of favorite books.
- As a guest, I want to be able to search and view books in the library without logging into the system.

### Endpoint:

- Stats
  - `GET api/stats`
- Books
  - `GET api/books`
  - `POST api/books`
  - `DELETE api/books`
  - `GET api/books/{BookID}`
  - `PUT api/books/{BookID}`
- Categories
  - `GET api/categories`
  - `POST api/categories`
- Users
  - FavBooks:
    - `GET api/users/{UserID}`
    - `POST api/users/{UserID}/favbooks`
    - `DELETE api/users/{UserID}/favbooks/{BookID}`
  - `GET api/users`
  - `POST api/users`
- Borrows
  - `GET api/borrows`
  - `POST api/borrows`
  - `DELETE api/borrows`
