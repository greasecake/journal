# School Journal
## Sample Spring Hibernate Project

Basic API for storing Groups, Subjects, Students, their schedules and grades.

### List of all methods
- ```/swagger-ui``` - use auto-generated swagger for the most up-to-date and precise info on available endpoints and controllers

### Groups and students
- ```/groups/all``` - list all avilable groups
- ```/students/all``` - list all available students

### Journal
- ```/journal``` - list all grades, sorted by date
- ```/journal/good``` - list only students with grades more than 3
- ```/journal?student_id={id}``` - list all grades for specific student, sorted by date

### Schedule
- ```/schedule``` - show schedule, sorted by group, day and time
- ```/schedule?group_id={id}``` - show schedule, for specific group
