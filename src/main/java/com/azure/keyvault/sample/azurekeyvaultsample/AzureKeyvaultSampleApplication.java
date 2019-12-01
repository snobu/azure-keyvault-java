package com.azure.keyvault.sample.azurekeyvaultsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

@SpringBootApplication
public class AzureKeyvaultSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureKeyvaultSampleApplication.class, args);
				
		// See this for clarity on DefaultAzureCredential:
		// https://github.com/Azure/azure-sdk-for-java/tree/master/sdk/identity/azure-identity#credentials
		// In short: Use developing locally it expects a service principal as env vars.
		// When running in Azure in a serivce that has Managed Identity enabled
		// it will acquire a token via that mechanism (you don't need to provide any secrets)
		DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();

		SecretClient client = new SecretClientBuilder()
			.vaultUrl("https://alice.vault.azure.net")
			.credential(credential)
			.buildClient();

		KeyVaultSecret secret = client.getSecret("secret1");
		System.out.printf("\nSecret is returned with name %s and value %s \n",
			secret.getName(),
			secret.getValue());

	}

}
