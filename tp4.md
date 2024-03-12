# TP4 avec maven et traitement des fichiers en Java

## Tester votre outil maven

```bash
mvn --version
```

* Quel est l'intérêt d'un outil tel que maven ?
c'est un build tool 
build java
exe test
exe
versions
+ libs
* Quelles alternatives existe-t-il ?
Gradle
Travis CI

## Créer un projet maven de base 

```bash
mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart
```

Ceci donnera une structure du type (avec package essai, artifact : mud)

```
mud
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── essai
    │           └── App.java
    └── test
        └── java
            └── essai
                └── AppTest.java
```

## Mettez votre projet MUD sous cette forme

### Initialisation maven avec un package précis

```
mvn archetype:generate -DgroupId=fr.univ_orleans.iut45.mud -DartifactId=mud -DinteractiveMode=false
```

Structure obtenue :

```
mud
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── fr
    │           └── univ_orleans
    │               └── iut45
    │                   └── mud
    │                       └── App.java
    └── test
        └── java
            └── fr
                └── univ_orleans
                    └── iut45
                        └── mud
                            └── AppTest.java
```

### Mise en place du projet dans l'arborescence

* Déplacer les fichiers pour obtenir l'arborescence suivante :

```
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── fr
│   │           └── univ_orleans
│   │               └── iut45
│   │                   └── mud
│   │                       ├── App.java
│   │                       ├── Box.java
│   │                       └── Thing.java
│   └── test
│       ├── java
│       │   └── fr
│       │       └── univ_orleans
│       │           └── iut45
│       │               └── mud
│       │                   └── TestBoxes.java
│       └── resources
│           ├── test1.json
│           ├── test2.json
│           ├── test3.json
│           └── test4.json
```

Les fichiers json sont ici utilisés dans les tests donc placés dans le dossiers resources de l'arborescence *src/test*.


* Créer les packages correspondants dans les fichiers

En ajoutant la ligne :

```java
package fr.univ_orleans.iut45.mud;
```

au début des fichiers Thing.java, Box.java et TestBoxes.java.

Essayez les commandes `mvn clean`, `mvn test` et `mvn compile`. Que se passe-t-il ?

mvn clean -> remove target dir
mvn compile ->

[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< mud_moi:mud_project >-------------------------
[INFO] Building mud_project 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ mud_project ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/local/o22302615/R2_03_TP_4/mud_project/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ mud_project ---
[INFO] Nothing to compile - all classes are up to date
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.949 s
[INFO] Finished at: 2024-03-12T16:05:37+01:00
[INFO] ------------------------------------------------------------------------

mvn test -> 

[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------< mud_moi:mud_project >-------------------------
[INFO] Building mud_project 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ mud_project ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/local/o22302615/R2_03_TP_4/mud_project/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ mud_project ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ mud_project ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ mud_project ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ mud_project ---
[INFO] Surefire report directory: /home/local/o22302615/R2_03_TP_4/mud_project/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running mud_moi.AppTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.027 sec
Running mud_moi.TestsBoxes
Tests run: 37, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.051 sec

Results :

Tests run: 38, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.610 s
[INFO] Finished at: 2024-03-12T16:02:22+01:00
[INFO] ------------------------------------------------------------------------

### Ajout de règles à mvn pour la lib gson

GSON, ajouter une *dependency* gson après celle de junit.  

```xml
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
    <dependency>
      <groupId>com.google.code.gson</groupId>
      <artifactId>gson</artifactId>
      <version>2.10.1</version>
      <scope>compile</scope>
    </dependency>
  </dependencies>
  ```
Puis ajouter la règle properties dans pom.xml après dependencies.

```xml
 <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>17</maven.compiler.source>
    <maven.compiler.target>17</maven.compiler.target>
  </properties>
```

Il faut aussi adapter le code dans TestBoxes.java pour pouvoir accéder aux fichiers de Test placés dans test/resources/ :

```java
@Test
    public void testBoxFromJSONSimple(){
        // use the file test1.json in ressources folder
        String path = TestBoxes.class.getClassLoader().getResource("test1.json").getFile();
        Box b = Box.fromJSON(path);
        assertEquals(b.capacity(), -1);
        assertTrue(b.isOpen());
    }

```

Vous devriez maintenant pouvoir exécuter `mvn test` !

### Autres cibles : package et exec:java

Pour packager, complétons la classe principale App.java, par exemple :

```java
package fr.univ_orleans.iut45.mud;

/**
 * main App 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Box b = new Box();
        Thing truc = new Thing("truc");
        Thing machin = new Thing("machin");
        b.add(truc);
        b.add(machin);
        b.actionLook();
    }
}

```

Puis configurer le plugin maven-shade-plugin pour packager votre App dans un fichier jar directement exécutable avec `mvn package`.



```xml
<build>
    <plugins>
      <plugin>
        <groupId>org.apache.maven.plugins</groupId>
        <artifactId>maven-shade-plugin</artifactId>
        <version>3.4.1</version>
        <executions>
          <execution>
            <phase>package</phase>
            <goals>
              <goal>shade</goal>
            </goals>
            <configuration>
              <transformers>
                <transformer
                    implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                  <mainClass>fr.univ_orleans.iut45.mud.App</mainClass>
                </transformer>
              </transformers>
            </configuration>
          </execution>
        </executions>
      </plugin>
    </plugins>

```

Où est placé le jar obtenu ? Comment l'utiliser ?


/target/mud_project-1.0-SNAPSHOT.jar
package mud_moi;


puis ajoutez le plugin  maven-exec-plugin pour executer directement l'App :

```xml
  <plugin>
        <groupId>org.codehaus.mojo</groupId>
        <artifactId>exec-maven-plugin</artifactId>
        <version>1.6.0</version>
        <configuration>
        <mainClass>fr.univ_orleans.iut45.mud.App</mainClass>
        </configuration>
  </plugin>
```

Tapez `mvn exec:java` pour cette nouvelle cible.
 
niquelle


Au total, quelles cibles mvn sont-elles maintenant disponibles ?

validate, initialize, generate-sources, process-sources, generate-resources, process-resources, compile, process-classes, generate-test-sources, process-test-sources, generate-test-resources, process-test-resources, test-compile, process-test-classes, test, prepare-package, package, pre-integration-test, integration-test, post-integration-test, verify, install, deploy, pre-clean, clean, post-clean, pre-site, site, post-site, site-deploy

Ce n'est pas la peine de versionner le dossier *target* !


  
