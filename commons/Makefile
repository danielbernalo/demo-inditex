SERVICE_NAME=prices-api

BASE_WORKSPACE ?= $(shell git rev-parse --show-toplevel)
GRADLE_PROFILE ?= default
GRADLE_WRAPPER ?= ${BASE_WORKSPACE}/gradlew

DATABASE_FILE=${BASE_WORKSPACE}/data/prices

debug:
	@echo ${BASE_WORKSPACE}
	@echo ${DATABASE_FILE}

# starts springboot on localhost:8080
run:
	DATABASE_FILE=${BASE_WORKSPACE}/data/prices ${GRADLE_WRAPPER} bootRun --no-daemon

# runs unit tests
.PHONY: test
test:
	DATABASE_FILE=${BASE_WORKSPACE}/data/prices ${GRADLE_WRAPPER} cleanTest test

# bundles app for production
.PHONY: build
build:
	${GRADLE_WRAPPER} -P${GRADLE_PROFILE} build
