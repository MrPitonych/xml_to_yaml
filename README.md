# XML to YAML Converter

 This web service converts XML input to YAML output It is implemented using Java and Spring Boot framework
```xml
<?xml version="1.0" encoding="UTF-8"?>
<note>
    <to>ToTest</to>
    <from>FromTest</from>
    <heading>HedingTest</heading>
    <access>AccessTest</access>
</note>
```

and sends response in YAML format matching the request:
```yaml
note:
 to: ToTest
 from: FromTest
 heading: HedingTest
 access: AccessTest
```

## Usage 

To create Docker image run Gradle task:

`$ ./gradlew docker`

After that Docker container can be run with optional port parameter (default is 8080):

`$ ./run.sh <PORT>`
