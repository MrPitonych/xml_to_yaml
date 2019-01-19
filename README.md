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

#### 1. To launch an image using Docker

To create Docker image run Gradle task:

`$ ./gradlew createImage`

After that Docker container can be run with optional port parameter (default is 8080):

`$ ./run.sh <PORT>`

#### 2. If you don't want to use Docker

Start the service directly from Gradle (Gradle builds and runs everything by itself):

`$ ./gradlew startService`

#### 3. If you want to get javadoc

To generate HTML-pages from javadoc, use the command:

`$ ./gradlew generateDocumentation`
