# Vote #

## Build & Run ##

```sh
$ cd Vote
$ ./sbt
> container:start
> ~ ;copy-resources;aux-compile
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.

To run in debug mode
```sh
$ export SBT_OPTS="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005"
$ sbt
> container:start
> ~ ;copy-resources;aux-compile
> browse
```
