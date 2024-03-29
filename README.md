## This sample demonstrates retrieving a secret from Azure Key Vault using the Azure SDK for Java.

[`DefaultAzureCredential`][1] is used to pick up a service principal from env vars when developing locally.
When running in Azure, it will try to use Managed Identity if enabled (no need to provide secrets in this case).

See this for more:
https://github.com/Azure/azure-sdk-for-java/tree/master/sdk/identity/azure-identity#key-concepts

To develop locally create an `env_secrets.sh` bash script with the following content:

```bash
export AZURE_CLIENT_ID=xxx
export AZURE_CLIENT_SECRET=yyy
export AZURE_TENANT_ID=zzz
```

This is later used by `make run` to populate those environment variables before booting the application.

Of course you can define those variables manually should you choose to do so. `make run` won't be able to pick them up in this case, however you can simply invoke `java -jar <path_to_jar>` instead (do make sure it's in the same terminal session).

### Build .jar
```
$ make build
```

### Run the application

```
$ make run
```


[1]: https://github.com/Azure/azure-sdk-for-java/tree/master/sdk/identity/azure-identity#defaultazurecredential
