dev/local:
	docker-compose up -d
	./mvnw spring-boot:run

api/test:
	./mvnw clean
	./mvnw test