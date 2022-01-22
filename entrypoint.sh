#!/bin/bash
export JAVA_OPTS="-server \
          -Xms8g \
          -XX:MaxGCPauseMillis=2000 \
          -XX:+UseStringDeduplication \
          -Xmx14g \
          -XX:+UseG1GC \
          -XX:ConcGCThreads=16 \
          -XX:ParallelGCThreads=16 \
          -Dpidfile.path=/dev/null"

java $JAVA_OPTS -jar /core/app.jar