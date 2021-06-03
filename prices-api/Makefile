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

# builds the production docker image
.PHONY: build-docker
build-docker:

	DOCKER_BUILD_OPTS="${ARGS}" docker build --rm -t ${SERVICE_NAME} -f Dockerfile.prod .

# starts the production docker image on localhost:8080
.PHONY: run-docker
run-docker:
	docker run -p 8080:8080 -e DATABASE_FILE=${DATABASE_FILE} -it ${SERVICE_NAME}
