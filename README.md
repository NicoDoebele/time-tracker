# time-tracker

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
