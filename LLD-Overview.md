+---------------------+       +-----------------------+
|  Angular Frontend   |       |  Security Layer       |
|                     |       |  (Spring Security,    |
|  - User Login       | ----> |   JWT Authentication) |
|  - Transaction Mgmt |       +-----------------------+
|  - Budget Tracking  |
+---------------------+
            |
            v
+-------------------------------------+
|          Spring Boot Backend        |
|                                     |
|  +-------------------------------+  |
|  |  Controller Layer             |  |
|  |  - Handles API requests       |  |
|  |  - Validates user inputs      |  |
|  +-------------------------------+  |
|              |                      |
|              v                      |
|  +-------------------------------+  |
|  |  Service Layer                |  |
|  |  - Business logic             |  |
|  |  - Manages transactions       |  |
|  |  - Handles categories, budget |  |
|  +-------------------------------+  |
|              |                      |
|              v                      |
|  +-------------------------------+  |
|  |  Repository Layer             |  |
|  |  - Uses JPA for database ops  |  |
|  |  - MySQL interaction          |  |
|  +-------------------------------+  |
+-------------------------------------+
            |
            v
+---------------------+       +-----------------------+
|       MySQL         |       |       Utilities       |
|  - Users Table      |       |  - Password Encoder   |
|  - Transactions     |       |  - Logging            |
|  - Categories       |       |  - Exception Handler  |
|  - Budgets          |       +-----------------------+
+---------------------+
