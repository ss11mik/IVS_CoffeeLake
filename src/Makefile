ROOT = ../
GRADLEW = cd $(ROOT) && ./gradlew
TEX_GARBAGE = *.aux *.bib *.bbl *.blg *.log *.out *.run.xml *.synctex.gz *.toc
TO_PACK =  .git/ mockup/ plan/ profiling/ src/ .gitignore .editorconfig README.md debugging.png dokumentace.pdf hodnoceni.txt screenshot.png
PACKED = xlohnm00.tar.gz
DONT_RUN_TESTS = -x test

.PHONY: test

all: build profile jar

pack: doc clean
	mkdir ../repo/
	cd $(ROOT) && cp -rt repo/ $(TO_PACK)
	tar -zcf ../$(PACKED) ../doc/ ../install/ ../repo/
	rm -rf ../repo/

clean:
	rm -rf html latex
	$(GRADLEW) clean
	cd ../doc && rm -f $(TEX_GARBAGE)
	cd ../profiling/report/ && rm -f $(TEX_GARBAGE)

test:
	$(GRADLEW) test

doc:
	doxygen
	cd ../doc/ && pdflatex dokumentace.tex && pdflatex dokumentace.tex && mv dokumentace.pdf ../	# double compilation for ToC generation
	cd ../profiling/report/ && pdflatex zprava.tex && mv zprava.pdf ../

run: jar
	cd ../build/libs/ && java -jar *.jar

profile:
	$(GRADLEW) --profile $(DONT_RUN_TESTS)



build:
	$(GRADLEW) build $(DONT_RUN_TESTS)

jar:
	$(GRADLEW) jar $(DONT_RUN_TESTS)
