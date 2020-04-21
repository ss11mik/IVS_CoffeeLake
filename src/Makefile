.PHONY: test

all: build profile jar

pack:
	tar -zcf ../xlohnm00.tar.gz ../doc/ ../install/ main/ test/
	# TODO include main, test, .git... files in repo/

clean:
	rm -rf html latex
	cd .. && ./gradlew clean

test:
	cd .. && ./gradlew test

doc:
	doxygen

run: jar
	cd ../build/libs/ && java -jar *.jar

profile:
	cd .. && ./gradlew --profile -x test



build:
	cd .. && ./gradlew build -x test

jar:
	cd .. && ./gradlew jar -x test
