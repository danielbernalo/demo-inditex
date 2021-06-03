SERVICE_NAME=prices-worker

BASE_WORKSPACE ?= $(shell git rev-parse --show-toplevel)
GRADLE_PROFILE ?= default
GRADLE_WRAPPER ?= ${BASE_WORKSPACE}/gradlew

DATABASE_FILE=${BASE_WORKSPACE}/data/prices
CSV_FILE=${BASE_WORKSPACE}/data_import.csv


debug:
	@echo ${BASE_WORKSPACE}

# starts springboot on localhost:8080
run:
	DATABASE_FILE=${DATABASE_FILE} CSV_FILE=${CSV_FILE} ${GRADLE_WRAPPER} bootRun --no-daemon

# runs unit tests
.PHONY: test
test:
	DATABASE_FILE=${DATABASE_FILE} CSV_FILE=${CSV_FILE} ${GRADLE_WRAPPER} cleanTest test

# bundles app for production
.PHONY: build
build:
	DATABASE_FILE=${DATABASE_FILE} CSV_FILE=${CSV_FILE} ${GRADLE_WRAPPER} -P${GRADLE_PROFILE} build

# builds the production docker image
.PHONY: build-docker
build-docker:
	DOCKER_BUILD_OPTS="${ARGS}" docker build --rm -t ${SERVICE_NAME} -f Dockerfile.prod .

# starts the production docker image on localhost:8080
.PHONY: run-docker
run-docker:
	docker run -i -t -e DATABASE_FILE=${DATABASE_FILE} -e CSV_FILE=${CSV_FILE} -v ${DATABASE_FILE}:${DATABASE_FILE} -v ${CSV_FILE}:${CSV_FILE} ${SERVICE_NAME}
