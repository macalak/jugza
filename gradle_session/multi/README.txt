1. Enable local Maven repository: maven { url "$localrepo_url"  }    
2. Enable Artifactory repository: maven { url "$artifactory_url" }
3. Tweak test task:

  test{
	minHeapSize = "128m"
	maxHeapSize = "512m"
   
	beforeTest { descriptor ->
     logger.lifecycle("Running test: " + descriptor)
	}
  }

4. Enable code coverage for subprojects: apply plugin: "jacoco"
   Additionoal Configuration: 
   
	jacoco configuration  
	jacoco {
		toolVersion = "0.7.1.201405082137"
	}

	jacocoTestReport {
		reports {
			html.enabled = true
			xml.enabled = true
			csv.enabled false
		}
	}
   
5. Enable checkstyle (static code analysis): apply plugin: 'checkstyle'
   Demonstrate error: Uncomment in checkstyleconfig for service subproject.
    <!--<module name="JavadocMethod"/>-->
	<!--<module name="JavadocType"/>-->
	
6. Enable findbugs: apply plugin: 'findbugs'    
   Configure:
   
   findbugs {
    ignoreFailures = true
    effort = "max"
    reportLevel = "high"
	sourceSets = [sourceSets.main]
    //visitors = ["FindSqlInjection", "SwitchFallthrough"]
    //omitVisitors = ["FindNonShortCircuit"]
	reports {
        xml.enabled = false
        html.enabled = true
    }
   }
   tasks.withType(FindBugs) {
    reports {
        xml.enabled = false
        html.enabled = true
    }
   }
   
7. Enable pmd: apply plugin: 'pmd'


    pmd {
	    ignoreFailures = true
        ruleSets = [
            "java-basic", "java-braces", "java-imports", "java-controversial", "java-unusedcode"
        ]
//        ruleSets = [
//            "java-typeresolution", "java-strings", "java-design", "java-coupling"
//        ]
    }   
  

8. Multiple artifacts: see data:access
9. Generated files: see data:model:zip  
10. Comunity plugins:
  plugins {
	id "com.jfrog.artifactory" version "4.0.0"
  }
  apply plugin: 'com.jfrog.artifactory'
  
  
  artifactory {
   publish {
    contextUrl = 'http://localhost:8081/artifactory'   //The base Artifactory URL for the publisher
    //A closure defining publishing information
    repository {
      repoKey = 'libs-release-local'   //The Artifactory repository key to publish to
      username = 'admin'          //The publisher user name
      password = 'password'       //The publisher password
    }
	defaults {
			publishConfigs('archives')
            publishArtifacts = true
        }
    }
  }
  
11. Incremental builds: data:model:generator (inputs/outputs)  
12. Run web application: web-> apply plugin: 'jetty'
13. Overide property: gradlew -Partifactory_publish_url="invalid" printP
    From env: ORG_GRADLE_PROJECT_artifactory_publish_url=
14. Dependency resolution strategy, if conflicts:

     configurations.testCompile.resolutionStrategy {
		failOnVersionConflict()
	  }
	  
15. Continuous builds
    gradlew -t 

16. --daemon and --no-daemon
	
17. Source Sets

	sourceSets {
		main {
			java {
				srcDirs = ['src']
			}
		}
		test {
			java {
				srcDirs = ['test']
			}
		}
}