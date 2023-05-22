# time-tracker

The Time Tracker Project is a web application that helps users effectively manage their time and improve productivity. It features a Java Spring backend and an Angular frontend for a seamless user experience. Users can create shifts and log in when they start working and log out when they finish. The application allows for better organization and tracking of shifts, enabling users to optimize their work schedules and enhance their time management skills.

### Start Server
```bash
cd server
gradle bootRun
```

### RESTAPI
#### Persons

##### GET
Get all Persons
```bash
http://localhost:8080/getallpersons
```

Get Person by ID
```bash
http://localhost:8080/persons/{id}
```
#### POST
Create a new Person
```bash
http://localhost:8080/persons
```

#### PUT
Update Person
```bash
http://localhost:8080/persons/{id}
```

#### Delete Person
```bash
http://localhost:8080/persons/{id}
```

#### Shift

##### GET
Get all Shifts
```bash
http://localhost:8080/getallshifts
```

Get Shift by ID
```bash
http://localhost:8080/shifts/{id}
```
#### POST
Create a new Shift
```bash
http://localhost:8080/shifts
```

#### PUT
Update Shift
```bash
http://localhost:8080/shifts/{id}
```

#### Delete Shift
```bash
http://localhost:8080/shifts/{id}
```
