package googlebooksapi

import googlebooksapi.exception.*
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

abstract class Client {
    protected val httpClient: HttpClient

    init {
        httpClient = HttpClient {
            install(JsonFeature)
        }
    }

    suspend fun get(url: String): HttpResponse {
        val response: HttpResponse
        try {
            response = httpClient.get(url) {}
        } catch (redirectException: RedirectResponseException) {
            throw RedirectException(redirectException.message ?: "3xx Error")
        } catch (clientException: ClientRequestException) {
            throw ClientException(clientException.message)
        } catch (serverException: ServerResponseException) {
            throw ServerException(serverException.message ?: "5xx Error")
        } finally {
            close()
        }

        return response
    }

    fun close() {
        httpClient.close()
    }
}