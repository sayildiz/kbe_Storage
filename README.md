# kbe_Storage

## Usage

### Alongside the other Projects

#### Create Network in Docker

```
docker network create myNetwork
```

then run in projectFolder of each microService

```
docker compose up -d
```

### With IntellJ
to run inside IntelliJ first do:

```
docker compose -f docker-compose-dbOnly.yml up -d
```

or **Right-Click** on *docker-compose-dbOnly.yml* and **run**

and than **Run** Application inside IntelliJ
