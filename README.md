# clf4j - Compact Logging Framework 4 Java

One of the most popular logging solutions in Java projects is slf4j. Even if this is not doing the real log, it's a very usefulll facade since is simple to use and the API with variable arguments makes logging simple, nice and easy.
When we talk about the real log framework behind, situations is different... There are some traditional logging solutions (log4j, java logging) and there is Logback. Logback is the most chosen solution since is newer (and hopefully better) and it was written having slf4j in mind.
Regardless of chosen solution, some question appears:
Have you ever wander why do you need half a megabyte JAR file(s) in order to log data into file?
Have you ever wander why do you need a very flexible system and use between 10% - 20% of it's features?
Have you ever wander why...

Well, because you didn't use clf4j...
