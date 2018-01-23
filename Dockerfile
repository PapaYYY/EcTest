FROM maven

ADD /src //src
ADD FunctionalAndAPITest.xml //FunctionalAndAPITest.xml
ADD pom.xml //pom.xml
ADD mvn-entrypoint.sh //mvn-entrypoint.sh

ENTRYPOINT ["mvn-entrypoint.sh"]

