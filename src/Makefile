ROOT = ../
GRADLEW = cd $(ROOT) && ./gradlew
TEX_GARBAGE = *.aux *.bib *.bbl *.blg *.log *.out *.run.xml *.synctex.gz *.toc
TO_PACK =  .git/ mockup/ plan/ profiling/ src/ .gitignore .editorconfig README.md debugging.png dokumentace.pdf hodnoceni.txt screenshot.png
PACKED = xlohnm00_xmikul69_xszotk07
DONT_RUN_TESTS = -x test

.PHONY: test

all: build profile jar

pack: doc cleanNoDoc
	mkdir $(ROOT)$(PACKED)
	mkdir $(ROOT)$(PACKED)/repo/
	mkdir $(ROOT)$(PACKED)/doc/
	cd $(ROOT) && cp -rt $(PACKED)/repo/ $(TO_PACK)
	cd $(ROOT) && cp -rt $(PACKED)/doc/ src/html/*
	cd $(ROOT) && cp -rt $(PACKED)/ install/
	cd $(ROOT) && zip -r9 $(PACKED).zip $(PACKED)
	rm -rf $(ROOT)$(PACKED)

clean: cleanNoDoc
	rm -rf html latex

test:
	$(GRADLEW) $@

doc:
	doxygen
	cd $(ROOT)doc/ && pdflatex dokumentace.tex && pdflatex dokumentace.tex && mv dokumentace.pdf $(ROOT)	# double compilation for ToC generation
	cd $(ROOT)profiling/report/ && pdflatex zprava.tex && mv zprava.pdf $(ROOT)

run: jar
	cd $(ROOT)build/libs/ && java -jar *.jar

profile:
	cd $(ROOT)profiling/ && ./inputGen.sh					#needs to first cd there, because it generates the files in current dir
	$(GRADLEW) $(DONT_RUN_TESTS) $@ --args='profiling/10'
	$(GRADLEW) $(DONT_RUN_TESTS) $@ --args='profiling/100'
	$(GRADLEW) $(DONT_RUN_TESTS) $@ --args='profiling/1000'



build:
	$(GRADLEW) $@ $(DONT_RUN_TESTS)

jar:
	$(GRADLEW) $@ $(DONT_RUN_TESTS)

cleanNoDoc:				#so that pack can generate the docs and clean after, without deleting Javadocs
	$(GRADLEW) clean
	cd $(ROOT)doc && rm -f $(TEX_GARBAGE)
	cd $(ROOT)profiling/report/ && rm -f $(TEX_GARBAGE)
	rm -f $(ROOT)$(PACKED).zip
	rm -rf $(ROOT)repo/
	rm -f $(ROOT)profiling/10 $(ROOT)profiling/100 $(ROOT)profiling/1000