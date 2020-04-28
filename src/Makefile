.PHONY: test

all: build profile jar

pack: clean
	mkdir ../repo/
	cp -rt ../repo/ ../.git/ ../mockup/ ../plan/ ../profiling/ ../src/ ../.gitignore ../.editorconfig ../README.md ../debugging.png ../dokumentace.pdf ../hodnoceni.txt ../screenshot.png
	tar -zcf ../xlohnm00.tar.gz ../doc/ ../install/ ../repo/
	rm -rf ../repo/

clean:
	rm -rf html latex
	cd .. && ./gradlew clean

test:
	cd .. && ./gradlew test

doc:
	doxygen
	cd ../dokumentace/ && pdflatex dokumentace.tex && pdflatex dokumentace.tex	# double compilation for ToC generation
	cd ../profiling/report/ && pdflatex zprava.tex && mv zprava.pdf ../

run: jar
	cd ../build/libs/ && java -jar *.jar

profile:
	cd .. && ./gradlew --profile -x test



build:
	cd .. && ./gradlew build -x test

jar:
	cd .. && ./gradlew jar -x test
