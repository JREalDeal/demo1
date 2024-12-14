# DefaultApi

All URIs are relative to *https://api.example.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**productsGet**](DefaultApi.md#productsGet) | **GET** /products | Get a list of products |
| [**productsIdDelete**](DefaultApi.md#productsIdDelete) | **DELETE** /products/{id} | Delete a product by ID |
| [**productsIdGet**](DefaultApi.md#productsIdGet) | **GET** /products/{id} | Get a single product by ID |
| [**productsIdPut**](DefaultApi.md#productsIdPut) | **PUT** /products/{id} | Update an existing product by ID |
| [**productsPost**](DefaultApi.md#productsPost) | **POST** /products | Create a new product |


<a id="productsGet"></a>
# **productsGet**
> List&lt;Product&gt; productsGet()

Get a list of products

### Example
```java
// Import classes:
import org.openapi.example.invoker.ApiClient;
import org.openapi.example.invoker.ApiException;
import org.openapi.example.invoker.Configuration;
import org.openapi.example.invoker.models.*;
import org.openapi.example.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.example.com/v1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    try {
      List<Product> result = apiInstance.productsGet();
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#productsGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Product&gt;**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | A list of products |  -  |

<a id="productsIdDelete"></a>
# **productsIdDelete**
> productsIdDelete(id)

Delete a product by ID

### Example
```java
// Import classes:
import org.openapi.example.invoker.ApiClient;
import org.openapi.example.invoker.ApiException;
import org.openapi.example.invoker.Configuration;
import org.openapi.example.invoker.models.*;
import org.openapi.example.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.example.com/v1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String id = "id_example"; // String | ID of the product to delete
    try {
      apiInstance.productsIdDelete(id);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#productsIdDelete");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| ID of the product to delete | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **204** | Product deleted successfully |  -  |

<a id="productsIdGet"></a>
# **productsIdGet**
> Product productsIdGet(id)

Get a single product by ID

### Example
```java
// Import classes:
import org.openapi.example.invoker.ApiClient;
import org.openapi.example.invoker.ApiException;
import org.openapi.example.invoker.Configuration;
import org.openapi.example.invoker.models.*;
import org.openapi.example.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.example.com/v1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String id = "id_example"; // String | ID of the product to retrieve
    try {
      Product result = apiInstance.productsIdGet(id);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#productsIdGet");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| ID of the product to retrieve | |

### Return type

[**Product**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Product details found |  -  |
| **404** | Product not found |  -  |

<a id="productsIdPut"></a>
# **productsIdPut**
> productsIdPut(id, product)

Update an existing product by ID

### Example
```java
// Import classes:
import org.openapi.example.invoker.ApiClient;
import org.openapi.example.invoker.ApiException;
import org.openapi.example.invoker.Configuration;
import org.openapi.example.invoker.models.*;
import org.openapi.example.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.example.com/v1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    String id = "id_example"; // String | ID of the product to update
    Product product = new Product(); // Product | 
    try {
      apiInstance.productsIdPut(id, product);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#productsIdPut");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **id** | **String**| ID of the product to update | |
| **product** | [**Product**](Product.md)|  | |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | Product updated successfully |  -  |

<a id="productsPost"></a>
# **productsPost**
> Product productsPost(product)

Create a new product

### Example
```java
// Import classes:
import org.openapi.example.invoker.ApiClient;
import org.openapi.example.invoker.ApiException;
import org.openapi.example.invoker.Configuration;
import org.openapi.example.invoker.models.*;
import org.openapi.example.api.DefaultApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("https://api.example.com/v1");

    DefaultApi apiInstance = new DefaultApi(defaultClient);
    Product product = new Product(); // Product | 
    try {
      Product result = apiInstance.productsPost(product);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling DefaultApi#productsPost");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **product** | [**Product**](Product.md)|  | |

### Return type

[**Product**](Product.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | Product created successfully |  -  |

