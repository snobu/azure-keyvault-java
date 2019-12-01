## This sample demonstrates retrieving a secret from Azure Key Vault using the Azure SDK for Java.

[`DefaultAzureCredential`][1] is used to pick up a service principal from env vars when developing locally.
When running in Azure, it will try to use Managed Identity if enabled (no need to provide secrets in this case).

See this for more:
https://github.com/Azure/azure-sdk-for-java/tree/master/sdk/identity/azure-identity#key-concepts

### Build
```
$ make build
```

### Run
```
$ make run
```


[1]: https://github.com/Azure/azure-sdk-for-java/tree/master/sdk/identity/azure-identity#defaultazurecredential