# quarkus-handlebars-demo

## Get the code
```
git clone https://github.com/briantanseng/quarkus-handlebars-demo.git && cd quarkus-handlebars-demo
```

## Edit the location of the templates
Open quarkus-handlebars-demo/src/main/resources/application.properties then edit the template.path
```
template.path=/path-to-your-project/quarkus-handlebars-demo/src/main/resources/META-INF/resources/views
```

## Build and run the project
```
mvn compile quarkus:dev
```

## View the template in action
Browse to http://localhost:8080/resources and refresh your browser several times. This is server-rendered HTML. Enjoy!

