## ol-jsonb-test
Sample project to reproduce jsonb concurrency issues experienced with OL-23.0.0.10.

Apache ab tool can be used to generate some load on the test endpoint to reproduce the concurrency issues:
```
ab -n 100 -c 100 -T "application/json" -p bean.json http://localhost:8080/test
```
This behaviour is not observed when the yasson dependency is removed from the build.gradle.

