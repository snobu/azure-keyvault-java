build:
	./mvnw package
run:
	. ./env_secrets.sh && java -jar target/azure-keyvault-java-0.1.jar