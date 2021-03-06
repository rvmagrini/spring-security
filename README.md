# Spring Security
## Basic Tutorial for Spring Security

## Process:

### 1: [INITIALIZING]
TASKS:
- [1.1] Create Spring Boot Project and build API
- [1.2] Add Spring Security and test Login

### 2: [BASIC AUTH]
TASKS:
- [2.1] Implement Basic Auth 
- [2.2] Add AntMatchers to whitelist URLs 

### 3: [USERS]
TASKS:
- [3.1] Create User
- [3.2] Encode Password

### 4: [ROLES AND PERMISSIONS/AUTHORITIES]
TASKS:
- [4.1] Create Admin User
- [4.2] Create Roles and Permissions using Enums
- [4.3] Implement Role Based Authentication

### 5: [PERMISSION BASED AUTHENTICATION]
TASKS:
- [5.1] Disable Cross Site Request Forgery (CSRF), build and test fake Management API
- [5.2] Implement Permission based Authentication using AntMatchers
- [5.3] Implement Permission based Authentication using PreAuthorize Annotation
- [5.4] Generate CSRF Token to Frontend as Cookie
- [5.5] Disable CSRF

### 6: [FORM BASED AUTHENTICATION]
TASKS:
- [6.1] Switch to Form Based Auth
- [6.2] Customize Login Page
- [6.3] Redirect after success Login
- [6.4] Implement Remember me option
- [6.5] Extend Session of Remember me
- [6.6] Implement Logout and clear Cookies

### 7: [DATABASE AUTHENTICATION]
TASKS:
- [7.1] Create UserDetails Class to construct Users
- [7.2] Implement Service to fetch Users data from fake DB

### 8: [JSON WEB TOKENS]
TASKS:
- [8.1] Add Java JWT Library dependencies
- [8.2] Fetch and validate credentials sent from Client
- [8.3] Generate Token and provide it as response
- [8.4] Implement stateless Authentication Filter
- [8.5] Have the server validate the Token and send the resource requested back

