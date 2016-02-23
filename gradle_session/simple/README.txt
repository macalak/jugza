1. Try 'gradlew dependencies'
2. Add dependency to 'commons-cli:commons-cli:1.2'

    repositories {
		jcenter()
	}
	dependencies{
		compile 'commons-cli:commons-cli:1.2';
	}	
	
3. Add dependency to latest one 'commons-cli:commons-cli:1.+'
4. Uncomment code in Main
5. Check the Gradle cache
6. Example of flat 'lib' compile fileTree("./lib")

7. Java Manifest config:

	jar {
		manifest {
			attributes 'Main-Class': 'ite.Main'
		}
	}

8. application plugin

	apply plugin: 'application'

	mainClassName = "ite.Main"


	