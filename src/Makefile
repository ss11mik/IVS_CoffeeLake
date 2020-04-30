ROOT = ../
VERSION = 1.0
EXECUTABLE = JCalc-$(VERSION).jar
PROFILE_EXECUTABLE = JCalc-profile-$(VERSION).jar
GRADLEW = cd $(ROOT) && ./gradlew
TEX_GARBAGE = *.aux *.bib *.bbl *.blg *.log *.out *.run.xml *.synctex.gz *.toc
TO_PACK =  .git/ mockup/ plan/ profiling/ src/ .gitignore .editorconfig README.md debugging.png dokumentace.pdf hodnoceni.txt skutecnost.txt screenshot.png
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

run: jar
	cd $(ROOT)build/libs/ && java -jar $(EXECUTABLE)

profile:
	cd $(ROOT)profiling/ && ./inputGen.sh
	$(GRADLEW) $(DONT_RUN_TESTS) $@



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

profile-run: profile
	cd $(ROOT)build/libs/ && java -jar $(PROFILE_EXECUTABLE) <  ../../profiling/10
	cd $(ROOT)build/libs/ && java -jar $(PROFILE_EXECUTABLE) < ../../profiling/100
	cd $(ROOT)build/libs/ && java -jar $(PROFILE_EXECUTABLE) < ../../profiling/1000