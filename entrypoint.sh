#!/bin/bash
export JAVA_OPTS="-server \
          -Xms1024m \
          -XX:MaxGCPauseMillis=1000 \
          -XX:+UseStringDeduplication \
          -Xmx3072m \
          -XX:+UseG1GC \
          -XX:ConcGCThreads=2 \
          -XX:ParallelGCThreads=2 \
          -Dpidfile.path=/dev/null"

java $JAVA_OPTS -jar /core/app.jar